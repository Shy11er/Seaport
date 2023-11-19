package com.example.Seaport.repository;

import com.example.Seaport.model.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.ListCrudRepository;

public interface Repository extends ListCrudRepository<Post, Integer> { }