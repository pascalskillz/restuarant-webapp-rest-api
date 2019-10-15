package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Reservation;
import com.monmouthvalley.tandoor.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationRestController {

    private ReservationService reservationService;

    @Autowired
    public ReservationRestController(ReservationService theReservationService){

        reservationService = theReservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> findAll(){

       return  reservationService.findAll();
    }

    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable int reservationId){

        Reservation reservation = reservationService.findById(reservationId);

        if(reservation == null){
            throw new RuntimeException("Reservation with Id " + reservationId + " Not found");
        }
        return reservation;
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation){

        //In case they pass an id in JSON...set id to 0
        //this is to force a save of new item...instead of update
        reservation.setId(0);

        reservationService.save(reservation);

        return reservation;
    }


    @DeleteMapping("/reservations/{reservationId}")
    public String removeReservation(@PathVariable int reservationId){

        Reservation  reservation = reservationService.findById(reservationId);

        if(reservation == null){
            throw new RuntimeException("Reservation with Id " + reservationId + " Not found");
        }

        reservationService.deleteById(reservationId);

        return "Remove reservation with id " + reservationId;
    }
}
