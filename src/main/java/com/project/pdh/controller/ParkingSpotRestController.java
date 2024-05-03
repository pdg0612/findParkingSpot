package com.project.pdh.controller;

import com.project.pdh.service.ParkingAPIService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class ParkingSpotRestController {

    private final ParkingAPIService parkingAPIServicel;

    public ParkingSpotRestController(ParkingAPIService parkingAPIServicel) {
        this.parkingAPIServicel = parkingAPIServicel;
    }

    @GetMapping("api")
    public String api() throws URISyntaxException, UnsupportedEncodingException {
        return parkingAPIServicel.getParkingData();
    }
}

