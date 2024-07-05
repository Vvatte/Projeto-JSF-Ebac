
package br.com.vvatte.service;

import br.com.vvatte.domain.Animal;
import br.com.vvatte.exceptions.DAOException;
import br.com.vvatte.services.generic.IGenericService;


public interface IAnimalService extends IGenericService<Animal, Long> {

	Animal buscarPorCodigo(Long codigo) throws DAOException;

}
