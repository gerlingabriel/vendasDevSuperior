package com.devsuperior.dsmeta.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findAll(String dateStart, String dateFinal, Pageable pageable){

        LocalDate now = dateStart == null ? LocalDate.now(): LocalDate.parse(dateStart);
    
        LocalDate end = dateFinal == null ? now.plusDays(1) : LocalDate.parse(dateFinal);       
  
        return repository.findByDateBetween(now, end, pageable);

    }
    
}
