package br.com.sgsistemas.forum.controller;

import br.com.sgsistemas.forum.drawings.Drawings;
import functions.Funcoes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
//		return Funcoes.breaklineToBr(Drawings.touhouInterrogation);
		return "algo!!!";
	}
}
