package com.multi.threading.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ResponseObjectData {
	
	private String responseStatus;
	private Object data;
	private Object error;

}
