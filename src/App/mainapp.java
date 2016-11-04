package App;

import java.util.ArrayList;
import java.util.List;

public class mainapp {
	
	public static void main(String[] args) {
		Grafo g = new Grafo(5,5);
		g.addEdge('A', 'B');
		g.addEdge('B', 'C');
		g.addEdge('A', 'D');
		/*
		if(g.existeAresta(g, 'A', 'B')){
			System.out.println("A se conecta com B\n");
		}else{
			System.out.println("A não se conecta com B\n");
		}
		*/
		//System.out.println(g.retornaAdjacentes('A'));
		
		Grafo g1 = new Grafo();
		g1.novaArestaListaEncadeada('A', 'B');
		g1.novaArestaListaEncadeada('A', 'D');
		System.out.println("Aresta A - D :" + g1.existeArestaListaEncadeada('A', 'D'));
		System.out.println("Aresta C - D :" +g1.existeArestaListaEncadeada('C', 'D'));
		g1.impressaoListaEncadeada('A');
	}

}
