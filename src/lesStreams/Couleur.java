package lesStreams;

public enum Couleur {
	
	MARRON("Marron"),
	BLEU("Bleu"),
	VERT("Vert"),
	VERRON("Verron"),
	INCONNU("Inconnu"),
	ROUGE("Rouge");
	
	private String name = "";
	private Couleur(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}

}
