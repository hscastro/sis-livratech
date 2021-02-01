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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.ce.hscastro.domain.Cliente;
import br.ce.hscastro.domain.Livro;
import br.ce.hscastro.domain.Uf;
import br.ce.hscastro.domain.Usuario;
import br.ce.hscastro.service.ClienteService;
import br.ce.hscastro.service.LivroService;
import br.ce.hscastro.util.SenhaUtil;

/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 30/01/2021 
 */

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private LivroService livroService;	
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {	
		Usuario user = cliente.getLogin();
		String senha = user.getSenha();
		senha = SenhaUtil.md5(senha);
		user.setSenha(senha);
		cliente.setLogin(user);
		
		//salva o cliente no banco de dados
		clienteService.salvar(cliente);		
		attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/entrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return "/cliente/cadastro";		
	}
	
	@PostMapping("/editar")
	public String editar(Cliente cliente, RedirectAttributes attr) {
		clienteService.editar(cliente);
		attr.addFlashAttribute("success", "Cliente atualizado com sucesso.");
		return "redirect:/clientes/cadastrar";
	}	

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		clienteService.excluir(id);
		attr.addFlashAttribute("success", "Cliente excluído com sucesso.");
		return "redirect:/clientes/listar";
	}
	
	@ModelAttribute("livros")
	public List<Livro> getLivro() {
		return livroService.buscarTodos();
	}	
	
	@ModelAttribute("ufs")
	public Uf[] getUfs() {
		return Uf.values();
	}

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("clientes", clienteService.buscarPorNome(nome));
		return "/cliente/lista";		
	}	
	
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", clienteService.buscarTodos());
		return "/cliente/lista";
	}	
	
}