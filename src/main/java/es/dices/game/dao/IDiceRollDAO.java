package es.dices.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dices.game.dto.DiceRoll;

public interface IDiceRollDAO extends JpaRepository<DiceRoll, Integer>{

}
