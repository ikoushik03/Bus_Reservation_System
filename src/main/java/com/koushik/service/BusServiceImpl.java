package com.koushik.service;

import com.koushik.exceptions.BusException;
import com.koushik.model.Bus;
import com.koushik.model.Route;
import com.koushik.repository.BusRepo;
import com.koushik.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements  BusService {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Override
    public Bus addBus(Bus bus) throws BusException {

        Route route = routeRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());

        if (route != null) {
            route.getBus().add(bus);
            bus.setRoute(route);
            return busRepo.save(bus);
        } else {
            throw new BusException("Bus not added due to technical error");
        }

    }

    @Override
    public Bus updateBus(Bus bus) throws BusException {

        Bus bus1 = new Bus();

        Optional<Bus> byId = busRepo.findById(bus.getBusId());
        if (byId.isPresent()) {

            bus1.setBusId(bus.getBusId());
            bus1.setBusName(bus.getBusName());
            bus1.setDriverName(bus.getDriverName());
            bus1.setBusType(bus.getBusType());
            bus1.setRouteFrom(bus.getRouteFrom());
            bus1.setRouteTo(bus.getRouteTo());
            bus1.setArrivalTime(bus.getArrivalTime());
            bus1.setDepartureTime(bus.getDepartureTime());
            bus1.setFarePerSeat(bus.getFarePerSeat());
            bus1.setSeats(bus.getSeats());
            bus1.setAvailableSeats(bus.getAvailableSeats());

            Route route = routeRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());

            if(route != null)
            {
                bus1.setRoute(route);
            }
            else {
                throw new BusException("Invalid route");
            }
            return busRepo.save(bus1);
        } else {
            throw new BusException(" Bus not found for id :: " + bus.getBusId());
        }
    }

    @Override
    public Bus deleteBus(int busId) throws BusException {
        Optional<Bus> byId = busRepo.findById(busId);
        if (byId.isPresent()) {
            busRepo.deleteById(busId);
            return byId.get();
        } else {
            throw new BusException(" Bus not found for id :: " + busId);
        }
    }


    @Override
    public Bus viewBus(int busId) throws BusException {

        Optional<Bus> byId = busRepo.findById(busId);
        if(byId.isPresent())
        {
            Bus bus = byId.get();
            return bus;
        }
        throw new BusException(" Bus not found for id :: " + busId);
    }

    @Override
    public List<Bus> viewBusByType(String BusType) throws BusException {
        List<Bus> byBusType = busRepo.findByBusType(BusType);
        if(byBusType.size()>0)
        {
            return byBusType;
        }
        else {
            throw new BusException("There is no bus of type "+ BusType);
        }
    }

    @Override
    public List<Bus> viewAllBuses() throws BusException {
        List<Bus> allBus = busRepo.findAll();
        if(allBus.size()>0)
        {
            return allBus;
        }
        throw  new BusException("There is no Bus Available");
    }
}
