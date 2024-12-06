package com.multi.threading.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPostByIdReq {
	
	@NotEmpty(message = "Empty postIds Field")
	private String postIds;
	@NotEmpty(message = "Empty boolean field for Multi-threading")
	private boolean doMultiThreading;

}
