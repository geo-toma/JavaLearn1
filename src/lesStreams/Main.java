package lesStreams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.testDesStreamAvecSourceUnFichier();
		
	} 
	
	public void testDesStreamAvecSourceUneListe() {
		List<Personne> listP = Arrays.asList(
				new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
				new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
				new Personne(1.75, 65, "C", "Germain", Couleur.VERT),
				new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
				new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
				new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
				new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)
		);	
		
		Stream<Personne> sp = listP.stream();
		sp.forEach(System.out::println);
		//sp.forEach(System.out::println); ne peut plus marcher une seconde fois car la methode forEach est terminal elle ferme le stream
		//donc aucune autre action ne peut plus etre appliquer a ce stream
		
		//Stream.iterate(1, (x) -> x+1).forEach(System.out::println);  creer un stream infini
		Stream.iterate(1, (x) -> x+1).limit(5).forEach(System.out::println);// ici le stream est generer a partir de l'interface elle meme
		
		//quelques action intermediaire qui ne ferme pas le stream
		
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50).forEach(System.out::println);
		
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50).map(x -> x.getPoids()).forEach(System.out::println);
		
		//quelques action terminal en plus du forEach
		
		sp = listP.stream();
		Double sum = sp.filter(x -> x.getPoids() > 50).map(a -> a.getPoids()).reduce(0.0d,(x,y) -> x+y);
		System.out.println(sum);
		//on profite pour voir un nouvelle object
		sp = listP.stream();
		Optional<Double> sum1 = sp.filter(x -> x.getPoids() > 250).map(a -> a.getPoids()).reduce((x,y) -> x+y);
		if(sum1.isPresent()) System.out.println(sum);
		else System.out.println("aucun poids ne verifie la condition");
		System.out.println(sum1.orElse(0.0d));
		
		sp = listP.stream();
		System.out.println(sp.filter(x -> x.getPoids() > 50).count());
		
		sp = listP.stream();
		List<Double> li = sp.filter(x -> x.getPoids() > 50).map(x -> x.getPoids()).collect(Collectors.toList());
		System.out.println(li);
	}

	public void testDesStreamAvecSourceUnFichier() {
		try(Stream<String> sf = Files.lines(Paths.get("file.txt"))) {
			sf.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
