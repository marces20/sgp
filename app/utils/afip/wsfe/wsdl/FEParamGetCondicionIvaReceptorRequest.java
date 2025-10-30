package utils.afip.wsfe.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEAuthRequest", propOrder = {
    "token",
    "sign",
    "cuit"
})
public class FEParamGetCondicionIvaReceptorRequest {

	@XmlElement(name = "Token")
    protected String token;
    @XmlElement(name = "Sign")
    protected String sign;
    @XmlElement(name = "Cuit")
    protected long cuit;

    public String getToken() {
        return token;
    }

    public void setToken(String value) {
        this.token = value;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String value) {
        this.sign = value;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long value) {
        this.cuit = value;
    }
}
