package com.example.reto3doctor.Repository;

import com.example.reto3doctor.Repository.crudrepository.ReservationCrudRepository;
import com.example.reto3doctor.Repository.crudrepository.ScoreCrudRepository;
import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.ScoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<ScoreModel> getAllScores(){
        return (List<ScoreModel>) scoreCrudRepository.findAll();
    }
    public Optional<ScoreModel> getScore(Integer id){
        return scoreCrudRepository.findById(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel){
        return scoreCrudRepository.save(scoreModel);
    }

    public ScoreModel updateScore (ScoreModel scoreModel){
        return scoreCrudRepository.save(scoreModel);
    }

    public boolean deleteScore(Integer id) {
        scoreCrudRepository.deleteById(id);
        return true;
    }

}
