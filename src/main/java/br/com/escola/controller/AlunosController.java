package br.com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escola.model.Aluno;
import br.com.escola.model.Instituicao;
import br.com.escola.repositorio.RepositorioAluno;
import br.com.escola.repositorio.RepositorioInstituicao;

@Controller
@RequestMapping("/alunos")
public class AlunosController {

	@Autowired
	private RepositorioAluno repositorioAluno;
	
	@Autowired
	private RepositorioInstituicao repositorioInstituicao;
	
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView resultado = new ModelAndView("aluno/index");
		List<Aluno> alunos = repositorioAluno.findAll();
		resultado.addObject("alunos", alunos);
		return resultado;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("aluno/inserir");
		List<Instituicao>instituicoes = repositorioInstituicao.findAll();
		Aluno aluno = new Aluno();
		aluno.setInstituicao(new Instituicao());
		resultado.addObject("aluno", aluno);
		resultado.addObject("instituicoes", instituicoes);
		return resultado;
	}
	
	@PostMapping("/inserir")
	public String inserir(Aluno aluno) {
		repositorioAluno.save(aluno);
		return "redirect:/alunos/index";
	}
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable ("id")Long id) {
		Aluno aluno = repositorioAluno.findOne(id);
		List<Instituicao>instituicoes = repositorioInstituicao.findAll();
		ModelAndView resultado = new ModelAndView("aluno/editar");
		resultado.addObject("aluno", aluno);
		resultado.addObject("instituicoes", instituicoes);
		return resultado;
	}
	
	@PostMapping("/editar")
	public String editar(Aluno aluno) {
		repositorioAluno.save(aluno);
		return "redirect:/alunos/index";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id) {
		repositorioAluno.delete(id);
		return "redirect:/alunos/index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
