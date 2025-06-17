package com.irctc.booking.controller;


import com.irctc.booking.entity.Train;
import com.irctc.booking.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
    public ResponseEntity<Train> addTrain(@RequestBody Train train){
        return ResponseEntity.ok(trainService.addTrain(train));
    }

    @GetMapping
    public ResponseEntity <List<Train>> getAllTrains(){
        return ResponseEntity.ok(trainService.getAllTrain());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable int id ){
        return ResponseEntity.ok(trainService.getTrainById(id));

    }


}
