package com.aa.testcontainerexample.dto.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
	
	private boolean success;
	private String message;
	private T response;
	
	private Timestamp timestamp = new Timestamp(new Date().getTime()); 
	
	private List<ApiError> apiErrors;
	
}
