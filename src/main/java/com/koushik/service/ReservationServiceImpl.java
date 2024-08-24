package com.koushik.service;

import com.koushik.dto.ReservationDTO;
import com.koushik.exceptions.ReservationException;
import com.koushik.model.Bus;
import com.koushik.model.Reservation;
import com.koushik.repository.BusRepo;
import com.koushik.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private BusRepo busRepo;

    @Override
    public Reservation addReservation(ReservationDTO reservationDTO) {

        Optional<Bus> bus = busRepo.findById(reservationDTO.getBusDTO().getBusId());

        if(reservationDTO.getJourneyDate().isBefore(LocalDate.now()));

        if(!reservationDTO.getDestination().equalsIgnoreCase(bus.get().getRouteTo()));
        int seat = bus.get().getAvailableSeats();
        if(seat<reservationDTO.getNoOfSeatsToBook());
        bus.get().setAvailableSeats(seat-reservationDTO.getNoOfSeatsToBook());
        Bus upadateBus=busRepo.save(bus.get());

        Reservation reservation = new Reservation();

        reservation.setReservationStatus("Successfull");
        reservation.setDestination(reservationDTO.getDestination());
        reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
        reservation.setFare((bus.get().getFarePerSeat())*(reservationDTO.getNoOfSeatsToBook()));
        reservation.setJourneyDate(reservationDTO.getJourneyDate());
        reservation.setReservationDate(LocalDate.now());
        reservation.setReservationTime(LocalTime.now());
  //      reservation.setUser(user);
        reservation.setBus(upadateBus);
        reservation.setReservationType("General");
        reservation.setSource(reservationDTO.getSource());

        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {


        return null;
    }

    @Override
    public Reservation deleteReservation(Integer reservationId) {
        return null;
    }

    @Override
    public Reservation viewAllReservation(Integer reservationId) {
        return null;
    }
}
