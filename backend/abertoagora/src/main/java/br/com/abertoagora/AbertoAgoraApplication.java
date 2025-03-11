package br.com.abertoagora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.abertoagora.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "br.com.abertoagora.repository.elastic")
public class AbertoAgoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbertoAgoraApplication.class, args);
	}

}
