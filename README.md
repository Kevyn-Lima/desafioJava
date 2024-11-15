# desafioJava

Realizado a implementação de uma aplicação em Java, para um gerenciamento de uma plataforma de cursos online.
Utilizando Hibernate, com três tabelas, sendo Aluno, Curso e Inscrição, Tendo as tabelas Aluno e Curso, Relação Muitos-para-muitos por meio da Tabela Inscrição.

Utilizei Populatio e DTO também, assim com Banco de Dados H2 Configurado com Hibernate.


Para testar se está funcionando, utilizei o Postman, da seguinte forma descria abaixo.


Cadastrar Aluno: POST http://localhost:8081/alunos com o corpo:

json

{
    "nome": "João Silva",
    "email": "joao@email.com",
    "dataCadastro": "2024-11-15"
}
Cadastrar Curso: POST http://localhost:8081/cursos com o corpo:

json

{
    "nome": "Java Básico",
    "descricao": "Curso de introdução ao Java",
    "dataCriacao": "2024-11-15"
}

Inscrever Aluno em Curso: POST http://localhost:8081/inscricoes?alunoId=1&cursoId=1

Listar Cursos por Aluno: GET http://localhost:8081/alunos/1/cursos

Listar Alunos por Curso: GET http://localhost:8081/cursos/1/alunos

# Nota que alterei a minha porta 8080 para 8081, pois a outra esta em uso em outro projeto meu.

para acessar o que foi postado, pelo Postman, basta acessar o localhost, com o diretorio, por exemplo:

http://localhost:8081/alunos ou http://localhost:8081/cursos
