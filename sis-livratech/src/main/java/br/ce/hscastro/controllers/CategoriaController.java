package br.ce.hscastro.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ce.hscastro.domain.Categoria;
import br.ce.hscastro.service.CategoriaService;


/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 30/01/2021 
 */

//controlador para as rotas de categorias de livros

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Categoria categoria) {
		return "categoria/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(Categoria categoria, RedirectAttributes attr) {
		service.salvar(categoria);
		attr.addFlashAttribute("success", "Categoria inserida com sucesso.");
		return "redirect:/categorias/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("categorias",  service.buscarTodos());
		return "categoria/lista";		
	}

	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("categoria", service.buscarPorId(id));
		return "categoria/cadastro";
	}	
	
	@PostMapping("/editar")
	public String editar(Categoria categoria, RedirectAttributes attr) {
		service.editar(categoria);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/categorias/cadastrar"; 		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.departamentoTemCargo(id)) {			
			model.addAttribute("fail", "Categoria não removido. Possui cargo(s) vinculado(s).");
			
		}else {
			service.excluir(id);
			model.addAttribute("success", "Categoria excluído com sucesso.");			
		}
		
		return listar(model);
	}
	
}
