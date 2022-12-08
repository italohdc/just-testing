package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.EstoqueDeProdutos;
import supermercado.ProdutoQuilo;
import supermercado.ProdutoUnitario;
import supermercado.Utilitario;

class EstoqueDeProdutosTest {
	
	EstoqueDeProdutos estoque = new EstoqueDeProdutos();
	
	ProdutoUnitario veja = new ProdutoUnitario("cod2", "Veja Limpeza", 4.49);
	ProdutoUnitario aluminio = new ProdutoUnitario("cod3","Papel Aluminio", 5.89);
	Utilitario u = new Utilitario();
	ProdutoQuilo abacate = new ProdutoQuilo("b54", "Abacate", 5.89, 50);

	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoEQuantidadetest() {
		estoque.adicionarProduto(abacate, 1);
		assertTrue(estoque.produtoParaCompra("b54", 2, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void precoPorCodigoTest() {
		estoque.adicionarProduto(aluminio, 1);
		assertEquals(5.89, estoque.precoPorCodigo("cod3"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void precoPorCodigoInexistenteTest() {
		estoque.adicionarProduto(aluminio, 1);
		assertEquals(0.00, estoque.precoPorCodigo("cod100"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoEQuantidade2test() {
		estoque.adicionarProduto(aluminio, 1);
		assertFalse(estoque.produtoParaCompra("cod3", 1000, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoEQuantidade3test() {
		estoque.adicionarProduto(abacate, 1);
		assertFalse(estoque.produtoParaCompra("b54", 100, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoQuantidadeIgualtest() {
		estoque.adicionarProduto(aluminio, 1);
		assertTrue(estoque.produtoParaCompra("cod3", 1, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoEQuantidade5test() {
		estoque.adicionarProduto(abacate, 1);
		assertTrue(estoque.produtoParaCompra("b54", 100, false));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoEQuantidade4test() {
		estoque.adicionarProduto(aluminio, 1);
		estoque.removerProduto("cod3", 2);
		assertTrue(estoque.produtoParaCompra("cod3", 12000, false));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoInexistentetest() {
		assertFalse(estoque.produtoParaCompra("b", 12000, false));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void removerProdutoTest() {
		estoque.adicionarProduto(aluminio, 2);
		estoque.removerProduto("cod3", 8);
		assertFalse(estoque.produtoParaCompra("cod3", 9, true));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void removerProdutoInexistenteTest() {
		estoque.adicionarProduto(veja, 0);
		
    	String mensagem = "*  ATENÇÃO! O estoque desse produto acabou:  veja  *";
    	u.ImprimaMensagem(mensagem);
    	estoque.removerProduto("veja", 2);
    	assertNotNull(mensagem);

	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProduto() {
		estoque.adicionarProduto(aluminio, 9);
		assertNotNull(estoque.seekProduto("cod3"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void verificaSeExisteProdutoQuilo() {
		estoque.adicionarProduto(abacate, 1);
		assertNotNull(estoque.seekProduto("b54"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void alimentacaoAutomaticaEstoque() {
		estoque.Feed();
		assertTrue(estoque.produtoParaCompra("20", 1, true));
	}
	

	

}
