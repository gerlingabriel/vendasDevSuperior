package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sales;

public interface SaleRepository extends JpaRepository<Sales, Long> {

    Page<Sales> findByDateBetween(LocalDate start,LocalDate end, Pageable pageable);
    
}
