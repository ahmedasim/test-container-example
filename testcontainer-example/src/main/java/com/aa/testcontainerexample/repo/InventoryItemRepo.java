package com.aa.testcontainerexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.testcontainerexample.entity.InventoryItemEntity;


@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItemEntity, Long> {

}
