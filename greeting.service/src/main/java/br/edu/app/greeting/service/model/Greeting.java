package br.edu.app.greeting.service.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class Greeting implements Serializable {
    private Long id;
    private String name;
}