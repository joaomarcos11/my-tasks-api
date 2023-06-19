package br.com.belo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.belo.entities.User;
import br.com.belo.repositories.UserRepository;
import br.com.belo.request.UserRequest;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class UserServiceTest {
  @Inject
  UserService userService;

  @Inject
  UserRepository userRepository;

  @Test
  public void testFindUserById() {
    User newUser = new User(1, "Jimmi Tree", "jimmitree@email.com", "senha123", LocalDateTime.now(), LocalDateTime.now());

    // userRepository.persist(newUser);

    // User user = userService.findUserById(1);
    // assertEquals("Jimmi Tree", user.getName());
  }
}
