package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.Balanca;

class BalancaTest {

	Balanca b1 = new Balanca();

	@SuppressWarnings("static-access")
	@Test
	void calcularValorPorPesoTeste () {
		double pesoProduto = 5;
		int quantidade = 10;
		assertEquals(50, b1.calcularValorPorPeso(pesoProduto, quantidade));
	}
	
	@SuppressWarnings("static-access")
	@Test
	void calcularValorPorItemTeste () {
		double valorProduto = 5.5;
		int quantidade = 11;
		assertEquals(60.5,b1.calcularValorPorItem(valorProduto, quantidade));
	}
	
	

}
