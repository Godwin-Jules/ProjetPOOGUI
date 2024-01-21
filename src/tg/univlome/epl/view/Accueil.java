package tg.univlome.epl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tg.univlome.epl.controller.panel.PanelAbout;
import tg.univlome.epl.controller.panel.PanelBoisson;
import tg.univlome.epl.controller.panel.PanelClient;
import tg.univlome.epl.controller.panel.PanelEntree;
import tg.univlome.epl.controller.panel.PanelFacture;
import tg.univlome.epl.controller.panel.PanelPlat;

public class Accueil extends JFrame {

	private static final long serialVersionUID = 1L;

	private static Utils utils = new Utils();
	
	private static JPanel contentPane;
	private static JPanel panelTop;
	private static JLabel labelTop;
	private static JPanel panelLeft;	
	private static JPanel panelCenter = new JPanel(new BorderLayout());
	private static JPanel panelBottom;
	private static JLabel labBottom;
	
	private static PanelClient panelClient = new PanelClient();
	private static PanelEntree panelEntree = new PanelEntree();
	private static PanelPlat panelPlat = new PanelPlat();
	private static PanelBoisson panelBoisson = new PanelBoisson();
	private static PanelFacture panelFacture = new PanelFacture();
	private static PanelAbout panelAbout = new PanelAbout();
	
	private static JButton btnClient;
	private static JButton btnEntree;
	private static JButton btnPlat;
	private static JButton btnBoisson;
	private static JButton btnFacture;
	private static JButton btnAbout;

	private static Image frame_image;
	
	public Accueil() {
		super("Dashbord | Gestion des factures de Res_Torrent");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1080, 700);
		this.setLocationRelativeTo(null);
		frame_image = new ImageIcon("img/restaurant_icon.jpg").getImage();
		this.setIconImage(frame_image);
		
		contentPane = new JPanel(new BorderLayout());
		this.getContentPane().add(contentPane);

		/*--------------- le panel de haut de page --------------*/
		panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(0, 100));
		panelTop.setBackground(Color.decode("#2C73D2"));
		labelTop = utils.createLab("Page d'accueil", "Leelawadee", 25);
		panelTop.add(labelTop);

		/*--------------- le panel de gauche ---------------*/
		panelLeft = new JPanel(new GridLayout(7, 1, 0, 5));
		panelLeft.setPreferredSize(new Dimension(200, 0));
		panelLeft.setBackground(Color.decode("#2C73D2"));
		btnClient = utils.createBtn("Clients", "Leelawadee", 20);
		btnClient.setForeground(Color.WHITE);
		btnClient.setBackground(Color.decode("#2C73D2"));
		
		btnEntree = utils.createBtn("Entrées", "Leelawadee", 20);
		btnEntree.setBackground(Color.decode("#2C73D2"));
		
		btnPlat = utils.createBtn("Plats", "Leelawadee", 20);
		btnPlat.setBackground(Color.decode("#2C73D2"));
		
		btnBoisson = utils.createBtn("Boissons", "Leelawadee", 20);
		btnBoisson.setBackground(Color.decode("#2C73D2"));
		
		btnFacture = utils.createBtn("Factures", "Leelawadee", 20);
		btnFacture.setBackground(Color.decode("#2C73D2"));
		
		btnAbout = utils.createBtn("About", "Leelawadee", 20);
		btnAbout.setBackground(Color.decode("#2C73D2"));
		
		panelLeft.add(btnClient);
		panelLeft.add(btnEntree);
		panelLeft.add(btnPlat);
		panelLeft.add(btnBoisson);
		panelLeft.add(btnFacture);
		panelLeft.add(btnAbout);

		/*--------------- le panel du centre ----------------*/
		panelCenter.add(panelClient);
		panelCenter.setBackground(Color.GRAY);

		/*--------------- le panel de bas de page --------------*/
		panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(0, 30));
		panelBottom.setBackground(Color.BLACK);
		labBottom = utils.createLab("Copyrigth 2023 - 2024", "Leelawadee", 20);
		labBottom.setForeground(Color.WHITE);
		panelBottom.add(labBottom);

		/*--------------- Ajout des actionListeners ---------------*/
		// Pour le bouton client
		btnClient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelCenter.removeAll();
				btnClient.setForeground(Color.WHITE);
				btnEntree.setForeground(Color.BLACK);
				btnPlat.setForeground(Color.BLACK);
				btnBoisson.setForeground(Color.BLACK);
				btnFacture.setForeground(Color.BLACK);
				btnAbout.setForeground(Color.BLACK);
				
				panelCenter.add(panelClient);
				revalidate();
				repaint();
			}
		});

		btnEntree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelCenter.removeAll();
				btnClient.setForeground(Color.BLACK);
				btnEntree.setForeground(Color.WHITE);
				btnPlat.setForeground(Color.BLACK);
				btnBoisson.setForeground(Color.BLACK);
				btnFacture.setForeground(Color.BLACK);
				btnAbout.setForeground(Color.BLACK);
				
				panelCenter.add(panelEntree);
				revalidate();
				repaint();
			}
		});
		// Pour le bouton plat
		btnPlat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelCenter.removeAll();
				btnClient.setForeground(Color.BLACK);
				btnEntree.setForeground(Color.BLACK);
				btnPlat.setForeground(Color.WHITE);
				btnBoisson.setForeground(Color.BLACK);
				btnFacture.setForeground(Color.BLACK);
				btnAbout.setForeground(Color.BLACK);
				
				panelCenter.add(panelPlat);
				revalidate();
				repaint();
			}
		});

		// Pour le bouton boisson
		btnBoisson.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCenter.removeAll();
				btnClient.setForeground(Color.BLACK);
				btnEntree.setForeground(Color.BLACK);
				btnPlat.setForeground(Color.BLACK);
				btnBoisson.setForeground(Color.WHITE);
				btnFacture.setForeground(Color.BLACK);
				btnAbout.setForeground(Color.BLACK);
				
				panelCenter.add(panelBoisson);
				revalidate();
				repaint();
			}
		});

		// Pour le bouton facture
		btnFacture.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCenter.removeAll();
				btnClient.setForeground(Color.BLACK);
				btnEntree.setForeground(Color.BLACK);
				btnPlat.setForeground(Color.BLACK);
				btnBoisson.setForeground(Color.BLACK);
				btnFacture.setForeground(Color.WHITE);
				btnAbout.setForeground(Color.BLACK);
				
				panelCenter.add(panelFacture);
				revalidate();
				repaint();
			}
		});

		// Pour le bouton à propos
		btnAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelCenter.removeAll();
				btnClient.setForeground(Color.BLACK);
				btnEntree.setForeground(Color.BLACK);
				btnPlat.setForeground(Color.BLACK);
				btnBoisson.setForeground(Color.BLACK);
				btnFacture.setForeground(Color.BLACK);
				btnAbout.setForeground(Color.WHITE);
				
				panelCenter.add(panelAbout);
				revalidate();
				repaint();
			}
		});
		
		/*--------------- Rassemblement des différents composants ----------------*/
		contentPane.add(panelTop, BorderLayout.NORTH);
		contentPane.add(panelLeft, BorderLayout.WEST);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}