package com.koushik.service;

import com.koushik.exceptions.RouteException;
import com.koushik.model.Route;
import com.koushik.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteRepo routeRepo;

    @Override
    public Route addRoute(Route route) throws RouteException {

        Route routes = routeRepo.save(route);

        if(routes != null)
        {
            return routes;
        }
        else {
            throw  new RouteException("Route not added due to technical error");
        }

    }

    @Override
    public Route updateRoute(Route route) throws RouteException {

        Route route1 = new Route();

        Optional<Route> byId = routeRepo.findById(route.getRouteId());
        if(byId.isPresent())
        {
            route1.setRouteId(route.getRouteId());
            route1.setDistance(route.getDistance());
            route1.setRouteFrom(route.getRouteFrom());
            route1.setRouteTo(route.getRouteTo());
            return  routeRepo.save(route1);
        }
        else {

            throw new RouteException("Route Not found");
        }


    }

    @Override
    public Route deleteRoute(int routeId) throws RouteException {

        Optional<Route> byId = routeRepo.findById(routeId);
        if(byId.isPresent())
        {
            Route r = byId.get();

            routeRepo.delete(r);

            return r;
        } else {
            throw new RouteException(" Route not found for id :: " + routeId);
        }

    }

    @Override
    public Route viewRoute(int routeId) throws RouteException {

        Optional<Route> byId = routeRepo.findById(routeId);

        Route route = null;
        if (byId.isPresent()) {
            return route = byId.get();
        } else {
            throw new RouteException(" Route not found for id :: " + routeId);
        }
    }

    @Override
    public List<Route> viewAllRoute() throws RouteException {
        List<Route> routes = routeRepo.findAll();

        if(routes!=null) {
            return routes;
        }else {
            throw new RouteException("rout not found");
        }

    }
}
