package no.nav.aura.appconfig.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AbacSecurity {

    /** reference to the credentials in fasit for the service user from AD for this application */
    @XmlAttribute
    private String serviceUserResourceAlias;

    public String getServiceUserResourceAlias() {
        return serviceUserResourceAlias;
    }

    public void setServiceUserResourceAlias(String serviceUser) {
        this.serviceUserResourceAlias = serviceUser;
    }
}
