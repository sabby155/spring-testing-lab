package com.flatiron.spring.FlatironSpring;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BitcoinServiceUnitTest {

    @Test
    void shouldReturnCost() {
        BitCoinService bitCoinService = Mockito.mock(BitCoinService.class);
        String bitcoinPrice = "1000.056";
        String name = "bitcoin";
        BitcoinController priceController = new BitcoinController(bitCoinService);
        when(bitCoinService.getBitcoinPrice(name)).thenReturn(bitcoinPrice);
        String expected = "Price: " +
                bitcoinPrice;
        String actual = priceController.price(name);
        assertEquals(expected, actual);
    }


}