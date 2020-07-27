package es.dices.game.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dices.game.dto.Dice;
import es.dices.game.dto.DiceRoll;
import es.dices.game.dto.Game;
import es.dices.game.dto.Player;
import es.dices.game.menu.MenuOptions;
import es.dices.game.service.DiceRollServiceImp;
import es.dices.game.service.GameServiceImp;
import es.dices.game.service.PlayerServiceImp;

@RestController
@RequestMapping ("/api")
public class PlayerController {
	
	@Autowired
	PlayerServiceImp playerServiceImp;
	Dice dice;
	DiceRollServiceImp dicerollService;
	GameServiceImp gameService;
	
	
	//---------------------------------------------------------------------
	//----------------------------------------------  CRUD
	//---------------------------------------------------------------------
	
	
	@GetMapping("/CRUD_players")
	public List<Player> showPlayers(){
		return playerServiceImp.showPlayers();
	}
	
	@GetMapping("/CRUD_players/{id}")	
	public Player playerXID (@PathVariable(name="id")Integer id) {		
		return playerServiceImp.playerXID(id);		
	}
	
	@PostMapping ("/CRUD_players")
	public Player savePlayer(@RequestBody Player player) {		
		return playerServiceImp.savePlayer(player);
	}
	
	@PutMapping("/CRUD_players/{id}")
	public Player updatePlayer(@PathVariable(name="id")Integer id, @RequestBody Player player) {

		Player player_selected = new Player();
			player_selected=playerServiceImp.playerXID(id);
			player_selected.setDate(player.getDate());
			player_selected.setName(player.getName());
			player_selected.setRanking(player.getRanking());
		
		Player player_update= new Player();
		
			player_update = playerServiceImp.updatePlayer(player_selected);
		
		return player_update;
	}
	
	@DeleteMapping ("/CRUD_players/{id}")
	public void deletePlayer(@PathVariable (name="id")Integer id) {
		playerServiceImp.deletePlayer(id);
	}
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------  CALL TO METHODS 
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------

			
	
	//GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.	
	@GetMapping("/players/ranking/loser")
	public Player showLoser(){		
		return playerServiceImp.showLoser();		
	}

	//GET /players/ranking/winner: retorna el jugador amb millor percentatge d’èxit.
	@GetMapping("/players/ranking/winner")
	public Player showWinner(){		
		return playerServiceImp.showWinner();		
	}
	
		
	//GET /players/{id}/games: retorna el llistat de jugades per un jugador.	
	@GetMapping("/player/{id}/games")	
	public List<Game> playerXID_Games (@PathVariable(name="id")Integer id) {				
		return playerServiceImp.playerXID_Games(id);		
	}
	
	
	//GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits
	//Me baso en los puntos de los dados
	@GetMapping("/players")
	public List<Player> showPlayers_Exits_Mig(){		
		return playerServiceImp.showPlayers_Exits();		
	}
	
	//GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits. 
	//Me baso en las veces que doy por ganado el juego (Que ambos dados sumen 7)	
	@GetMapping("/players/ranking")
	public List<Player> showPlayers_Ranking_Mig(){		
		return playerServiceImp.showPlayers_Ranking();		
	}
	
	
	
	
	
	// POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.		
	@PostMapping("/players/{id}/games")	
	public String rolldice(@PathVariable(name="id")Integer id){
		
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		
		DiceRoll roll = new DiceRoll();
			roll.setDice1(dice1.getToss());
			roll.setDice2(dice2.getToss());
			roll.setResult(dice1.getToss()+dice2.getToss());
			
		List<Game> games = new ArrayList<Game> ();
			games=playerXID_Games(id);
		
		Game lastGame = new Game();
			lastGame = games.get(games.size()-1);
		
		Player activeplayer = new Player();
			activeplayer=playerXID(id);
		
		
		dicerollService.saveDiceRoll(roll);
		
		
		if (lastGame.getPlayer1().getId()==activeplayer.getId()) {
			lastGame.setRoll1(roll);
		}else {
			lastGame.setRoll2(roll);
		}
				
		return "Roll Dices : \nDice 1 : " + dice1.getToss() + " \nDice 2 : " + dice2.getToss();		
	}
	
	
	
	// DELETE /players/{id}/games: elimina les tirades del jugador.


}
