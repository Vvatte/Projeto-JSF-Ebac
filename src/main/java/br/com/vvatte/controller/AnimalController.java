
package br.com.vvatte.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vvatte.domain.Animal;
import br.com.vvatte.service.IAnimalService;


@Named
@ViewScoped
public class AnimalController implements Serializable {

	private static final long serialVersionUID = 8030245985235567808L;
	
	private Animal animal;
	
	private Collection<Animal> animais;
	
	@Inject
	private IAnimalService animalService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.animal = new Animal();
			this.animal = (Animal) animalService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os animais"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.animal = new Animal();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Animal animal) {
		try {
			this.isUpdate = true;
			this.animal = animal;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o animal"));
		}
		
    } 
	
	public void delete(Animal animal) {
		try {
			animalService.excluir(animal);
			animais.remove(animal);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o animal"));
		}
		
    } 
	
	public void add() {
		try {
			animalService.cadastrar(animal);
			this.animais = animalService.buscarTodos();
			this.animal = new Animal();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o animal"));
		}
		
        
    }

    public void update() {
    	try {
    		animalService.alterar(this.animal);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Animal Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o animal"));
		}
        
    }

	public Animal getAnimais() {
		return animal;
	}

	public void setAnimais(Collection<Animal> animais) {
		this.animais = animais;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	

}
