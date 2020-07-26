package es.dices.game.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dices.game.dao.IGameDAO;
import es.dices.game.dao.IPlayerDAO;
import es.dices.game.dto.Game;
import es.dices.game.dto.Player;

@Service
public class PlayerServiceImp implements IPlayerService {
	@Autowired
	IPlayerDAO iPlayerDao;
	
	GameServiceImp gameServiceImp;
	
	@Autowired
	IGameDAO igameDao;

	@Override
	public List<Player> showPlayers() {
		
		return iPlayerDao.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		
		return iPlayerDao.save(player);
	}

	@Override
	public Player playerXID(int id) {
		return iPlayerDao.findById(id).get();
	}

	@Override
	public Player updatePlayer(Player player) {
		return iPlayerDao.save(player);
	}

	@Override
	public void deletePlayer(int id) {
		iPlayerDao.deleteById(id);
	}

	public List<Game> playerXID_Games(Integer id) {
		List<Game> games=new ArrayList<Game>();
		List<Game> allPlayersGames = new ArrayList<Game>();
		
		allPlayersGames=igameDao.findAll();
		
		for(Game game : allPlayersGames)
			if((game.getPlayer1().getId() ==id) || (game.getPlayer2().getId() ==id)) {
				games.add(game);				
			}
		return games;
	}

}
