package com.multi.threading.demo.executor;


import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import java.time.Instant;

import com.multi.threading.demo.client.JsonPlaceholderApiWebClient;
import com.multi.threading.demo.model.GetPostByIdApiRes;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GetPostByIdAsyncExecutor {
	
	@Autowired
	private JsonPlaceholderApiWebClient jsonPlaceHolderApiWebClient;
	
	@Async
	public Future<GetPostByIdApiRes> getPostById(final String postId){
		return CompletableFuture.supplyAsync(()->{
			final Instant start = Instant.now();
			log.info("Calling Json Place Holder API for postId : {}", postId);
			final GetPostByIdApiRes apiRes = jsonPlaceHolderApiWebClient.getPostById(postId) ;
			log.info("Json Place holder Service completed. Time taken : {} ms", Duration.between(start, Instant.now()).toMillis());
			return apiRes;
		});
	}
	

}
