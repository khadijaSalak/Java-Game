package gestionFile;
import java.io.* ; // pour les classes flux
import java.util.ArrayList;
import java.util.Scanner;
public class Test { 
	

	public static void main (String args[]) throws IOException { 
		
		
		PrintWriter sortie0 = new PrintWriter (new FileWriter ("users")) ; 
		PrintWriter score=new PrintWriter(new FileWriter("score"));
		ArrayList<String> phrase1=new ArrayList<>();
		  phrase1.add("pourquoi demain ce n'est pas hier");
		  phrase1.add("on apprend d'abord � ecouter avant de parler ");
		  phrase1.add("apprendre � parler le fran�ais");
		  phrase1.add("ne me donne pas un poisson apprend moi � pecher");
		  phrase1.add("le future c'est vous qui le cr�e");
		  phrase1.add("la lecture est utile, pour nourir vos esprits");
		  phrase1.add("le sport est bon pour la sant�");
		  phrase1.add("r�fl�chir avant de parler, pour �viter le regret");
		  phrase1.add("il faut etre confident");
		  phrase1.add("l'anglais est la laugue mondiale");
		PrintWriter sortie = new PrintWriter (new FileWriter ("Niveau1.txt")) ; 
		for(int i=0;i<phrase1.size();i++) {
			sortie.println(phrase1.get(i));
		}
		sortie.close () ; System.out.println ("*** fin creation ");
		ArrayList<String> phrase2=new ArrayList<>();
		  phrase2.add("java est un language de programmation ");
		  phrase2.add("ton p�re est le seul qui veut te voir plus meilleur que lui");
		  phrase2.add("il faut travailer pour gagner");
		  phrase2.add("ne juger pas les autres, vous n'etes pas impeccable");
		  phrase2.add("demain c'est plus beau, disaient les optimistes");
		  phrase2.add("on doit proteger la nature, pour qu'elle nous prot�ge");
		  phrase2.add("dit non au racisme, nous somme tous humains");
		  phrase2.add("vous etes ce que vous pensez");
		  phrase2.add("l'enfer c'est l'autre a dit Sartre");
		  phrase2.add("le succ�e n'est pas un talent");
		  phrase2.add("rever ce n'est pas suffisant");
		PrintWriter sortie1 = new PrintWriter (new FileWriter ("Niveau2.txt")) ; 
		for(int i=0;i<phrase2.size();i++) {
			sortie1.println(phrase2.get(i));
			
		}
		sortie1.close () ; 
		ArrayList<String> phrase3=new ArrayList<>();
		phrase2.add("les chose terribles et sanglantes sont parfois les plus belles");
		 phrase3.add("nous sommes ce nous pensons");
		 phrase3.add("si deux personnes s'aiment il ne peut y avoir de fin heureuse");
		  phrase3.add("with great power comes great responsability");
		  phrase3.add("celui qui a reni� sa patrie, celui-l� a reni� son Dieu");
		  phrase3.add("il faut pas juger les autre sont les avoir connaitre");
		  phrase3.add("votre exp�rience ne s'applique pas sur les autres");
		  phrase3.add("il faut etre beau dans sa mentalit� avant son apparence");
		  phrase3.add("fait ce que vous devez faire et ignorer le reste");
		  phrase3.add("la perte d'un combat ne vaut pas dire la perte de la guerre");
		  phrase3.add("un ami fid�le est une carte gagnante");
		  phrase3.add("il ya pas de secret pour le bonheur");
		  phrase3.add("la vie nous retire des choses pour nous donner le meilleur ");
		  phrase3.add("le changement commence de l'int�rieur");
		PrintWriter sortie2 = new PrintWriter (new FileWriter ("Niveau3.txt")) ; 
		for(int i=0;i<phrase3.size();i++) {
			sortie2.println(phrase3.get(i));
		}
		sortie2.close () ; System.out.println ("*** fin creation ");
		

}}