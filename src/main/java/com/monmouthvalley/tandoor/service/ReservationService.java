package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.entity.Reservation;

import java.util.List;

public interface ReservationService {

    public List<Reservation> findAll();

    public Reservation findById(int id);

    public void save(Reservation reservation);

    public void deleteById(int id);

}
