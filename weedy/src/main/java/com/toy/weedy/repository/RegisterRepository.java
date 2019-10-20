package com.toy.weedy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.weedy.entity.Boards;

public interface RegisterRepository extends JpaRepository<Boards, Integer>{

}
