package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import supermercado.Caixa;
import supermercado.Cliente;
import supermercado.EnumTipoDePagamento;
import supermercado.OperadorDeCaixa;
import supermercado.ProdutoUnitario;
import supermercado.Utilitario;
import supermercado.Venda;


class CaixaTest {
	
	Caixa caixa = new Caixa(1);
	OperadorDeCaixa operador = new OperadorDeCaixa("Maria de Jesus", "marJesus", "jerico123");
	OperadorDeCaixa operador2 = new OperadorDeCaixa("João de Abreu", "jobreu", "escuridao456");
	Caixa caixa2 = new Caixa(2, operador);
	Utilitario u = new Utilitario();
	Cliente cliente5 = new Cliente();
	Venda vendaNova = new Venda(caixa2, cliente5 );
	ProdutoUnitario macarrao = new ProdutoUnitario("cod1","Macarrao",4.00);


	
	@Test
	void qualNumeroCaixaTest() {
		assertEquals(2, caixa2.getNumeroDoCaixa());
	}
	
	@Test
	void qualOperadorCaixa() {
		assertEquals(operador, caixa2.getOperadorCaixa());
	}
	
	@Test
	void setNumeroCaixa() {
		caixa.setNumeroDoCaixa(3);
		assertEquals(3, caixa.getNumeroDoCaixa());
	}
	
	@Test
	void setOperadorCaixa() {
		caixa.setOperadorCaixa(operador2);
		assertEquals(operador2, caixa.getOperadorCaixa());
	}
	
	@Test
	void getVendasTest() {
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		assertEquals(vendas, caixa.getVendas());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void setVendasTest() {
		Cliente c = new Cliente();
		Venda v = new Venda(caixa, c); 
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		vendas.add(v);
		caixa.setVendas(vendas);
		assertEquals(vendas, caixa.getVendas());
	}
	
    @Test
    void numCaixaTest() {
    	assertEquals("Caixa 1", caixa.toString());
    }
    
    @SuppressWarnings("static-access")
	@Test
    void relatorioCaixaVazioTest() {
    	String mensagem = "*           Não há vendas registradas nesse caixa              *";
    	u.ImprimaMensagem(mensagem);
    	caixa.relatorioCaixa();
    	assertNotNull(mensagem);
    }   
    
    
    @SuppressWarnings("static-access")
	@Test
    void iniciarVendaTest(){	
    	String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	String mensagem = "*  !!!! FALHA AO COMPRAR !!!!  *";
    	u.ImprimaMensagem(mensagem);
    	caixa.iniciarVenda(cliente5);
    	System.setIn(in);
    	assertNotNull(mensagem);
    }
    
    @SuppressWarnings("static-access")
	@Test
    void iniciarVenda2Test(){
    	String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    	String mensagem = "*  !!!! FALHA AO COMPRAR !!!!  *";
    	u.ImprimaMensagem(mensagem);
    	caixa.iniciarVenda(cliente5);
    	System.setIn(in);
       	assertNotNull(mensagem);
    }
    
}
