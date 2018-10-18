package br.com.escola.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Instituicao;

public interface RepositorioInstituicao extends JpaRepository<Instituicao, Long>{
	
	List<Instituicao> findByNomeContaining(String nome);

}
