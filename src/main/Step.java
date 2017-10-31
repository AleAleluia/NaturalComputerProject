package main;

public class Step {
	
	private String name; //nome do passo
	//String category; //categoria do passo (grand-plie, tendu, jette)
	private int exLevel;/*execute level 1 - n�o executa o passo
								2 - executa muito mal
								3 - executa normal
								4 - executa bem
								5 - executa muito bem*/
	
	public Step(String name, int exLevel) {
		this.name = name;
		this.exLevel = exLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExLevel() {
		return exLevel;
	}
	public void setExLevel(int exLevel) {
		this.exLevel = exLevel;
	}

	
	
	/*Metodos:
	 * set exLevel
	 * get exLevel
	 * get category
	 * get name (?)
	 */
}
