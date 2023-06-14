package com.movie.application.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.movie.application.configuration.*;
import com.movie.application.configuration.OmdbConfigurationProperties.OMDB;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(OmdbConfigurationProperties.class)
public class UrlGenerator {

	@Autowired
	private OmdbConfigurationProperties omdbConfigurationProperties;

    public String generate(String movieTitle) {
        OmdbConfigurationProperties.OMDB properties = omdbConfigurationProperties.getOmdb();
        return properties.getUrl()
                .replace("{key}", properties.getApiKey())
                .replace("{title}", movieTitle)
                .trim()
                .replace(" ", "_");
    }

}

