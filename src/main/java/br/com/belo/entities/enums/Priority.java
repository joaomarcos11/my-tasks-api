package br.com.belo.entities.enums;

import lombok.Getter;

@Getter
public enum Priority {
  Baixa(1, "Baixa"),
  Media(2, "Média"),
  Alta(3, "Alta"); 

  private Integer level;
  private String name;

  private Priority(Integer level, String name) {
    this.level = level;
    this.name = name;
  }
}
