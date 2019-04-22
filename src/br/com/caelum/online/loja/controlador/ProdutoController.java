package br.com.caelum.online.loja.controlador;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import java.util.List;

@Resource
public class ProdutoController {


    private final RepositorioDeProdutos produtos;
    private final Result result;

    public ProdutoController(Result result, RepositorioDeProdutos produtos) {
        this.result = result;
        this.produtos = produtos;
    }

    public List<Produto> lista(){
        return this.produtos.pegaTodos();
    }

    @Path("/produto/{id}")
    public Produto exibe(Long id){
        return this.produtos.pegaPorId(id);
    }

    @Path("/produto/{id}/xml")
    public void exibeComoXML(Long id){
        Produto produto =  this.produtos.pegaPorId(id);
        result.use(Results.xml()).from(produto).serialize();
    }

    @Path("/produto/{id}/json")
    public void exibeComoJson(Long id){
        Produto produto =  this.produtos.pegaPorId(id);
        result.use(Results.json()).from(produto).serialize();
    }

    public void formulario(){

    }

    @Post
    public void adiciona(Produto produto){
        this.produtos.salva(produto);
        result.include("mensagem","Novo produto adicionado com sucesso!");
        result.redirectTo(ProdutoController.class).lista();
    }
}
