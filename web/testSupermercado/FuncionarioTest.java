package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.EstoqueDeProdutos;
import supermercado.Funcionario;
import supermercado.OperadorDeCaixa;
import supermercado.ProdutoQuilo;

class FuncionarioTest {
	Funcionario op = new Funcionario("Theo", "theo_op", "123456");
	EstoqueDeProdutos estoque = new EstoqueDeProdutos();
	ProdutoQuilo abacate = new ProdutoQuilo("b54", "Abacate", 5.89, 50);

	@SuppressWarnings({ "static-access" })
	@Test
	void addProd() {
		estoque.adicionarProduto(abacate, 2);
		assertEquals(5.89, estoque.precoPorCodigo("b54"), "mensagem");
	}
	
	@Test
	void setNomeTest() {
		op.setNome("Marisa");
		assertEquals("Marisa", op.getNome());
	}
	
	@Test
	void getNomeTest() {
		assertEquals("Theo", op.getNome());
	}
	
	@Test
	void setUserNomeTest() {
		op.setUserName("marIsa");
		assertEquals("marIsa", op.getUserName());
	}

	@Test
	void setSenhaTest() {
		op.setSenha("password");
		assertEquals("password", op.getSenha());
	}
	
	@SuppressWarnings("static-access")
	@Test
	void adicionarProdutoFuncionarioTest() {
		op.adicionarProduto(abacate, 5);
		assertTrue(estoque.produtoParaCompra("b54", 5, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void removerProdutoFuncionarioTest() {
		op.adicionarProduto(abacate, 5);
		op.removerProduto("b54", 5.0);
		assertFalse(estoque.produtoParaCompra("b54", 1024, true));
	}
}
