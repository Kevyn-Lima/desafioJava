package com.example.gerenciadorcursos.controller;

import com.example.gerenciadorcursos.entity.Aluno;
import com.example.gerenciadorcursos.entity.Curso;
import com.example.gerenciadorcursos.entity.Inscricao;
import com.example.gerenciadorcursos.repository.InscricaoRepository;
import com.example.gerenciadorcursos.repository.AlunoRepository;
import com.example.gerenciadorcursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Inscricao inscreverAlunoEmCurso(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(new Date());

        return inscricaoRepository.save(inscricao);
    }
}

