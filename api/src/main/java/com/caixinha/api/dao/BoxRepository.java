package com.caixinha.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caixinha.api.entity.Box;
import com.caixinha.api.entity.BoxInterface;

public interface BoxRepository extends JpaRepository<Box, String> {
    List<BoxInterface> findByUserId(int userId);
}
