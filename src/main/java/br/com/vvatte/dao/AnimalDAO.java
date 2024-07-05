
package br.com.vvatte.dao;

import br.com.vvatte.dao.generic.GenericDAO;
import br.com.vvatte.domain.Animal;

public class AnimalDAO extends GenericDAO<Animal, Long> implements IAnimalDAO {

	public AnimalDAO() {
		super(Animal.class);
	}

}
