package it.univr.graph;

public class Main {
	public static void main(String[] args) {
		// un grafo di stringhe
		Graph<String> g1 = new Graph<>();
		Graph<String>.Node n1 = g1.add("hello");
		g1.addRed("how");
		Graph<String>.Node n2 = g1.addRed("are");
		g1.add("you?");
		Graph<String>.Node n3 = g1.add("hello");
		n1.linkTo(n1);
		n1.linkTo(n2);
		n1.linkTo(n3);
		n1.linkTo(n3); // ripetizione, non verra' considerato
		n2.linkTo(n2);
		n2.linkTo(n3);
		n3.linkTo(n1);
		System.out.println(g1);

		// un grafo di interi
		Graph<Integer> g2 = new Graph<>();
		Graph<Integer>.Node n4 = g2.addRed(17);
		Graph<Integer>.Node n5 = g2.add(42);
		n4.linkTo(n5);
		n5.linkTo(n4);
		System.out.println(g2);		

		// un altro grafo di stringhe, con un unico nodo legato a un nodo del primo grafo
		Graph<String> g3 = new Graph<>();
		Graph<String>.Node n6 = g3.add("hello");
		n1.linkTo(n6); // illegale legare nodi di grafi diversi!
	}
}