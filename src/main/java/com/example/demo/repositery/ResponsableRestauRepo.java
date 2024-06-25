package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ResponsableRestau;

@Repository
public interface ResponsableRestauRepo extends JpaRepository<ResponsableRestau, Long> {

}
