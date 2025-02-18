package com.MercadoMaven.Final.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MercadoMaven.Final.Entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    // Métodos de consulta personalizados, se necessário, podem ser adicionados aqui
}