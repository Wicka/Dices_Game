package es.dices.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dices.game.dto.Game;

import es.dices.game.service.GameServiceImp;

@RestController
@RequestMapping ("/api")
public class GameController {
	
	@Autowired
	GameServiceImp gameServiceImp;
	
	@GetMapping ("/holag")
	public String hola() {
		return "DESDE GAME CONTROLLER";
	}
	
	@GetMapping("/games")
	public List<Game> showGames(){
		
		return gameServiceImp.showGame();	
	}
	
	

}
