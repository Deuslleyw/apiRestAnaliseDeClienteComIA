package com.deusley.api_clienteIA.service.impl;

import com.deusley.api_clienteIA.domain.Cliente;
import com.deusley.api_clienteIA.dto.ClienteRequest;
import com.deusley.api_clienteIA.dto.ClienteResponse;
import com.deusley.api_clienteIA.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    @Override
    public ClienteResponse classificarCliente(ClienteRequest clienteRequest) {




        return null;
    }

    @Override
    public List<Cliente> listasTodos() {



        return List.of();
    }
}
