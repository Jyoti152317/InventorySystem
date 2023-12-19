package com.xyz.Inventory_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xyz.Inventory_System.dto.ItemDTO;
import com.xyz.Inventory_System.entity.Item;
import com.xyz.Inventory_System.service.ItemService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@GetMapping
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		Item item = itemService.getItemById(id);
		return ResponseEntity.ok().body(item);
	}

	@PostMapping
	public ResponseEntity<Item> addItem(@Valid @RequestBody ItemDTO item) {
		Item newItem = itemService.addItem(item);
		return new ResponseEntity<>(newItem, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id, @Valid @RequestBody ItemDTO itemDTO) {

		Item updatedItem = itemService.updateItem(id, itemDTO);
		return ResponseEntity.ok().body(updatedItem);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return ResponseEntity.ok().build();
	}
}