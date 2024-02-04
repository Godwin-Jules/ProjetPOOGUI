package tg.univlome.epl.controller.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import tg.univlome.epl.controller.modele_table.ModeleTableEntree;
import tg.univlome.epl.entity.Article;
import tg.univlome.epl.view.Utils;

public class PanelEntree extends JPanel {

	private static final long serialVersionUID = -879781822833881482L;
	public static final Utils utils = new Utils();
	private static ModeleTableEntree modele = new ModeleTableEntree();
	private JTable tableau;

	public PanelEntree() {
		super();

		this.setLayout(new BorderLayout());
		tableau = new JTable(modele);
		this.add(new JScrollPane(tableau), BorderLayout.CENTER);

		JButton btnAdd = utils.createBtn("Ajouter",120, 40, "Candara", 20);
		btnAdd.addActionListener(new AddEntree());

		JButton btnModify = utils.createBtn("Modifier", 120, 40, "Candara", 20);
		btnModify.addActionListener(new ModifyEntree());

		JButton btnRemove = utils.createBtn("Supprimer", 120, 40, "Candara", 20);
		btnRemove.addActionListener(new RemoveEntree());

		JPanel boutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		boutons.add(btnAdd);
		boutons.add(btnModify);
		boutons.add(btnRemove);
		this.add(boutons, BorderLayout.SOUTH);
	}

	/*------------------ La méthode qui permet d'ajouter un nouveau entree dans la base ------------------*/

	private class AddEntree extends AbstractAction {

		private static final long serialVersionUID = -7324538130885814737L;

		private AddEntree() {
		}

		public boolean insertEntree(JFrame frame_parent, String libelle, double prixUnitaire, double remise)
				throws Exception {
			if (libelle.equals("")) {
				JOptionPane.showMessageDialog(frame_parent, "Information(s) incorrecte(s)", "Information",
						JOptionPane.CLOSED_OPTION);
				return false;
			} else if (modele.verifEntree(libelle)) {
				JOptionPane.showMessageDialog(frame_parent, "Cette entrée existe déjà dans la base !", "Information",
						JOptionPane.CLOSED_OPTION);
				return false;
			} else {
				String libelleU = libelle.toUpperCase();
				String libelleL = libelle.toLowerCase();
				libelle = libelleU.charAt(0) + libelleL.substring(1);
				try {
					if (prixUnitaire < 0) {
						prixUnitaire = 0;
					} else {
						prixUnitaire = (float) prixUnitaire;
					}

					if (remise < 0) {
						remise = 0;
					} else {
						remise = (float) remise;
					}

					modele.addEntree(new Article(libelle, prixUnitaire, remise));
					JOptionPane.showMessageDialog(frame_parent, "Enregistrement d'une nouvelle entrée avec succès !",
							"Enregistrement réussi", JOptionPane.CLOSED_OPTION);
					return true;
				} catch (Exception e) {
					System.err.print(e.getMessage());
					;
					throw new Exception("Valeurs incorrectes");
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			JFrame addEntree = new JFrame();
			JPanel contentPane = new JPanel();
			addEntree.getContentPane().add(contentPane);
			addEntree.setTitle("Enregistrement d'une nouvelle entreé");
			addEntree.setPreferredSize(new Dimension(500, 450));
			addEntree.setResizable(false);
			addEntree.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JPanel ajoutEntree = new JPanel(new GridLayout(8, 1));

			JLabel labEntreeTitle = utils.createLab("NOUVELLE ENTREE  -  ENREGRISTREMENT", 20);
			JLabel labEntreeLibelle = utils.createLab("Nom de la nouvelle entrée", 16);
			JLabel labEntreePrixUnitaire = utils.createLab("Prix unitaire de l'entrée", 16);
			JLabel labEntreeRemise = utils.createLab("Remise de la nouvelle entrée", 16);
			JLabel labEntreeVerifLibelle = utils.createLab("");
			JLabel labEntreeVerifPrixUnitaire = utils.createLab("");
			JLabel labEntreeVerifRemise = utils.createLab("");

			JTextField txtEntreeLibelle = new JTextField("");
			JTextField txtEntreePrixUnitaire = new JTextField("");
			JTextField txtEntreeRemise = new JTextField("");

			JButton btnEntreeSave = utils.createBtn("Enregistrer", 120, 35, "Candara", 18);
			JButton btnEntreeCancel = utils.createBtn("Annuler", 120, 35, "Candara", 18);

			JPanel panelTitle = new JPanel();
			panelTitle.add(labEntreeTitle);

			JPanel panelEntreeLibelle = new JPanel(new GridLayout(1, 2));
			panelEntreeLibelle.add(labEntreeLibelle);
			panelEntreeLibelle.add(txtEntreeLibelle);

			JPanel panelEntreePrixUnitaire = new JPanel(new GridLayout(1, 2));
			panelEntreePrixUnitaire.add(labEntreePrixUnitaire);
			panelEntreePrixUnitaire.add(txtEntreePrixUnitaire);

			JPanel panelEntreeRemise = new JPanel(new GridLayout(1, 2));
			panelEntreeRemise.add(labEntreeRemise);
			panelEntreeRemise.add(txtEntreeRemise);

			JPanel panelEntreeSave = new JPanel();
			panelEntreeSave.add(btnEntreeCancel);
			panelEntreeSave.add(btnEntreeSave);

			ajoutEntree.add(panelTitle);
			ajoutEntree.add(panelEntreeLibelle);
			ajoutEntree.add(labEntreeVerifLibelle);
			ajoutEntree.add(panelEntreePrixUnitaire);
			ajoutEntree.add(labEntreeVerifPrixUnitaire);
			ajoutEntree.add(panelEntreeRemise);
			ajoutEntree.add(labEntreeVerifRemise);
			ajoutEntree.add(panelEntreeSave);
			contentPane.add(ajoutEntree);

			addEntree.pack();
			addEntree.setLocationRelativeTo(null);
			addEntree.setVisible(true);

			btnEntreeSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String libelle = txtEntreeLibelle.getText();
					String prixUnitaireS = txtEntreePrixUnitaire.getText();
					String remsieS = txtEntreeRemise.getText();
					try {
						double prixUnitaire = Double.parseDouble(prixUnitaireS);
						double remise = Double.parseDouble(remsieS);
						boolean createEntree = insertEntree(addEntree, libelle, prixUnitaire, remise);
						if (createEntree == true) {
							addEntree.dispose();
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(addEntree, e1.getMessage(), "Information",
								JOptionPane.CLOSED_OPTION);
						System.err.print(e1.getMessage());
					}
				}
			});

			btnEntreeCancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					addEntree.dispose();
				}
			});
		}
	}

	/*------------------ La méthode qui permet de modifier un entree dans la base ------------------*/

	private class ModifyEntree extends AbstractAction {

		private static final long serialVersionUID = -2418337127320485433L;

		private ModifyEntree() {

		}

		public boolean modifyEntree(JFrame frame_parent, int selected, String libelle, double prixUnitaire, double remise) {

			if (libelle.toUpperCase().equals(((String) modele.getValueAt(selected, 1)).toUpperCase())
					&& (float) modele.getValueAt(selected, 2) == prixUnitaire
					&& (float) modele.getValueAt(selected, 3) == remise) {
				JOptionPane.showMessageDialog(frame_parent, "Aucune modification apportée", "Information",
						JOptionPane.CLOSED_OPTION);
				return false;
			} else if (libelle.equals("")) {
				JOptionPane.showMessageDialog(frame_parent, "Libellé vide", "Information",
						JOptionPane.CLOSED_OPTION);
				return false;
			} else if (modele.getValueAt(selected, 1).equals(libelle)
					|| (float) modele.getValueAt(selected, 2) != prixUnitaire
					&& (float) modele.getValueAt(selected, 3) != remise){
				int option = JOptionPane.showConfirmDialog(frame_parent, "Vous voulez vraiment modifier cette entrée ?",
						"Demande de confirmation", JOptionPane.YES_NO_OPTION);

				if (option == JOptionPane.YES_OPTION) {
					String libelleU = libelle.toUpperCase();
					String libelleL = libelle.toLowerCase();
					libelle = libelleU.charAt(0) + libelleL.substring(1);

					modele.setValueAt(libelle.toUpperCase(), selected, 1);
					modele.setValueAt(libelle, selected, 2);
					JOptionPane.showMessageDialog(frame_parent, "Modification effectuée avec succès", "Information",
							JOptionPane.CANCEL_OPTION);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();

			if (selection.length == 0) {
				JOptionPane.showMessageDialog(null, "Aucun élément sélectionné", "Information",
						JOptionPane.CANCEL_OPTION);
			} else if (selection.length == 1) {

				JFrame modifyEntree = new JFrame();
				JPanel contentPane = new JPanel();
				modifyEntree.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				modifyEntree.setTitle("Modification d'un entree");
				modifyEntree.setPreferredSize(new Dimension(450, 450));
				modifyEntree.setResizable(false);
				modifyEntree.getContentPane().add(contentPane);

				JPanel modifierEntree = new JPanel(new GridLayout(8, 1));
				JLabel labEntreeTitle = utils.createLab("NOUVELLE ENTREE  -  ENREGRISTREMENT", 20);
				JLabel labEntreeLibelle = utils.createLab("Nom de l'entrée", 16);
				JLabel labEntreePrixUnitaire = utils.createLab("Prix unitaire de l'entree   ", 16);
				JLabel labEntreeRemise = utils.createLab("Remise de l'entrée   ", 16);
				JLabel labEntreeVerifLibelle = utils.createLab("");
				JLabel labEntreeVerifPrixUnitaire = utils.createLab("");
				JLabel labEntreeVerifRemise = utils.createLab("");

				JTextField txtEntreeLibelle = new JTextField(modele.getValueAt(selection[0], 1).toString(), JLabel.RIGHT);
				JTextField txtEntreePrixUnitaire = new JTextField(modele.getValueAt(selection[0], 2).toString(),JLabel.RIGHT);
				JTextField txtEntreeRemise = new JTextField((String) modele.getValueAt(selection[0], 3).toString(), JLabel.RIGHT);

				JButton btnEntreeSave = utils.createBtn("Enregistrer", 120, 35, "Candara", 18);
				JButton btnEntreeCancel = utils.createBtn("Annuler", 120, 35, "Candara", 18);

				JPanel panelTitle = new JPanel();
				panelTitle.add(labEntreeTitle);
				
				JPanel panelEntreeLibelle = new JPanel(new GridLayout(1, 2));
				panelEntreeLibelle.add(labEntreeLibelle);
				panelEntreeLibelle.add(txtEntreeLibelle);
				
				JPanel panelEntreePrixUnitaire = new JPanel(new GridLayout(1, 2));
				panelEntreePrixUnitaire.add(labEntreePrixUnitaire);
				panelEntreePrixUnitaire.add(txtEntreePrixUnitaire);
				
				JPanel panelEntreeRemise = new JPanel(new GridLayout(1, 2));
				panelEntreeRemise.add(labEntreeRemise);
				panelEntreeRemise.add(txtEntreeRemise);
				
				JPanel panelEntreeSave = new JPanel();
				panelEntreeSave.add(btnEntreeCancel);
				panelEntreeSave.add(btnEntreeSave);

				modifierEntree.add(panelTitle);
				modifierEntree.add(panelEntreeLibelle);
				modifierEntree.add(labEntreeVerifLibelle);
				modifierEntree.add(panelEntreePrixUnitaire);
				modifierEntree.add(labEntreeVerifPrixUnitaire);
				modifierEntree.add(panelEntreeRemise);
				modifierEntree.add(labEntreeVerifRemise);
				modifierEntree.add(panelEntreeSave);

				contentPane.add(modifierEntree);
				modifyEntree.pack();
				modifyEntree.setLocationRelativeTo(null);
				modifyEntree.setVisible(true);

				btnEntreeCancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						modifyEntree.dispose();

					}
				});

				btnEntreeSave.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String libelle = txtEntreeLibelle.getText();
						String prixUnitaireS = txtEntreePrixUnitaire.getText();
						String remiseS = txtEntreeRemise.getText();
						try {
							double prixUnitaire = Double.parseDouble(prixUnitaireS);
							double remise = Double.parseDouble(remiseS);
							boolean result = modifyEntree(modifyEntree, selection[0], libelle, prixUnitaire, remise);
							if (result) {
								modifyEntree.dispose();
							}
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(modifierEntree, e1.getMessage(), "Information",
									JOptionPane.CLOSED_OPTION);
							System.err.print(e1.getMessage());
						}
					}
				});

			} else {
				JOptionPane.showMessageDialog(null, "Un seul élément ne peut être modifié à la fois", "Information",
						JOptionPane.CANCEL_OPTION);
			}

		}

	}

	/*------------------ La méthode qui permet de supprimer un entree dans la base ------------------*/

	private class RemoveEntree extends AbstractAction {

		private static final long serialVersionUID = 5166784993147077316L;

		private RemoveEntree() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();

			if (selection.length == 0) {
				JOptionPane.showMessageDialog(null, "Aucune entrée sélectionnée", "Information",
						JOptionPane.CANCEL_OPTION);

			} else {
				int option = JOptionPane.showConfirmDialog(null,
						"Vous voulez vraiment supprimer ".concat(String.format("%d entrée(s) ?", selection.length)),
						"Confirmation de suppression", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					for (int i = selection.length - 1; i >= 0; i--) {
						modele.removeEntree(selection[i]);
					}
					JOptionPane.showConfirmDialog(null,
							String.format("%d élément(s) supprimé(s) avec succès !", selection.length),
							"Suppression réussie", JOptionPane.CLOSED_OPTION);
				}
			}
		}
	}
}
