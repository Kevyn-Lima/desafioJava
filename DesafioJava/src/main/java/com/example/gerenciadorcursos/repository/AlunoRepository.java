package com.example.gerenciadorcursos.repository;

import com.example.gerenciadorcursos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}