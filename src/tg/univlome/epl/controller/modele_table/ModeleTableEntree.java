package tg.univlome.epl.controller.modele_table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tg.univlome.epl.entity.Article;

public class ModeleTableEntree extends AbstractTableModel {

	private static final long serialVersionUID = 7557423182749043027L;

	private List<Article> entrees = new ArrayList<Article>();

	private final String[] entete = { "ID", "Libellé", "Prix Unitaire", "Remise" };

	public ModeleTableEntree() {
		super();

		entrees.add(new Article("Saumon Fumé Maison"));
		entrees.add(new Article("Tartare d'Avocat et Crevettes"));
		entrees.add(new Article("Carpacion de Boeuf au Herbes"));
		entrees.add(new Article("Velouté de Champignons Sauvages"));
		entrees.add(new Article("Salade César Classique"));
		entrees.add(new Article("Salade simple", 8.5, 0.32));
		entrees.add(new Article("Salade de fruit", 9.0, 0.3));
		entrees.add(new Article("Salade de chèvre chaud aux noix", 10.50));
		entrees.add(new Article("Saumon Gravlax à l'aneth", 12.5));
		entrees.add(new Article("Soupe de potiron et crème fraîche", 8.00));
		entrees.add(new Article("Spaghetti Carbonara", 14.0));
		entrees.add(new Article("Tagliatelles aux fruits de mer", 17.5));
		entrees.add(new Article("Risotto aux asperges", 15.5));
		entrees.add(new Article("Risotto aux Truffes"));
		entrees.add(new Article("Risotto aux Champignons Porcini", 9.4));
		entrees.add(new Article("Risotto aux Champignons sauvages"));
		entrees.add(new Article("Tiramisu à la framboise", 9.0));
		entrees.add(new Article("Fondant au chocolat avec vanille", 10.5));
		entrees.add(new Article("Fondant au Chocolat Grand Cru", 10.5));
		entrees.add(new Article("Crème brûlée à la vanille", 8.5));
		entrees.add(new Article("Profiteroles au Chocolat Chaud", 12));
		entrees.add(new Article("Sorbet Citron Basilic", 9.5));
		entrees.add(new Article("Crème Brûlée à la Vanille Bourbon", 5));
		entrees.add(new Article("Tiramisu aux Framboises", 8.1));
	}

	@Override
	public int getRowCount() {
		return entrees.size();
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
			return entrees.get(rowIndex).getId();
		case 1:
			return entrees.get(rowIndex).getLibelle();
		case 2:
			return entrees.get(rowIndex).getPrixUnitaire();
		case 3:
			return entrees.get(rowIndex).getRemise();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Article entree = new Article();
		entree = entrees.get(rowIndex);

		switch (columnIndex) {
		case 1:
			entree.setLibelle((String) value);
			entrees.set(rowIndex, entree);
			fireTableRowsUpdated(rowIndex, rowIndex);
			break;
		case 2:	
			entree.setPrixUnitaire((float) value);
			entrees.set(columnIndex, entree);
			fireTableRowsUpdated(rowIndex, rowIndex);
			break;
		case 3:
			entree.setRemise((float) value);
			entrees.set(columnIndex, entree);
			fireTableRowsUpdated(rowIndex, rowIndex);
			break;
		default:
			break;
		}
	}

	public void addEntree(Article entree) {
		entrees.add(entree);

		fireTableRowsInserted(entrees.size() - 1, entrees.size() - 1);
	}

	public void removeEntree(int rowIndex) {
		entrees.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public boolean verifEntree(String libelle) {
		for (Article entree : entrees) {
			if (entree.getLibelle().toUpperCase().equals(libelle.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
}
