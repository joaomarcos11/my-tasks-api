package br.com.belo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.belo.entities.User;
import br.com.belo.repositories.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusTest
public class UserServiceTest {
  @Inject
  UserService userService;

  @Inject
  UserRepository userRepository;

  @Test
  @Transactional
  public void testFindUserById() {
    User newUser = new User();

    newUser.setName("Jimmi Tree");
    newUser.setEmail("jimmitree@email.com");
    newUser.setPassword("senha123");
    userService.createUser(newUser);

    User user = userService.findUserById(newUser.getId());
    assertEquals("Jimmi Tree", user.getName());

    userRepository.delete(newUser);
  }
}
