package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Planner {
	
	ArrayList<Step> stepDB = new ArrayList<Step>();
	ArrayList<Student> studentDB = new ArrayList<Student>();
	ArrayList<Teacher> teacherDB = new ArrayList<Teacher>();
	
	public void run(){
		
		fillSteps();
				
		int choose;
		Scanner in = new Scanner(System.in);
		System.out.println("Ola, seja bem-vindo ao Ballet Class Planner!");
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar");
		
		choose = in.nextInt();
		switch(choose)
		{
			case 1: //login
				//printSteps(stepDB);
				System.out.println("Por favor, digite seu nome para efetuar o login");
				String loginName = in.nextLine();
				//search(loginName); //procura no sistema e verifica se professor ou aluno
				//se for professor: showTeacherMenu(user);
				//se for aluno: showStudentMenu(user);
				break;
			case 2: //cadastrar
				sign_in(teacherDB,studentDB,stepDB);
				//Primeiro pergunta se e estudante ou professor
				//registerStudent();
				break;
		}
	}
	
	private static void sign_in(ArrayList<Teacher> teacherDB, ArrayList<Student> studentDB, ArrayList<Step> stepDB) {
		int type = userQuestion();
		switch(type)
		{
		case 1: sign_in_Student(studentDB,stepDB);
				break;
		case 2: sign_in_Teacher(teacherDB);
		}
	}
	
	private static void sign_in_Student(ArrayList<Student> studentDB, ArrayList<Step> stepDB) {
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("Digite seu nome:");
		name = in.nextLine();
		Student newStudent = new Student(name);
		//showMeYourMoves(newStudent,stepDB);
		//coloque no json.
	}
	
	private static void sign_in_Teacher(ArrayList<Teacher> teacherDB) {
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
		int choose;
		Scanner in = new Scanner(System.in);
		System.out.println("Aluno ou professor?");
		System.out.println("1 - Aluno");
		System.out.println("2 - Professor");
		choose = in.nextInt();
		return choose;
	}
	
	private void fillSteps(){
		
		Step step1 = new Step("Grand plie", 5);
		this.stepDB.add(step1);
		
		Step step2 = new Step("Tendu", 5);
		this.stepDB.add(step2);
		
		Step step3 = new Step("Jette", 5);
		this.stepDB.add(step3);
		
		Step step4 = new Step("Rond de jambe", 5);
		this.stepDB.add(step4);
		
		Step step5 = new Step("Retire", 5);
		this.stepDB.add(step5);
		
		Step step6 = new Step("Develope", 5);
		this.stepDB.add(step6);
		
		Step step7 = new Step("Arabesque", 5);
		this.stepDB.add(step7);
		
		Step step8 = new Step("Assemble", 5);
		this.stepDB.add(step8);
		
		Step step9 = new Step("Attitude", 5);
		this.stepDB.add(step9);
		
		Step step10 = new Step("Balance", 5);
		this.stepDB.add(step10);
		
		Step step11 = new Step("Ballone", 5);
		this.stepDB.add(step11);
		
		Step step12 = new Step("Ballote", 5);
		this.stepDB.add(step12);
		
		Step step13 = new Step("Cabriolle", 5);
		this.stepDB.add(step13);
		
		Step step14 = new Step("Cambre", 5);
		this.stepDB.add(step14);
		
		Step step15 = new Step("Changement", 5);
		this.stepDB.add(step15);
		
		Step step16 = new Step("Chasse", 5);
		this.stepDB.add(step16);
		
		Step step17 = new Step("Cloche", 5);
		this.stepDB.add(step17);
		
		Step step18 = new Step("Coupe", 5);
		this.stepDB.add(step18);
		
		Step step19 = new Step("Deboule", 5);
		this.stepDB.add(step19);
		
		Step step20 = new Step("Detire", 5);
		this.stepDB.add(step20);
		
		Step step21 = new Step("Echappe", 5);
		this.stepDB.add(step21);
		
		Step step22 = new Step("Eleve", 5);
		this.stepDB.add(step22);
		
		Step step23 = new Step("Emboite", 5);
		this.stepDB.add(step23);
		
		Step step24 = new Step("Fondu", 5);
		this.stepDB.add(step24);
		
		Step step25 = new Step("Fouette", 5);
		this.stepDB.add(step25);
		
		Step step26 = new Step("Frappe", 5);
		this.stepDB.add(step26);
		
		Step step27 = new Step("Glissade", 5);
		this.stepDB.add(step27);
		
		Step step28 = new Step("Pas de basque", 5);
		this.stepDB.add(step28);
		
		Step step29 = new Step("Pas de bouree", 5);
		this.stepDB.add(step29);
		
		Step step30 = new Step("Penche", 5);
		this.stepDB.add(step30);
		
		Step step31 = new Step("Pique", 5);
		this.stepDB.add(step31);
		
		Step step32 = new Step("Pirouette", 5);
		this.stepDB.add(step32);
		
		Step step33 = new Step("Promenade", 5);
		this.stepDB.add(step33);
		
		Step step34 = new Step("Releve", 5);
		this.stepDB.add(step34);
		
		Step step35 = new Step("Sissone", 5);
		this.stepDB.add(step35);
		
		Step step36 = new Step("Sous sous", 5);
		this.stepDB.add(step36);
		
		Step step37 = new Step("Tombe", 5);
		this.stepDB.add(step37);
	}
	
	public void printSteps(ArrayList<Step> StepList){
		for(int i=0; i<StepList.size(); i++){
			System.out.print(i);
			System.out.print(" - ");
			System.out.println(StepList.get(i).getName());
		}
	}

}
