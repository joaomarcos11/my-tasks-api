package br.com.belo.entities;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskType {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  Integer id;

  String description;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;
}
