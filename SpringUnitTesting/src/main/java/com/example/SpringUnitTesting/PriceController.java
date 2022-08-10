package com.example.SpringUnitTesting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
public class PriceController {

    private CryptoService cryptoService;

    public PriceController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }


    @GetMapping("/crypto/{crypto}")
    public String price(@PathVariable String crypto) {
        log.trace("Inside price method");
        log.info("Generating html for page");
        return String.format("<h1>Hello User</h1>" +
                "Price of "+ crypto+ " is currently: " + cryptoService.getCryptoPrice(crypto));

    }

}