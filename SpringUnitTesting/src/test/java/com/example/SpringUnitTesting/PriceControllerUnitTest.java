package com.example.SpringUnitTesting;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PriceControllerUnitTest {

    @Test
    void shouldReturnGreeting() {
        BitCoinService bitCoinService = Mockito.mock(BitCoinService.class);
        double bitcoinPrice = 1000.05;
        PriceController priceController = new PriceController(bitCoinService);
        when(bitCoinService.getBitcoinPrice()).thenReturn(String.valueOf(bitcoinPrice));
        String expected = "<h1>Hello User</h1>"+"Price of Bitcoin currently: " +
                bitcoinPrice;
        String actual = priceController.price();
        assertEquals(expected, actual);
    }
}