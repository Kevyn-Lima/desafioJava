package com.example.gerenciadorcursos.controller;

import com.example.gerenciadorcursos.dto.AlunoDTO;
import com.example.gerenciadorcursos.dto.CursoDTO;
import com.example.gerenciadorcursos.entity.Aluno;
import com.example.gerenciadorcursos.repository.AlunoRepository;
import com.example.gerenciadorcursos.util.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoDTO cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return InscricaoPopulator.toAlunoDTO(alunoSalvo);
    }

    @GetMapping
    public List<AlunoDTO> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return InscricaoPopulator.toAlunoDTOList(alunos);
    }

    @GetMapping("/{id}/cursos")
    public List<CursoDTO> listarCursosPorAluno(@PathVariable Long id) {
        List<CursoDTO> cursos = alunoRepository.findById(id)
                .map(aluno -> aluno.getCursos().stream()
                        .map(InscricaoPopulator::toCursoDTO)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return cursos;
    }
}
