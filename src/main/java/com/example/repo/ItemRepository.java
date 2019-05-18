package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.Items;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Items, Long> {
	
	
}
