package com.pbsi.fuelfilling.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	private Logger LOG = Logger.getLogger(HomeController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("init Method is started");
		
		LOG.info("init Method is Ended");
		return "home";
	}
	
}
