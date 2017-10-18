package main;

import java.util.ArrayList;

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
	
	public Teacher(String name) {
		this.name = name;
	}
	
	/*Metodos:
	 * registerNewStudent
	 * editStudent
	 */

}
