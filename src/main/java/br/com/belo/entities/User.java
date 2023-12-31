package br.com.belo.entities;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "MyUsers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  Integer id;

  String name;
  String email;
  String password;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;

  @OneToMany(mappedBy = "user")
  List<Task> tasks;

  public void addTask(Task task) {
    task.setUser(this);
    this.tasks.add(task);
  }
}
