package com.aa.testcontainerexample.service;

import java.util.List;

import com.aa.testcontainerexample.dto.inventoryservice.request.InventoryItemRequestDto;
import com.aa.testcontainerexample.dto.inventoryservice.response.InventoryItemResponseDto;

public interface InventoryItemService {

	InventoryItemResponseDto save(InventoryItemRequestDto requestDto);

	InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId);
	
	void delete(Long itemId) throws Exception;

	InventoryItemResponseDto findById(Long itemId) throws Exception;
	
	List<InventoryItemResponseDto> findAll();


}
