package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Planner {

	public static void main(String[] args) {
		
		ArrayList<Step> stepDB = new ArrayList<Step>();
		ArrayList<Student> studentDB = new ArrayList<Student>();
		ArrayList<Teacher> teacherDB = new ArrayList<Teacher>();
		
		stepDB = fillSteps(stepDB);
		
		int choose;
		Scanner in = new Scanner(System.in);
		System.out.println("Ola, seja bem-vindo ao Ballet Class Planner!");
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
				printSteps(stepDB);
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
	
	private static ArrayList<Step> fillSteps(ArrayList<Step> StepList){
		
		Step step1 = new Step("Grand plie", 5);
		StepList.add(step1);
		
		Step step2 = new Step("Tendu", 5);
		StepList.add(step2);
		
		Step step3 = new Step("Jette", 5);
		StepList.add(step3);
		
		Step step4 = new Step("Rond de jambe", 5);
		StepList.add(step4);
		
		Step step5 = new Step("Retire", 5);
		StepList.add(step5);
		
		Step step6 = new Step("Develope", 5);
		StepList.add(step6);
		
		Step step7 = new Step("Arabesque", 5);
		StepList.add(step7);
		
		Step step8 = new Step("Assemble", 5);
		StepList.add(step8);
		
		Step step9 = new Step("Attitude", 5);
		StepList.add(step9);
		
		Step step10 = new Step("Balance", 5);
		StepList.add(step10);
		
		Step step11 = new Step("Ballone", 5);
		StepList.add(step11);
		
		Step step12 = new Step("Ballote", 5);
		StepList.add(step12);
		
		Step step13 = new Step("Cabriolle", 5);
		StepList.add(step13);
		
		Step step14 = new Step("Cambre", 5);
		StepList.add(step14);
		
		Step step15 = new Step("Changement", 5);
		StepList.add(step15);
		
		Step step16 = new Step("Chasse", 5);
		StepList.add(step16);
		
		Step step17 = new Step("Cloche", 5);
		StepList.add(step17);
		
		Step step18 = new Step("Coupe", 5);
		StepList.add(step18);
		
		Step step19 = new Step("Deboule", 5);
		StepList.add(step19);
		
		Step step20 = new Step("Detire", 5);
		StepList.add(step20);
		
		Step step21 = new Step("Echappe", 5);
		StepList.add(step21);
		
		Step step22 = new Step("Eleve", 5);
		StepList.add(step22);
		
		Step step23 = new Step("Emboite", 5);
		StepList.add(step23);
		
		Step step24 = new Step("Fondu", 5);
		StepList.add(step24);
		
		Step step25 = new Step("Fouette", 5);
		StepList.add(step25);
		
		Step step26 = new Step("Frappe", 5);
		StepList.add(step26);
		
		Step step27 = new Step("Glissade", 5);
		StepList.add(step27);
		
		Step step28 = new Step("Pas de basque", 5);
		StepList.add(step28);
		
		Step step29 = new Step("Pas de bouree", 5);
		StepList.add(step29);
		
		Step step30 = new Step("Penche", 5);
		StepList.add(step30);
		
		Step step31 = new Step("Pique", 5);
		StepList.add(step31);
		
		Step step32 = new Step("Pirouette", 5);
		StepList.add(step32);
		
		Step step33 = new Step("Promenade", 5);
		StepList.add(step33);
		
		Step step34 = new Step("Releve", 5);
		StepList.add(step34);
		
		Step step35 = new Step("Sissone", 5);
		StepList.add(step35);
		
		Step step36 = new Step("Sous sous", 5);
		StepList.add(step36);
		
		Step step37 = new Step("Tombe", 5);
		StepList.add(step37);
		
		return StepList;
	}

	public static void printSteps(ArrayList<Step> StepList){
		for(int i=0; i<37; i++){
			System.out.print(i );
			System.out.print(" - ");
			System.out.println(StepList.get(i).getName());
		}
	}
}
