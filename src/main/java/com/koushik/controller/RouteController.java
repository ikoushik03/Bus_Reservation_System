package com.koushik.controller;

import com.koushik.exceptions.RouteException;
import com.koushik.model.Route;
import com.koushik.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route/")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @PostMapping("/save")
    public ResponseEntity<Route> createRoute(@RequestBody Route route) throws RouteException {

        Route rou = routeService.addRoute(route);

        return new ResponseEntity<>(rou, HttpStatus.CREATED);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Route>> getAllRoutes()throws RouteException {

        return new ResponseEntity<List <Route>>(routeService.viewAllRoute(),HttpStatus.OK);
    }


    @GetMapping("/find/{routeId}")
    public ResponseEntity<Route> getRouteById(@PathVariable int routeId)throws RouteException{

        Route route = routeService.viewRoute(routeId);

        return new ResponseEntity<Route>(route,HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Route> updateRouteById( @RequestBody Route route)throws RouteException {

        return new ResponseEntity<Route>(routeService.updateRoute(route),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{routeId}")
    public ResponseEntity<Route> deleteRouteById(@PathVariable int routeId)throws RouteException {

        return new ResponseEntity<Route>(routeService.deleteRoute(routeId),HttpStatus.OK);
    }



}
