package com.multi.threading.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.threading.demo.client.JsonPlaceholderApiWebClient;
import com.multi.threading.demo.model.GetPostByIdReq;
import com.multi.threading.demo.model.ResponseObjectData;

import io.micrometer.common.util.StringUtils;

@Service
public class JsonPlaceholderApiService {
	
	@Autowired
	private JsonPlaceholderApiWebClient jsonPlaceholderApiWebClient;

	public ResponseObjectData getPostById(final GetPostByIdReq apiRequest) {
		final ResponseObjectData response = new ResponseObjectData();
		if(StringUtils.isNotEmpty(apiRequest.getPostIds())) {
			final String postid = apiRequest.getPostIds();
			response.setData(jsonPlaceholderApiWebClient.getPostById(postid));
		}
		return response;
	}

}
