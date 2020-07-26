package es.dices.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dices.game.dao.IDiceRollDAO;
import es.dices.game.dto.DiceRoll;
@Service
public class DiceRollServiceImp implements IDiceRollService {
	@Autowired
	IDiceRollDAO iDiceRollDao;
	
	@Override
	public List<DiceRoll> showDiceRoll() {		
		return iDiceRollDao.findAll();
	}
	

	@Override
	public DiceRoll diceRollXID(int id) {		
		return iDiceRollDao.findById(id).get();
	}


	@Override
	public DiceRoll saveDiceRoll(DiceRoll diceRoll) {
		return iDiceRollDao.save(diceRoll);
	}

	@Override
	public DiceRoll updateDiceRoll(DiceRoll diceRoll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDiceRoll(int id) {
		// TODO Auto-generated method stub

	}


	

}
