package main;

import java.util.ArrayList;

public class Simulator {
	
	//Algoritmo Genético aqui
	Step result[] = new Step[8];
	
	public Step[] run(ArrayList<Step> population){
		population = improvement(population);
		Step chromo[] = new Step[8];
		
		//Setar os cromossomos
		
		//Fazer mutacoes (se necessario)
		
		//Executar cruzamento (vai ter selecao elitista?)
		
		return this.result;
	}
	
	public int howMuchToImprove(Step step){
		int fitness, perfectStep = 5;
		fitness = perfectStep - step.getExLevel();
		return fitness;
	}
	
	public ArrayList<Step> improvement(ArrayList<Step> stepList){
		ArrayList<Step> improvementArray = new ArrayList<Step>();
		improvementArray = (ArrayList<Step>)stepList.clone();
		int improvement;
		
		for(int i=0; i<stepList.size(); i++){
			improvement = howMuchToImprove(stepList.get(i));
			improvementArray.get(i).setExLevel(improvement);
		}
		
		return improvementArray;
	}
}
