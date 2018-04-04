package br.ufpb.dcx.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class AuthController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return ("auth/login");
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/login";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/acesso_negado")
	public String acessoNegado() {
		return ("auth/acesso_negado");
	}
}
