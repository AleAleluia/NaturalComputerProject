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
	private Scanner in;
	
	public Teacher(String name) {
		this.name = name;
	}
	
	//Editar o nome do professor
	public void editName(String newName){
		this.name = newName;
	}
	
	public void createClass(){
		System.out.println("Digite o nome da turma a ser criada");
		String className = in.nextLine();
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
	
	public void addStudent(){
		
		in = new Scanner(System.in);
		String name;
		int classNumber;
		
		System.out.println("Digite o nome do aluno");
		name = in.nextLine();
		Student newStudent = new Student(name);
		
		System.out.println("Qual turma você deseja associá-lo?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma número %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		
		newStudent.setAssociatedClass(this.classes.get(classNumber));		
		this.classes.get(classNumber).getStudents().add(newStudent);
		System.out.println("Aluno adicionado com sucesso");
	}
	
	//Editar informacoes de um estudante
	public void editStudent(){
		
		in = new Scanner(System.in);
		String name;
		int classNumber;
		
		System.out.println("Qual turma você deseja alterar?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma número %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		
		System.out.println("Qual o nome do estudante que você deseja alterar?");
		for(int i=0; i<this.classes.get(classNumber).getStudents().size(); i++){
			System.out.printf("Estudante: %s \n", this.classes.get(classNumber).getStudents().get(i).getName());
		}
		name = in.nextLine();
		
		this.classes.get(classNumber).editStudent(name);		
		
	}
	
	public void editClass(){
		in = new Scanner(System.in);
		int classNumber;
		String newClassName;
		System.out.println("Qual turma você deseja alterar o nome?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma número %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		System.out.println("Digite o novo nome para a turma");
		newClassName = in.nextLine();
		this.classes.get(classNumber).setClassName(newClassName);
	}
	
	public void teacherMenu(){
		int choice;
		System.out.println("Olá professor, o que deseja fazer?");
		System.out.printf("1 - Planejar aula \n"
				+ "2 - Criar turma \n"
				+ "3 - Adicionar aluno \n"
				+ "4 - Editar informações de aluno \n"
				+ "5 - Editar nome de turma \n");
		choice = in.nextInt();
		switch(choice){
			case 1: //Planejar aula
				break;
			case 2: //Criar turma
				this.createClass();
				break;
			case 3: //Adicionar aluno
				this.addStudent();
				break;
			case 4: //Editar info de aluno
				this.editStudent();
				break;
			case 5: //Editar nome de turma
				this.editClass();
				break;
			default:
				System.out.println("Nenhuma opção válida selecionada");
				break;
		}
	}

}
