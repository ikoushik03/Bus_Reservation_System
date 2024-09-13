package com.koushik.controller;

import com.koushik.exceptions.BusException;
import com.koushik.model.Bus;
import com.koushik.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/find/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable int busId)throws BusException{

        return new ResponseEntity<Bus>(busService.viewBus(busId),HttpStatus.OK);
    }

    @GetMapping("/buses/{busType}")
    public ResponseEntity<List<Bus>> getBusesByType(@PathVariable("busType") String busType) throws BusException{

        List<Bus> listOfBuses=busService.viewBusByType(busType);

        return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
    }


    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> getAllBuses() throws BusException{

        List<Bus> listOfBuses=busService.viewAllBuses();

        return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
    }



}
