package com.rafael.cr.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.cr.aop.annotatios.InterceptorBusiness;
import com.rafael.cr.aop.beans.Request;
import com.rafael.cr.aop.beans.Response;

import io.swagger.annotations.Api;

/**
 * The Class Controller.
 *
 * @author carpinteyror
 * @version 1.0
 * @since 18/04/2018
 */
@Api
@RestController
@RequestMapping("/aop/")
public class Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	/**
	 * Method 1.
	 *
	 * @author carpinteyror
	 * @param request the request
	 * @param one the one
	 * @param two the two
	 * @param three the three
	 * @return the response entity
	 */
	@RequestMapping(value = "method1", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Response> method1(@RequestBody Request request,
			@RequestHeader(name = "one", required = false) String one,
			@RequestHeader(name = "two") String two,
			@RequestHeader(name = "three") String three) {
		LOGGER.info("Entry for test {}", nameMethod());
		Response response = new Response();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		try {
			LOGGER.info("Headers {} {} {}", one, two, three);
			response.setSuccess(true);
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			response.setCodeOperation(-1);
		}
		
		return new ResponseEntity<>(response, status);
	}

	@RequestMapping(value = "method2", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@InterceptorBusiness
	public ResponseEntity<Response> method2(@RequestBody Request request,
			@RequestHeader(name = "one", required = false) String one,
			@RequestHeader(name = "two") String two,
			@RequestHeader(name = "three") String three) {
		LOGGER.info("Entry for test {}", nameMethod());
		Response response = new Response();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		try {
			LOGGER.info("Headers {} {} {}", one, two, three);
			response.setSuccess(true);
			status = HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			response.setCodeOperation(-1);
		}
		
		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * Name method.
	 *
	 * @author carpinteyror
	 * @return the string
	 */
	private String nameMethod() {
		return new Exception().getStackTrace()[1].getMethodName();
	}
	
}
