package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Class {
	
	String teacherName;
	String className;
	ArrayList<Student> students = new ArrayList<Student>();
	private Scanner in;
	
	public Class(String className, String teacherName){
		this.className = className;
		this.teacherName = teacherName;
	}
	
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
		System.out.println("Nome do professor alterado com sucesso");
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
		System.out.println("Nome da turma alterado com sucesso");
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public void addStudent(Student newStudent){
		for(int i=0; i< this.students.size(); i++){
			if(this.students.get(i).getName().equals(newStudent.getName())){
				System.out.println("Esse aluno já existe nessa turma!");
				return;				
			}
		}
		this.students.add(newStudent);
		System.out.println("Aluno adicionado com sucesso!");
	}
	
	//Procura um aluno na turma ao passar o nome
	public Student searchStudent(String studentName){
		for(int i=0; i< this.students.size(); i++){
			if(this.students.get(i).getName().equals(studentName)){
				System.out.println("Aluno encontrado");
				return this.students.get(i) ;				
			}
		}
		System.out.println("Estudante não cadastrado na turma");
		return null;
	}
	
	public void editStudent(String studentName){
		int choice, step, exLvl, secondChoice=0;
		String name;
		in = new Scanner(System.in);
		
		for(int i=0; i< this.students.size(); i++){
			
			if(this.students.get(i).getName().equals(studentName)){
				System.out.println("Aluno encontrado");
				System.out.println("O que deseja fazer?");
				System.out.printf("1 - Alterar nome \n"
						+ "2 - Alterar nível de execução de passo");
				choice = in.nextInt();
				
				if(choice == 1){ //Alterar nome
					System.out.printf("Nome atual: %s \n", this.students.get(i).getName());
					System.out.println("Digite o novo nome");
					name = in.nextLine();
					name = in.nextLine();
					this.students.get(i).setName(name);
				}
				else if(choice == 2){ //Alterar exLevel
					while (secondChoice==0){
						System.out.println("Escolha qual passo e o nível para alterar");
						this.students.get(i).showSteps();
						step = in.nextInt();
						exLvl = in.nextInt();
						this.students.get(i).editStep(step, exLvl);
						System.out.println("Deseja alterar mais algum passo?");
						System.out.println("Digite 0 para continuar alterando ou outro número para sair");
						secondChoice = in.nextInt();
					}
				}else{
					System.out.println("Escolha invalida");
					return;
				}				
			}else{
				System.out.println("Estudante não cadastrado na turma");
			}
		}

		return;
	}

}
