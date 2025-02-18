package com.MercadoMaven.Final.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MercadoMaven.Final.Entity.Funcionario;
import com.MercadoMaven.Final.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Criar ou atualizar um funcionário
    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Listar todos os funcionários
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // Buscar um funcionário por CPF
    public Optional<Funcionario> getFuncionarioByCpf(String cpf) {
        return funcionarioRepository.findById(cpf);
    }

    // Deletar um funcionário
    public void deleteFuncionario(String cpf) {
        funcionarioRepository.deleteById(cpf);
    }
}