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

import tg.univlome.epl.controller.modele_table.ModeleTableClient;
import tg.univlome.epl.entity.Client;
import tg.univlome.epl.view.Utils;

public class PanelClient extends JPanel {

	private static final long serialVersionUID = 2194271599629711537L;
	public static final Utils utils = new Utils();
	private static ModeleTableClient modele = new ModeleTableClient();
	private JTable tableau;

	public PanelClient() {
		super();

		this.setLayout(new BorderLayout());
		tableau = new JTable(modele);
		this.add(new JScrollPane(tableau), BorderLayout.CENTER);

		
		JButton btnAdd = utils.createBtn("Ajouter", 120, 40, "Candara", 20);
		btnAdd.addActionListener(new AddClient());
		
		JButton btnModify = utils.createBtn("Modifier", 120, 40, "Candara", 20);
		btnModify.addActionListener(new ModifyClient());
		
		JButton btnRemove = utils.createBtn("Supprimer", 120, 40, "Candara", 20);
		btnRemove.addActionListener(new RemoveClient());
		
		JPanel boutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		boutons.add(btnAdd);
		boutons.add(btnModify);
		boutons.add(btnRemove);
		this.add(boutons, BorderLayout.SOUTH);
	}

	/*------------------ La méthode qui permet d'ajouter un nouveau client dans la base ------------------*/

	private class AddClient extends AbstractAction {

		private static final long serialVersionUID = -7324538130885814737L;

		private AddClient() {
		}

		public boolean insertClient(JFrame frame_parent, String name, String prenoms) {
			if (name.equals("") || prenoms.equals("")) {
				JOptionPane.showMessageDialog(frame_parent, "Information(s) incorrecte(s)", "Information",
						JOptionPane.CLOSED_OPTION);
				return false;
			} else if (modele.verifClient(name, prenoms)) {
				JOptionPane.showMessageDialog(frame_parent, "Ce client existe déjà dans la base !", "Information",
						JOptionPane.CLOSED_OPTION);
				return false;
			} else {
				String prenomU = prenoms.toUpperCase();
				String prenomL = prenoms.toLowerCase();
				prenoms = prenomU.charAt(0) + prenomL.substring(1);
				modele.addClient(new Client(name.toUpperCase(), prenoms));
				JOptionPane.showMessageDialog(frame_parent, "Enregistrement d'un nouveau client avec succès !",
						"Enregistrement réussi", JOptionPane.CLOSED_OPTION);
				return true;
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			JFrame addClient = new JFrame();
			JPanel contentPane = new JPanel();
			addClient.getContentPane().add(contentPane);
			addClient.setTitle("Enregistrement d'un nouveau client");
			addClient.setPreferredSize(new Dimension(450, 350));
			addClient.setResizable(false);
			addClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JPanel ajoutClient = new JPanel(new GridLayout(6, 1));

			JLabel labClientTitle = utils.createLab("NOUVEAU CLIENT  -  ENREGRISTREMENT", 20);
			JLabel labClientName = utils.createLab("Nom du nouveau client", 16);
			JLabel labClientPrenoms = utils.createLab("Prénom(s) du nouveau client   ", 16);
			JLabel labClientVerifName = utils.createLab("");
			JLabel labClientVerifPrenoms = utils.createLab("");

			JTextField txtClientName = new JTextField("", JLabel.RIGHT);
			JTextField txtClientPrenoms = new JTextField("", JLabel.RIGHT);

			JButton btnClientSave = utils.createBtn("Enregistrer", 100, 35, "Candara", 16);
			JButton btnClientCancel = utils.createBtn("Annuler", 120, 35, "Candara", 18);

			JPanel panelTitle = new JPanel();
			panelTitle.add(labClientTitle);
			JPanel panelClientName = new JPanel(new GridLayout(1, 2));
			panelClientName.add(labClientName);
			panelClientName.add(txtClientName);
			JPanel panelClientPrenom = new JPanel(new GridLayout(1, 2));
			panelClientPrenom.add(labClientPrenoms);
			panelClientPrenom.add(txtClientPrenoms);
			JPanel panelClientSave = new JPanel();
			panelClientSave.add(btnClientCancel);
			panelClientSave.add(btnClientSave);

			ajoutClient.add(panelTitle);
			ajoutClient.add(panelClientName);
			ajoutClient.add(labClientVerifName);
			ajoutClient.add(panelClientPrenom);
			ajoutClient.add(labClientVerifPrenoms);
			ajoutClient.add(panelClientSave);
			contentPane.add(ajoutClient);

			addClient.pack();
			addClient.setLocationRelativeTo(null);
			addClient.setVisible(true);

			btnClientSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String name = txtClientName.getText();
					String prenoms = txtClientPrenoms.getText();
					boolean createClient = insertClient(addClient, name, prenoms);
					if (createClient == true) {
						addClient.dispose();
					}
				}
			});

			btnClientCancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					addClient.dispose();
				}
			});

		}
	}

	/*------------------ La méthode qui permet de modifier un client dans la base ------------------*/
	
	private class ModifyClient extends AbstractAction {

		private static final long serialVersionUID = -2418337127320485433L;

		private ModifyClient() {
			
		}

		public boolean modifyClient(JFrame frame_parent, int selected, String nom, String prenom) {

			if (nom.toUpperCase().equals(((String) modele.getValueAt(selected, 1)).toUpperCase())
					&& prenom.toUpperCase().equals(((String) modele.getValueAt(selected, 2)).toUpperCase())) {
				JOptionPane.showMessageDialog(frame_parent, "Aucune modification apportée", "Information",
						JOptionPane.CANCEL_OPTION);
				return false;
			} else if (nom.equals("") || prenom.equals("")) {
				JOptionPane.showMessageDialog(frame_parent, "Valeur incorrecte", "Information", JOptionPane.CANCEL_OPTION);
				return false;
			} else 	if (modele.verifClient(nom, prenom)) {
					JOptionPane.showMessageDialog(frame_parent, "Ce client existe déjà dans la base", "Information",
							JOptionPane.CANCEL_OPTION);
					return false;
			} else {
				int option = JOptionPane.showConfirmDialog(frame_parent, "Vous voulez vraiment modifier ce client ?",
						"Demande de confirmation", JOptionPane.YES_NO_OPTION);

				if (option == JOptionPane.YES_OPTION) {
					String prenomU = prenom.toUpperCase();
					String prenomL = prenom.toLowerCase();
					prenom = prenomU.charAt(0) + prenomL.substring(1);

					modele.setValueAt(nom.toUpperCase(), selected, 1);
					modele.setValueAt(prenom, selected, 2);
					JOptionPane.showMessageDialog(frame_parent, "Modification effectuée avec succès", "Information",
							JOptionPane.CANCEL_OPTION);
					return true;
				} else {
					return false;
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();

			if (selection.length == 0) {
				JOptionPane.showMessageDialog(null, "Aucun élément sélectionné", "Information",
						JOptionPane.CANCEL_OPTION);
			} else if (selection.length == 1) {

				JFrame modifyClient = new JFrame();
				JPanel contentPane = new JPanel();
				modifyClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				modifyClient.setTitle("Modification d'un client");
				modifyClient.setPreferredSize(new Dimension(450, 350));
				modifyClient.setResizable(false);
				modifyClient.getContentPane().add(contentPane);

				JPanel modifierClient = new JPanel(new GridLayout(6, 1));
				JLabel labClientTitle = utils.createLab("NOUVEAU CLIENT  -  ENREGRISTREMENT", 20);
				JLabel labClientName = utils.createLab("Nom du nouveau client", 16);
				JLabel labClientPrenoms = utils.createLab("Prénom(s) du nouveau client   ", 16);
				JLabel labClientVerifName = utils.createLab("");
				JLabel labClientVerifPrenoms = utils.createLab("");

				JTextField txtClientName = new JTextField((String) modele.getValueAt(selection[0], 1), JLabel.RIGHT);
//				txtClientName.setPreferredSize(new Dimension(150, 20));
				JTextField txtClientPrenoms = new JTextField((String) modele.getValueAt(selection[0], 2), JLabel.RIGHT);
//				txtClientPrenoms.setPreferredSize(new Dimension(150, 20));

				JButton btnClientSave = utils.createBtn("Enregistrer", 120, 35, "Candara", 18);
				JButton btnClientCancel = utils.createBtn("Annuler", 120, 35, "Candara", 18);

				JPanel panelTitle = new JPanel();
				panelTitle.add(labClientTitle);
				JPanel panelClientName = new JPanel(new GridLayout(1, 2));
				panelClientName.add(labClientName);
				panelClientName.add(txtClientName);
				JPanel panelClientPrenom = new JPanel(new GridLayout(1, 2));
				panelClientPrenom.add(labClientPrenoms);
				panelClientPrenom.add(txtClientPrenoms);
				JPanel panelClientSave = new JPanel();
				panelClientSave.add(btnClientCancel);
				panelClientSave.add(btnClientSave);

				modifierClient.add(panelTitle);
				modifierClient.add(panelClientName);
				modifierClient.add(labClientVerifName);
				modifierClient.add(panelClientPrenom);
				modifierClient.add(labClientVerifPrenoms);
				modifierClient.add(panelClientSave);

				contentPane.add(modifierClient);
				modifyClient.pack();
				modifyClient.setLocationRelativeTo(null);
				modifyClient.setVisible(true);

				btnClientCancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						modifyClient.dispose();

					}
				});

				btnClientSave.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String nom = txtClientName.getText();
						String prenom = txtClientPrenoms.getText();

						boolean result = modifyClient(modifyClient, selection[0], nom, prenom);
						if (result) {
							modifyClient.dispose();
						}
					}
				});
				
			} else {
				JOptionPane.showMessageDialog(null, "Un seul élément ne peut être modifié à la fois", "Information",
						JOptionPane.CANCEL_OPTION);
			}

		}

	}

	/*------------------ La méthode qui permet de supprimer un client dans la base ------------------*/

	private class RemoveClient extends AbstractAction {

		private static final long serialVersionUID = 5166784993147077316L;

		private RemoveClient() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();

			if (selection.length == 0) {
				JOptionPane.showMessageDialog(null, "Aucun client sélectionné", "Information",
						JOptionPane.CANCEL_OPTION);

			} else {
				int option = JOptionPane.showConfirmDialog(null,
						"Vous voulez vraiment supprimer ".concat(String.format("%d client(s) ?", selection.length)),
						"Confirmation de suppression", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					for (int i = selection.length - 1; i >= 0; i--) {
						modele.removeClient(selection[i]);
					}
					JOptionPane.showConfirmDialog(null,
							String.format("%d élément(s) supprimé(s) avec succès !", selection.length),
							"Suppression réussie", JOptionPane.CLOSED_OPTION);
				}
			}
		}
	}
}
