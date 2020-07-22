package es.dices.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dices.game.dao.IPlayerDAO;
import es.dices.game.dto.Player;

@Service
public class PlayerServiceImp implements IPlayerService {
	
	IPlayerDAO iPlayerDao;

	@Override
	public List<Player> showPlayers() {
		
		return iPlayerDao.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		
		return null;
	}

	@Override
	public Player playerXID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player updatePlayer(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlayer(int id) {
		// TODO Auto-generated method stub

	}

}
