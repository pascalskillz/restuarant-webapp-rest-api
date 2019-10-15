package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.dao.ReservationRepository;
import com.monmouthvalley.tandoor.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository theReservationRepository){
        reservationRepository = theReservationRepository;
    }


    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(int id) {

        Optional<Reservation> result = reservationRepository.findById(id);

        Reservation reservation;

        if(result.isPresent()){
            reservation = result.get();
        }
        else {
            //reservation not found

            throw new RuntimeException("Reservation with id " + id + " does not exist");
        }

        return reservation;
    }

    @Override
    public void save(Reservation reservation) {

        reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(int id) {

        reservationRepository.deleteById(id);
    }
}
