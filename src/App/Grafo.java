package App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	/**
	 * Globals
	 */
	String vetorVertices[];
	boolean matrizVertices[][];
	Map<Character, List<Character>> listaVertices;
	int quantx, quanty;

	/**
	 * Gets Sets
	 */
	public String[] getVetorVertices() {
		return vetorVertices;
	}

	public void setVetorVertices(String[] vetorVertices) {
		this.vetorVertices = vetorVertices;
	}

	public boolean[][] getMatrizVertices() {
		return matrizVertices;
	}

	public void setMatrizVertices(boolean[][] matrizVertices) {
		this.matrizVertices = matrizVertices;
	}

	public Map<Character, List<Character>> getListaVertices() {
		return listaVertices;
	}

	public void setListaVertices(Map<Character, List<Character>> listaVertices) {
		this.listaVertices = listaVertices;
	}

	public int getQuantx() {
		return quantx;
	}

	public void setQuantx(int quantx) {
		this.quantx = quantx;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	/**
	 * Functions
	 */
	// MATRIZ
	public Grafo(int quant1, int quant2) {
		matrizVertices = new boolean[quant1][quant2];
		this.quantx = quant1;
		this.quanty = quant2;
		for (int i = 0; i < quant1; i++) {
			for (int j = 0; j < quant2; j++) {
				matrizVertices[i][j] = false;
			}
		}
	}

	// MATRIZ
	public boolean existeAresta(Grafo g, char origem, char destino) {
		return g.matrizVertices[origem - 65][destino - 65];
	}

	// MATRIZ
	public List<Character> retornaAdjacentes(Character c) {
		List<Character> adjacentes = new ArrayList<Character>();
		for (int j = 0; j < this.quanty; j++) {
			if (existeAresta(this, c, (char) (j + 65))) {
				adjacentes.add((char) (j + 65));
			}
		}
		return adjacentes;
	}

	// MATRIZ
	public void addEdge(char origem, char destino) {
		this.matrizVertices[origem - 65][destino - 65] = true;
	}

	// VETOR
	public Grafo(int numVertices) {
		vetorVertices = new String[numVertices];
	}

	public void impressaoLista(List<Character> lista) {
		for (Character c : lista) {
			System.out.println(c);
		}
	}
	
	//HashMap
	public Grafo() {
		listaVertices = new HashMap<Character, List<Character>>(5);
	}
	//HashMap
	public void novaArestaListaEncadeada(Character origem, Character destino){
		if(listaVertices.containsKey(origem)){
			List lista = listaVertices.get(origem);
			lista.add(destino);
		}else{
			List lista = new ArrayList<Character>();
			lista.add(destino);
			listaVertices.put(origem, lista);
		}
	}
	//HashMap
	public boolean existeArestaListaEncadeada(Character origem, Character destino){
		if (listaVertices.containsKey(origem)) {
			List<Character> lista = listaVertices.get(origem);
			for (Character c : lista) {
				if (c.equals(destino)) {
					return true;
				}
			}
		}
		return false;
	}
	//Hashmap
	public void impressaoListaEncadeada(Character c){
		ArrayList<Character> retorno = new ArrayList<Character>();
		if(listaVertices.containsKey(c)){
			List<Character> lista = listaVertices.get(c);
			for(Character c1 : lista){
				retorno.add(c1);
			}
		}
		System.out.println(retorno);
	}

}
