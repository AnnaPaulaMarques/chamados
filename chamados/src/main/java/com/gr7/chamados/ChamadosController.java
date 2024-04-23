package com.gr7.chamados;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequestMapping("/chamados") //não deixei assim pois nem tds métodos aqui responderão a esse endpoint, endereço URL, rota

@Controller
public class ChamadosController {
    private String nome;
    @GetMapping("/chamados") //só assim ou apenas @GetMapping embaixo mas com RequestMapping acima
    @ResponseBody
    //@GetMapping
    public String exibir(){
        return "Dentro da classe Controller";
    }

    @GetMapping("/index")
    public String menu(){
        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam("tipo") String tipo, Model model){
        model.addAttribute("tipo", tipo);
        return "login";
    }

    @PostMapping("/login")
    public String verificaLogin(@RequestParam("tipo") String tipo,
                                @RequestParam("nome") String nome,
                                @RequestParam("senha") String senha,
                                Model model){
        this.nome = nome;
        model.addAttribute("nome", nome);
        return "tecnico".equals(tipo) ? "tecnico" : "usuario";
    }

    @RequestMapping(value = "/novo-chamado", method = RequestMethod.GET)
    public String novoChamado(Model model, @RequestParam String nome) {
        this.nome = nome;
        model.addAttribute("nome", nome);
        return "novo-chamado";
    }

}


