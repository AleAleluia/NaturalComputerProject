package main;

import java.util.ArrayList;

public class Class {
	
	String teacherName;
	String className;
	ArrayList<Student> students = new ArrayList<Student>();
	
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Class(String className, String teacherName){
		this.className = className;
		this.teacherName = teacherName;
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
	public Student getStudent(String studentName){
		for(int i=0; i< this.students.size(); i++){
			if(this.students.get(i).getName().equals(studentName)){
				System.out.println("Aluno encontrado");
				return this.students.get(i) ;				
			}
		}
		System.out.println("Estudante não cadastrado na turma");
		return null;
	}
	
	//Fazer a funcao de calcular a media dos exLevel dos alunos da turma

}
