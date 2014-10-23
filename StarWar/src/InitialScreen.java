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
import java.io.File;

public class InitialScreen {

	private JFrame frmStarwar;
	
	public JFrame getfrmStarwar(){
		return frmStarwar;
	}
	
	public InitialScreen(GameScreenPresenter presenter) {
		initialize(presenter);
	}

	private void initialize(final GameScreenPresenter presenter) 
	{
		File mp3File = new File(InitialScreen.class.getResource("sound/theme.mp3").getPath());
		MP3Runner backgroundMusic = new MP3Runner(mp3File);
		Thread mp3Thread = new Thread(backgroundMusic);
		mp3Thread.start();

		frmStarwar = new JFrame();
		frmStarwar.setTitle("StarWar");
		frmStarwar.setBounds(100, 100, 1366, 768);
		frmStarwar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarwar.getContentPane().setLayout(new CardLayout(0, 0));
				
		final JPanel mainPanel = new JPanel()
		{
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStarwar.dispose();
				presenter.show();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnNewButton.setBounds(576, 162, 210, 83);
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
		
		final JPanel helpPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(  
                        InitialScreen.class.getResource("image/outerspace.jpg"));  
              g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}
		};
		helpPanel.setLayout(null);
		frmStarwar.getContentPane().add(helpPanel, "name_11996292856650");
		
		final JPanel configurationPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(  
                        InitialScreen.class.getResource("image/outerspace.jpg"));  
              g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		configurationPanel.setLayout(null);
		frmStarwar.getContentPane().add(configurationPanel, "name_11912079648588");
		
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
				helpPanel.setVisible(false);
				configurationPanel.setVisible(false);
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
				helpPanel.setVisible(false);
				configurationPanel.setVisible(false);
				
				
			}
		});
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setBackground(new Color(210, 105, 30));
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnSobre.setBounds(576, 565, 210, 83);
		mainPanel.add(btnSobre);
		
		JButton btnConfiguracoes = new JButton("Configura\u00E7\u00F5es");
		btnConfiguracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPanel.setVisible(false);
				mainPanel.setVisible(false);
				helpPanel.setVisible(false);
				configurationPanel.setVisible(true);
			}
		});
		btnConfiguracoes.setForeground(Color.WHITE);
		btnConfiguracoes.setBackground(new Color(189, 183, 107));
		btnConfiguracoes.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnConfiguracoes.setBounds(541, 366, 275, 83);
		mainPanel.add(btnConfiguracoes);
		
		JButton button = new JButton("Abrir Jogo");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 37));
		button.setBackground(new Color(95, 158, 160));
		button.setBounds(576, 263, 210, 83);
		mainPanel.add(button);
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPanel.setVisible(false);
				mainPanel.setVisible(false);
				helpPanel.setVisible(true);
				configurationPanel.setVisible(false);
			}
		});
		btnAjuda.setForeground(Color.WHITE);
		btnAjuda.setFont(new Font("Tahoma", Font.PLAIN, 37));
		btnAjuda.setBackground(new Color(165, 42, 42));
		btnAjuda.setBounds(576, 471, 210, 83);
		mainPanel.add(btnAjuda);
		
		JLabel lblConfiguracoes = new JLabel("CONFIGURA\u00C7\u00D5ES");
		lblConfiguracoes.setForeground(Color.YELLOW);
		lblConfiguracoes.setFont(new Font("Tahoma", Font.PLAIN, 93));
		lblConfiguracoes.setBounds(323, 11, 741, 113);
		configurationPanel.add(lblConfiguracoes);
		
		JButton btnVoltar2 = new JButton("Voltar");
		btnVoltar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aboutPanel.setVisible(false);
				mainPanel.setVisible(true);
				helpPanel.setVisible(false);
				configurationPanel.setVisible(false);
			}
		});
		btnVoltar2.setForeground(Color.WHITE);
		btnVoltar2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnVoltar2.setBackground(new Color(165, 42, 42));
		btnVoltar2.setBounds(53, 630, 166, 52);
		configurationPanel.add(btnVoltar2);
		
		
		
		JLabel lblAjuda = new JLabel("AJUDA");
		lblAjuda.setForeground(Color.YELLOW);
		lblAjuda.setFont(new Font("Tahoma", Font.PLAIN, 93));
		lblAjuda.setBounds(521, 11, 291, 113);
		helpPanel.add(lblAjuda);
		
		JButton btnVoltar3 = new JButton("Voltar");
		btnVoltar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPanel.setVisible(false);
				mainPanel.setVisible(true);
				helpPanel.setVisible(false);
				configurationPanel.setVisible(false);
			}
		});
		btnVoltar3.setForeground(Color.WHITE);
		btnVoltar3.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnVoltar3.setBackground(new Color(165, 42, 42));
		btnVoltar3.setBounds(53, 630, 166, 52);
		helpPanel.add(btnVoltar3);
	}
}
