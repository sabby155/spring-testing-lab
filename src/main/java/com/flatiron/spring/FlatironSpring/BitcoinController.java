package com.flatiron.spring.FlatironSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitcoinController {

    @Autowired
    private BitCoinService bitcoinService;

    public BitcoinController(BitCoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/price")
    public String price() {
        return "Price: " + bitcoinService.getBitcoinPrice();
    }
}
