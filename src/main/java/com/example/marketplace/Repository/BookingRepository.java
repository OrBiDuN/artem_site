package com.example.marketplace.Repository;


import com.example.marketplace.Object.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer> {
    List<Booking> findAllByIduser(Integer id);
}


