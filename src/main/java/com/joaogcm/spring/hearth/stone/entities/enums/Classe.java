package com.joaogcm.spring.hearth.stone.entities.enums;

public enum Classe {

	MAGO(1, "Mago"),
	PALADINO(2, "Paladino"),
	CACADOR(3, "Caçador"),
	DRUIDA(4, "Druida"),
	QUALQUER(5, "Qualquer");

	private Integer classe;
	private String descricao;

	private Classe(Integer classe, String descricao) {
		this.classe = classe;
		this.descricao = descricao;
	}

	public Integer getClasse() {
		return classe;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Classe status(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (Classe c : Classe.values()) {
			if (codigo.equals(c.getClasse())) {
				return c;
			}
		}

		throw new IllegalArgumentException("Código inválido. ID = " + codigo);
	}
}