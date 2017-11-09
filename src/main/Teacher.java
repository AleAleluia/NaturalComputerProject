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
	private String name;
	ArrayList<Class> classes = new ArrayList<Class>();
	private Scanner in = new Scanner(System.in);
	
	public Teacher(String name) {
		this.name = name;
	}
	
	//Editar o nome do professor
	public void editName(String newName){
		this.name = newName;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void createClass(){
		System.out.println("Digite o nome da turma a ser criada");
		String className = in.nextLine();
		className = in.nextLine();
		for(int i=0; i<this.classes.size(); i++){
			if( (this.classes.get(i).getClassName()).equals(className) ){
				System.out.println("A classe ja existe!");
				return;
			}
		}
		Class newClass = new Class(className, this.name);
		this.classes.add(newClass);
		System.out.println("Classe criada com sucesso");
		return;
	}
	
	public void addStudent(){
		
		in = new Scanner(System.in);
		String name;
		int classNumber;
		
		System.out.println("Digite o nome do aluno");
		name = in.nextLine();
		Student newStudent = new Student(name);
		
		System.out.println("Qual turma voce deseja associa-lo?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma numero %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		
		newStudent.setAssociatedClass(this.classes.get(classNumber));		
		this.classes.get(classNumber).getStudents().add(newStudent);
		System.out.println("Aluno adicionado com sucesso");
	}
	
	//Editar informacoes de um estudante
	public void editStudent(ArrayList<Student> studentDB, ArrayList<Teacher> teacherDB){
		
		in = new Scanner(System.in);
		String name;
		int classNumber;
		
		System.out.println("Qual turma voce deseja alterar?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma numero %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		
		System.out.println("Qual o nome do estudante que voce deseja alterar?");
		for(int i=0; i<this.classes.get(classNumber).getStudents().size(); i++){
			System.out.printf("Estudante: %s \n", this.classes.get(classNumber).getStudents().get(i).getName());
		}
		name = in.nextLine();
		name = in.nextLine();
		if(isNameIn(name,studentDB,teacherDB))
		{
			System.out.println("Ja existe uma pessoa cadastrada com esse nome");
		}
		else
		{
			this.classes.get(classNumber).editStudent(name);
		}
	}
	
	private boolean isNameIn(String name, ArrayList<Student> studentDB, ArrayList<Teacher> teacherDB) {
		for(int i=0;i<studentDB.size();i++)
		{
			if(studentDB.get(i).getName().equals(name))
			{
				return true;
			}
		}
		for(int i=0;i<teacherDB.size();i++)
		{
			if(teacherDB.get(i).getName().equals(name))
			{
				return true;
			}
		}
		return false;
	}

	public void editClass(){
		in = new Scanner(System.in);
		int classNumber;
		String newClassName;
		System.out.println("Qual turma voce deseja alterar o nome?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma numero %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		System.out.println("Digite o novo nome para a turma");
		newClassName = in.nextLine();
		this.classes.get(classNumber).setClassName(newClassName);
	}
	
	public void planClass(){
		Simulator sim = new Simulator();
		int classNumber;
		in = new Scanner(System.in);
		
		System.out.println("Para qual turma voce deseja planejar a aula?");
		for(int i=0; i<this.classes.size(); i++){
			System.out.printf("Turma numero %d: %s", i, this.classes.get(i).getClassName());
		}
		classNumber = in.nextInt();
		
		sim.run(calculateAverage(this.classes.get(classNumber).getStudents()));
	}
	
	public void teacherMenu(ArrayList<Student> studentDB, ArrayList<Teacher> teacherDB){
		int choice, end=1;
		while(end==1){
			System.out.println("Ola professor, o que deseja fazer?");
			System.out.printf("1 - Planejar aula \n"
					+ "2 - Criar turma \n"
					+ "3 - Adicionar aluno \n"
					+ "4 - Editar informacoes de aluno \n"
					+ "5 - Editar nome de turma \n"
					+ "0 - Logout \n");
			choice = in.nextInt();
			switch(choice){
				case 0:
					end = 0;
					break;
				case 1: //Planejar aula
					if(this.classes.size()<1)
					{
						System.out.println("Nao ha nenhuma turma.");
					}
					else
					{
						planClass();
					}
					break;
				case 2: //Criar turma
					this.createClass();
					break;
				case 3: //Adicionar aluno
					if(this.classes.size()<1)
					{
						System.out.println("Nao ha nenhuma turma.");
					}
					else
					{
						this.addStudent();
					}
					break;
				case 4: //Editar info de aluno
					if(this.classes.size()<1)
					{
						System.out.println("Nao ha nenhuma turma.");
					}
					else
					{
						this.editStudent(studentDB,teacherDB);
					}
					break;
				case 5: //Editar nome de turma
					if(this.classes.size()<1)
					{
						System.out.println("Nao ha nenhuma turma.");
					}
					else
					{
						this.editClass();
					}
					break;
				default:
					System.out.println("Nenhuma opcao valida selecionada");
					break;
			}
		}
	}
	
	public ArrayList<Step> calculateAverage(ArrayList<Student> studentsList){
		int stepMean, sum=0, numberOfSteps=37;
		Student useless = new Student("UselessStudent");
		ArrayList<Step> stepAverage = new ArrayList<Step>();
		stepAverage = (ArrayList<Step>) useless.getLearned().clone();
		
		for(int i=0; i<numberOfSteps; i++){
			sum=0;
			for(int j=0; j<studentsList.size(); j++){
				sum += studentsList.get(j).getLearned().get(i).getExLevel();
			}
			stepMean = sum/(studentsList.size());
			stepAverage.get(i).setExLevel(stepMean);
		}
		
		for(int i=0; i<stepAverage.size(); i++)
			System.out.printf(" Passo %s media: %d", stepAverage.get(i).getName(), stepAverage.get(i).getExLevel());
		
		return stepAverage;
	}

}
