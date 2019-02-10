package java_util_fonction_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Test {
	public static void main(String[] args) {
		List<Personne> personnes = Arrays.asList(
				new Personne("titi", 10),
				new Personne("tete", 20),
				new Personne("tata", 30),
				new Personne("toto", 40),
				new Personne("tutu", 50)
		);
		Test test = new Test();
		
		test.testFunction(personnes);
		test.testConsumer(personnes);
		test.testPredicate(personnes);
		test.testSupplier();
		
	}
	
	public static List<String> transformToListString(List<Personne> list, Function<Personne,String> func) {
		List<String> ls = new ArrayList<>();
		for(Personne p : list)
			ls.add(func.apply(p));
		return ls;
	}
	
	public static List<Integer> transformToListInt(List<Personne> list, Function<Personne, Integer> func){
		List<Integer> ls = new ArrayList<>();
		for(Personne p : list)
			ls.add(func.apply(p));
		return ls;				
	}
	
	public void testFunction(List<Personne> personnes) {
		Function<Personne, String> f1 = (Personne p) -> p.getNom();
		Function<Personne, Integer> f2 = (Personne p) -> p.getAge();
		
		System.out.println(transformToListString(personnes, f1));
		System.out.println(transformToListInt(personnes, f2));
		
		// on peut surcharger la methode apply redefini en faisant un deuxieme operation a la suite
		
		Function<Integer, Integer> f3 = (Integer a) -> a*2;
		System.out.println(transformToListInt(personnes, f2.andThen(f3)));// c'est le meme que f3.apply(f2.apply(p))
	}

	public void testConsumer(List<Personne> personnes) {
		System.out.println(personnes);
		Consumer<Personne> c = (Personne p) -> p.setAge(p.getAge() + 8);
		for(Personne per : personnes)
			c.accept(per);
		System.out.println(personnes);
	}

	public void testPredicate(List<Personne> personnes) {
		Predicate<Personne> predicate = (Personne p) -> p.getAge() > 20;
		for(Personne p : personnes) {
			if(predicate.test(p))
				System.out.println(p.getNom()+" a l'age requis");
			else
				System.out.println(p.getNom()+" n'a pas l'age");
		}
	}

	public void testSupplier() {
		Supplier<String> s1 = () -> new String("parole...");
		System.out.println(s1.get());
		Supplier<Personne> s2 = () -> new Personne("Moi", 20);
		System.out.println(s2.get());
	}
}
