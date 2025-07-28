package com.deusley.api_clienteIA.service;

import com.deusley.api_clienteIA.domain.Cliente;
import com.deusley.api_clienteIA.dto.ClienteRequest;
import com.deusley.api_clienteIA.dto.ClienteResponse;

import java.util.List;

public interface ClienteService {


     ClienteResponse classificarCliente(ClienteRequest clienteRequest);

     List<Cliente> findAll();


}
