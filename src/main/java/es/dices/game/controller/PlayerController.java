package es.dices.game.controller;

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
import es.dices.game.dto.Player;
import es.dices.game.menu.MenuOptions;
import es.dices.game.service.PlayerServiceImp;

@RestController
@RequestMapping ("/api")
public class PlayerController {
	
	@Autowired
	PlayerServiceImp playerServiceImp;
	Dice dice;

	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------  CALL TO METHODS
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------

		
		
	//---------------------------------------------------------------------
	//----------------------------------------------  GET METHODS (VIEWS)
	//---------------------------------------------------------------------
	
	@GetMapping("/players/menu")
	public String menuPlayer()
	{					
		return MenuOptions.players();
	}
	
	@GetMapping("/players")
	public List<Player> showPlayers(){
		
		return playerServiceImp.showPlayers();		
	}
	
	@GetMapping("/players/{id}")	
	public Player playerXID (@PathVariable(name="id")Integer id) {
		
		return playerServiceImp.playerXID(id);		
	}

	@GetMapping("/players/{id}/games")	
	public List<DiceRoll> playerXID_ (@PathVariable(name="id")Integer id) {
		
		return playerServiceImp.playerXID(id).getDiceroll();		
	}

	@GetMapping("/players2/{id}/games")
	public int rolldice(){
		return dice.getToss();
	}
	
	
	//----------------------------------------------------------------------
	//--------------------------------------------  POST METHOD  (NEW USER PLAYER)
	//----------------------------------------------------------------------

	
	//@PostMapping ("/players/{id}/games")
	
	
	@PostMapping ("/players")
	public Player savePlayer(@RequestBody Player player) {
		
		return playerServiceImp.savePlayer(player);
	}
	
	

	//-----------------------------------------------------------------------
	//----------------------------------  PUT METHOD (UPDATE ONE PLAYER BY ID)
	//-----------------------------------------------------------------------

	@PutMapping("/players/{id}")
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
	
	//-------------------------------------------------------------------
	//------------------------------------  DELETE METHOD   (DELETE PLAYER)
	//----------------------CASCADE IN BBDD ------------------------------
	//--------------------------------------------------------------------

	@DeleteMapping ("/players/{id}")
	public void deletePlayer(@PathVariable (name="id")Integer id) {
		playerServiceImp.deletePlayer(id);
	}

}
