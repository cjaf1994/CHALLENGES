package com.example.reto3doctor.controller;

import com.example.reto3doctor.Repository.ScoreRepository;
import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.ScoreModel;
import com.example.reto3doctor.service.ReservationService;
import com.example.reto3doctor.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins="*")
public class ScoreController {
    @Autowired

    private ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> getAllScores(){
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> getScore(@PathVariable("id") Integer id){
        return scoreService.getScore(id);
    }
    @PostMapping("/save")
    public ScoreModel saveScore(@RequestBody ScoreModel scoreModel){
        return scoreService.saveScore(scoreModel);
    }

    @PutMapping("/update")
    public ScoreModel updateScore(@RequestBody ScoreModel scoreModel){
        return scoreService.updateScore(scoreModel);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteScore(@PathVariable Integer id){
        return  scoreService.deleteScore(id);
    }

}
