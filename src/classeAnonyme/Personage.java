package classeAnonyme;

public abstract class Personage {
	
	Soin soin;
	
	public Personage() {
	}

	public Personage(Soin soin) {
		this.soin = soin;
	}

	public abstract void soigner();
	
	public Soin getSoin() {
		return soin;
	}


	public void setSoin(Soin soin) {
		this.soin = soin;
	}

}
