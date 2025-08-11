package com.deusley.api_clienteIA.dto;

import lombok.*;

@Data
public class ClienteRequest {

    private String nome;
    private Integer idade;
    private Integer compras;
    private Double ticketMedio;
}
