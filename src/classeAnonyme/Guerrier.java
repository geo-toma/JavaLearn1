package classeAnonyme;

public class Guerrier extends Personage {
	
	
	
	public Guerrier() {
	}


	public Guerrier(Soin soin) {
		super(soin);
	}


	@Override
	public void soigner() {
		soin.soigner();
	}


	
	
}
