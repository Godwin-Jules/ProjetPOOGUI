package tg.univlome.epl.controller.modele_table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tg.univlome.epl.entity.Client;

public class ModeleTableClient extends AbstractTableModel {

	private static final long serialVersionUID = 7557423182749043027L;

	private List<Client> clients = new ArrayList<Client>();

	private final String[] entete = { "ID", "Nom", "Prenoms", "Nbre payement" };

	public ModeleTableClient() {
		super();

		clients.add(new Client("TCHIGBE", "Ezéchiel"));
		clients.add(new Client("ZEGBLA", "Kossi Kaleb"));
		clients.add(new Client("MILEGNE", "Dieu donné"));
		clients.add(new Client("SOKEL", "Roland"));
		clients.add(new Client("AWOMAKOU", "Vivien"));
		clients.add(new Client("ALOWANOU", "Léonce Yvann"));
		clients.add(new Client("AGBAN", "Ezéchiel"));
		clients.add(new Client("TELOU", "Oded"));
		clients.add(new Client("PALI", "Majoie"));
		clients.add(new Client("ADONSOU", "Diane"));
		clients.add(new Client("AYITEH", "Josué"));
		clients.add(new Client("NOYOULIWA", "Victoire"));
		clients.add(new Client("AMOUSSOU", "Holla Josué"));
		clients.add(new Client("DWEGGAH", "Ariel"));
		clients.add(new Client("SOSSOU", "Olivier"));
		clients.add(new Client("AHAMA", "Jonathan"));
		clients.add(new Client("EKLOU", "Kossi Dodji"));
		clients.add(new Client("LAWSON-BODY", "Latevi Josué"));
		clients.add(new Client("BASSOWOU", "Kokou Edouard"));
		clients.add(new Client("ATUAKUMA", "Kossi Nami"));
		clients.add(new Client("DJIBOM", "Mardia"));
		clients.add(new Client("WILSON-BAHUN", "Adjé Sitou Jean-Cyrille"));
		clients.add(new Client("AMAVIGAN", "Ayi Mawuli Hénoc"));
		clients.add(new Client("KAMDE", "Aklesso Steeve"));
		clients.add(new Client("EDOH", "Yao Gildas"));
		clients.add(new Client("AGBAVO", "Koffi K. Félix"));
		clients.add(new Client("GOSSOU", "Yao Sylvain"));
		clients.add(new Client("ZODJIHOUE", "Abla Thibaute"));
		clients.add(new Client("TOFA", "Emmanuel Evamé"));
		clients.add(new Client("MADJANTA", "Yoyo Ariel Diréma"));
		clients.add(new Client("AZIAMADJI", "Koami Mawuli Crépin"));
		clients.add(new Client("YIGBE", "Israel"));
		clients.add(new Client("AMEDOME", "Sunday"));
		clients.add(new Client("AGBEGNINOU", "Léna"));
		clients.add(new Client("ETSE", "Kossivi Paul"));
		clients.add(new Client("ALI", "Rahim"));
		clients.add(new Client("KLIKO", "Geoffrey"));
		clients.add(new Client("AMAÏZO", "Teddy"));
		clients.add(new Client("HOETOWOU", "Yaovi"));
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return clients.get(rowIndex).getId();
		case 1:
			return clients.get(rowIndex).getNom();
		case 2:
			return clients.get(rowIndex).getPrenom();
		case 3:
			return clients.get(rowIndex).getNbFacture();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Client client = new Client();
		client = clients.get(rowIndex);
		
		switch (columnIndex) {
		case 1:
			client.setNom((String) value);
			clients.set(rowIndex, client);
			fireTableRowsUpdated(rowIndex, rowIndex);
			break;
		case 2:
			client.setPrenom((String) value);
			clients.set(columnIndex, client);
			fireTableRowsUpdated(rowIndex, rowIndex);
			break;
		default:
			break;
		}
	}

	public void addClient(Client client) {
		clients.add(client);

		fireTableRowsInserted(clients.size() - 1, clients.size() - 1);
	}

	public void removeClient(int rowIndex) {
		clients.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public boolean verifClient(String nom, String prenom) {
		for (Client client : clients) {
			if (client.getNom().toUpperCase().equals(nom.toUpperCase())
					&& client.getPrenom().toUpperCase().equals(prenom.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
}
