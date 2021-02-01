package br.ce.hscastro.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ce.hscastro.domain.Cliente;
import br.ce.hscastro.domain.Usuario;
import br.ce.hscastro.service.LoginService;
import br.ce.hscastro.util.SenhaUtil;
import br.ce.hscastro.domain.Uf;

/**Projeto Livraria ABC
 * Desenvolvedor: Antonio Halyson - email:halisonsc5@gmail.com
 * Data: 30/01/2021 
 */

@Controller
public class HomeController {
	
	@Autowired
	private LoginService service;

	
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login() {		
		return "login";
	}
	
	@PostMapping("/login")
	public String entrar(Usuario usuario, HttpSession session, RedirectAttributes attr) {
						
		try {
			//senha criptografada
			usuario = service.findByLoginAndSenha(usuario.getLogin(),
					SenhaUtil.md5(usuario.getSenha()));
			//senha sem criptografia
			//usuario = service.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());   
			
			if(usuario != null) {
				session.setAttribute("usuarioLogado", usuario);						
			}			
			
			return "home";
			
		} catch (Exception e) {
			
			attr.addFlashAttribute("mensagem", "Login/senha inválidos!");
			return "redirect:/login";
		}						

	}
	

	@GetMapping("/cliente/cadastro")
	public String cadastrar(Cliente cliente) {
		return "/cliente/cadastro";
	}
	
	@ModelAttribute("ufs")
	public Uf[] getUfs() {
		return Uf.values();
	}	
	
	@GetMapping("/")
	public String home() {
    	return "login";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
