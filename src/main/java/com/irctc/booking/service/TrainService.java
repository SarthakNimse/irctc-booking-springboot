package com.irctc.booking.service;

import com.irctc.booking.entity.Train;
import com.irctc.booking.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public Train addTrain(Train train){
        return trainRepository.save(train);
    }

    public List<Train>getAllTrain(){
        return trainRepository.findAll();
    }

    public Train getTrainById(int id){
        return trainRepository.findById(id).orElseThrow(()-> new RuntimeException("Train Not Found WIth Id "));
    }
}
