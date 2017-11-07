package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	/* O estudante deve ser capaz de:
	 * 		- O array de steps conhecidos tem todos os passos com exLevel 1 (nao sabe fazer)
	 * 		o estudante escolhe os passos que ele sabe e quer editar o exLevel
	 * 		- Editar seu nome
	 * 		- Se ele nao estiver associado a uma turma, poder alterar seu ExecuteLevel
	 * 		- Pedir o planejamento de uma aula individual
	 */
	
	private String name; //nome do estudante
	private ArrayList<Step> learned = new ArrayList<Step>(); //lista de passos que ele sabe
	private Class associatedClass; //turma que ele pertence
	private Scanner in = new Scanner(System.in);
	
	public Student(String name) {
		
		this.name = name;
		
		Step step1 = new Step("Grand plie", 1);
		this.learned.add(step1);		
		Step step2 = new Step("Tendu", 1);
		this.learned.add(step2);		
		Step step3 = new Step("Jette", 1);
		this.learned.add(step3);		
		Step step4 = new Step("Rond de jambe", 1);
		this.learned.add(step4);		
		Step step5 = new Step("Retire", 1);
		this.learned.add(step5);		
		Step step6 = new Step("Develope", 1);
		this.learned.add(step6);		
		Step step7 = new Step("Arabesque", 1);
		this.learned.add(step7);		
		Step step8 = new Step("Assemble", 1);
		this.learned.add(step8);		
		Step step9 = new Step("Attitude", 1);
		this.learned.add(step9);		
		Step step10 = new Step("Balance", 1);
		this.learned.add(step10);		
		Step step11 = new Step("Ballone", 1);
		this.learned.add(step11);		
		Step step12 = new Step("Ballote", 1);
		this.learned.add(step12);		
		Step step13 = new Step("Cabriolle", 1);
		this.learned.add(step13);		
		Step step14 = new Step("Cambre", 1);
		this.learned.add(step14);		
		Step step15 = new Step("Changement", 1);
		this.learned.add(step15);		
		Step step16 = new Step("Chasse", 1);
		this.learned.add(step16);		
		Step step17 = new Step("Cloche", 1);
		this.learned.add(step17);		
		Step step18 = new Step("Coupe", 1);
		this.learned.add(step18);		
		Step step19 = new Step("Deboule", 1);
		this.learned.add(step19);		
		Step step20 = new Step("Detire", 1);
		this.learned.add(step20);		
		Step step21 = new Step("Echappe", 1);
		this.learned.add(step21);		
		Step step22 = new Step("Eleve", 1);
		this.learned.add(step22);		
		Step step23 = new Step("Emboite", 1);
		this.learned.add(step23);		
		Step step24 = new Step("Fondu", 1);
		this.learned.add(step24);		
		Step step25 = new Step("Fouette", 1);
		this.learned.add(step25);		
		Step step26 = new Step("Frappe", 1);
		this.learned.add(step26);		
		Step step27 = new Step("Glissade", 1);
		this.learned.add(step27);		
		Step step28 = new Step("Pas de basque", 1);
		this.learned.add(step28);		
		Step step29 = new Step("Pas de bouree", 1);
		this.learned.add(step29);		
		Step step30 = new Step("Penche", 1);
		this.learned.add(step30);
		Step step31 = new Step("Pique", 1);
		this.learned.add(step31);		
		Step step32 = new Step("Pirouette", 1);
		this.learned.add(step32);		
		Step step33 = new Step("Promenade", 1);
		this.learned.add(step33);		
		Step step34 = new Step("Releve", 1);
		this.learned.add(step34);		
		Step step35 = new Step("Sissone", 1);
		this.learned.add(step35);		
		Step step36 = new Step("Sous sous", 1);
		this.learned.add(step36);		
		Step step37 = new Step("Tombe", 1);
		this.learned.add(step37);
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Nome alterado com sucesso!");
	}
	
	public ArrayList<Step> getLearned() {
		return learned;
	}

	public void setLearned(ArrayList<Step> learned) {
		this.learned = learned;
	}

	public Class getAssociatedClass() {
		return associatedClass;
	}

	public void setAssociatedClass(Class associatedClass) {
		this.associatedClass = associatedClass;
	}



	public void editStep(int stepNumber, int newExLevel){
		learned.get(stepNumber).setExLevel(newExLevel);
		System.out.println("Nivel do passo alterado com sucesso");
	}
	
	public void showSteps(){
		System.out.println("LISTA DE PASSOS:");
		for(int i=0; i<(this.learned.size()); i++ ){
			System.out.printf("Passo %d:" + "Nome do passo: %s \n"
					+ "Nivel de execucao: %d \n \n", i, this.learned.get(i).getName(), this.learned.get(i).getExLevel());
		}
	}
	
	public void studentMenu(){
		int choice, step, exLvl, secondChoice=0, end=1;
		String name;
		
		while(end==1){		
			System.out.println("Ola aluno, o que deseja fazer?");
			System.out.printf("1 - Planejar aula \n"
					+ "2 - Editar nome \n"
					+ "3 - Editar nivel de passo \n"
					+ "4 - Logout \n");
		
			choice = in.nextInt();
			switch(choice){
				case 0:
					end = 0;
					break;
				case 1: //Planejar aula
					Simulator sim = new Simulator();
					sim.run(this.learned);
					break;
				case 2: //Editar nome
					System.out.printf("Nome atual: %s \n", this.getName() );
					System.out.println("Digite o novo nome");
					name = in.nextLine();
					this.setName(name);
					break;
				case 3: //Editar nivel de passo
					while (secondChoice==0){
						System.out.println("Escolha qual passo e o nivel para alterar");
						this.showSteps();
						step = in.nextInt();
						exLvl = in.nextInt();
						this.editStep(step-1, exLvl);
						System.out.println("Deseja alterar mais algum passo?");
						System.out.println("Digite 0 para continuar alterando ou outro numero para sair");
						secondChoice = in.nextInt();
					}
					break;
				default:
					System.out.println("Nenhuma opcao valida selecionada");
					break;
			}
		}
	}
	
	/* Metodos:
	 * editStep (alterar o nivel do passo)
	 * planClass (planejar a aula de ballet)
	 */

}
