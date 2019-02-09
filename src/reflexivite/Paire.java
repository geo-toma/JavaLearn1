package reflexivite;

public class Paire {
	
	private String val;
	private String val1;
	
	public Paire() {
		val = null;
		val1 = null;
		System.out.println("instanciation");
	}

	public Paire(String val, String val1) {
		this.val = val;
		this.val1 = val1;
		System.out.println("instanciation avec des parametres");
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}
	
	@Override
	public String toString() {
		return "je suis un object qui a pour valeur "+val+" - "+val1;
	}
}
