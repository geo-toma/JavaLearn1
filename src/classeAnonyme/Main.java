package classeAnonyme;

public class Main {
	public static void main(String[] args) {
		
		Personage per = new Guerrier();
		per.soigner();
		per.setSoin(new Operation());
		per.soigner();
		
		per.setSoin(new Soin() {
			public void soigner() {
				System.out.println("methode soigner redefinit par la classe anonyme");
			}
		});
		per.soigner();
		
		per.setSoin(() -> {System.out.println("methode soigner redefinit avec lambda");});
		per.soigner();
		
		Soin soin = () -> {System.out.println("methode soigner redefinit avec lambda d'une autre maniere");};
		per.setSoin(soin);
		per.soigner();
		
	}

}
