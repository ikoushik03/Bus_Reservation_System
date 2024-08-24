package com.koushik.controller;

import com.koushik.dto.ReservationDTO;
import com.koushik.exceptions.ReservationException;
import com.koushik.model.Reservation;
import com.koushik.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/save")
    public ResponseEntity<Reservation> save(@RequestBody ReservationDTO reservationDTO) throws ReservationException {
        Reservation reservation = reservationService.addReservation(reservationDTO);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }
}
