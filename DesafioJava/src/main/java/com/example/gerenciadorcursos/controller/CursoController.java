package com.example.gerenciadorcursos.controller;

import com.example.gerenciadorcursos.dto.AlunoDTO;
import com.example.gerenciadorcursos.dto.CursoDTO;
import com.example.gerenciadorcursos.entity.Curso;
import com.example.gerenciadorcursos.repository.CursoRepository;
import com.example.gerenciadorcursos.util.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public CursoDTO cadastrarCurso(@RequestBody Curso curso) {
        Curso cursoSalvo = cursoRepository.save(curso);
        return InscricaoPopulator.toCursoDTO(cursoSalvo);
    }

    @GetMapping
    public List<CursoDTO> listarCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return InscricaoPopulator.toCursoDTOList(cursos);
    }

    @GetMapping("/{id}/alunos")
    public List<AlunoDTO> listarAlunosPorCurso(@PathVariable Long id) {
        List<AlunoDTO> alunos = cursoRepository.findById(id)
                .map(curso -> curso.getAlunos().stream()
                        .map(InscricaoPopulator::toAlunoDTO)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return alunos;
    }
}


