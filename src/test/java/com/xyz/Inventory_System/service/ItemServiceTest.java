package com.xyz.Inventory_System.service;


import ch.qos.logback.core.net.SyslogOutputStream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.xyz.Inventory_System.entity.Item;
import com.xyz.Inventory_System.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testGetAllItems() {
        // Mocking data
        Item item1 = new Item(1L, "kitkat", 15, 15);
        Item item2 = new Item(2L, "Maggi", 15, 5);
        List<Item> items = Arrays.asList(item1, item2);

        // Mocking the behavior of the itemRepository to return the list of items
        when(itemRepository.findAll()).thenReturn(items);

        // Calling the service method to get all items
        List<Item> retrievedItems = itemService.getAllItems();

        // Assertions
        assertEquals(2, retrievedItems.size()); // Ensure correct number of items
        assertEquals("kitkat", retrievedItems.get(0).getName()); // Validate item details
        assertEquals(15, retrievedItems.get(1).getQuantity()); // Validate another item detail
        // Add more assertions based on your requirements
        System.out.println(retrievedItems);
    }
}
