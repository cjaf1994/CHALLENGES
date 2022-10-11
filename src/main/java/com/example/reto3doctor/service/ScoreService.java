package com.example.reto3doctor.service;


import com.example.reto3doctor.Repository.ReservationRepository;
import com.example.reto3doctor.Repository.ScoreRepository;
import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.ScoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired

    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAllScores(){
        return scoreRepository.getAllScores();
    }

    public Optional<ScoreModel> getScore(Integer id){
        return scoreRepository.getScore(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel){
        return scoreRepository.saveScore(scoreModel);
    }

    public ScoreModel updateScore(ScoreModel scoreModel){
        return scoreRepository.updateScore(scoreModel);
    }

    public boolean deleteScore(Integer id) {
        scoreRepository.deleteScore(id);
        return true;}
}
