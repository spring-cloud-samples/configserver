package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.platform.config.server.EnableConfigServer;
import org.springframework.platform.netflix.eureka.EnableEurekaClient;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
