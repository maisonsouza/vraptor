package br.com.caelum.online.loja.controlador;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

import java.util.List;

@Resource
public class ProdutoController {


    private final RepositorioDeProdutos produtos;
    private final Result result;
    private final Validator validator;

    public ProdutoController(Result result, RepositorioDeProdutos produtos, Validator validator) {
        this.result = result;
        this.produtos = produtos;
        this.validator = validator;
    }

    public List<Produto> lista() {
        return this.produtos.pegaTodos();
    }

    @Path("/produto/{id}")
    public Produto exibe(Long id) {
        return this.produtos.pegaPorId(id);
    }

    @Path("/produto/{id}/xml")
    public void exibeComoXML(Long id) {
        Produto produto = this.produtos.pegaPorId(id);
        result.use(Results.xml()).from(produto).serialize();
    }

    @Path("/produto/{id}/json")
    public void exibeComoJson(Long id) {
        Produto produto = this.produtos.pegaPorId(id);
        result.use(Results.json()).from(produto).serialize();
    }

    public void formulario() {

    }

    @Post
    public void adiciona(final Produto produto) {
        validator.checking(new Validations() {
            {
                that(produto.getPreco() > 0.1,"preco",  "produto.preco.invalido" );
                that(produto.getDescricao() != null && produto.getDescricao().length() > 0, "descricao",  "produto.descricao.invalida");
                that(produto.getNome() != null && produto.getNome().length() >= 3 && produto.getNome().length() <= 100, "nome",  "produto.nome.invalido");
            }
        });
        validator.onErrorUsePageOf(ProdutoController.class).formulario();
        this.produtos.salva(produto);
        result.include("mensagem", "Novo produto adicionado com sucesso!");
        result.redirectTo(ProdutoController.class).lista();
    }
}
