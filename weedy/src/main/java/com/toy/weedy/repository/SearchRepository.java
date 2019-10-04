package com.toy.weedy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.weedy.entity.Apps;

public interface SearchRepository extends JpaRepository<Apps, Integer>{

}
