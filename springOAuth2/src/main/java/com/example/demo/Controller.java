package com.example.demo;

import java.security.Principal;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;



@org.springframework.stereotype.Controller
//@RestController
public class Controller {

	@GetMapping("/user")
	public String getUser(Principal principal) 
	{
		return "Home";
	}
	
}
