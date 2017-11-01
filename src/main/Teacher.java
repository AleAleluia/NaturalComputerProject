package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
	
	/* O professor deve ser capaz de:
	 * 		- Cadastrar turmas
	 * 		- Pode escolher entre: escolher um aluno existente ou criar um aluno para formar suas turmas
	 * 		- Ver suas turmas
	 * 		- Editar o ExecuteLevel dos alunos (caso o aluno melhore ou piore executando um passo)
	 * 		- Pedir o planejamento de uma aula coletiva
	 */
	String name;
	ArrayList<Class> classes = new ArrayList<Class>();
	
	public Teacher(String name) {
		this.name = name;
	}
	
	//Editar o nome do professor
	public void editName(String newName){
		this.name = newName;
	}
	
	public void createClass(String className){
		for(int i=0; i<this.classes.size(); i++){
			if( (this.classes.get(i).getClassName()).equals(className) ){
				System.out.println("A classe ja existe!");
				return;
			}
		}
		Class newClass = new Class(className, this.name);
		this.classes.add(newClass);
		return;
	}
	
	//Editar o nível de algum passo
	public void editStepLevel(){
		
		Scanner in = new Scanner(System.in);
		int classNumber, i;
		String studentName;
		Student student;
		
		System.out.println("Qual aluno você deseja editar?");
		studentName = in.nextLine();
		for(i=0; i<this.classes.size(); i++){
			student = this.classes.get(i).getStudent(studentName);
			if(student!=null)
				break;
		}
		//Falta completar, talvez seja mais facil fazer direto no class
	}
	
	/*public void editStepLevel(int id, String studentName){
		boolean check=false;
		int i, j;
		for(i=0; i< (this.classes.size()) ; i++){
			for(j=0; this.classes.get(i).students.size(); j++)
				// tem que checar se o nome do estudante bate
				check = studentName.equals();
			if( check ){
				break;
			}
		}
		
		if(check){ //encontrou o estudante
			
		}else{
			System.out.println("Estudante nao encontrado!");
		}
			
	}*/
	
	/*Metodos:
	 * registerNewStudent
	 * editStudent
	 */

}
