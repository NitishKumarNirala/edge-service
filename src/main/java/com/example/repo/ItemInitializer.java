package com.example.repo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.domain.Items;

@Component
public class ItemInitializer implements CommandLineRunner {

	private final ItemRepository itemRepository;

	ItemInitializer(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	    public void run(String... args) throws Exception {
	        Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
	                .forEach(item -> itemRepository.save(new Items(item)));
	        itemRepository.findAll().forEach(System.out::println);
	    }
}
