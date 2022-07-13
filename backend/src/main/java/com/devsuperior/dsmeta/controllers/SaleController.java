package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleServices;
import com.devsuperior.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    
    @Autowired
    private SaleServices services;

    @Autowired
    private SmsService smsService;

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Sale> findAll(
        String dateStart,
        String dateFinal,
        Pageable pageable){
        return services.findAll(dateStart, dateFinal, pageable);
    }

    @GetMapping("/{id}/sendSms")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public void sendSms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
