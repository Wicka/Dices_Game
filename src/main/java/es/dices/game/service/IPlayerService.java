package es.dices.game.service;

import java.util.List;

import es.dices.game.dto.Player;

public interface IPlayerService {
	
	public List<Player> showPlayers();
	public Player savePlayer(Player player);
	public Player playerXID(int id);
	public Player updatePlayer (Player player);
	public void deletePlayer(int id);

}
