package com.multi.threading.demo.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.threading.demo.model.GetPostByIdReq;
import com.multi.threading.demo.model.ResponseObjectData;
import com.multi.threading.demo.service.JsonPlaceholderApiService;
import com.multi.threading.demo.util.CommonUtil;



@RestController
public class JsonPlaceholderApiGetPost {
	
	
	@Autowired
	private CommonUtil commonUtil; 
	
	@Autowired
	private JsonPlaceholderApiService jsonPlaceholderApiService;
	
	@PostMapping("/getPostById")
	public ResponseEntity<ResponseObjectData> getWeatherData(@RequestBody final GetPostByIdReq apiRequest){
		
		final Instant start = Instant.now();
		try {
			return commonUtil.getSuccessResponse(jsonPlaceholderApiService.getPostById(apiRequest), start, "getWeatherData");
		} catch (final Exception exception) {
			return commonUtil.getFailureResponse(exception, start, "getWeatherData");
		}
		
	}

}
