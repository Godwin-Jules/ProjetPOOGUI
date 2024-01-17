package tg.univlome.epl.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Commande {

	private static long id_increment = 0;

	private long id;
	private LocalDateTime dateTime;
	private List<Article> articles = new ArrayList<>();

	public Commande() {
		id_increment += 1;
		this.id = id_increment;
		this.dateTime = LocalDateTime.now();
	}

	public static long getId_increment() {
		return id_increment;
	}

	public static void setId_increment(long id_increment) {
		Commande.id_increment = id_increment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String afficher() {
		String afficheCommande = String.format("Commande {\n\tid : %d,\n\tdate : %tF,\n\theure : %tT\n\tArticles : {\n", id, dateTime, dateTime);
		for (Article article : articles) {
			afficheCommande += String.format("\t\t" + article.toString() + "\n");
		}
		afficheCommande += "\t}\n}";
		
		return afficheCommande;
	}

	@Override
	public String toString() {
		return "| " + id + " | " + dateTime + " | " + articles;
	}

	public boolean ajouterArticles(Article article, int qt) {
		int i = 0;
		for (Article a : articles) {
			if (a.getLibelle().equals(article.getLibelle())) {
				article.setQt(a.getQt() + qt);
				articles.set(i, article);
				return true;
			}
			i++;
		}
		article.setQt(qt);
		articles.add(article);
		return true;
	}
	
	public void afficherArticles() {
		for (Article article : articles) {
			System.out.printf("|  | %2d | %-22s | %,6d | $%,-4.2f | $%,-4.2f  | $%,-11.2f |  |\n"
					, article.getId()
					, article.getLibelle()
					, article.getQt()
					, article.getPrixUnitaire()
					, article.getRemise()
					, (article.getPrixUnitaire() - article.getRemise()) * article.getQt());		
		}
	}

	public void afficherCommande() {
		System.out.println("|  +----+------------------------+--------+-------+--------+--------------+  |");
		System.out.printf("|  | id | %-22s |   Qt   | P.U.  | Remise |     P.T.     |  |\n", "Articles");
		System.out.println("|  +----+------------------------+--------+-------+--------+--------------+  |");
		afficherArticles();
		System.out.println("|  +----+------------------------+--------+-------+--------+--------------+  |");
	}
	
	public float calculPrixTotal() {
		float prixTotal = 0;
		for (Article article : articles) {
			 prixTotal += article.getPrixUnitaire() * article.getQt();
		}
		return prixTotal;
	}
	
	public float calculRemiseTotale() {
		float remiseTotale = 0;
		for (Article article : articles) {
			remiseTotale += article.getRemise() * article.getQt();
		}
		return remiseTotale;
	}
	
	public float calculPrixAPayer() {
		float prixAPayer = 0;
		prixAPayer += calculPrixTotal() - calculRemiseTotale();
		return prixAPayer;
	}
}
