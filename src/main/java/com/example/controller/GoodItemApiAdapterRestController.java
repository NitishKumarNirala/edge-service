package com.example.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Item;
import com.example.data.ItemClient;

@RestController
public class GoodItemApiAdapterRestController {

	  private final ItemClient itemClient;

	    public GoodItemApiAdapterRestController(ItemClient itemClient) {
	        this.itemClient = itemClient;
	    }

	    @GetMapping("/top-brands")
	    public Collection<Item> goodItems() {
	        return itemClient.readItems()
	                .getContent()
	                .stream()
	                .filter(this::isGreat)
	                .collect(Collectors.toList());
	    }

	    private boolean isGreat(Item item) {
	        return !item.getName().equals("Nike") &&
	                !item.getName().equals("Adidas") &&
	                !item.getName().equals("Reebok");
	    }
	}
