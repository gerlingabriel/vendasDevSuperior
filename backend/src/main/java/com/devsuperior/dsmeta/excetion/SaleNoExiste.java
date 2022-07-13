package com.devsuperior.dsmeta.excetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SaleNoExiste extends RuntimeException{

    public SaleNoExiste(String arg0) {
        super(arg0);
    }

    
}
