package guru.springframework.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("guru.springframework.repositories")
public class BasicConfiguration {
}
