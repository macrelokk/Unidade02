package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private List<Funcionario> lista = new ArrayList<>();

    // CREATE
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario f) {
        lista.add(f);
        return f;
    }

    // READ ALL
    @GetMapping
    public List<Funcionario> listar() {
        return lista;
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable int id) {
        return lista.get(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable int id, @RequestBody Funcionario f) {
        lista.set(id, f);
        return f;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id) {
        lista.remove(id);
        return "Funcionario removido";
    }
}
