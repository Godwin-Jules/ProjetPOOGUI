package tg.univlome.epl.entity;

public class Article {

	private static long id_increment = 0;
	
	private long id;
	private String libelle;
	private float prixUnitaire;
	private float remise;
	private int qt;
	
	public Article() {
		id_increment += 1;
		this.id = id_increment;
	}
	
	public Article(String libelle, double prixUnitaire, double remise) {
		id_increment += 1;
		this.id = id_increment;
		this.libelle = libelle;
		this.prixUnitaire = (float) prixUnitaire;
		this.remise = (float) remise;
	}
	
	public Article(Article article) { 
		id_increment += 1;
		this.id = id_increment;
		this.libelle = article.getLibelle();
		this.prixUnitaire = article.getPrixUnitaire();
		this.remise = article.getRemise();
	}

	public static long getId_increment() {
		return id_increment;
	}

	public long getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = (float) prixUnitaire;
	}

	public float getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = (float) remise;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	@Override
	public String toString() {
		return "Article {\n\tid : " + id + ", \n\tlibelle : " + libelle + ", \n\tPrix unitaire : " + prixUnitaire + ", \n\tremise : " + remise
				+ "\n}";
	}
	
	public String afficher() {
		return "| " + id + " | " + libelle + " | " + prixUnitaire + " | " + remise;
	}
}
