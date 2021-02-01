package br.ce.hscastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ce.hscastro.domain.Categoria;
import br.ce.hscastro.domain.Livro;
import br.ce.hscastro.service.CategoriaService;
import br.ce.hscastro.service.LivroService;


@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private CategoriaService categoriaService; 

	
	@GetMapping("/cadastrar")
	public String cadastrar(Livro livro) {
		return "/livro/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Livro livro, RedirectAttributes attr) {
		livroService.salvar(livro);
		attr.addFlashAttribute("success", "Livro inserido com sucesso.");
		return "redirect:/livros/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("livro", livroService.buscarPorId(id));
		return "/livro/cadastro";
	}	
	
	@PostMapping("/editar")
	public String editar(Livro livro, RedirectAttributes attr) {
		livroService.editar(livro);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/livros/cadastrar"; 		
	}

//	@GetMapping("/excluir/{id}")
//	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
//		if(livroService.cargoTemFuncionario(id)) {			
//			attr.addAttribute("fail", "Livro não removido. Possui funcionário(s) vinculado(s).");
//		}else {
//			livroService.excluir(id);
//			attr.addAttribute("success", "Cargo excluído com sucesso.");			
//		}		
//		return "redirect:/cargos/listar";
//	}	

	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("livros", livroService.buscarTodos());
		return "/livro/lista";
	}	
	
	@ModelAttribute("categorias")
	public List<Categoria> listaDeCategorias() {
		return categoriaService.buscarTodos();		
	}	
	
	
}
