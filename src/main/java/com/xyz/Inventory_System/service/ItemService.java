 
package com.xyz.Inventory_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.Inventory_System.dto.ItemDTO;
import com.xyz.Inventory_System.entity.Item;
import com.xyz.Inventory_System.exception.ItemNotFoundException;
import com.xyz.Inventory_System.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
    	 return itemRepository.findById(id)
                 .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + id));
    }

    public Item addItem(@Valid ItemDTO itemDTO) {
            Item item = Item.build(itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQuantity());
            return itemRepository.save(item);
    }

    
    public Item updateItem(Long id,@Valid ItemDTO itemDTO) {
        Optional<Item> optionalExistingItem = itemRepository.findById(id);
        if (optionalExistingItem.isPresent()) {
            Item existingItem = optionalExistingItem.get();
            Item item = Item.build(itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQuantity());
            if (item.getName() != null && !item.getName().isEmpty()) {
                existingItem.setName(item.getName());
            }
            if (item.getQuantity() >= 0) {
                existingItem.setQuantity(item.getQuantity());
            }
            if (item.getPrice() >= 0) {
                existingItem.setPrice(item.getPrice());
            }
            return itemRepository.save(existingItem);
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + id);
        }
    }


    public void deleteItem(Long id) {
    	Item itemToDelete = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with ID: " + id));

        // If the item is found, proceed with deletion
        itemRepository.delete(itemToDelete);
    }
}