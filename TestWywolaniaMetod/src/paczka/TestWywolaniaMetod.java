package paczka;

public class TestWywolaniaMetod {

	public static void main(String[] args) {
		//1) typ prosty - przekazany przez wartosc - zmieniana tylko wewnatrz metody
			//metody nie mog¹ zmieniac parametrow liczbowych
		System.out.println("--------------------------------------------------------------------------");
		double wartosc = 10.0;
		System.out.println("Wartoœæ przed: " + wartosc); 
		potrojWartosc(wartosc);
		System.out.println("Wartoœæ po zakoñczeniu metody to: "+wartosc);
		
		//2) obiekty przekazywane s¹ przez kopiê referencj
			//zmieniony obiekt wewnatrz metody zostanie zmieniony
		System.out.println("--------------------------------------------------------------------------");
		Pracownik2 p1 = new Pracownik2("Kamil", 3000);
		System.out.println("Pobrana pensja po utworzeniu: " + p1.pobierzPensje());
		potrojPensje(p1);
		System.out.println("Pobrana pensja po przekazaniu obiektu do metody i potrojeniu: " + p1.pobierzPensje());
		
		//3) obiekt przekazywany jest za pomoc¹ kopii referencji
			//jesli ta referencja zostanie nadpisana w zmiennej - to tylko lokalnie w metodzie
		System.out.println("--------------------------------------------------------------------------");
		Pracownik2 p2 = new Pracownik2("Agnieszka", 4000);
		System.out.println("p1, przed: || " + p1.toString());
		System.out.println("p2, przed: || " + p2.toString());
		zamienKolejnoscia(p1, p2);
		System.out.println("p1, po: || " + p1.toString());
		System.out.println("p2, po: || " + p2.toString());
		
	}
	
	
	private static void potrojWartosc(double w){
		w = w*3;
		System.out.println("Potrojona wartoœæ to: "+w);
	}
	private static void potrojPensje(Pracownik2 p){
		p.podniesPensje(200);
	}
	private static void zamienKolejnoscia(Pracownik2 p1, Pracownik2 p2){
		Pracownik2 temp = p1;
		p1 = p2;
		p2 = temp;
		System.out.println("p1, wewnatrz metody: || " + p1.toString());
		System.out.println("p2, wewnatrz metody: || " + p2.toString());
	}
}

class Pracownik2{
	String nazwa;
	double pensja;
	
	Pracownik2(String n, double p){
		this.nazwa = n;
		this.pensja = p;
	}
	
	public void podniesPensje(double p){
		pensja = pensja + ((pensja * p)/100);
	}
	
	public double pobierzPensje(){
		return this.pensja;
	}
	
	@Override
	public String toString(){
		return "Imie: " + this.nazwa
				+ ", pensja: " + this.pensja;	
	}
}
