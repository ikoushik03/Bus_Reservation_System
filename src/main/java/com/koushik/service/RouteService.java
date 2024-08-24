package com.koushik.service;

import com.koushik.exceptions.RouteException;
import com.koushik.model.Route;

import java.util.List;

public interface RouteService {
    public Route addRoute(Route route)throws RouteException;
    public Route updateRoute(Route route)throws RouteException;
    public Route deleteRoute(int routeId)throws RouteException;
    public Route viewRoute(int routeId)throws RouteException;
    List<Route> viewAllRoute()throws RouteException;
}
