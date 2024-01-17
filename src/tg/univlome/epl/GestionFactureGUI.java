package tg.univlome.epl;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import tg.univlome.epl.view.Accueil;

public class GestionFactureGUI {

	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		new Accueil();
	}

}
