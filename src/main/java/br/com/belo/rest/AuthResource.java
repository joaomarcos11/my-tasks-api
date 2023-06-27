package br.com.belo.rest;

import br.com.belo.entities.User;
import br.com.belo.request.AuthRequest;
import br.com.belo.request.UserRequest;
import br.com.belo.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class AuthResource {
  @Inject
  UserService userService;

  @POST
  @Transactional
  public Response login(AuthRequest request) {
    User authUser = new User();

    authUser.setEmail(request.getEmail());
    authUser.setPassword(request.getPassword());

    try {
      return Response
          .status(Status.OK)
          .entity(userService.authUser(authUser))
          .build();
    } catch (Exception e) {
      e.printStackTrace();
      return Response
          .status(Status.FORBIDDEN)
          .entity("Login inválido")
          .build();
    }
  }
}
