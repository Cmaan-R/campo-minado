package br.com.cod3r.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.modelo.Campo;

public class CampoTeste {
	
	private Campo campo = new Campo(3, 3);
	
	@BeforeEach
	void iniciarCampo() {	
		campo = new Campo(3 , 3);
	}
	
	@Test
	void testeVizinhoRealDistancia1Esquerda () {
		Campo vizinho = new Campo(3 ,2);
		boolean resultado  = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita () {
		Campo vizinho = new Campo(3 ,4);
		boolean resultado  = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Emcima () {
		Campo vizinho = new Campo(2 ,3);
		boolean resultado  = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
		
	}
	
	@Test
	void testeVizinhoRealDistancia1Embaixo () {
		Campo vizinho = new Campo(4 ,3);
		boolean resultado  = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2 () {
		Campo vizinho = new Campo(2 ,2);
		boolean resultado  = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho () {
		Campo vizinho = new Campo(1 ,1);
		boolean resultado  = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
		
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas () {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado () {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado () {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado () {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();	
			
		});
		
		
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirComVizinhos() {
		
		Campo campo11 = new Campo(2 , 2);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		
		Campo campo22 = new Campo(1, 1);
		campo22.adicionarVizinho(campo12);
		campo11.adicionarVizinho(campo22);
		
		campo.adicionarVizinho(campo11);		
		
		campo.abrir();
		
		assertTrue(!campo11.isFechado() && campo22.isAberto());
	}
}
