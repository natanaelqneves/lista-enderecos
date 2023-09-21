package com.natanaelqneves.enderecos.tratamento;

import com.natanaelqneves.enderecos.conexao.RetornaEndereco;
import com.natanaelqneves.enderecos.modelo.Endereco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class EnderecoController {

    private List<Endereco> enderecos = new ArrayList<>();
    @GetMapping
    public String carregaPaginaDePesquisa(){
        return "pagina/index";
    }

    @GetMapping("/endereco")
    public String encontraEndereco(String cep, Model model) throws IOException, InterruptedException {
        try {
            Endereco endereco = RetornaEndereco.cep(cep);
            enderecos.add(endereco);
            model.addAttribute("endereco", endereco);
        } catch (IllegalStateException e) {
            return "redirect: /index";
        }


        return "pagina/endereco";
    }

    @GetMapping("/enderecos")
    public String mostraUltimosEnderecosPesquisador(Model model){
        model.addAttribute("enderecos", enderecos);
        return "pagina/enderecos";
    }
}
