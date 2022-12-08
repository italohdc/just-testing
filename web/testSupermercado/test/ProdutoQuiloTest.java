package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.ProdutoQuilo;

class ProdutoQuiloTest {
	
	ProdutoQuilo abacate = new ProdutoQuilo("b54", "Abacate", 5.89, 50);

	@Test
	void setarQuantidadeQuilosTest() {
		abacate.setQtdQuilos(49);
		assertEquals(49, abacate.getQtdQuilos());
	}
	
	@Test
	void setarValorProdutoTest() {
		abacate.setValor(4.87);
		assertEquals(4.87, abacate.getValor());
	}
	
	@Test
	void setarCodigoProduto() {
		abacate.setCodigo("b74");
		assertEquals("b74", abacate.getCodigo());
	}
	
	@Test
	void setarNomeProduto() {
		abacate.setNome("Abacate Manteiga");
		assertEquals("Abacate Manteiga", abacate.getNome());
	}

	@Test
	void setarQuantidadeQuilosValorNegativoTest() {
		abacate.setQtdQuilos(-4);
		assertEquals(0, abacate.getQtdQuilos());
	}
	
	@Test
	void calcularValorTest() {
		assertEquals(11.78, abacate.calcularValor(2));
	}
}
