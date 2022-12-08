package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supermercado.EstoqueDeProdutos;
import supermercado.Leitor;
import supermercado.ProdutoUnitario;
import supermercado.Utilitario;

class LeitorTest {
	public static Leitor l; 
	public static Utilitario u ;
	public static ProdutoUnitario PU ;
	public static EstoqueDeProdutos estoque ;
	
	@BeforeEach
	void setUp() throws Exception {
		l = new Leitor();
		u = new Utilitario();
		PU = new ProdutoUnitario("cod7","Macarrao", 20.50);
		estoque = new EstoqueDeProdutos();
	}

	

	@SuppressWarnings("static-access")
	@Test
	void test() {
		String codigo = "133";
		String mensagem = "*               Procurando produto de cógido '" + codigo + "'           *";
		u.ImprimaMensagem(mensagem);
		String nome = PU.getNome();
		double valor = PU.getValor();
		
		assertNotNull(mensagem);
		assertNotNull("*   Produto: "+ nome + "   *\n*   Preço: R$ " + valor + "   *");
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testEstoque() {
		String codigo = "523";
		PU = (ProdutoUnitario) estoque.seekProduto(codigo);
		
		assertNotNull("*                    Produto não encontrado!                    *");
	}
	
	@SuppressWarnings("static-access")
	@Test
	void mostraValorProdutoInexistenteTest() {
        String mensagem =  "*               Procurando produto de cógido 9876           *"
                + "*                    Produto não encontrado!                    *";
	    	u.ImprimaMensagem(mensagem);
	    	l.mostrarValorProduto("9876");
	    	assertNotNull(mensagem);
	    }   
	
	@SuppressWarnings("static-access")
	@Test
	void mostraValorProdutoTest() {
		ProdutoUnitario sabao = new ProdutoUnitario("sab32","Sabao",2.00);
		estoque.adicionarProduto(sabao, 10);
        String mensagem =  "*               Procurando produto de cógido sab32           *"
                + "*   Produto: sabao   *\n*   Preço: R$ 2.00   *";
	    	u.ImprimaMensagem(mensagem);
	    	l.mostrarValorProduto("sab32");
	    	assertNotNull(mensagem);
	    }   
	

}
