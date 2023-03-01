package net.kepco.srm.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import net.kepco.srm.framework.config.BondBootInitialization;

@SpringBootApplication
@ImportResource("classpath*:/bond/spring/context-*.xml")
@Import(BondBootInitialization.class)
@ComponentScan(basePackages = "net.kepco.srm")
public class BondBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BondBootApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.setLogStartupInfo(false);
		springApplication.run(args);
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
	}
}