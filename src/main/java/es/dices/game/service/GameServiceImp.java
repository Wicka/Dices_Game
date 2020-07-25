package es.dices.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dices.game.dao.IGameDAO;
import es.dices.game.dto.Game;
@Service
public class GameServiceImp implements IGameService {
	
	@Autowired
	IGameDAO igameDao;
	

	@Override
	public List<Game> showGame() {		
		return igameDao.findAll();
	}

	@Override
	public Game saveGame(Game game) {
		return igameDao.save(game);
	}

	@Override
	public Game gametXID(int id) {
		return igameDao.findById(id).get();
	}

	@Override
	public Game updateGame(Game game) {
		return igameDao.save(game);
	}

	@Override
	public void deleteGame(int id) {
		igameDao.deleteById(id);
	}

}
