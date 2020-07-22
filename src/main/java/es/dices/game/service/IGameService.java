package es.dices.game.service;

import java.util.List;

import es.dices.game.dto.Game;


public interface IGameService {
	
	public List<Game> showGame();
	public Game saveGame(Game game);
	public Game gametXID(int id);
	public Game updateGame (Game game);
	public void deleteGame(int id);

}
