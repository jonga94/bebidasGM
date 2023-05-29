package com.server.bebidasGM.security;

import com.server.bebidasGM.model.Clientes;
import com.server.bebidasGM.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public UserDetails loadUserByUsername(String celular) throws UsernameNotFoundException {
    Clientes clientes = clienteRepository.findOneBytelefonoCliente(celular)
      .orElseThrow(() -> new UsernameNotFoundException("El usuario con celular: "+celular+" no existe."));

    return new UserDetailsImpl(clientes);
  }
}
