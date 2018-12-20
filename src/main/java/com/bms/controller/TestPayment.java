package com.bms.controller;

import org.springframework.web.client.RestTemplate;

public class TestPayment {
	
	public static void main(String []args){
	
		//final String uri = "https://jsonplaceholder.typicode.com/posts/{id}";
		final String url = "https://api.sandbox.paypal.com/v1";
		/*Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "2");*/
	 
	    RestTemplate restTemplate = new RestTemplate();
	  
		String result = restTemplate.getForObject(url, String.class);
	     
	    System.out.println(result);
	}

	
}
