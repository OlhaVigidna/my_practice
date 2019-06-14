package com.example.demo.dao;

import com.example.demo.models.DocumentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDetailsDAO extends JpaRepository<DocumentDetails, Integer>{
}
