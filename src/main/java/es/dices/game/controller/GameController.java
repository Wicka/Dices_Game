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

import es.dices.game.dto.Game;
import es.dices.game.menu.MenuOptions;
import es.dices.game.service.GameServiceImp;

@RestController
@RequestMapping ("/api")
public class GameController {
	
	@Autowired
	GameServiceImp gameServiceImp;
	
		//---------------------------------------------------------------------
		//----------------------------------------------  CRUD
		//---------------------------------------------------------------------
		
	
	@GetMapping("/CRUD_games")
	public List<Game> showGames(){		
		return gameServiceImp.showGame();	
	}
	
	@GetMapping("/CRUD_games/{id}")
	public Game gameXID (@PathVariable (name="id")Integer id) {
		return gameServiceImp.gametXID(id);
	}
	
	@PostMapping("/CRUD_games")
	public Game saveGame(@RequestBody Game game) {		
		return gameServiceImp.saveGame(game);
	}
	
	@PutMapping("/CRUD_games/{id}")
	public Game updateGame(@PathVariable(name="id")Integer id, @RequestBody Game game) {
		
		Game activeGame = new Game();
			activeGame = gameServiceImp.gametXID(id);			
			activeGame.setWinner(game.getWinner());			
			activeGame.setPlayer1(game.getPlayer1());
			activeGame.setPlayer2(game.getPlayer2());
			activeGame.setRoll1(game.getRoll_1());
			activeGame.setRoll2(game.getRoll_2());
			
		Game endGame = new Game();
		
			endGame = gameServiceImp.saveGame(activeGame);
		
		return gameServiceImp.updateGame(endGame);
	}
	
	@DeleteMapping ("/CRUD_games/{id}")
	public void deleteGame(@PathVariable(name="id")Integer id) {		
		gameServiceImp.deleteGame(id);
		
	}
	
}
