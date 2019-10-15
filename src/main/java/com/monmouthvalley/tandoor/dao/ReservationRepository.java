package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
