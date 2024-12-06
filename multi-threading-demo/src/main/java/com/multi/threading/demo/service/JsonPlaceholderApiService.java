package com.multi.threading.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.threading.demo.client.JsonPlaceholderApiWebClient;
import com.multi.threading.demo.model.GetPostByIdApiRes;
import com.multi.threading.demo.model.GetPostByIdReq;
import com.multi.threading.demo.model.ResponseObjectData;

@Service
public class JsonPlaceholderApiService {

	@Autowired
	private JsonPlaceholderApiWebClient jsonPlaceholderApiWebClient;

	public ResponseObjectData getPostById(final GetPostByIdReq apiRequest) {
		final ResponseObjectData response = new ResponseObjectData();
		final List<GetPostByIdApiRes> postByidResponses = new ArrayList<>();
		if (StringUtils.isNotEmpty(apiRequest.getPostIds())) {
			final List<String> postids = Arrays.asList(StringUtils.split(apiRequest.getPostIds(), ","));
			if (apiRequest.isDoMultiThreading()) {

			} else {
				postids.forEach(postid -> {
					postByidResponses.add(jsonPlaceholderApiWebClient.getPostById(postid));
				});
			}
			response.setData(postByidResponses);
		}
		return response;
	}

}
