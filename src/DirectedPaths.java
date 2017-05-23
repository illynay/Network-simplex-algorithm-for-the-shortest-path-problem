import java.util.HashMap;

/**
 * Odpowiedzialna za wyliczenie DFS.  
 */
public class DirectedPaths {
	/**
	 * Tablica, w której zapisywane są odwiedzone łuki.
	 */	
	private boolean[] odwiedzone;
	/**
	 * Indeks klucza w HashMapie o nazwie wynik.
	 */	
	private int counter = 0;
	/**
	 * HashMapa przechowująca wszystkie łuki grafu.
	 */	
	HashMap<String, Luk> luki = new HashMap<String, Luk>();
	/**
	 * HashMapa przechowująca zaktualizowane obiekty typu Luk.
	 */	
	HashMap<Integer, Luk> wynik = new HashMap<Integer, Luk>();
	/**
	 * HashMapa przechowująca wyliczone potencjały dj.
	 */	
	HashMap<Integer, Integer> dj = new HashMap<Integer, Integer>();
	/**
	 * Początkowy potencjał di = 0.
	 */	
	int di = 0;
	
	/**
	 * Uruchamiamy w nim rekurencyjnie funkcje DFS.
	 * @param graf	Graf stworzony z wprowadzonych wierzchołków, krawędzi i wag.
	 * @param start	Wierzchołek startowy.
	 */	
	public DirectedPaths(Graf graf, int start){
		int liczba = graf.liczbaWierzcholkow() > graf.liczbaKrawedzi() ? graf.liczbaWierzcholkow() : graf.liczbaKrawedzi();
		this.odwiedzone = new boolean[liczba];
		this.luki = graf.getLuki();
		
		dfs(graf, start, this.di);
	}
	
	/**
	 * Funkcja obliczająca CIJ
	 * @param di	Potencjał di.
	 * @param dj	Potencjał dj.
	 * @param waga	Waga krawędzi.
	 * @return Obliczone CIJ
	 */		
	public int obliczCij ( int di, int dj, int waga) {
		return di - dj + waga;
	}
	/**
	 * Funkcja przechodząca graf za pomocą algorytmu DFS.
	 * @param graf	Graf stworzony z wprowadzonych wierzchołków, krawędzi i wag.
	 * @param wierzcholek Wierzchołek, który aktualnie będzie rozpatrywany.
	 * @param _di	Potencjał di aktualnego wierzchołka.
	 */		
	private void dfs(Graf graf, int wierzcholek, int _di){
		odwiedzone[wierzcholek] = true;
		
		for (int v : graf.sasiedztwoWierzcholka(wierzcholek))
		{
			Luk wierz = this.luki.get(wierzcholek + "" + v);
			if ( wierz instanceof Luk )
			{
				int waga = wierz.getWaga();
				
				int nowe_dj = _di + waga;
				int _dj = nowe_dj;
				
				if ( dj.get(v) != null )
				{
					_dj = dj.get(v);
					
					if ( _dj > ( _di + waga ) )
					{
						_dj = nowe_dj;
					}
				}
				else
				{
					dj.put(wierzcholek, _di);
					dj.put(v, _dj);
				}
				
				int cij = this.obliczCij(_di, _dj, waga);
				
				wierz.setCij(cij);
				wierz.setDj(_dj);
				wierz.setDi(_di);
				wierz.setOdwiedzony(odwiedzone[v]);
				wynik.put(counter++, wierz);
				
				if ( !odwiedzone[v] )
				{							
					dfs(graf, v, _dj);
				}
			}
		}
	}

	/**
	 * @return Tablica wyliczonych łuków.
	 */	
	public HashMap<Integer, Luk> getWynik(){
		return this.wynik;
	}
}
