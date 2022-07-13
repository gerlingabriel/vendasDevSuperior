package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.services.SaleServices;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    
    @Autowired
    private SaleServices services;

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Sales> findAll(
        String dateStart,
        String dateFinal,
        Pageable pageable){
        return services.findAll(dateStart, dateFinal, pageable);
    }
}
