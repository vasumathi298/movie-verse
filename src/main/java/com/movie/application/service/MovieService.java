package com.movie.application.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.application.dto.*;
import com.movie.application.utility.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final UrlGenerator urlGenerator;
	private final RestTemplate restTemplate;

	public ResponseEntity<MovieDto> find(final String movieTitle) {
		final var response = restTemplate.getForEntity(urlGenerator.generate(movieTitle), MovieDto.class);
		final var movieDto = response.getBody();

		if (movieDto.getResponse().equalsIgnoreCase("FALSE"))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(movieDto);
	}

}
