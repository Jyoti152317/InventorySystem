package com.xyz.Inventory_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.Inventory_System.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
