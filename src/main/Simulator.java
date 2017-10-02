package main;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Simulator {
	
	//Algoritmo Genetico aqui
	Step result[] = new Step[8];
	
	public Step[] run(ArrayList<Step> population){
		population = improvement(population);
		ArrayList<Chromosome> chromoPopulation = new ArrayList<Chromosome>();
		ArrayList<Chromosome> chromoDescendants = new ArrayList<Chromosome>();
		chromoPopulation = fillPopulation(chromoPopulation, population);
		//Step chromo[] = new Step[8];
		//iteracoes das geracoes
		for(int generation=0;generation<8;generation++)
		{
			//cruzamentos na populacao
			for(int crossovers=0;crossovers<6;crossovers++)
			{
				Chromosome father, mother;
				int indexfather, indexmother;
				//roleta
				indexfather= roulette(chromoPopulation);
				indexmother = roulette(chromoPopulation);
				while(indexfather == indexmother)
				{
					indexmother = roulette(chromoPopulation);
				}
				father = chromoPopulation.get(indexfather);
				mother = chromoPopulation.get(indexmother);
				crossover(father,mother,chromoDescendants,population);
			}
			chromoPopulation = chromoDescendants;
			chromoDescendants = new ArrayList<Chromosome>();
		}
		//escolher resultado
		
		return this.result;
	}
	
	private int roulette(ArrayList<Chromosome> chromoPopulation) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void crossover(Chromosome father, Chromosome mother, ArrayList<Chromosome> chromoDescendants, ArrayList<Step> population) {
		//cruzamento
		//adicionar para descendentes
		int randomCut = ThreadLocalRandom.current().nextInt(1, 7);
		Chromosome child1 = new Chromosome();
		Chromosome child2 = new Chromosome();
		for(int i=0;i<8;i++)
		{
			if(i<randomCut)
			{
				child1.getChromo().add(father.getChromo().get(i));
				child2.getChromo().add(mother.getChromo().get(i));
			}
			else
			{
				child1.getChromo().add(mother.getChromo().get(i));
				child2.getChromo().add(father.getChromo().get(i));
			}
		}
		//detectar duplicacao
		int indexMutation = checkDuplication(child1);
		while(indexMutation!=-1)
		{
			mutate(child1,indexMutation,population);
			indexMutation = checkDuplication(child1);
		}
		indexMutation = checkDuplication(child2);
		while(indexMutation!=-1)
		{
			mutate(child2,indexMutation, population);
			indexMutation = checkDuplication(child2);
		}
		chromoDescendants.add(child1);
		chromoDescendants.add(child2);
	}
	
	private int checkDuplication(Chromosome child1) {
		for(int i=0;i<7;i++)
		{
			for(int j=i+1;j<8;j++)
			{
				if(child1.getChromo().get(i).equals(child1.getChromo().get(j)))
				{
					return j;
				}
			}
		}
		return -1;
	}

	private void mutate(Chromosome child, int indexMutation, ArrayList<Step> population) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, population.size());
		Step step = population.get(randomNum);
		child.getChromo().set(indexMutation, step);
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
		int randomNum;
		Step step;
		for(int i=0; i<12; i++){
			for(int j=0; j<8; j++){
				randomNum = ThreadLocalRandom.current().nextInt(0, stepsList.size());
				step = stepsList.get(randomNum);
				if( !chromoPopulation.get(i).getChromo().contains(step) ){
					chromoPopulation.get(i).getChromo().add(step);
				}
				else
				{
					while(chromoPopulation.get(i).getChromo().contains(step))
					{
						randomNum = ThreadLocalRandom.current().nextInt(0, stepsList.size());
						step = stepsList.get(randomNum);
					}
					chromoPopulation.get(i).getChromo().add(step);
				}
			}
		}
		return chromoPopulation;
	}
}
