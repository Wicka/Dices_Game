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

import es.dices.game.service.GameServiceImp;
import es.dices.game.service.MenuOptions;

@RestController
@RequestMapping ("/api")
public class GameController {
	
	@Autowired
	GameServiceImp gameServiceImp;
	
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------  CALL TO METHODS
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------

		
		
		//---------------------------------------------------------------------
		//----------------------------------------------  GET METHODS (VIEWS)
		//---------------------------------------------------------------------	
	
	@GetMapping("/games/menu")
	public String menu() {
		return MenuOptions.Games();
	}
	
	@GetMapping("/games")
	public List<Game> showGames(){
		
		return gameServiceImp.showGame();	
	}
	
	@GetMapping("/games/{id}")
	public Game gameXID (@PathVariable (name="id")Integer id) {
		return gameServiceImp.gametXID(id);
	}
	
		//----------------------------------------------------------------------
		//--------------------------------------------  POST METHOD  (NEW GAME)
		//----------------------------------------------------------------------

	@PostMapping("/games")
	public Game saveGame(@RequestBody Game game) {
		return gameServiceImp.saveGame(game);
	}
	
	
		//----------------------------------------------------------------------
		//--------------------------------------------  POST METHOD  (NEW GAME)
		//----------------------------------------------------------------------

	@PutMapping("/games/{id}")
	public Game updateGame(@PathVariable(name="id")Integer id, @RequestBody Game game) {
		
		Game activeGame = new Game();
			activeGame = gameServiceImp.gametXID(id);			
			activeGame.setWinner(game.getWinner());
			
		Game endGame = new Game();
		
			endGame = gameServiceImp.saveGame(activeGame);
		
		return gameServiceImp.updateGame(endGame);
	}
	
	//-------------------------------------------------------------------
	//------------------------------------  DELETE METHOD   (DELETE PLAYER)
	//----------------------CASCADE IN BBDD ------------------------------
	//--------------------------------------------------------------------

	@DeleteMapping ("/games/{id}")
	public void deleteGame(@PathVariable(name="id")Integer id) {
		
		gameServiceImp.deleteGame(id);
		
	}
	
	
}
