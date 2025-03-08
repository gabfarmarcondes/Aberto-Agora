package br.com.abertoagora;

import br.com.abertoagora.repository.EstabelecimentoElasticRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.abertoagora.repository", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = EstabelecimentoElasticRepository.class))
@EnableElasticsearchRepositories(basePackages = "br.com.abertoagora.repository")
public class AbertoAgoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbertoAgoraApplication.class, args);
	}

}
