package main;

import java.util.ArrayList;

public class Chromosome {
	private ArrayList<Step> chromo = new ArrayList<Step>();

	public ArrayList<Step> getChromo() {
		return chromo;
	}

	public void setChromo(ArrayList<Step> chromo) {
		this.chromo = chromo;
	}
}
