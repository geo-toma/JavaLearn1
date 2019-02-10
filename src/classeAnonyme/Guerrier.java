package classeAnonyme;

public class Guerrier extends Personage {
	
	
	
	public Guerrier() {
		//utilisation de la classe anonyme
		this.soin = new Soin() {
		};
	}


	public Guerrier(Soin soin) {
		super(soin);
	}


	@Override
	public void soigner() {
		soin.soigner();
	}


	
	
}
