package com.joaogcm.spring.hearth.stone.entities.enums;

public enum Tipo {

	MAGIA(1, "Magia"),
	CRIATURA(2, "Criatura");

	private Integer tipo;
	private String descricao;

	private Tipo(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Tipo status(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (Tipo t : Tipo.values()) {
			if (codigo.equals(t.getTipo())) {
				return t;
			}
		}

		throw new IllegalArgumentException("Código inválido. ID = " + codigo);
	}
}