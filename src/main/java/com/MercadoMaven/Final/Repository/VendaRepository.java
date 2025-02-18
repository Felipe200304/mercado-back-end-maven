package com.MercadoMaven.Final.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MercadoMaven.Final.Entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {  // Altere para Long aqui

}