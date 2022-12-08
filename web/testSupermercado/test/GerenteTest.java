package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import supermercado.Caixa;
import supermercado.EstoqueDeProdutos;
import supermercado.Gerente;
import supermercado.Utilitario;

class GerenteTest {

	Gerente g = new Gerente("Marcia", "marcia_test","5678");
	EstoqueDeProdutos estoque = new EstoqueDeProdutos();
	Utilitario u = new Utilitario();
	Caixa caixa = new Caixa(1);
	Caixa caixa2 = new Caixa(2);
	List<Caixa> caixas = new ArrayList<Caixa>();
	

	@SuppressWarnings("static-access")
	@Test
	void relatorioDeVendasCaixaTest() {
		caixas.add(caixa);
		caixas.add(caixa2);
        String mensagem =  "*                   Relatório do Caixa: 1"
                + "*           Não há vendas registradas nesse caixa              *"
                + "*                   Relatório do Caixa: 2"
                + "*           Não há vendas registradas nesse caixa              *";
	    	u.ImprimaMensagem(mensagem);
	    	g.emitirRelatorioDeVendas(caixas);
	    	assertNotNull(mensagem);
	    }   
	    
	
}
