package es.dices.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dices.game.dao.IPlayerDAO;
import es.dices.game.dto.Player;

@Service
public class PlayerServiceImp implements IPlayerService {
	@Autowired
	IPlayerDAO iPlayerDao;

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

}
