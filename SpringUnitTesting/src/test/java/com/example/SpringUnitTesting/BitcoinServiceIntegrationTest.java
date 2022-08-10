package com.example.SpringUnitTesting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BitcoinServiceIntegrationTest {

    @Test
    void shouldReturnPrice() {
        BitCoinService bitCoinService = new BitCoinService();
        String currentPrice = bitCoinService.getBitcoinPrice();
        assertThat(currentPrice).isNotNull();

    }
}