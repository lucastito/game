import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;


/**
 * @author Daniel
 *
 */
public class InitialScreen {

	private JFrame frmStarwar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialScreen window = new InitialScreen();
					window.frmStarwar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitialScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmStarwar = new JFrame();
		frmStarwar.setTitle("StarWar");
		frmStarwar.setBounds(100, 100, 1366, 768);
		frmStarwar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarwar.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel mainPanel = new JPanel(){
			public void paintComponent(Graphics g) {  
				                      Image img = Toolkit.getDefaultToolkit().getImage(  
				                                InitialScreen.class.getResource("image/outerspace.jpg"));  
				                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
				                 }
		};
		frmStarwar.getContentPane().add(mainPanel, "name_27958844715217");
		mainPanel.setLayout(null);
		

		JLabel lblStarWar = new JLabel("STAR WAR");
		lblStarWar.setBounds(460, 0, 456, 151);
		lblStarWar.setForeground(new Color(255, 215, 0));
		lblStarWar.setFont(new Font("Tahoma", Font.PLAIN, 95));
		mainPanel.add(lblStarWar);
		
		JButton btnNewButton = new JButton("Novo Jogo");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnNewButton.setBounds(576, 194, 210, 83);
		mainPanel.add(btnNewButton);
		
		final JPanel aboutPanel = new JPanel()
		{
			public void paintComponent(Graphics g) {  
				                      Image img = Toolkit.getDefaultToolkit().getImage(  
				                                InitialScreen.class.getResource("image/outerspace.jpg"));  
				                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
				                 }
		};
		frmStarwar.getContentPane().add(aboutPanel, "name_27958852908665");
		aboutPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SOBRE");
		lblNewLabel.setBounds(533, 5, 283, 113);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 93));
		aboutPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\nTrabalho final da disciplina Engenharia de Software 2.<br>\r\n<br>\r\nStarWar \u00E9 um jogo baseado nas regras do jogo War, com ambienta\u00E7\u00E3o da obra de fic\u00E7\u00E3o Star Wars.<br>\r\n<br>\r\nEQUIPE: Grupo 6<br>\r\nGerente: Matheus Lima<br>\r\nPO: Lucas Tito<br>\r\nDesenvolvedores: Daniel Rossi, Leonardo Muniz e Marcelo D'Almeida<br>\r\n</html>");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel_1.setBounds(40, 103, 1284, 564);
		aboutPanel.add(lblNewLabel_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(165, 42, 42));
		btnVoltar.setBounds(53, 630, 166, 52);
		aboutPanel.add(btnVoltar);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPanel.setVisible(true);
				mainPanel.setVisible(false);
				
			}
		});
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setBackground(new Color(210, 105, 30));
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnSobre.setBounds(576, 374, 210, 83);
		mainPanel.add(btnSobre);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(new Color(189, 183, 107));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnSair.setBounds(576, 556, 210, 83);
		mainPanel.add(btnSair);
		
		

		

	}
}
