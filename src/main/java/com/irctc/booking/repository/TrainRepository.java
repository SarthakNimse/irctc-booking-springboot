package com.irctc.booking.repository;

import com.irctc.booking.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {


}
