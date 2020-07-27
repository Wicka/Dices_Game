package es.dices.game.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dices.game.dao.IDiceRollDAO;
import es.dices.game.dao.IGameDAO;
import es.dices.game.dao.IPlayerDAO;
import es.dices.game.dto.DiceRoll;
import es.dices.game.dto.Game;
import es.dices.game.dto.Player;

@Service
public class PlayerServiceImp implements IPlayerService {
	@Autowired
	IPlayerDAO iPlayerDao;
	
	@Autowired
	IGameDAO iGameDao;

	@Autowired
	IDiceRollDAO iDiceRollDao;
	
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
		
		allPlayersGames=iGameDao.findAll();
		
		for(Game game : allPlayersGames)
			if((game.getPlayer1().getId() ==id) || (game.getPlayer2().getId() ==id)) {
				games.add(game);				
			}
		return games;
	}

	// METODO EN EL QUE ACTUALIZO LOS JUGADORES CON TODOS LOS JUEGOS ACABADOS Y SUS TIRADAS DE DADOS
	public List<Player> Players_Classifications() {
		
		List<Game> games = new ArrayList<Game>();
		List<Player> players= new ArrayList<Player>();
		List<DiceRoll> dicerolls = new ArrayList<DiceRoll>();
		
		int iContWin;
		int iContGames;
		int iPoints;
		
		games=iGameDao.findAll();		
		players=iPlayerDao.findAll();
		dicerolls = iDiceRollDao.findAll();
		
		for (Player player : players) {			
			iContWin=iContGames=iPoints = 0;
			
			for (Game game : games) {
				if((game.getPlayer1().getId() ==player.getId()) || (game.getPlayer2().getId() ==player.getId())) {
					iContGames=iContGames+1;					
					if(game.getWinner().getId()==player.getId()) {
						iContWin=iContWin+1;						
					}
					for(DiceRoll diceroll: dicerolls) {
						if(game.getPlayer1().getId()==player.getId()) {
							iPoints = iPoints + game.getRoll_1().getResult();							
						}else {
							iPoints = iPoints + game.getRoll_2().getResult();							
						}		
					}
					
				}
			}
			player.setPoints(iPoints);
			player.setIgames(iContGames);
			player.setIwingames(iContWin);
			if (iContWin==0) {
				player.setRate(0);
				player.setRanking(0);
			}else {
				player.setRate(iContGames/iContWin);
				player.setRanking(iContGames/iContWin);
			}
			savePlayer(player);
		}
	
	
		return players;
	}

	public List<Player> showPlayers_Exits() {
		List<Player> players_exits= new ArrayList<Player>();
		players_exits=Players_Classifications() ;		
		Collections.sort(players_exits, Comparator.comparing(Player::getPoints).reversed());		
		return players_exits;
	}

	public List<Player> showPlayers_Ranking() {
		List<Player> players_rankings= new ArrayList<Player>();
		players_rankings=Players_Classifications() ;
		Collections.sort(players_rankings, Comparator.comparing(Player::getRanking).reversed());	
		return players_rankings;
	}

	public Player showWinner() {
		List<Player> players_rankings= new ArrayList<Player>();

		players_rankings=showPlayers_Ranking() ;		
		return players_rankings.get(0);
	}

	public Player showLoser () {
		int iPos=-1;
		
		List<Player> players_rankings= new ArrayList<Player>();
		players_rankings=showPlayers_Ranking() ;		
		iPos = players_rankings.size()-1;
		
		return players_rankings.get(iPos);
	}

}
