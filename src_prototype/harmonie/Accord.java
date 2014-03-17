package harmonie;

import java.util.ArrayList;

public abstract class Accord {
	
	private int soprano;
	private int alto;
	private int basse;
	private int tenor;
	private int duree;
	
	private Accord suivant;
	private ArrayList<Accord> jeuxSuivants;
	
	public int getDuree() {
		return duree;
	}
	public int getSoprano() {
		return soprano;
	}
	public int getAlto() {
		return alto;
	}
	public int getBasse() {
		return basse;
	}
	public int getTenor() {
		return tenor;
	}
	public Accord getSuivant() {
		return suivant;
	}
	public void setSuivant(Accord suivant) {
		this.suivant = suivant;
	}
	
	public Accord(int s, int a, int b, int t, int d){
		soprano=s;
		alto=s;
		tenor=t;
		basse=b;
		duree=d;
	}
	
	public boolean verifAccord(Accord a){
		return verifAccordLocal() && verifAccordEnchainement(a);
	}
	private boolean verifAccordLocal(){
		return Regle.verifNote(this);
	}
	private boolean verifAccordEnchainement(a){
		return Regle.enchainementCorrect(this, a);
	}
}
