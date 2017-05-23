import java.util.HashMap;
import java.util.Scanner;

/**
 * Klasa główna programu.
 */

public class App {

	/**
	 * Liczba wierzchołków, który poda użytkownik.
	 */
	private static int v;
	
	/**
	 * Liczba krawędzi, którą poda użytkownik.
	 */	
	private static int e;
	
	/**
	 * Tablica wyliczonych łuków zwróconych przez DFS.
	 */		
	private static HashMap<Integer, Luk> wynik = new HashMap<Integer, Luk>();
	
	/**
	 * Funkcja startowa programu.
	 * Użytkownik podaje liczbę wierzchołków, krawędzi i wagi.
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner odczyt = new Scanner(System.in); 
		
		System.out.println("Podaj liczbę wierzchołków: ");
		v = 0;
		v = odczyt.nextInt();	
		
		System.out.println("Podaj liczbę krawędzi: ");
		e = 0;
		e = odczyt.nextInt();		
		
		Graf graf = new Graf(v, e);
		
		System.out.println("Uwaga! Wierzchołek, który podasz jako pierwszy, będzie wierzchołkiem początkowym: ");
		int poczatek = 0;
		int p = 0;
		int k = 0;
		int w = 0;		
		for( int i = 1; i <= e; i++ )
		{
			System.out.println("Krawędz " +i);
			System.out.println("Podaj początkowy wierzchołek: ");
			p = odczyt.nextInt();
			
			System.out.println("Podaj końcowy wierzchołek: ");
			k = odczyt.nextInt();	
			
			System.out.println("Podaj koszt na tej trasie: ");
			w = odczyt.nextInt();			
			
			if ( i == 1 ) poczatek = p;
			
			Luk wierz = new Luk(p,k,w);
			graf.dodajKrawedz(wierz);
		}
		
		DirectedPaths dfs = new DirectedPaths(graf, poczatek);
		wynik = dfs.getWynik();
		
		int koszt = 0;
		for(HashMap.Entry<Integer, Luk> i : wynik.entrySet()) 
		{
		    int key = i.getKey();
		    Luk wierz = i.getValue();
		    
		    if ( wierz.getCij() == 0 && wierz.isOdwiedzony() == false )
		    {
		    	System.out.println(wierz.getPoczatek() + " -> " + wierz.getKoniec());
		    	//System.out.println(wierz.toString());
		    	koszt += wierz.getWaga();
		    }
		}
		
		System.out.println("Laczny koszt: " + koszt);
	}

}
