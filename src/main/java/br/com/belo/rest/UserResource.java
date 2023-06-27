package br.com.belo.rest;

import br.com.belo.entities.User;
import br.com.belo.request.UserRequest;
import br.com.belo.response.UserResponse;
import br.com.belo.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UserResource {
  @Inject
  UserService userService;

  @GET
  @Path("{id}")
  public Response findUserById(Integer id) {

    // /users/id
    // /users/ 

    User user = userService.findUserById(id);
    UserResponse userResponse = new UserResponse(user);

    return Response.ok().entity(userResponse).build();
  }

  @POST
  @Transactional
  public Response createUser(UserRequest request) {
    User newUser = new User();

    newUser.setName(request.getName());
    newUser.setEmail(request.getEmail());
    newUser.setPassword(request.getPassword());

    return Response
        .status(201)
        .entity(userService.createUser(newUser))
        .build();
  }
}
