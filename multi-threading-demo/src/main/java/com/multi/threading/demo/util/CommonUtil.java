package com.multi.threading.demo.util;

import java.time.Duration;
import java.time.Instant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.multi.threading.demo.constant.ApiStatus;
import com.multi.threading.demo.model.ResponseObjectData;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommonUtil {

	public ResponseEntity<ResponseObjectData> getSuccessResponse(final ResponseObjectData responseObjectData,
			final Instant start, final String reqMethod) {
		responseObjectData.setResponseStatus(ApiStatus.SUCCESS.name());
		log.info("{} api completed in {} time", reqMethod, Duration.between(start, Instant.now()).toMillis());
		return new ResponseEntity<ResponseObjectData>(responseObjectData, HttpStatus.OK);
	}

	public ResponseEntity<ResponseObjectData> getFailureResponse(final Exception exception, final Instant start,
			final String reqMethod) {
		final ResponseObjectData responseObjectData = new ResponseObjectData();
		responseObjectData.setResponseStatus(ApiStatus.FAILURE.name());
		if (StringUtils.isEmpty(exception.getMessage())) {
			responseObjectData.setError("Error Processing your request");
		} else {
			responseObjectData.setError(exception.getMessage());
		}
		log.info("{} api completed in {} time", reqMethod, Duration.between(start, Instant.now()).toMillis());
		return new ResponseEntity<ResponseObjectData>(responseObjectData, HttpStatus.OK);
	}
}
