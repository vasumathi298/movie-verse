package com.movie.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.movie.application.constant.*;

@Controller
public class IndexController {

	@GetMapping(value = { Path.INDEX, "/" })
	public String indexHandler() {
		return Template.INDEX;
	}

}
