package com.aa.testcontainerexample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.testcontainerexample.dto.inventoryservice.request.InventoryItemRequestDto;
import com.aa.testcontainerexample.dto.inventoryservice.response.InventoryItemResponseDto;
import com.aa.testcontainerexample.entity.InventoryItemEntity;
import com.aa.testcontainerexample.repo.InventoryItemRepo;
import com.aa.testcontainerexample.service.InventoryItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	InventoryItemRepo repo;
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Override
	public InventoryItemResponseDto save(InventoryItemRequestDto requestDto) {
		InventoryItemEntity entity = objectMapper.convertValue(requestDto, InventoryItemEntity.class);
		repo.save(entity);
		return objectMapper.convertValue(entity, InventoryItemResponseDto.class);
	}

	@Override
	public InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId) {
		return null;
	}

	@Override
	public void delete(Long itemId) throws Exception {
		Optional<InventoryItemEntity> opt = repo.findById(itemId);
		if(opt.isPresent()) {
			repo.delete(opt.get());
		}else {
			throw new Exception("Resounce Not Found");
		}
	}

	@Override
	public InventoryItemResponseDto findById(Long itemId) throws Exception {
		Optional<InventoryItemEntity> opt = repo.findById(itemId);
		if(opt.isPresent()) {
			return objectMapper.convertValue(opt.get(), InventoryItemResponseDto.class);
		}else {
			throw new Exception("Resounce Not Found");
		}
	}

	@Override
	public List<InventoryItemResponseDto> findAll() {
		List<InventoryItemEntity> itemEntities = repo.findAll();
		return itemEntities.stream().map(e -> objectMapper.convertValue(e, InventoryItemResponseDto.class)).toList();
	}

}
