package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Client;

@Repository
public interface ClientRepositery extends JpaRepository<Client, Long> {

}
