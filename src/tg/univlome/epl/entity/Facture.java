package tg.univlome.epl.entity;

import java.time.LocalDateTime;

public class Facture {

	private static long id_increment;
	
	private long id;
	private LocalDateTime dateTime;
	private Commande commande;
	private Client client;
	
	public Facture() {
		id_increment += 1;
		this.id = id_increment;
		this.dateTime = LocalDateTime.now();
	}
	
	public Facture(Commande commande) {
		id_increment += 1;
		this.id = id_increment;
		this.dateTime = LocalDateTime.now();
		this.commande = commande;
	}
	
	public Facture(Commande commande, Client client) {
		id_increment += 1;
		this.id = id_increment;
		this.dateTime = LocalDateTime.now();
		this.commande = commande;
		this.client = client;
	}
	
	public static long getId_increment() {
		return id_increment;
	}

	public static void setId_increment(long id_increment) {
		Facture.id_increment = id_increment;
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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Facture {\n\tid : " + id + ",\n\tdate : " + String.format("%tF", dateTime) + "\n\theure : " + String.format("%tT", dateTime) + ",\n\t" + commande.afficher() + ",\n\tclient : " + client + "}";
	}

	
	public void afficher() {
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("|                                                                            |");
		System.out.println("|                                                                            |");
		System.out.printf("|  Ets Res_Torrent\t\t\t\t\t\tFacture N°%d  |\n", id);
		System.out.println("|                                                                            |");
		System.out.printf("|    Client N° %d\t\t\t\t\t\t\t     |\n", client.getId());
		System.out.printf("|    Nom    :  %-30s \t\t\t\t     |\n", client.getNom());
		System.out.printf("|    Prenom :  %-30s \t\t\t\t     |\n", client.getPrenom());
		System.out.println("|                                                                            |");
		System.out.println("|                                                                            |");
		System.out.printf("|\tDate : %tF\t\t\t\tHeure : %tT     |\n", dateTime, dateTime);
		System.out.println("|                                                                            |");
		commande.afficherCommande();
		System.out.println("|                                                                            |");
		System.out.println("|                                                                            |");
		System.out.printf("|  \tTotal sans remise       :    $%,-10.2f\t\t\t     |\n", commande.calculPrixTotal());
		System.out.printf("|  \tTotal des remises       :    $%,-10.2f\t\t\t     |\n", commande.calculRemiseTotale());
		System.out.printf("|  \tTotal à payer           :    $%,-10.2f\t\t\t     |\n", commande.calculPrixAPayer());
		System.out.println("|                                                                            |");
		System.out.println("|                                                                            |");
		System.out.println("|   \t\t\t\tSignatures\t\t\t\t     |");
		System.out.println("|      Client\t\t\t\t\t\t\t Gérant\t     |");
		System.out.println("|      ......\t\t\t\t\t\t\t ......\t     |");
		System.out.println("|                                                                            |");
		System.out.printf("|      %c. %-20s\t\t\t\t\t Gérant      |\n", client.getPrenom().charAt(0), client.getNom());
		System.out.println("|                                                                            |");
		System.out.println("|                                                                            |");
		System.out.println("+----------------------------------------------------------------------------+\n");
	}
}
