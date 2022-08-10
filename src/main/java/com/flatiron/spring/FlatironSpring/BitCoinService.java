package com.flatiron.spring.FlatironSpring;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BitCoinService {

    public String getBitcoinPrice(String name) {
        String apiURL = "https://api.coincap.io/v2/assets/" + name;
        RestTemplate restTemplate = new RestTemplate();
        Data result = restTemplate.getForObject(apiURL, Data.class);
        log.info("Received data from crypto API. Here's data ID: " + result.getData().getId());
        return result.getData().getPriceUsd();
    }
}

@Getter
@Setter
class BitCoin {
    private String id;
    private String symbol;
    private String priceUsd;
}

@Getter
@Setter
class Data{
    private BitCoin data;
}
