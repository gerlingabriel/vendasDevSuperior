package com.devsuperior.dsmeta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.excetion.SaleNoExiste;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

    @Autowired
    private SaleRepository repository;

	public void sendSms(Long saleId) {

		Twilio.init(twilioSid, twilioKey);

        Optional<Sale> sale = repository.findById(saleId);

        checkIfIdExists(sale);

        String msg = "Vendedor" +  sale.get().getSellerName();

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}

    private void checkIfIdExists(Optional<Sale> sale) {

        if (!sale.isPresent()) {
            throw new SaleNoExiste("Sales no exists!");
        }
    }
}