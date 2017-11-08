package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Planner {
	
	ArrayList<Step> stepDB = new ArrayList<Step>();
	ArrayList<Student> studentDB = new ArrayList<Student>();
	ArrayList<Teacher> teacherDB = new ArrayList<Teacher>();
	
	public void run(){
		
		fillSteps();
		createDB();
		//teste
		/*Student studentTest = new Student("Eva");
		studentDB.add(studentTest);*/
				
		int choice, end=1;
		Scanner in = new Scanner(System.in);
		
		while(end==1){
			System.out.println("Ola, seja bem-vindo ao Ballet Class Planner!");
			System.out.println("O que deseja fazer?");
			System.out.println("0 - Encerrar");
			System.out.println("1 - Login");
			System.out.println("2 - Cadastrar");
			
			choice = in.nextInt();
			switch(choice)
			{
				case 0:
					end = 0;
					break;
				case 1: //login
					//printSteps(stepDB);
					System.out.println("Por favor, digite seu nome para efetuar o login");
					in.nextLine();
					String loginName = in.nextLine();
					//search(loginName); //procura no sistema e verifica se professor ou aluno, FALTA IMPLEMENTAR
					if(isNameIn(loginName,studentDB,teacherDB))
					{
						if(isStudent(loginName,studentDB))
						{
							Student stUser = getStudent(loginName,studentDB);
							stUser.studentMenu(studentDB,teacherDB);
						}
						else
						{
							Teacher teUser = getTeacher(loginName,teacherDB);
							teUser.teacherMenu(studentDB,teacherDB);
						}
					}
					break;
				case 2: //cadastrar
					sign_in(teacherDB,studentDB,stepDB);
					//Primeiro pergunta se e estudante ou professor
					//registerStudent();
					break;
				case 3:
					printDB();
					break;
				default:
					System.out.println("Opcao invalida!");
			}
		}
	}
	
	private Teacher getTeacher(String loginName, ArrayList<Teacher> teacherDB) {
		for(int i=0;i<teacherDB.size();i++)
		{
			if(teacherDB.get(i).getName().equals(loginName))
			{
				return teacherDB.get(i);
			}
		}
		return null;
	}

	private Student getStudent(String loginName, ArrayList<Student> studentDB) {
		for(int i=0;i<studentDB.size();i++)
		{
			if(studentDB.get(i).getName().equals(loginName))
			{
				return studentDB.get(i);
			}
		}
		return null;
	}

	private boolean isStudent(String loginName, ArrayList<Student> studentDB2) {
		for(int i=0;i<studentDB.size();i++)
		{
			if(studentDB.get(i).getName().equals(loginName))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean isNameIn(String loginName, ArrayList<Student> studentDB, ArrayList<Teacher> teacherDB) {
		for(int i=0;i<studentDB.size();i++)
		{
			if(studentDB.get(i).getName().equals(loginName))
			{
				return true;
			}
		}
		for(int i=0;i<teacherDB.size();i++)
		{
			if(teacherDB.get(i).getName().equals(loginName))
			{
				return true;
			}
		}
		return false;
	}

	private static void sign_in(ArrayList<Teacher> teacherDB, ArrayList<Student> studentDB, ArrayList<Step> stepDB) {
		int type = userQuestion();
		switch(type)
		{
		case 1: sign_in_Student(studentDB,stepDB,teacherDB);
				break;
		case 2: sign_in_Teacher(teacherDB,studentDB);
		}
	}
	
	private static void sign_in_Student(ArrayList<Student> studentDB, ArrayList<Step> stepDB, ArrayList<Teacher> teacherDB) {
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("Digite seu nome:");
		name = in.nextLine();
		if(isNameIn(name,studentDB,teacherDB))
		{
			System.out.println("Já existe uma pessoa cadastrada com esse nome");
		}
		else
		{
			Student newStudent = new Student(name);
			studentDB.add(newStudent);
			System.out.println("Nome cadastrado");
		}
		//showMeYourMoves(newStudent,stepDB);
		//coloque no json.
	}
	
	private static void sign_in_Teacher(ArrayList<Teacher> teacherDB, ArrayList<Student> studentDB) {
		Scanner in = new Scanner(System.in);
		String name;
		System.out.println("Digite seu nome:");
		name = in.nextLine();
		if(isNameIn(name,studentDB,teacherDB))
		{
			System.out.println("Já existe uma pessoa cadastrada com esse nome");
		}
		else
		{
			Teacher newTeacher = new Teacher(name);
			teacherDB.add(newTeacher);
			System.out.println("Nome cadastrado");
		}
		//coloque no JSON
		
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
	
	private void createDB(){
		
		Student eva = new Student("Eva");
		studentDB.add(eva);
		Student ana = new Student("Ana");
		ana.editStep(0, 4);
		ana.editStep(1, 4);
		ana.editStep(8, 2);
		ana.editStep(14, 3);
		ana.editStep(20, 5);
		ana.editStep(21, 5);
		ana.editStep(30, 3);
		ana.editStep(35, 5);
		studentDB.add(ana);
		Student julia = new Student("Julia");
		julia.editStep(14, 3);
		julia.editStep(17, 2);
		julia.editStep(21, 3);
		julia.editStep(22, 3);
		julia.editStep(36, 4);
		studentDB.add(julia);
		Student james = new Student("James");
		james.editStep(0, 2);
		james.editStep(1, 2);
		james.editStep(2, 2);
		james.editStep(3, 2);
		james.editStep(4, 2);
		james.editStep(5, 2);
		james.editStep(6, 2);
		james.editStep(7, 2);
		james.editStep(8, 2);
		james.editStep(9, 2);
		james.editStep(10, 2);
		studentDB.add(james);
		
		Teacher alessandra = new Teacher("Alessandra");
		teacherDB.add(alessandra);
		Teacher diego = new Teacher("Diego");
		teacherDB.add(diego);
	}
	
	private void printDB(){
		for(int i=0; i<this.studentDB.size();i++)
			System.out.println("Estudante: " + this.studentDB.get(i).getName());
		
		for(int i=0; i<this.teacherDB.size();i++)
			System.out.println("Professor: " + this.teacherDB.get(i).getName());
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
