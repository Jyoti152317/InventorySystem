package com.xyz.Inventory_System.controller;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.xyz.Inventory_System.entity.Item;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/items";
    }

    @Test
    public void testGetAllItems() {
        ResponseEntity<String> response = restTemplate.getForEntity(getRootUrl(), String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions based on the expected behavior
    }

    @Test
    public void testGetItemById() {
        ResponseEntity<Item> responseEntity = restTemplate.getForEntity(getRootUrl() +"/{id}", Item.class, 1L);
        Item item = responseEntity.getBody();
        Assert.assertNotNull(item);
        
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testAddItem() {
        Item item = new Item();
        item.setName("New Item");
        item.setQuantity(10);
        item.setPrice(50);

        ResponseEntity<Item> postResponse = restTemplate.postForEntity(getRootUrl(), item, Item.class);
        Assert.assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
    }

    @Test
    public void testUpdateItem() {
        long id = 1L;
        Item item = restTemplate.getForObject(getRootUrl() + "/{id}", Item.class, id);
        item.setName("Updated Name");

        restTemplate.put(getRootUrl() + "/{id}", item, id);
        Item updatedItem = restTemplate.getForObject(getRootUrl() + "/{id}", Item.class, id);
        Assert.assertEquals("Updated Name", updatedItem.getName());
    }

    @Test
    public void testDeleteItem() {
        long id = 2L;
        Item item = restTemplate.getForObject(getRootUrl() + "/{id}", Item.class, id);
        Assert.assertNotNull(item);

        restTemplate.delete(getRootUrl() + "/{id}", id);

        try {
            restTemplate.getForObject(getRootUrl() + "/{id}", Item.class, id);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }
}

