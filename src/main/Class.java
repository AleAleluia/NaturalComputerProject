package main;

import java.util.ArrayList;

public class Class {
	
	String teacherName;
	String className;
	ArrayList<Student> students = new ArrayList<Student>();
	
	public Class(String className, String teacherName){
		this.className = className;
		this.teacherName = teacherName;
	}
	
	private void addStudent(Student newStudent){
		for(int i=0; i< this.students.size(); i++){
			if(this.students.get(i).getName().equals(newStudent.getName())){
				System.out.println("Esse aluno já existe nessa turma!");
				return;				
			}
		}
		this.students.add(newStudent);
		System.out.println("Aluno adicionado com sucesso!");
	}
	
	//Fazer a funcao de calcular a media dos exLevel dos alunos da turma

}
