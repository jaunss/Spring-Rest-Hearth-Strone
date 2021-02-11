package com.joaogcm.spring.hearth.stone.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.joaogcm.spring.hearth.stone.entities.enums.Classe;
import com.joaogcm.spring.hearth.stone.entities.enums.Tipo;

@Entity
@Table(name = "tb_carta")
public class Carta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Nome obrigatório")
	@Size(min = 1, max = 50)
	private String nome;
	
	@Size(min = 1, max = 100)
	private String descricao;
	
	@Min(value = 1, message = "Valor deve ser maior que 0")
	@Max(value = 10, message = "Valor não pode ser maior que 10")
	private Integer ataque;
	
	@Min(value = 1, message = "Valor deve ser maior que 0")
	@Max(value = 10, message = "Valor não pode ser maior que 10")
	private Integer defesa;
	
	@NotNull(message = "Valor não pode ser maior que 2")
	private Integer tipo;
	
	@NotNull(message = "Valor não pode ser maior que 5")
	private Integer classe;
	
	public Carta() {
		
	}
	
	public Carta(Integer id, String nome, String descricao, Integer ataque, Integer defesa, Tipo tipo, Classe classe) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ataque = ataque;
		this.defesa = defesa;
		this.tipo = tipo.getTipo();
		this.classe = classe.getClasse();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getAtaque() {
		return ataque;
	}
	
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	
	public Integer getDefesa() {
		return defesa;
	}
	
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	
	public Tipo getTipo() {
		return Tipo.status(tipo);
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo.getTipo();
	}
	
	public Classe getClasse() {
		return Classe.status(classe);
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe.getClasse();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ataque == null) ? 0 : ataque.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (ataque == null) {
			if (other.ataque != null)
				return false;
		} else if (!ataque.equals(other.ataque))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}