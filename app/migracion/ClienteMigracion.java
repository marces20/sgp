package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.Configuracion2;
import server.Configuration;

public class ClienteMigracion {
public void migrar(){

	/*
	 *
	 alter table certificaciones_servicios_linea_clientes disable trigger all;
update certificaciones_servicios_linea_clientes set cliente_id =22196 where cliente_id in(28844,27725); --
alter table certificaciones_servicios_linea_clientes enable trigger all;

	 alter table orden_lineas disable trigger all;
update orden_lineas set cliente_id =18453 where cliente_id in(21718,21719); --
alter table orden_lineas enable trigger all;

alter table solicitudes disable trigger all;
update solicitudes set cliente_id =18453 where cliente_id in(21718,21719); --
alter table solicitudes enable trigger all;

alter table remito_linea_clientes disable trigger all;
update remito_linea_clientes set cliente_id =18453 where cliente_id in(21718,21719); --
alter table remito_linea_clientes enable trigger all;

alter table orden_linea_clientes disable trigger all;
update orden_linea_clientes set cliente_id =18453 where cliente_id in(21718,21719); --
alter table orden_linea_clientes enable trigger all;

alter table orden_linea_anulacion_clientes disable trigger all;
update orden_linea_anulacion_clientes set cliente_id =18453 where cliente_id in(21718,21719); --
alter table orden_linea_anulacion_clientes enable trigger all;

alter table recupero_facturas disable trigger all;
update recupero_facturas set cliente_id =18453 where cliente_id in(21718,21719); --
alter table recupero_facturas enable trigger all;


alter table recupero_pagos disable trigger all;
update recupero_pagos set cliente_id =18453 where cliente_id in(21718,21719); --
alter table recupero_pagos enable trigger all;

alter table public.recupero_certificado_deudas disable trigger all;
update public.recupero_certificado_deudas set cliente_id =23685 where cliente_id in(30110); --
alter table public.recupero_certificado_deudas enable trigger all;

alter table public.recupero_certificado_deudas disable trigger all;
update public.recupero_certificado_deudas set cliente_id =23685 where cliente_id in(30110); --
alter table public.recupero_certificado_deudas enable trigger all;


delete from clientes where id in(21718,21719);
	 */

		Connection conn = null;
		Connection conn2 = null;

		try {

			System.out.println("Empezo a migrar ClienteMigracion");

        	conn = Configuration.get().getConnection();
        	conn2 = Configuracion2.get2().getConnection2();
        	System.out.println("2222222222");
			PreparedStatement stmt = conn.prepareStatement("select " +
					" ru.id,ru.name,"+
					" ru.active," +
					" ru.cuit," +
					" ru.nro_inscripcion," +
					" ru.create_uid," +
					" ru.create_date " +
					" from res_partner ru where customer = true");

			ResultSet rs = stmt.executeQuery();
			PreparedStatement stmt2 = null;

			while (rs.next()) {
				System.out.print('1');
				stmt2 = conn2.prepareStatement("INSERT INTO clientes " +
						" (id,nombre,activo,cuit,nro_inscripcion,create_usuario_id,create_date)" +
						" VALUES (?,?,?,?,?,?,?)");

				stmt2.setLong(1, rs.getLong(1));
				stmt2.setString(2, rs.getString(2));
				stmt2.setBoolean(3, rs.getBoolean(3));
				stmt2.setString(4, rs.getString(4));
				stmt2.setString(5, rs.getString(5));
				if(rs.getLong(6) == 0 || rs.getLong(6) == 129){
					stmt2.setNull(6,0);
				}else{
					stmt2.setLong(6, rs.getLong(6));
				}

				stmt2.setDate(7, rs.getDate(7));

				stmt2.executeUpdate();

				PreparedStatement stmt3 = conn.prepareStatement("select " +
						" ru.id,ru.partner_id,"+
						" ru.street," +
						" ru.active," +
						" ru.city," +
						" ru.name," +
						" ru.zip," +
						" ru.country_id," +
						" ru.state_id," +
						" ru.localidad_id," +
						" ru.email," +
						" ru.numero," +
						" ru.phone," +
						" ru.fax," +
						" ru.mobile," +
						" ru.create_date," +
						" ru.create_uid " +
						" from res_partner_address ru where partner_id = ? ");
				stmt3.setLong(1, rs.getLong(1));

				ResultSet rs3 = stmt3.executeQuery();

				while (rs3.next()) {

					PreparedStatement stmt5 = conn2.prepareStatement("INSERT INTO clientes_direcciones " +
							" (id,cliente_id,calle,activo,ciudad,nombre,zip,pais_id,provincia_id," +
							"  localidad_id,email,numero,telefono,fax,mobile,create_date,create_usuario_id)" +
							" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt5.setLong(1, rs3.getLong(1));
					stmt5.setLong(2, rs3.getLong(2));
					stmt5.setString(3, rs3.getString(3));
					stmt5.setBoolean(4, rs3.getBoolean(4));
					stmt5.setString(5, rs3.getString(5));// ciudad
					stmt5.setString(6, rs3.getString(6));
					stmt5.setString(7, rs3.getString(7));

					if(rs3.getLong(8) == 0){
						stmt5.setNull(8,0);
					}else{
						stmt5.setLong(8, rs3.getLong(8));
					}

					if(rs3.getLong(9) == 0){
						stmt5.setNull(9,0);
					}else{
						stmt5.setLong(9, rs3.getLong(9));
					}

					if(rs3.getLong(10) == 0){
						stmt5.setNull(10,0);
					}else{
						stmt5.setLong(10, rs3.getLong(10));
					}

					stmt5.setString(11, rs3.getString(11));
					stmt5.setString(12, rs3.getString(12));
					stmt5.setString(13, rs3.getString(13));
					stmt5.setString(14, rs3.getString(14));
					stmt5.setString(15, rs3.getString(15));
					stmt5.setDate(16, rs3.getDate(16));
					if(rs3.getLong(17) == 0 || rs3.getLong(17) == 129){
						stmt5.setNull(17,0);
					}else{
						stmt5.setLong(17, rs3.getLong(17));
					}

					stmt5.executeUpdate();

				}

			}
			rs.close();
			stmt.close();
			stmt2.close();
			System.out.println("Termino a migrar ClienteMigracion");
        } catch (SQLException e) {
            //log.error("Error ResUserMigracion ", e);
        	play.Logger.error("errror", e);
        } finally {
        	if (conn2 != null) try { conn2.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
	}
}
