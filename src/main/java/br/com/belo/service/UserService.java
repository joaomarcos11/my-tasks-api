package br.com.belo.service;

import br.com.belo.entities.User;
import br.com.belo.repositories.UserRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class UserService {
  @Inject
  UserRepository userRepository;

  public User findUserById(Integer id) {
    return userRepository.findById(id); 
  }

  public Integer createUser(User user) {
    // ToDo - validações
    userRepository.persist(user);
    return user.getId();
  }

  public Object authUser(User authUser) throws Exception {
    User user = userRepository.findUserByEmail(authUser.getEmail());
    if (user == null || !authUser.getPassword().equals(user.getPassword())) {
      // vai subir para camada acima, ou seja, para quem chama
      throw new Exception("Email/senha inválidos");
    }

    // TODO: tratar token JWT
    String token = "aksdpkdpaokdpoakop";

    return token;
  }
}
