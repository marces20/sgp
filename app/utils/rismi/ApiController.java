package utils.rismi;

import play.mvc.*;
import utils.DateUtils;
import play.libs.WS;
import play.libs.F.Promise;
import play.Logger;
import play.Play;
import play.libs.F.Function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Periodo;
import models.novedades.Planificacion;
import models.novedades.ProduccionPuestoPeriodo;
import play.libs.Json;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class ApiController {

	private static final String API_BASE_URL = "http://10.1.4.24/api";
    private static final String CLIENT_ID = Play.application().configuration().getString("rismi.cliente_id");
    private static final String CLIENT_SECRET = Play.application().configuration().getString("rismi.cliente_secret");



    public static Promise<JsonNode> loginConJSON() {

        Logger.debug("=== INTENTANDO LOGIN CON JSON ===");

        ObjectNode jsonBody = Json.newObject();
        jsonBody.put("client_id", CLIENT_ID);
        jsonBody.put("client_secret", CLIENT_SECRET);

        Logger.debug("JSON Body: " + jsonBody.toString());

        Promise<WS.Response> promise = WS.url(API_BASE_URL + "/login")
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json") // JSON en lugar de form
            .setTimeout(5000)
            .post(jsonBody); // Enviar JSON

        return promise.map(new Function<WS.Response, JsonNode>() {
            public JsonNode apply(WS.Response response) {
                Logger.debug("Status: " + response.getStatus());
                Logger.debug("Body: " + response.getBody());

                if (response.getStatus() == 200 && response.getBody() != null && !response.getBody().isEmpty()) {
                    return response.asJson();
                } else {
                    ObjectNode errorJson = Json.newObject();
                    errorJson.put("error", true);
                    errorJson.put("status", response.getStatus());
                    errorJson.put("body", response.getBody());
                    return errorJson;
                }
            }
        }).recover(new Function<Throwable, JsonNode>() {
            public JsonNode apply(Throwable throwable) {
                Logger.error("Error en login con JSON", throwable);
                ObjectNode errorJson = Json.newObject();
                errorJson.put("error", true);
                errorJson.put("message", throwable.getMessage());
                return errorJson;
            }
        });
    }

    public static Promise<JsonNode> getPrestacionesTotalizado(String endpoint, String token,String dni,Long puestoLaboralId,Periodo pe,Planificacion pla) {

        endpoint = "/v1/externos/prestaciones-totalizado";
        Logger.debug("=== INICIO getPrestacionesTotalizado ===");

        return loginConJSON().flatMap(
            new Function<JsonNode, Promise<JsonNode>>() {
                public Promise<JsonNode> apply(JsonNode loginJson) throws Throwable {
                    Logger.debug("Login response recibido: " + loginJson.toString());

                    // ✅ Validar error
                    if (loginJson.has("error") && loginJson.get("error").asBoolean()) {
                        Logger.error("Login falló: " + loginJson.get("message").asText());
                        return Promise.pure(loginJson);
                    }

                    // ✅ Validar que tenga access_token
                    if (!loginJson.has("access_token")) {
                        Logger.error("Login no retornó access_token. JSON completo: " + loginJson.toString());
                        ObjectNode error = Json.newObject();
                        error.put("error", true);
                        error.put("message", "No se recibió access_token");
                        error.put("loginResponse", loginJson);
                        return Promise.pure(error);
                    }

                    String token = loginJson.get("access_token").asText();
                    Logger.debug("Token obtenido: " + token.substring(0, Math.min(20, token.length())) + "...");

                    String url = API_BASE_URL + "/v1/externos/prestaciones-totalizado";
                    Logger.debug("Request URL: " + url);

                    return WS.url(url)
                        .setHeader("Accept", "application/json")
                        .setHeader("Authorization", "Bearer " + token)
                        .setQueryParameter("id_dominio", "1")
                        .setQueryParameter("fecha_desde", DateUtils.formatDate(pe.date_start,"yyyy-MM-dd"))
                        .setQueryParameter("fecha_hasta", DateUtils.formatDate(pe.date_stop,"yyyy-MM-dd"))
                        .setQueryParameter("numero_documento", dni)

                        .get()
                        .map(new Function<WS.Response, JsonNode>() {
                            public JsonNode apply(WS.Response resp) throws JsonProcessingException, IOException {
                                Logger.debug("Prestaciones Status: " + resp.getStatus());
                                Logger.debug("Prestaciones Body: " + resp.getBody());
                                Logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxx-  "+dni+"  - xxxxxxxxxxxxxxxxxxxxxxxxx");
                                if (resp.getStatus() == 200) {

                                	ObjectMapper mapper = new ObjectMapper();
                                    JsonNode json = mapper.readTree(resp.getBody());

                                	if (json.has("data")) {
                                		try {
	                                		JsonNode dataArray = json.get("data");

		                                    if (dataArray != null && dataArray.isArray() && dataArray.size() > 0) {
		                                        for (JsonNode item : dataArray) {
		                                        	ProduccionPuestoPeriodo p = new ProduccionPuestoPeriodo();

		                                        	p.cantidad = new BigDecimal(item.get("cantidad").asInt());
		                                        	JsonNode codigoNode = item.get("codigo");
		                                        	p.codigo_ips = (codigoNode != null && !codigoNode.isNull())? codigoNode.asText(): null;
		                                        	p.valor_ips = ProduccionPuestoPeriodo.getValorIps(p.codigo_ips);


		                                        	p.nombre_rismi = item.get("producto").asText();
		                                        	p.periodo_id = pe.id.intValue();
		                                        	p.puesto_laboral_id = puestoLaboralId;
		                                        	p.planificacion_id = pla.id;
		                                        	p.save();





		                                        }
		                                    }
                                		 } catch (RuntimeException e) {
                                             Logger.error("Error parseando JSON de prestaciones", e);
                                             Logger.error("Error parseando JSON de prestaciones2", resp.asJson());
                                             Logger.error("Error parseando JSON de prestaciones3", dni);

                                             ObjectNode error = Json.newObject();
                                             error.put("error", true);
                                             error.put("message", "Error parseando JSON");
                                             error.put("detail", e.getMessage());
                                             error.put("body",  resp.getBody().substring(0, Math.min(500,  resp.getBody().length())));
                                             return error;
                                         }


                                	}
                                	//ProduccionPuestoPeriodo ppp = new ProduccionPuestoPeriodo();
                                	//ppp.cantidad


                                    return resp.asJson();
                                } else {
                                    ObjectNode error = Json.newObject();
                                    error.put("error", true);
                                    error.put("status", resp.getStatus());
                                    error.put("message", "Error obteniendo prestaciones");
                                    error.put("body", resp.getBody());
                                    return error;
                                }
                            }
                        });
                }
            }
        ).recover(new Function<Throwable, JsonNode>() {
            public JsonNode apply(Throwable error) throws Throwable {
                Logger.error("Error en getPrestacionesTotalizado", error);
                ObjectNode errorJson = Json.newObject();
                errorJson.put("error", true);
                errorJson.put("message", "Error procesando prestaciones");
                errorJson.put("detail", error.getMessage());
                return errorJson;
            }
        });
    }


    public static Promise<JsonNode> login() {
        String formBody = "client_id=" + urlEncode(CLIENT_ID) +
                         "&client_secret=" + urlEncode(CLIENT_SECRET);

        Promise<WS.Response> promise = WS.url(API_BASE_URL + "/login")
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/x-www-form-urlencoded")
            .setTimeout(5000)
            .post(formBody);

        return promise.map(new Function<WS.Response, JsonNode>() {
            public JsonNode apply(WS.Response response) {
                int status = response.getStatus();

                if (status == 200) {


                	Logger.debug("LOGIINNN RISMI: "+response.asJson());
                    return response.asJson();
                } else {
                    // Retorna JSON de error
                    ObjectNode errorJson = Json.newObject();
                    errorJson.put("error", true);
                    errorJson.put("status", status);
                    errorJson.put("message", "Error en login");
                    errorJson.put("detail", response.getBody());
                    return errorJson;
                }
            }
        }).recover(new Function<Throwable, JsonNode>() {
            public JsonNode apply(Throwable throwable) {
                ObjectNode errorJson = Json.newObject();
                errorJson.put("error", true);
                errorJson.put("message", "Error de conexión");
                errorJson.put("detail", throwable.getMessage());
                return errorJson;
            }
        });
    }


    /*public static Promise<JsonNode> getPrestacionesTotalizadoxxx(String endpoint, String token) {

    	endpoint= "/v1/externos/prestaciones-totalizado";
    	Logger.debug("111111111111111: ");
    	return login().flatMap(

    	        //             ↓ flatMap recibe UNA Function
    	        new Function<JsonNode, Promise<JsonNode>>() {
    	            //       ↑ Tipo entrada    ↑ Tipo salida (Promise!)

    	            // Esta función se ejecutará cuando el login() termine
    	            public Promise<JsonNode> apply(JsonNode loginJson) throws Throwable {
    	                // loginJson = resultado del login
    	            	Logger.debug("22222222222222222222: ");
    	                // Validar
    	                if (loginJson.has("error")) {
    	                	Logger.debug("333333333333333333: "+loginJson.toString());
    	                    ObjectNode error = Json.newObject();
    	                    error.put("error", true);
    	                    error.put("message", "Login falló");
    	                    return Promise.pure(error); // Retornar Promise con error
    	                }

    	                Logger.debug("4444444444444444444: ");

    	                // Extraer token
    	                String token = loginJson.get("access_token").asText();

    	                // Hacer el segundo request (retorna Promise!)
    	                return WS.url(API_BASE_URL + "/v1/externos/prestaciones-totalizado")
    	                		.setHeader("Accept", "application/json")
    	                        .setHeader("Authorization", "Bearer "+token)
    	                        .setQueryParameter("id_dominio", "1")
    	                        .setQueryParameter("fecha_desde", "2025-09-01")
    	                        .setQueryParameter("fecha_hasta", "2025-09-30")
    	                        .setQueryParameter("numero_documento", "29020773")
    	                        .get()
    	                    .map(new Function<WS.Response, JsonNode>() {
    	                        public JsonNode apply(WS.Response resp) {
    	                        	Logger.debug("33333333333333333: ");
    	                        	Logger.debug("getPrestacionesTotalizadogetPrestacionesTotalizado: "+resp.asJson());
    	                            return resp.asJson();
    	                        }
    	                    });
    	            }
    	        }
    	    );
    	*/


    	/*Promise<JsonNode> promiseJson = login();
    	JsonNode json = promiseJson.flatMap();

        Logger.debug("json json: "+json);

        String access_token = json.f

    	endpoint= "/v1/externos/prestaciones-totalizado";
    	id_dominio=1&
    	fecha_desde=2025-09-18&
    	fecha_hasta=2025-09-18&
    	id_programa_medico=&
    	id_cobertura=null&
    	id_prestacion=&
    	id_profesional=null&
    	numero_documento=null&
    	id_area=null&
    	facturable=null&
    	nivel_atencion=null&
    	pais=null&
    	pagina=


    	Promise<WS.Response> promise = WS.url(API_BASE_URL + endpoint)
            .setHeader("Accept", "application/json")
            .setHeader("Authorization", "Bearer "+token)
            .setQueryParameter("id_dominio", "1")
            .setQueryParameter("fecha_desde", "2025-09-01")
            .setQueryParameter("fecha_hasta", "2025-09-30")
            .setQueryParameter("numero_documento", "29020773")
            .get();

        return promise.map(new Function<WS.Response, JsonNode>() {
            public JsonNode apply(WS.Response response) {

            	System.out.println("=== DEBUG GET REQUEST ===");
                System.out.println("URL: " + API_BASE_URL + "/v1/externos/persona?id=123");
                System.out.println("Status: " + response.getStatus());
                System.out.println("Response Body: " + response.getBody());
                System.out.println("========================");

                if (response.getStatus() == 200) {
                	Logger.debug("LOGIINNN RISMI: "+response.asJson());
                    return response.asJson();
                } else {
                    ObjectNode errorJson = Json.newObject();
                    errorJson.put("error", true);
                    errorJson.put("status", response.getStatus());
                    errorJson.put("message", "Error en request GET");
                    Logger.debug("errorJson RISMI: "+errorJson);
                    try {
                        JsonNode errorFromApi = response.asJson();
                        errorJson.put("apiError", errorFromApi);
                    } catch (Exception e) {
                        errorJson.put("rawError", response.getBody());
                    }

                    return errorJson;
                }
            }
        });
    }*/

    public static Promise<JsonNode> getPacientes(String endpoint, String token) {

    	endpoint= "/v1/externos/persona?id=123";
    	Promise<WS.Response> promise = WS.url(API_BASE_URL + endpoint)
            .setHeader("Accept", "application/json")
            .setHeader("Authorization","Bearer "+ token)
            .setTimeout(10000).setQueryParameter("id", "123")
            .get();

        return promise.map(new Function<WS.Response, JsonNode>() {
            public JsonNode apply(WS.Response response) {

            	System.out.println("=== DEBUG GET REQUEST ===");
                System.out.println("URL: " + API_BASE_URL + "/v1/externos/persona?id=123");
                System.out.println("Status: " + response.getStatus());
                System.out.println("Response Body: " + response.getBody());
                System.out.println("========================");

                if (response.getStatus() == 200) {
                	Logger.debug("LOGIINNN RISMI: "+response.asJson());
                    return response.asJson();
                } else {
                    ObjectNode errorJson = Json.newObject();
                    errorJson.put("error", true);
                    errorJson.put("status", response.getStatus());
                    errorJson.put("message", "Error en request GET");
                    Logger.debug("errorJson RISMI: "+errorJson);
                    try {
                        JsonNode errorFromApi = response.asJson();
                        errorJson.put("apiError", errorFromApi);
                    } catch (Exception e) {
                        errorJson.put("rawError", response.getBody());
                    }

                    return errorJson;
                }
            }
        });
    }

    public static Promise<JsonNode> getPersonas() {
        String formBody = "client_id=" + urlEncode(CLIENT_ID) +
                         "&client_secret=" + urlEncode(CLIENT_SECRET);

        Promise<WS.Response> promise = WS.url(API_BASE_URL)
            .setHeader("Accept", "application/json")
            .setHeader("Authorization", "Bearer")


            .get();

        return promise.map(new Function<WS.Response, JsonNode>() {
            public JsonNode apply(WS.Response response) {
                int status = response.getStatus();

                if (status == 200) {
                	Logger.debug("LOGIINNN RISMI: "+response.asJson());
                    return response.asJson();
                } else {
                    // Retorna JSON de error
                    ObjectNode errorJson = Json.newObject();
                    errorJson.put("error", true);
                    errorJson.put("status", status);
                    errorJson.put("message", "Error en login");
                    errorJson.put("detail", response.getBody());
                    return errorJson;
                }
            }
        }).recover(new Function<Throwable, JsonNode>() {
            public JsonNode apply(Throwable throwable) {
                ObjectNode errorJson = Json.newObject();
                errorJson.put("error", true);
                errorJson.put("message", "Error de conexión");
                errorJson.put("detail", throwable.getMessage());
                return errorJson;
            }
        });
    }

    private static String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return value;
        }
    }

}
