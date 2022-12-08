package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.CarrinhoDeCompras;
import supermercado.ProdutoQuilo;
import supermercado.ProdutoUnitario;

class CarrinhoDeComprasTest {
	
	CarrinhoDeCompras c1 = new CarrinhoDeCompras();
	
	ProdutoUnitario macarrao = new ProdutoUnitario("cod1","Macarrao",4.00);
	ProdutoUnitario veja = new ProdutoUnitario("cod2", "Veja Limpeza", 5.10);
	ProdutoUnitario aluminio = new ProdutoUnitario("cod3","Papel Aluminio", 5.89);
	
	ProdutoQuilo abacate = new ProdutoQuilo("b54", "Abacate", 5.00, 2);
	ProdutoQuilo banana = new ProdutoQuilo("b51", "Banana", 2.00, 3);
	ProdutoQuilo limao = new ProdutoQuilo("l21", "Limão", 1.00, 5);

	@Test
	void carrinhoEstaVazioTest() {
		assertFalse(c1.verificaCarrinho());
	}
	
	@Test
	void calculaValorTotalCarrinhoTest(){
		c1.addProduto(macarrao, 1);
		c1.addProduto(veja, 1);
		c1.addProduto(aluminio, 0);
		assertEquals(9.10, c1.calcularPrecoCarrinho());
	}
	
	@Test
	void calculaValorTotalCarrinhoProdutosQuiloTest(){
		c1.addProduto(abacate, 1);
		c1.addProduto(banana, 1);
		c1.addProduto(limao, 0);
		assertEquals(7, c1.calcularPrecoCarrinho());
	}
	
	@Test
	void esvaziaCarrinhoTest() {
		c1.devolverProdutosCarrinho();
		assertFalse(c1.verificaCarrinho());
	}
	
	@Test
	void calculaValorCarrinhoTest() {
		assertEquals(0, c1.getValorCompra());
	}
	
	@Test
	void calcularValorCompraTest() {
		c1.addProduto(abacate, 1);
		c1.addProduto(veja, 1);
		c1.setValorCompra(c1.calcularPrecoCarrinho());
		assertEquals(10.1, c1.calcularValorCompra());
	}
	
	@Test
	void devolverProdutosCarrinho() {
		c1.addProduto(abacate, 7);
		c1.devolverProdutosCarrinho();
		assertFalse(c1.verificaCarrinho());
	}
	

}
