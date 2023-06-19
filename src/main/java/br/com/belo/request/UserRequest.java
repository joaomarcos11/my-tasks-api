package br.com.belo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
  String name;
  String password;
  String email;
}
