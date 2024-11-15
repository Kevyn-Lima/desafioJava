package com.example.gerenciadorcursos.util;

import com.example.gerenciadorcursos.dto.AlunoDTO;
import com.example.gerenciadorcursos.dto.CursoDTO;
import com.example.gerenciadorcursos.entity.Aluno;
import com.example.gerenciadorcursos.entity.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class InscricaoPopulator {

    // Converter Aluno para AlunoDTO
    public static AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setEmail(aluno.getEmail());
        return alunoDTO;
    }

    // Converter Curso para CursoDTO
    public static CursoDTO toCursoDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());
        cursoDTO.setDescricao(curso.getDescricao());
        return cursoDTO;
    }

    // Converter uma lista de Aluno para uma lista de AlunoDTO
    public static List<AlunoDTO> toAlunoDTOList(List<Aluno> alunos) {
        return alunos.stream().map(InscricaoPopulator::toAlunoDTO).collect(Collectors.toList());
    }

    // Converter uma lista de Curso para uma lista de CursoDTO
    public static List<CursoDTO> toCursoDTOList(List<Curso> cursos) {
        return cursos.stream().map(InscricaoPopulator::toCursoDTO).collect(Collectors.toList());
    }
}

