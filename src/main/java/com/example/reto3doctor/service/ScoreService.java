package com.example.reto3doctor.service;


import com.example.reto3doctor.Repository.ReservationRepository;
import com.example.reto3doctor.Repository.ScoreRepository;
import com.example.reto3doctor.model.MessageModel;
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
        if(scoreModel.getId()==null){
            return scoreRepository.saveScore(scoreModel);
        }else{
            Optional<ScoreModel> optionalScoreModel= scoreRepository.getScore(scoreModel.getId());
            if(optionalScoreModel.isEmpty()){
                return scoreRepository.saveScore(scoreModel);
            }else {
                return scoreModel;
            }

        }

    }

    public ScoreModel updateScore(ScoreModel scoreModel) {
        if (scoreModel.getId() != null) {
            Optional<ScoreModel> optionalScoreModel =scoreRepository.getScore((scoreModel.getId()));
            if (!optionalScoreModel.isEmpty()) {
                if (scoreModel.getScore() != null){
                    optionalScoreModel.get().setScore(scoreModel.getScore());
                }
                if (scoreModel.getMessageScore() != null) {
                    optionalScoreModel.get().setMessageScore(scoreModel.getMessageScore());
                }
                scoreRepository.saveScore(optionalScoreModel.get());
                return optionalScoreModel.get();
            } else {
                return scoreModel;
            }
        }return scoreModel;
    }

    public boolean deleteScore(Integer id) {
        Boolean aBoolean=getScore(id).map(scoreModel1 -> {
            scoreRepository.deleteScore(scoreModel1.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }



}
