
package br.com.vvatte.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.vvatte.dao.IAnimalDAO;
import br.com.vvatte.domain.Animal;
import br.com.vvatte.exceptions.DAOException;
import br.com.vvatte.exceptions.MaisDeUmRegistroException;
import br.com.vvatte.exceptions.TableException;
import br.com.vvatte.services.generic.GenericService;


@Stateless
public class AnimalService extends GenericService<Animal, Long> implements IAnimalService {
	
	@Inject
	public AnimalService(IAnimalDAO animalDAO) {
		super(animalDAO);
	}

	@Override
	public Animal buscarPorCodigo(Long codigo) throws DAOException {
		try {
			return this.dao.consultar(codigo);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
