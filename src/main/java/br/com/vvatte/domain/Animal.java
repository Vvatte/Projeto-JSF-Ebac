
package br.com.vvatte.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ANIMAL")
public class Animal implements Persistente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="animal_seq")
	@SequenceGenerator(name="animal_seq", sequenceName="sq_animal", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "RAÇA", nullable = false, length = 50)
	private String raça;
	
	@Column(name = "CODIGO", nullable = false, unique = true)
    private Long codigo;
    
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "PESO", nullable = false)
    private Long peso;
	
	@Column(name = "HABITAT", nullable = false, length = 50)
    private String habitat;
    
	@Column(name = "DIETA", nullable = false, length = 100)
    private String dieta;

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public Long getPeso() {
		return peso;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
