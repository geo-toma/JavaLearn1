package reflexivite;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Objet_class {
	
	public void testWithStringClass() {
		//Class c = String.class; une maniere d'obtenir l'objet class 
		Class c = (new String()).getClass(); // une deuxieme maniere
		System.out.println("la supperclasse de la classe "+c.getName()+" est : "+c.getSuperclass()+"\n");

		Class[] classes = c.getInterfaces();
		System.out.println("il y a "+classes.length+" interface implemente par la classe "+c.getName());
		for(int i = 0; i < classes.length; i++) System.out.println(classes[i]);System.out.println();
		
		Method[] methods = c.getMethods();
		System.out.println("il y a "+methods.length+" methodes dans cette classe");
		Class[] param = methods[5].getParameterTypes();
		System.out.println("la SIXIEME methode ("+methods[5].getName()+") contient "+param.length+" parametre");
		for (int i = 0; i < param.length; i++) System.out.println(param[i].getName());System.out.println();
		
		Field[] fields = c.getDeclaredFields();
		System.out.println("il y a "+fields.length+" champ dans la classe "+c.getName());
		for (int i = 0; i < fields.length; i++) System.out.println(fields[i].getName()); System.out.println();
		
		Constructor[] con = c.getConstructors();
		System.out.println("il y a "+con.length+" constructeur dans la classe "+c.getName());
		Class[] parm = con[1].getParameterTypes();
		System.out.println("le deuxieme constructeur ("+con[1].getName()+") contient "+parm.length+" parametre");
		for (int i = 0; i < parm.length; i++) System.out.println(parm[i].getName());
	}

	public void testWithPaireClass() {
		String nom = Paire.class.getName();
		try {
			Class c = Class.forName(nom);//creation d'un objet class
			
			Object o = c.newInstance();//nouvelle instance de la classe paire
			
			Class[] param = new Class[] {String.class, String.class};//creation des parametres du constructeur parametree
			Constructor ct = c.getConstructor(param);//recuperation du constructeur avec les deux parametres
			Object o1 = ct.newInstance(new String[] {"valeur 1", "valeur 2"});
			
			Method m = c.getMethod("toString", null);//recupere la methode toString et null car elle ne contient aucun parametre
			
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("la methode "+m.getName()+" appliquer sur l'objet o : "+m.invoke(o, null));
			System.out.println("la methode "+m.getName()+" appliquer sur l'objet o1 : "+m.invoke(o1, null));
			// invoke execute la methode m appeler par l'objet passer en parametre
			//pas de parametre de la methode m donc le deuxieme parametre vaut null
		} catch (SecurityException e) {
		    e.printStackTrace();
		  } catch (IllegalArgumentException e) {
		    e.printStackTrace();
		  } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		  } catch (InstantiationException e) {
		    e.printStackTrace();
		  } catch (IllegalAccessException e) {
		    e.printStackTrace();
		  } catch (NoSuchMethodException e) {
		    e.printStackTrace();
		  } catch (InvocationTargetException e) {
		    e.printStackTrace();
		  }
	}
}
