package main;

import java.util.ArrayList;

public class Student {
	
	/* O estudante deve ser capaz de:
	 * 		- O array de steps conhecidos tem todos os passos com exLevel 1 (nao sabe fazer)
	 * 		o estudante escolhe os passos que ele sabe e quer editar o exLevel
	 * 		- Editar seu nome
	 * 		- Se ele nao estiver associado a uma turma, poder alterar seu ExecuteLevel
	 * 		- Pedir o planejamento de uma aula individual
	 */
	
	String name; //nome do estudante
	ArrayList<Step> learned = new ArrayList<Step>(); //lista de passos que ele sabe
	Class associatedClass; //turma que ele pertence
	
	public Student(String name) {
		this.name = name;
	}
	
	public void registerStep(int StepValue, ArrayList<Step> StepList){
		learned.add(StepList.get(StepValue));
		System.out.printf("Passo %s adicionado com sucesso!\n", StepList.get(StepValue).getName());
	}
	
	/*Metodos:
	 * setName (para editar o nome)
	 * insertNewStep
	 * editStep
	 */

}
