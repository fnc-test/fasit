package no.nav.aura.appconfig.exposed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExposedEjb extends ExposedService {

	@XmlAttribute
	private String jndi;

	@XmlAttribute
	private String beanHomeInterface;

	@XmlAttribute
	private String beanComponentInterface;

	public String getJndi() {
		return jndi;
	}

	public void setJndi(String jndi) {
		this.jndi = jndi;
	}

	public String getBeanHomeInterface() {
		return beanHomeInterface;
	}

	public void setBeanHomeInterface(String beanHomeInterface) {
		this.beanHomeInterface = beanHomeInterface;
	}

	public String getBeanComponentInterface() {
		return beanComponentInterface;
	}

	public void setBeanComponentInterface(String beanComponentInterface) {
		this.beanComponentInterface = beanComponentInterface;
	}
}
