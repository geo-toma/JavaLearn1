package classeAnonyme;

public interface Soin {
	
	default void soigner() {
		System.out.println("je ne soigne pas");
	}

}
