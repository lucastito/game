import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CharacterSelectScreen {

	private JFrame frame;
	private GameScreenPresenter presenter;


	public CharacterSelectScreen(GameScreenPresenter presenter) {
		this.presenter = presenter;
		initialize();
	}
	
	
	public void startGameWith(){
		
		frame.dispose();
		presenter.show();
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
				startGameWith();
			}
		});
		chooseSith.setBounds(84, 440, 130, 279);
//		btnNewButton.setBorder(null);  Esse codigo comentado será necessario para fazer um aperfeicoamento na tela futuramente
//		btnNewButton.setBorderPainted(false);
		chooseSith.setContentAreaFilled(false);
//		btnNewButton.setOpaque(false);
		mainPanel.add(chooseSith);
		
		JButton chooseClone = new JButton("");
		chooseClone.setContentAreaFilled(false);
		chooseClone.setBounds(224, 440, 130, 279);
		mainPanel.add(chooseClone);
		
		JButton choosePadawan = new JButton("");
		choosePadawan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith();
			}
		});
		choosePadawan.setContentAreaFilled(false);
		choosePadawan.setBounds(364, 440, 114, 279);
		mainPanel.add(choosePadawan);
		
		JButton chooseDroid = new JButton("");
		chooseDroid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith();
			}
		});
		chooseDroid.setContentAreaFilled(false);
		chooseDroid.setBounds(492, 423, 152, 296);
		mainPanel.add(chooseDroid);
		
		JButton chooseTrandosh = new JButton("");
		chooseTrandosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith();
			}
		});
		chooseTrandosh.setContentAreaFilled(false);
		chooseTrandosh.setBounds(671, 388, 123, 331);
		mainPanel.add(chooseTrandosh);
		
		JButton chooseWookie = new JButton("");
		chooseWookie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameWith();
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
