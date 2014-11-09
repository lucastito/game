import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CharacterSelectScreen {

	private JFrame frame;
	private GameScreenPresenter presenter;


	public CharacterSelectScreen(GameScreenPresenter presenter) {
		this.presenter = presenter;
		initialize();
	}
	
	
	public void startGameWith(String race){
		PlayerDTO player1 = new PlayerDTO(1, "Player 1", race);
		String oponentsRace = "";
		while (oponentsRace == null || oponentsRace == "")
		{
			int random = (int)(1 + 6*Math.random());
			
			if (random == 1)
				oponentsRace = "SITH";
			if (random == 2)
				oponentsRace = "CLONE";
			if (random == 3)
				oponentsRace = "PADAWAN";
			if (random == 4)
				oponentsRace = "DROIDE";
			if (random == 5)
				oponentsRace = "TRANDOSHAN";
			if (random == 6)
				oponentsRace = "WOOKIEE";
			
			if (oponentsRace.equals(race))
				oponentsRace = "";			
		}
		
		PlayerDTO player2 = new PlayerDTO(2, "Player 2", oponentsRace);
		GameCreationInputPort gameCreation = presenter.getGameCreation();
		gameCreation.addPlayerToCurrentGame(player1);
		gameCreation.addPlayerToCurrentGame(player2);
		gameCreation.setUpPlayersObjective();
		gameCreation.setUpPlayersTerritoriesAndTerritoriesCards();
		frame.dispose();
		JOptionPane.showMessageDialog(null, "Você escolheu a raça "+race);
	}
	

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel mainPanel = new JPanel()
		{

			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {  
				                      Image img = Toolkit.getDefaultToolkit().getImage(  
				                                CharacterSelectScreen.class.getResource("image/character_select.jpg"));  
				                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
				                 }
		};
		frame.getContentPane().add(mainPanel, null);
		mainPanel.setLayout(null);
		
		JButton chooseSith = new JButton("");
		chooseSith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGameWith("SITH");
			}
		});
		chooseSith.setBounds(84, 440, 130, 279);
//		btnNewButton.setBorder(null);  Esse codigo comentado será necessario para fazer um aperfeicoamento na tela futuramente
//		btnNewButton.setBorderPainted(false);
		chooseSith.setContentAreaFilled(false);
//		btnNewButton.setOpaque(false);
		mainPanel.add(chooseSith);
		
		JButton chooseClone = new JButton("");
		chooseClone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith("CLONE");
			}
		});
		chooseClone.setContentAreaFilled(false);
		chooseClone.setBounds(224, 440, 130, 279);
		mainPanel.add(chooseClone);
		
		JButton choosePadawan = new JButton("");
		choosePadawan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith("PADAWAN");
			}
		});
		choosePadawan.setContentAreaFilled(false);
		choosePadawan.setBounds(364, 440, 114, 279);
		mainPanel.add(choosePadawan);
		
		JButton chooseDroid = new JButton("");
		chooseDroid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith("DROIDE");
			}
		});
		chooseDroid.setContentAreaFilled(false);
		chooseDroid.setBounds(492, 423, 152, 296);
		mainPanel.add(chooseDroid);
		
		JButton chooseTrandosh = new JButton("");
		chooseTrandosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith("TRANDOSHAN");
			}
		});
		chooseTrandosh.setContentAreaFilled(false);
		chooseTrandosh.setBounds(671, 388, 123, 331);
		mainPanel.add(chooseTrandosh);
		
		JButton chooseWookie = new JButton("");
		chooseWookie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith("WOOKIEE");
			}
		});
		chooseWookie.setContentAreaFilled(false);
		chooseWookie.setBounds(815, 337, 166, 382);
		mainPanel.add(chooseWookie);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
}
