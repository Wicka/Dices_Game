package es.dices.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dices.game.dto.Player;
import es.dices.game.service.PlayerServiceImp;

@RestController
@RequestMapping ("/api")
public class PlayerController {
	
	@Autowired
	PlayerServiceImp playerServiceImp;
	
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------  CALL TO METHODS
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------

		
		
	//---------------------------------------------------------------------
	//----------------------------------------------  GET METHODS (VIEWS)
	//---------------------------------------------------------------------
	
	@GetMapping ("/hola")
	public String hola() {
		return "DESDE PLAYER CONTROLLER";
	}
	
	@GetMapping("/players")
	public List<Player> showPlayers(){
		
		return playerServiceImp.showPlayers();		
	}
	
	

}
