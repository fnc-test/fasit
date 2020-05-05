package no.nav.aura.envconfig.model.infrastructure;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import no.nav.aura.envconfig.util.SerializablePredicate;

import java.util.Arrays;
import java.util.List;

import static no.nav.aura.envconfig.model.infrastructure.Zone.FSS;
import static no.nav.aura.envconfig.model.infrastructure.Zone.SBS;

public enum Domain {
    Utvikling("utvikling.local", EnvironmentClass.u, FSS),
    Devillo("devillo.no", EnvironmentClass.u, FSS, SBS),
    DevilloT("devillo-t.local", EnvironmentClass.u, SBS),
    TestLocal("test.local", EnvironmentClass.t, FSS),
    OeraT("oera-t.local", EnvironmentClass.t, SBS),
    PreProd("preprod.local", EnvironmentClass.q, FSS),
    OeraQ("oera-q.local", EnvironmentClass.q, SBS),
    Adeo("adeo.no", EnvironmentClass.p, FSS),
    Oera("oera.no", EnvironmentClass.p, SBS);

    private final String fullyQualifiedDomainName;
    private final EnvironmentClass envClass;
    private List<Zone> zone;

    private Domain(String fqdn, EnvironmentClass envClass, Zone... zone) {
        this.fullyQualifiedDomainName = fqdn;
        this.envClass = envClass;
        this.zone = Arrays.asList(zone);
    }

    public String getFqn() {
        return fullyQualifiedDomainName;
    }

    public EnvironmentClass getEnvironmentClass() {
        return envClass;
    }

    public boolean isInZone(Zone zone) {
        return this.zone.contains(zone);
    }

    @SuppressWarnings("serial")
    public static List<Domain> getByEnvironmentClass(final EnvironmentClass environmentClass) {
        List<Domain> allDomains = Lists.newArrayList(values());
        if (environmentClass == null) {
            return allDomains;
        } else {
            return Lists.newArrayList(Iterables.filter(allDomains, new SerializablePredicate<Domain>() {
                public boolean test(Domain domain) {
                    return environmentClass == domain.getEnvironmentClass();
                }
            }));
        }
    }
    
    public static Domain from(final EnvironmentClass environmentClass, Zone zone){
        if(environmentClass==EnvironmentClass.u){
            return Domain.Devillo;
        }
        
        List<Domain> domains = getByEnvironmentClass(environmentClass);
        for (Domain domain : domains) {
            if(domain.isInZone(zone)){
                return domain;
            }
        }
        throw new IllegalArgumentException("Unable to determine domain for " + environmentClass + ":" + zone );
    }

    public List<Zone> getZone() {
        return this.zone;
    }

    public static Domain fromFqdn(String name) {
        for (Domain d : values()) {
            if (d.getFqn().equalsIgnoreCase(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("Domain with name not found: " + name);
    }

    public String getNameWithZone() {
        return String.format("%s (%s)", fullyQualifiedDomainName, zone);
    }
}
