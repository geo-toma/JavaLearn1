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
		
	}

}
