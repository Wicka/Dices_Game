package es.dices.game.service;

import java.util.List;

import es.dices.game.dto.DiceRoll;


public interface IDiceRoll {
	public List<DiceRoll> showDiceRoll();
	public DiceRoll saveDiceRoll(DiceRoll diceRoll);
	public DiceRoll diceRollXID(int id);
	public DiceRoll updateDiceRoll (DiceRoll diceRoll);
	public void deleteDiceRoll(int id);

}
