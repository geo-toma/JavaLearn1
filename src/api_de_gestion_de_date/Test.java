package api_de_gestion_de_date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {
	
	public void gestionDuTempHumain() {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Date et l'heure actuel "+ currentTime);
		
		LocalDate currentDate = currentTime.toLocalDate();
		System.out.println("la date d'aujourd'hui "+ currentDate);
		
		Month mois = currentTime.getMonth();
		int jour = currentDate.getDayOfMonth();//on peut utiliser currentDate comme currentTime
		int heure = currentTime.getHour();
		System.out.println("Mois : "+mois+" Jour : "+jour+" Heure : "+heure);
		
		// fixer une date par nous meme en modifiant une autre
		LocalDateTime date = currentTime.withYear(2020).withMonth(4).withHour(2);
		System.out.println("date modifie : "+date);//le contenu de currentTime ne sera pas modifie par contre
		//autre maniere de faire
		LocalDate date1 = LocalDate.of(2019, Month.APRIL, 23);
		System.out.println("autre maniere d'avoir la date qu'on veur : "+date1);
		
		//convertion depuis un String
		LocalTime time = LocalTime.parse("23:37:09");
		System.out.println("l'heure convertie depuis un String : "+time);
	}
	
	public void dateManipulation() {
		LocalDateTime ldt = LocalDateTime.of(2019, 04, 23, 2, 53, 47);
		System.out.println("date de reference : "+ldt+"\n");
		
		System.out.println("+1 semaine : "+ldt.plus(1, ChronoUnit.WEEKS));
		System.out.println("+2 mois : "+ldt.plus(2, ChronoUnit.MONTHS));
		System.out.println("+3 ans : "+ldt.plus(3, ChronoUnit.YEARS));
		System.out.println("+4 heures : "+ldt.plus(4, ChronoUnit.HOURS));
		System.out.println("-5 minutes : "+ldt.minus(5, ChronoUnit.MINUTES));
		System.out.println("-30 secondes : "+ldt.minusSeconds(30));
	}
	
	public void dureeEtPeriod() {
		LocalDateTime ldt = LocalDateTime.of(2019, 04, 23, 2, 53, 47);
		LocalDateTime ldt1 = ldt.plus(3, ChronoUnit.YEARS);
		LocalDateTime ldt2 = ldt.plusMinutes(2);
		
		Period p = Period.between(ldt.toLocalDate(), ldt1.toLocalDate());
		Duration d = Duration.between(ldt.toLocalTime(), ldt2.toLocalTime());
		
		System.out.println("periode : "+p.getYears());
		System.out.println("duree : "+d.getSeconds());
		System.out.println("ecart en jour : "+ChronoUnit.DAYS.between(ldt, ldt1));
	}

	public void ajustementTemp() {
		LocalDate ldt = LocalDate.of(2018, Month.DECEMBER, 25);
		System.out.println("date reference : "+ldt);
		
		//on recupere le prochain samedi
		LocalDate ldt1 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("le prochain samedi : "+ldt1);
		
		//on recupere le troisieme mardi du mois suivant (on le fait en trois etapes)
		ldt = ldt.plusMonths(1);//on rentre dans le mois suivant
		LocalDate ldt2 = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);//on recupere le premier du mois
		//on peut le faire de cette maniere aussi LocalDate ldt2 = ldt.withDay(1);
		//on recupere le premier mardi et on l'avance de 3 mardi
		LocalDate troisMardi;
		if(ldt2.getDayOfWeek() != DayOfWeek.TUESDAY) {
			troisMardi = ldt2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
					.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
					.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		} else {
			troisMardi = ldt2.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))
					.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		}
		System.out.println("le troisieme mardi du mois suivant : "+troisMardi);
	}

	public void toutLesFuseau() {
		Map<String, String> maps = ZoneId.SHORT_IDS;
		maps.values().stream().forEach(x -> {System.out.println(x+" -- "+ZoneId.of(x).getRules());});
		
		//avoir notre fuseau
		System.out.println("\nFuseau horraire courant : "+ZoneId.systemDefault());
		System.out.println("regle applique au heure : "+ZoneId.systemDefault().getRules());
	}

	public void tempDeFuseau() {
		LocalDateTime ldt = LocalDateTime.parse("2018-01-01T01:33:00");
		List<ZoneId> lzi = Arrays.asList(ZoneId.of("Europe/Paris"), ZoneId.of("Asia/Tokyo"),ZoneId.of("America/Anchorage"));
		
		lzi.stream().forEach(x -> System.out.println(x+" : \t"+ldt.atZone(x).toInstant()));
	}
}
