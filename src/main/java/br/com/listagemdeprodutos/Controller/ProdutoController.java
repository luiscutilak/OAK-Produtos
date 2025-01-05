package br.com.listagemdeprodutos.Controller;

import br.com.listagemdeprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public String home(Model model) {
    model.addAttribute("produtos", produtoService.findAll());
    return "produtos";
    }
}
