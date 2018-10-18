package br.com.escola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Aluno;

public interface RepositorioAluno extends JpaRepository<Aluno, Long>{

}
