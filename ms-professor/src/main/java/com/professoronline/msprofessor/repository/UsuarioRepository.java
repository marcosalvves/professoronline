package com.professoronline.msprofessor.repository;

import com.professoronline.msprofessor.model.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    UserDetails findByNome(String nome);
    UserDetails findByEmail(String email);
}
