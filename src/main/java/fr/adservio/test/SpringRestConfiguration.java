package fr.adservio.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

@Configuration
public class SpringRestConfiguration implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		config.useHalAsDefaultJsonMediaType(false);
		config.setDefaultMediaType(MediaType.APPLICATION_JSON);
	}
}