package com.example.gerenciadorcursos.repository;

import com.example.gerenciadorcursos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
