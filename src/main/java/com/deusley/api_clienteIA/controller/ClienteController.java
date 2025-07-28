package com.deusley.api_clienteIA.controller;

import com.deusley.api_clienteIA.domain.Cliente;
import com.deusley.api_clienteIA.dto.ClienteRequest;
import com.deusley.api_clienteIA.dto.ClienteResponse;
import com.deusley.api_clienteIA.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/classificar")
    public ResponseEntity<ClienteResponse> classificarCliente(@RequestBody ClienteRequest request){
        var cliente = clienteService.classificarCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        var response = clienteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
