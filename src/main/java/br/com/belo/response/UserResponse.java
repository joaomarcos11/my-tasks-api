package br.com.belo.response;

import java.time.LocalDateTime;

import br.com.belo.entities.User;

public class UserResponse {
  Integer id;

  String name;
  String email;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;

  public UserResponse(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.createdAt = user.getCreatedAt();
    this.updatedAt = user.getUpdatedAt();
  }
}
