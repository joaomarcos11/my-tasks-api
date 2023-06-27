package br.com.belo.entities;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.List;

import br.com.belo.entities.enums.Priority;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  Integer id;

  String description;
  String title;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;
  LocalDateTime finishedAt;

  @ManyToOne
  User user;

  @OneToMany
  List<SubTask> subTasks;

  @ManyToOne
  TaskStatus status;

  @ManyToOne
  TaskType type;

  Priority priority;
}
