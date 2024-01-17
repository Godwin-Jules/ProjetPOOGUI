package tg.univlome.epl.entity;

public class Client {

	private static long id_increment;
	private long id;
	private String nom;
	private String prenom;
	private int nbFacture;

	public Client() {
		id_increment += 1;
		this.nbFacture = 0;
		this.id = id_increment;
	}

	public Client(String nom, String prenom) {
		id_increment += 1;
		this.id = id_increment;
		this.nom = nom;
		this.prenom = prenom;
		this.nbFacture = 0;
	}

	public static long getId_increment() {
		return id_increment;
	}

	public static void setId_increment(long id_increment) {
		Client.id_increment = id_increment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNbFacture() {
		return nbFacture;
	}

	public void setNbFacture(int nbFacture) {
		this.nbFacture = nbFacture;
	}

	@Override
	public String toString() {
		return "Client {\n\tid : " + id + ",\n\tnom : " + nom + ",\n\tprenom : " + prenom + "\n\tnb  facture : " + nbFacture + "}";
	}

	public String afficher() {
		return "| " + id + " | " + nom + " | " + prenom + " | " + nbFacture;
	}
}
