package com.aa.testcontainerexample.dto.inventoryservice.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItemRequestDto {
	private Long itemId;
    private String itemCode;
    private String itemName;
    private Long categoryId;
    private Integer statusId;
    private BigDecimal cost;
}
