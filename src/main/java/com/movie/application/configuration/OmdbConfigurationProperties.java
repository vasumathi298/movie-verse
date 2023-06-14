package com.movie.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.movie.application")
public class OmdbConfigurationProperties {

	private OMDB omdb = new OMDB();

	@Data
	public class OMDB {
		private String apiKey;
		private String url;	
	}

}
