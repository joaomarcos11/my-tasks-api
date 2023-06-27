package br.com.belo.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
  String email;
  String password;
}
