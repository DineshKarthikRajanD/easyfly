package com.easyfly.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WelcomeController {
	
	@Value("${server.port}")
	private int port;

 

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String welcome() {
		log.info("home page called...");
		return "index";
	}
	@GetMapping(value = "/node_details", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String nodeDetails() {
		String ip = null;
		String hostName = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "Welcome to easyfly. Application version:v1 running on Ip: " + ip + "  hostname: "+ hostName + "   port: "+ port ;
	}
}
