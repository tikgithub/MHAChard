package com.mhacard.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class LoginServiceImpl {
	public String restAuthentication(String username, String password) {
		try {

//			String url = "http://10.1.1.5:8889";
//			RestTemplate rest = new RestTemplate();
//		    HttpHeaders header = new HttpHeaders();
//			header.setContentType(MediaType.APPLICATION_JSON);
//			header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//			header.add("x-api-key", "123456789");
//			Map<String , Object> map = new HashMap<String, Object>();
//			System.out.println("Sending Request......");
//			HttpEntity<?> httpRequest = new HttpEntity<>("{\"Request\":{ \"RequestID\": \"1\",\"Username\": \"" + username + "\",\"Password\": \"" + password +"\",\"SearchDetail\": \"?\"}}",header);
//			String json = rest.postForObject(url, httpRequest, String.class);
//			JSONParser parser = new JSONParser();
//			Object obj = parser.parse(json);
//			JSONObject resultOut = (JSONObject) obj; // Parser result out
//			JSONObject objectOut = (JSONObject) resultOut.get("ResultOut");
//		return objectOut.get("ErrorCode").toString();
			
			
		//Comment Below code for using API and Comment Above code to use API
		System.out.println(username + " " + password);
		if(username.equals("Jack") && password.equals("123")) {
			System.out.println("return 1");
			return "1";
		}
		return "0";
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
