package net.kepco.srm.framework.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("net.kepco.srm.bond.domain")
@EnableJpaRepositories("net.kepco.srm.bond.repository")
public class BondHibernateConfig {
}
