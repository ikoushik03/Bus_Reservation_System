package com.koushik.service;

import com.koushik.dto.ReservationDTO;
import com.koushik.exceptions.ReservationException;
import com.koushik.model.Reservation;

import javax.security.auth.login.LoginException;

public interface ReservationService {

    public Reservation addReservation(ReservationDTO reservationDTO)throws ReservationException;

    public Reservation updateReservation(Reservation reservation)throws ReservationException;

    public Reservation deleteReservation(Integer reservationId)throws ReservationException;

    public Reservation viewAllReservation(Integer reservationId)throws ReservationException;

   // public List<Reservations> getReservationDeatials(String key) throws ReservationException, LoginException;
}
