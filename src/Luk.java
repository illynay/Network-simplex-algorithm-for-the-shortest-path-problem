/**
 * Odpowiedzialna za tworzenie łuków.  
 */
public class Luk {
	/**
	 * Początek łuku.
	 */
	private int poczatek;
	/**
	 * Koniec łuku.
	 */
	private int koniec;
	/**
	 * Waga łuku.
	 */
	private int waga;
	/**
	 * Potencjał di.
	 */
	private int di;
	/**
	 * Potencjał dj.
	 */
	private int dj;
	/**
	 * Potencjał cij.
	 */
	private int cij;
	/**
	 * Czy wierzchołek był odwiedzony.
	 */
	private boolean odwiedzony = false;
	
	/**
	 * Zapisywanie podstawowych danych o łuku.
	 * @param  poczatek Początek łuku.
	 * @param koniec Koniec łuku.
	 * @param waga Koszt od początku do końca.
	 */
	public Luk(int poczatek, int koniec, int waga) 
	{
		this.poczatek = poczatek;
		this.koniec = koniec;
		this.waga = waga;
	}
	/**
	 * @return Zwraca wszystkie szczegóły łuku.
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		
		s.append("poczatek: ").append(poczatek).append(newLine);
		s.append("koniec: ").append(koniec).append(newLine);
		s.append("waga: ").append(waga).append(newLine);
		s.append("di: ").append(di).append(newLine);
		s.append("dj: ").append(dj).append(newLine);
		s.append("cij: ").append(cij).append(newLine);
		s.append("odwiedzony: ").append(odwiedzony ? "tak" : "nie").append(newLine);
		
		s.append(newLine);
		
		return s.toString();
	}
	/**
	 * @return Zwraca, czy łuk był odwiedzony.
	 */
	public boolean isOdwiedzony() {
		return odwiedzony;
	}
	/**
	 * Zapisuje, czy łuk był odwiedzony.
	 * @param odwiedzony Czy wierzchołek był odwiedzony.
	 */
	public void setOdwiedzony(boolean odwiedzony) {
		this.odwiedzony = odwiedzony;
	}
	/**
	 * @return Zwraca początek łuku.
	 */
	public int getPoczatek() {
		return poczatek;
	}
	/**
	 * @return Zwraca koniec łuku.
	 */
	public int getKoniec() {
		return koniec;
	}
	/**
	 * @return Zwraca wagę.
	 */
	public int getWaga() {
		return waga;
	}
	/**
	 * @return Zwraca potencjał di.
	 */
	public int getDi() {
		return di;
	}
	/**
	 * Zapisuje potencjał di.
	 * @param di potencjał di.
	 */
	public void setDi(int di) {
		this.di = di;
	}
	/**
	 * @return Zwraca potencjał dj.
	 */
	public int getDj() {
		return dj;
	}
	/**
	 * Zapisuje potencjał dj.
	 * @param di potencjał dj.
	 */
	public void setDj(int dj) {
		this.dj = dj;
	}
	/**
	 * @return Zwraca cij.
	 */
	public int getCij() {
		return cij;
	}
	/**
	 * Zapisuje cij.
	 * @param cij Potencjał cij.
	 */
	public void setCij(int cij) {
		this.cij = cij;
	}
}
