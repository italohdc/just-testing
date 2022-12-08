package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.EstoqueDeProdutos;
import supermercado.OperadorDeCaixa;
import supermercado.ProdutoUnitario;
import supermercado.Utilitario;

class OperadorDeCaixaTest {
	
	OperadorDeCaixa op = new OperadorDeCaixa("Maria de Jesus", "marJesus", "jerico123");
	ProdutoUnitario PU = new ProdutoUnitario("cod7","Macarrao", 20.50);
	EstoqueDeProdutos estoque = new EstoqueDeProdutos();
	Utilitario u = new Utilitario();

	@Test
	void addProd() {
		double qtd = 50;
		boolean resp;
		if(PU != null) {
			resp = true;
		}resp = false;
		 
		assertNotNull("*                ATENÇÃO - OPERAÇÃO NÃO PERMITIDA                  *");
	}
	
	@SuppressWarnings("static-access")
	@Test
	void removerProdutoTest() {
		estoque.adicionarProduto(PU, 10);
		op.removerProduto("cod7", 5);
		assertFalse(estoque.produtoParaCompra("cod7", 7, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void operadorCaixaAdicionarProduto() {
		op.adicionarProduto(PU, 5);
		assertFalse(estoque.produtoParaCompra("cod7", 7, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void mostrarEstoqueTest() {
	        String mensagem =  "********************************************************************"
	                + "*                ATENÇÃO - OPERAÇÃO NÃO PERMITIDA                  *"
	        		+ "*  Operadores de caixa NÂO possuem acesso para mostrar o estoque   *"
	                + "********************************************************************";
		    	u.ImprimaMensagem(mensagem);
		    	op.mostrarEstoque();
		    	assertNotNull(mensagem);
		     
	}

}
