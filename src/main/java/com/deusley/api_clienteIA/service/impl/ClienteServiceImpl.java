package com.deusley.api_clienteIA.service.impl;

import com.deusley.api_clienteIA.domain.Cliente;
import com.deusley.api_clienteIA.dto.ClienteRequest;
import com.deusley.api_clienteIA.dto.ClienteResponse;
import com.deusley.api_clienteIA.integration.OpenClienteIA;
import com.deusley.api_clienteIA.repository.ClienteRepository;
import com.deusley.api_clienteIA.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OpenClienteIA openClienteIA;


    @Override
    public ClienteResponse classificarCliente(ClienteRequest clienteRequest) {

        String prompt = "Classifique o cliente com base nos dados: "
                        + "Idade: "   + clienteRequest.getIdade() + ","
                        + "Compras: " + clienteRequest.getCompras() + ","
                        + "Ticket Medio: " + clienteRequest.getTicketMedio()
                        + ". As categorias são: Bronze, prata, ouro , platina. Responda apenas com a categoria.";

        String classificacao = openClienteIA.classificarCliente(prompt);

        var cliente = new Cliente();
            cliente.setNome(clienteRequest.getNome());
            cliente.setIdade(clienteRequest.getIdade());
            cliente.setCompras(clienteRequest.getCompras());
            cliente.setTicketMedio(clienteRequest.getTicketMedio());
            cliente.setClassificacao(classificacao);

            clienteRepository.save(cliente);

        return new ClienteResponse(clienteRequest.getNome(),classificacao);
    }

    @Override
    public List<Cliente> listarTodos() {

        var clientes = clienteRepository.findAll();

        return clientes;
    }
}
