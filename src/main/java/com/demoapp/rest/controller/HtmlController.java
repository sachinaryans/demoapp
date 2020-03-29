package com.demoapp.rest.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// TODO: Auto-generated Javadoc

/**
 * The Class HtmlController.
 * @author Sachin
 */
@Controller
@RequestMapping(path = "/")
public class HtmlController {
	
	/**
	 * Home page.
	 *
	 * @param model the model
	 * @return the string
	 */
	public String homePage(Map<String, Object> model) {
		return "index";
	}

}
