package com.flatiron.spring.FlatironSpring;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class BitcoinController {

    @Autowired
    private BitCoinService bitcoinService;

    public BitcoinController(BitCoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/api/price")
    public String price(@RequestParam(name = "targetName", defaultValue = "bitcoin") String name) {
        log.trace("Trace in beginning.");
        log.trace("Trace in end - but before return.");
        return "Price: " + bitcoinService.getBitcoinPrice(name);
    }
}
