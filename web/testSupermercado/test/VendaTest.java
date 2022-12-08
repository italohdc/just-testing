package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supermercado.Caixa;
import supermercado.CarrinhoDeCompras;
import supermercado.Cliente;
import supermercado.EnumTipoDePagamento;
import supermercado.OperadorDeCaixa;
import supermercado.ProdutoUnitario;
import supermercado.Utilitario;
import supermercado.Venda;

class VendaTest {
	Cliente c = new Cliente();
	OperadorDeCaixa op = new OperadorDeCaixa("Theo", "theo_op", "123456");
	Caixa cx = new Caixa(10);
	Caixa cx2 = new Caixa(12, op);
	Venda v = new Venda(cx, c);
	CarrinhoDeCompras carro = new CarrinhoDeCompras();
	Utilitario u = new Utilitario();
	EnumTipoDePagamento etp;
	ProdutoUnitario veja = new ProdutoUnitario("cod2", "Veja Limpeza", 5.10);
	ProdutoUnitario aluminio = new ProdutoUnitario("cod3","Papel Aluminio", 5.89);

	@Test
	void vendasNoCarrinhoTest() {
		double valorDaVenda = 10.5;
		valorDaVenda = carro.calcularPrecoCarrinho();

		assertEquals(valorDaVenda, c.getCarrinho().calcularPrecoCarrinho());
		
	}

	@Test
	void dadosVenda() {
		assertEquals("Theo", cx2.getOperadorCaixa().getNome());
		assertEquals("123456", cx2.getOperadorCaixa().getSenha());

	}
	
	@Test
	void getFormaDePagamento() {
		v.setFormaDePagamento(EnumTipoDePagamento.DINHEIRO);
		assertEquals(EnumTipoDePagamento.DINHEIRO, v.getFormaDePagamento());
	}
	
	@Test
	void getCaixaTest() {
		assertEquals(cx, v.getCaixa());
	}
	   
	  @Test
	  void venderTest() {
		  carro.addProduto(aluminio, 2);
		  carro.addProduto(veja, 3);
		  v.vender();
		  assertEquals(69.46, carro.calcularPrecoCarrinho());
	  }
	  
	  @Test
	  void getValorVendaTest() {
		  c.getCarrinho().addProduto(aluminio, 2);
		  c.getCarrinho().addProduto(veja, 3);
		  v.vender();
		  assertEquals(69.46, v.getValorVenda());
	  }



}
