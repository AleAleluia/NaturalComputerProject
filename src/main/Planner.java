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
		System.out.println("Ol�, seja bem-vindx ao Ballet Class Planner!");
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
		case 2: sign_in();
				break;
		}

	}

	private static void sign_in() {
		// TODO Auto-generated method stub
		int type = question();
		switch(type)
		{
		case 1: //sign_in_Student();
				break;
		case 2: //sign_in_Teacher();
		}
	}

	private static int question() {
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
