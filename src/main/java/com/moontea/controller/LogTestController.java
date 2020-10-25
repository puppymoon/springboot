package com.moontea.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/log")
	public String logTest() {

		logger.error("error");
		logger.warn("warn");
		logger.debug("debug");
		logger.trace("trace");
		logger.info("info");

		return "LogTest";
	}

}
