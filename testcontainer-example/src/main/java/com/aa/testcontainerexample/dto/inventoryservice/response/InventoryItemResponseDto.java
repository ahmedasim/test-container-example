package com.aa.testcontainerexample.dto.inventoryservice.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemResponseDto {
	private Long itemId;
    private String itemCode;
    private String itemName;
    private Long categoryId;
    private Integer statusId;
    private BigDecimal cost;
}
