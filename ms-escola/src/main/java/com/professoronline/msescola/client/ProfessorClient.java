package com.professoronline.msescola.client;

import com.professoronline.msescola.dto.ProfessorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "ms-professor" é o nome do serviço registrado no Eureka ou a URL direta
@FeignClient(name = "ms-professor", path = "/professores")
public interface ProfessorClient {

    @GetMapping("/{id}")
    ProfessorDTO buscarProfessorPorId(@PathVariable("id") Integer id);
}