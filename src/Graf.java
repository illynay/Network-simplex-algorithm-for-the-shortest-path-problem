import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Klasa Graf odpowiedzialna za stworzenie grafu.  
 */
public final class Graf {
	/**
	 * Liczba krawędzi grafu, którą poda użytkownik.
	 */
	private int liczba_krawedzi;
	/**
	 * Liczba wierzchołków, którą poda użytkownik.
	 */
	private int liczba_wierzcholkow;
	/**
	 * Lista przechowująca sąsiadów wierzchołka.
	 */
	private List<Integer>[] sasiedztwa_wierzcholka;
	/**
	 * HashMapa przechowująca wszystkie łuki grafu.
	 */	
	HashMap<String, Luk> luki = new HashMap<String, Luk>();
	
	/**
	 * Tworzona jest pusta lista sąsiedztwa wierzchołka o wielkości zależnej od liczby krawędzi lub wierzchołków (pod uwagę brana jest większa liczba).
	 * @param liczba_wierzcholkow Liczba wierzchołków, którą poda użytkownik.
	 * @param liczba_krawedzi Liczba krawędzi grafu, którą poda użytkownik.
	 */	
	public Graf(int liczba_wierzcholkow, int liczba_krawedzi) {
		this.liczba_wierzcholkow = liczba_wierzcholkow;
		this.liczba_krawedzi = liczba_krawedzi;
		int liczba = liczba_krawedzi > liczba_wierzcholkow ? liczba_krawedzi : liczba_wierzcholkow;
		this.sasiedztwa_wierzcholka = (List<Integer>[]) new List[liczba];
		
		for (int i = 0; i < liczba; i++) 
		{
			this.sasiedztwa_wierzcholka[i] = new ArrayList<Integer>();
		}
	}
	/**
	 * Funkcja dodaje krawędzie do grafu.
	 * @param wierz Obiekt typu Luk.
	 */	
	public void dodajKrawedz(Luk wierz) {
		this.sasiedztwa_wierzcholka[wierz.getPoczatek()].add(wierz.getKoniec());
		this.luki.put(wierz.getPoczatek() + "" + wierz.getKoniec(), wierz);
	}
	/**
	 * @return Zwraca liczbę krawędzi.
	 */	
	public int liczbaKrawedzi(){
		return this.liczba_krawedzi;
	}
	/**
	 * @return Zwraca liczbę wierchołków.
	 */	
	public int liczbaWierzcholkow(){
		return this.liczba_wierzcholkow;
	}
	/**
	 * @return Zwraca łuki.
	 */
	public HashMap<String, Luk> getLuki(){
		return this.luki;
	}	
	/**
	 * @param wierzcholek Wierzchołek, dla którego będzie zwrócony wierchołek.
	 * @return Zwraca listę sąsiedztwa podanego wierzchołka.
	 */
	public Iterable<Integer> sasiedztwoWierzcholka(int wierzcholek){
		return this.sasiedztwa_wierzcholka[wierzcholek];
	}
}
