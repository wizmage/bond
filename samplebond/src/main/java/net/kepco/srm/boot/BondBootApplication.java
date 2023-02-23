package net.kepco.srm.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ImportResource({"classpath:/bond/springmvc/dispatcher-servlet.xml","classpath*:/bond/spring/context-*.xml"})
@Import(BondBootInitialization.class)
@ComponentScan(basePackages="net.kepco.srm")
@EntityScan("net.kepco.srm.bond.domain")
@EnableJpaRepositories("net.kepco.srm.bond.repository")
public class BondBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BondBootApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.setLogStartupInfo(false);
		springApplication.run(args);
	}

}
