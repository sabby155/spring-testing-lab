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
        BitcoinController priceController = new BitcoinController(bitCoinService);
        when(bitCoinService.getBitcoinPrice()).thenReturn(bitcoinPrice);
        String expected = "Price: " +
                bitcoinPrice;
        String actual = priceController.price();
        assertEquals(expected, actual);
    }


}