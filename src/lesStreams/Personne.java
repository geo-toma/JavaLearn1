package lesStreams;

public class Personne {
	
	private double taille = 0.0d, poids = 0.0d;
	private String nom = "", prenom = "";
	private Couleur yeux = Couleur.INCONNU;
	
	public Personne() {
	}

	public Personne(double taille, double poids, String nom, String prenom, Couleur yeux) {
		this.taille = taille;
		this.poids = poids;
		this.nom = nom;
		this.prenom = prenom;
		this.yeux = yeux;
	}
	
	@Override
	public String toString() {
		String str = "je m'appelle "+nom+" "+prenom+
				", je pese "+poids+"Kg , et je mesure "+taille+"Cm"+
				". j'ai des yeux "+yeux;
		return str;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Couleur getYeux() {
		return yeux;
	}

	public void setYeux(Couleur yeux) {
		this.yeux = yeux;
	}
	
}
