package es.dices.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dices.game.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player, Integer>{

}
