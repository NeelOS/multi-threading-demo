package com.multi.threading.demo.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.multi.threading.demo.model.GetPostByIdApiRes;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JsonPlaceholderApiWebClient {

	
	private static final String URI = "https://jsonplaceholder.typicode.com/posts/{postId}";

	@Autowired
	private WebClient webClient;

	public GetPostByIdApiRes getPostById(final String postId) {
		final GetPostByIdApiRes defaultResponse = new GetPostByIdApiRes();
		final Map<String, String> params = new HashMap<>();
		params.put("postId", postId);
		return webClient.get()
				.uri(URI, params)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatusCode::isError, clientResponse -> {
					log.error("Error in calling Json Placeholder API, Status code : {} ", clientResponse.statusCode());
					return clientResponse.bodyToMono(String.class).map(Exception::new) ;
				})
				.bodyToMono(GetPostByIdApiRes.class)
				.defaultIfEmpty(defaultResponse)
				.block();
	}

}
