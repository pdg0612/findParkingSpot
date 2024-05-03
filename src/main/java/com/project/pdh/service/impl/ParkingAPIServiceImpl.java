package com.project.pdh.service.impl;

import com.project.pdh.service.ParkingAPIService;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class ParkingAPIServiceImpl implements ParkingAPIService {

    private final RestTemplate restTemplate;

    @Value("${api.service.key}")
    private String apiKey;

    @Autowired
    public ParkingAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getParkingData() throws URISyntaxException, UnsupportedEncodingException {
        String encodeResult = URLEncoder.encode(apiKey,"utf-8");
            String apiUrl = "http://api.data.go.kr/openapi/tn_pubr_prkplce_info_api?serviceKey=" + encodeResult;
            URI uri = new URI(apiUrl);
        System.out.println(uri);
        return restTemplate.getForObject(uri, String.class);
    }
}
