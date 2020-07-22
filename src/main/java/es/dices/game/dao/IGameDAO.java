package es.dices.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dices.game.dto.Game;

public interface IGameDAO extends JpaRepository <Game,Integer> {

}
