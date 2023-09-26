package com.aa.testcontainerexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.testcontainerexample.dto.common.ApiError;
import com.aa.testcontainerexample.dto.common.ApiResponse;
import com.aa.testcontainerexample.dto.inventoryservice.request.InventoryItemRequestDto;
import com.aa.testcontainerexample.dto.inventoryservice.response.InventoryItemResponseDto;
import com.aa.testcontainerexample.service.InventoryItemService;


@RestController
@RequestMapping("/api/v1/item")
public class InventoryItemController {

	@Autowired
	InventoryItemService service;
	
	@PostMapping
	public ApiResponse<InventoryItemResponseDto> save(@RequestBody InventoryItemRequestDto requestDto) {
		ApiResponse<InventoryItemResponseDto> apiResponse = new ApiResponse<>();
		try {
			InventoryItemResponseDto responseDto = service.save(requestDto);
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseDto);
			apiResponse.setMessage("Entity saved successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@PutMapping("/{itemId}")
	public ApiResponse<InventoryItemResponseDto> update(@RequestBody InventoryItemRequestDto requestDto, @PathVariable Long itemId) {
		ApiResponse<InventoryItemResponseDto> apiResponse = new ApiResponse<>();
		try {
			InventoryItemResponseDto responseDto = service.update(requestDto, itemId);
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseDto);
			apiResponse.setMessage("Entity updated successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@DeleteMapping("/{itemId}")
	public ApiResponse<InventoryItemResponseDto> delete(@PathVariable Long itemId) {
		ApiResponse<InventoryItemResponseDto> apiResponse = new ApiResponse<>();
		try {
			service.delete(itemId);
			apiResponse.setSuccess(true);
			apiResponse.setMessage("Entity deleted successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@GetMapping("/{itemId}")
	public ApiResponse<InventoryItemResponseDto> findById(@PathVariable Long itemId) {
		ApiResponse<InventoryItemResponseDto> apiResponse = new ApiResponse<>();
		try {
			InventoryItemResponseDto responseDto = service.findById(itemId);
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseDto);
			apiResponse.setMessage("Entity fetched successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	@GetMapping
	public ApiResponse<List<InventoryItemResponseDto>> findAll() {
		ApiResponse<List<InventoryItemResponseDto>> apiResponse = new ApiResponse<>();
		try {
			//InventoryItemResponseDto responseDto = service.findById(itemId);
			//apiResponse.setSuccess(true);
			//apiResponse.setResponse(responseDto);
			//apiResponse.setMessage("Entity fetched successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
}
