package com.movie.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.application.constant.*;
import com.movie.application.service.*;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ResultController {

	private final MovieService movieService;

	@PostMapping(value = Path.RESULT)
	public String result(@RequestParam("title") final String movieTitle, final Model model) {
		final var response = movieService.find(movieTitle);

		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND))
			return Template.NOT_FOUND;

		model.addAttribute("movie", movieService.find(movieTitle).getBody());
		return Template.RESULT;
	}

}