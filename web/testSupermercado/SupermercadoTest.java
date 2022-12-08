package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supermercado.Supermercado;

class SupermercadoTest {
	public static Supermercado sup;
	
	@BeforeEach
	void setUp() throws Exception {
		sup = new Supermercado();
	}

	@Test
	void messagesTest() {
		Scanner s = new Scanner("1");
		s.nextInt();
		assertNotNull(" ( 1 ) Gerente \n ( 2 ) Funcionário \n ( 3 ) Cliente \n ( 0 ) Sair do sistema");

	}
	

}
