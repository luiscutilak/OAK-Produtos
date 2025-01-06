package br.com.listagemdeprodutos.Controller;

import br.com.listagemdeprodutos.model.Produto;
import br.com.listagemdeprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public String listarPrdutos(Model model) {
    model.addAttribute("produtos", produtoService.findAll());
    return "produtos";
    }

    @GetMapping("/novo")
    public String formProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "formProduto";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        if (produto.isDisponivel()) {
            produtoService.save(produto);
            return "redirect:/produtos";
        } else {
            return "redirect:/erro";
        }
    }
    }


