package model;

import dao.CharacterDAO;

public class CharacterDeleteLogic {


	public void delete(int id) {
		CharacterDAO dao = new CharacterDAO();
		dao.delete(id);

	}

}
