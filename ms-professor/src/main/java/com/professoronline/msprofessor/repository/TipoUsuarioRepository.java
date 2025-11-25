package com.professoronline.msprofessor.repository;

import com.professoronline.msprofessor.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
    // Usado na lógica de segurança para buscar a Role
    TipoUsuario findByNome(String nome);
}