package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Planner {

	public static void main(String[] args) {
		
		ArrayList<Step> stepDB = new ArrayList<Step>();
		ArrayList<Student> studentDB = new ArrayList<Student>();
		ArrayList<Teacher> teacherDB = new ArrayList<Teacher>();
		int choose;
		Scanner in = new Scanner(System.in);
		System.out.println("Olá, seja bem-vindo ao Ballet Class Planner!");
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar");
		
		/* Caso 1:
		 * 		Pergunta se e Professor ou Aluno
		 * Caso 2:
		 * 		Pergunta se e Professor ou Aluno e leva para a tela de cadastro
		 * 
		 * E melhor perguntar antes se e professor ou aluno ja que a pergunta e a mesma para ambos os casos?
		 */
		choose = in.nextInt();
		switch(choose)
		{
		case 1: //login();
				break;
		case 2: sign_in(teacherDB,studentDB,stepDB);
				break;
		}

	}

	private static void sign_in(ArrayList<Teacher> teacherDB, ArrayList<Student> studentDB, ArrayList<Step> stepDB) {
		// TODO Auto-generated method stub
		int type = userQuestion();
		switch(type)
		{
		case 1: sign_in_Student(studentDB,stepDB);
				break;
		case 2: sign_in_Teacher(teacherDB);
		}
	}

	private static void sign_in_Student(ArrayList<Student> studentDB, ArrayList<Step> stepDB) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("Digite seu nome:");
		name = in.nextLine();
		Student newStudent = new Student(name);
		//showMeYourMoves(newStudent,stepDB);
		//coloque no json.
	}

	private static void sign_in_Teacher(ArrayList<Teacher> teacherDB) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("Digite seu nome:");
		name = in.nextLine();
		Teacher newTeacher = new Teacher(name);
		teacherDB.add(newTeacher);
		//coloque no JSON
		System.out.println("Nome cadastrado");
		
	}

	private static int userQuestion() {
		// TODO Auto-generated method stub
		int choose;
		Scanner in = new Scanner(System.in);
		System.out.println("Aluno ou professor?");
		System.out.println("1 - Aluno");
		System.out.println("2 - Professor");
		choose = in.nextInt();
		return choose;
	}

}
