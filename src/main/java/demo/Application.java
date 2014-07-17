package demo;

import java.util.Arrays;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.cloudfoundry.community.servicebroker.service.BeanCatalogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.platform.cloudfoundry.broker.FreeServiceDefinitionFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@Import(org.springframework.platform.config.server.Application.class)
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public BeanCatalogService catalogService() {
		return new BeanCatalogService(catalog());
	}

	@Bean
	public Catalog catalog() {
		return new Catalog(Arrays.asList(serviceDefinition()));
	}

	@Bean
	@ConfigurationProperties("service.definition")
	public ServiceDefinition serviceDefinition() {
		return new FreeServiceDefinitionFactory("config-").create("configserver",
				"Spring platform config server");
	}

}
