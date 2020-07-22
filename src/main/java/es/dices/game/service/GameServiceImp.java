package es.dices.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dices.game.dao.IGameDAO;
import es.dices.game.dto.Game;
@Service
public class GameServiceImp implements IGameService {
	
	IGameDAO igameDao;
	

	@Override
	public List<Game> showGame() {
		
		return igameDao.findAll();
	}

	@Override
	public Game saveGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game gametXID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game updateGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGame(int id) {
		// TODO Auto-generated method stub

	}

}
