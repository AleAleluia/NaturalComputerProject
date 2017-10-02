package main;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Simulator {
	
	//Algoritmo Genético aqui
	Step result[] = new Step[8];
	
	public Step[] run(ArrayList<Step> population){
		population = improvement(population);
		ArrayList<Chromosome> chromoPopulation = new ArrayList<Chromosome>();
		chromoPopulation = fillPopulation(chromoPopulation, population);
		//Step chromo[] = new Step[8];
		
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
	
	public ArrayList<Chromosome> fillPopulation(ArrayList<Chromosome> chromoPopulation, ArrayList<Step> stepsList){
		int randomNum = ThreadLocalRandom.current().nextInt(0, stepsList.size());
		Step step = stepsList.get(randomNum);
		for(int i=0; i<12; i++){
			for(int j=0; j<8; j++){
				if( !chromoPopulation.get(i).getChromo().contains(step) ){
					chromoPopulation.get(i).getChromo().add(step);
				}
				randomNum = ThreadLocalRandom.current().nextInt(0, stepsList.size());
				step = stepsList.get(randomNum);
			}
		}
		return chromoPopulation;
	}
}
