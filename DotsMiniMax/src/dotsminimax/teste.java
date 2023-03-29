package dotsminimax;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class teste {
	
	private boolean isClicked = true;
	private static Tabuleiro board = new Tabuleiro();
	private JFrame frame;
	private Tabuleiro possTree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		

	    ArrayList<Jogada> jogadas = new ArrayList<>();
	    Tabuleiro tab = new Tabuleiro(jogadas,0);
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					teste window = new teste();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 */
	public teste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 620);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_21 = new JButton("");
		JButton btnNewButton_2 = new JButton("");
		JButton btnNewButton_19 = new JButton("");
		JButton btnNewButton_20 = new JButton("");
		JButton btnNewButton_22 = new JButton("");
		JButton btnNewButton_17 = new JButton("");
		JButton btnNewButton_11 = new JButton("");
		JButton btnNewButton = new JButton("");
		JButton btnNewButton_15 = new JButton("");
		JButton btnNewButton_6 = new JButton("");
		JButton btnNewButton_13 = new JButton("");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 251, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{159, 159, 159, 159, 159, 0};
		gbl_panel.rowHeights = new int[]{107, 100, 111, 105, 121, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton_7 = new JButton("X");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 0;
		panel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setFont(new Font("Lucida Grande", Font.PLAIN, 59));

		board.jogadas.add(new Jogada(0, 1,1));
		btnNewButton_8.setEnabled(false);
		btnNewButton_8.setText("-");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 1;
		gbc_btnNewButton_8.gridy = 0;
		panel.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 2;
		gbc_btnNewButton_9.gridy = 0;
		panel.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnNewButton_4.setText("-");
				board.jogadas.add(new Jogada(0, 3,1));
				if(isClicked) {
					
					isClicked = false;
					board.gerarFilhos(1);
					
				}btnNewButton_4.setEnabled(false);
				Jogada melhor = board.melhorMovimento(1, 10);
				System.out.println("linha" + melhor.getLinha() +"coluna "+ melhor.getColuna());
				board.jogadas.add(new Jogada(melhor.getLinha(),melhor.getColuna(),0));
				if(melhor.getLinha() == 1 && melhor.getColuna() == 0) {
					btnNewButton_19.setText("|");
					btnNewButton_19.setEnabled(false);
				}else if(melhor.getLinha() == 1 && melhor.getColuna() == 2) {
					btnNewButton_20.setText("|");
					btnNewButton_20.setEnabled(false);
				}else if(melhor.getLinha() == 1 && melhor.getColuna() == 4) {
					btnNewButton_22.setText("|");
					btnNewButton_22.setEnabled(false);
			}
			else if(melhor.getLinha() == 2 && melhor.getColuna() == 1) {
				btnNewButton_17.setText("-");
				btnNewButton_17.setEnabled(false);
			}else if(melhor.getLinha() == 2 && melhor.getColuna() == 3) {
				btnNewButton_11.setText("-");
				btnNewButton_11.setEnabled(false);
		}else if(melhor.getLinha() == 3 && melhor.getColuna() == 0) {
			btnNewButton.setText("|");
			btnNewButton.setEnabled(false);
		}else if(melhor.getLinha() == 3 && melhor.getColuna() == 2) {
			btnNewButton_2.setText("|");
			btnNewButton_2.setEnabled(false);
		}
		else if(melhor.getLinha() == 3 && melhor.getColuna() ==4) {
			btnNewButton_15.setText("|");
			btnNewButton_15.setEnabled(false);
		}
		else if(melhor.getLinha() == 4 && melhor.getColuna() == 1) {
			btnNewButton_6.setText("-");
			btnNewButton_6.setEnabled(false);
		}else if(melhor.getLinha() == 4 && melhor.getColuna() == 3) {
			btnNewButton_13.setText("-");
			btnNewButton_13.setEnabled(false);
	}
}

		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 0;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_10 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_10.gridx = 4;
		gbc_btnNewButton_10.gridy = 0;
		panel.add(btnNewButton_10, gbc_btnNewButton_10);
		
		// btn for display 1,0
		btnNewButton_19.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_19.setText("|");
				board.jogadas.add(new Jogada(1, 0,1));
				if(isClicked) {
					
					isClicked = false;
					board.gerarFilhos(1);
					
					
				}btnNewButton_19.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_19 = new GridBagConstraints();
		gbc_btnNewButton_19.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_19.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_19.gridx = 0;
		gbc_btnNewButton_19.gridy = 1;
		panel.add(btnNewButton_19, gbc_btnNewButton_19);
		
		JButton button = new JButton("");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		panel.add(button, gbc_button);
		
		// btn for display 1,2
		btnNewButton_20.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_20.setText("|");
				board.jogadas.add(new Jogada(1, 2,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_20.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_20 = new GridBagConstraints();
		gbc_btnNewButton_20.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_20.gridx = 2;
		gbc_btnNewButton_20.gridy = 1;
		panel.add(btnNewButton_20, gbc_btnNewButton_20);
		
		
		GridBagConstraints gbc_btnNewButton_21 = new GridBagConstraints();
		gbc_btnNewButton_21.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_21.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_21.gridx = 3;
		gbc_btnNewButton_21.gridy = 1;
		panel.add(btnNewButton_21, gbc_btnNewButton_21);
		
		// btn for display 1,4 
		btnNewButton_22.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_22.setText("|");
				board.jogadas.add(new Jogada(1, 4,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_22.setEnabled(false);
			}
		});
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_22.gridx = 4;
		gbc_btnNewButton_22.gridy = 1;
		panel.add(btnNewButton_22, gbc_btnNewButton_22);
		
		JButton btnNewButton_18 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_18 = new GridBagConstraints();
		gbc_btnNewButton_18.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_18.gridx = 0;
		gbc_btnNewButton_18.gridy = 2;
		panel.add(btnNewButton_18, gbc_btnNewButton_18);
		
		//btn for display 2,1
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_17.setText("-");
				board.jogadas.add(new Jogada(2, 1,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_17.setEnabled(false);
			}
		});
		btnNewButton_17.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton_17 = new GridBagConstraints();
		gbc_btnNewButton_17.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_17.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_17.gridx = 1;
		gbc_btnNewButton_17.gridy = 2;
		panel.add(btnNewButton_17, gbc_btnNewButton_17);
		
		JButton btnNewButton_23 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_23 = new GridBagConstraints();
		gbc_btnNewButton_23.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_23.gridx = 2;
		gbc_btnNewButton_23.gridy = 2;
		panel.add(btnNewButton_23, gbc_btnNewButton_23);
		
		//btn for display 2,3
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_11.setText("-");
				board.jogadas.add(new Jogada(2, 3,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_11.setEnabled(false);
			}
		});
		btnNewButton_11.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 3;
		gbc_btnNewButton_11.gridy = 2;
		panel.add(btnNewButton_11, gbc_btnNewButton_11);
		
		JButton btnNewButton_14 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_14.gridx = 4;
		gbc_btnNewButton_14.gridy = 2;
		panel.add(btnNewButton_14, gbc_btnNewButton_14);
		
		//btn for display 3,0
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setText("|");
				board.jogadas.add(new Jogada(3, 0,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 3;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		//btn display for 3,2
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setText("|");
				board.jogadas.add(new Jogada(3, 2,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_2.setEnabled(false);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 3;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_12 = new JButton("");
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 3;
		gbc_btnNewButton_12.gridy = 3;
		panel.add(btnNewButton_12, gbc_btnNewButton_12);
		
		//btn for display 3,4
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_15.setText("|");
				board.jogadas.add(new Jogada(3, 4,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_15.setEnabled(false);
			}
		});
		btnNewButton_15.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		gbc_btnNewButton_15.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_15.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_15.gridx = 4;
		gbc_btnNewButton_15.gridy = 3;
		panel.add(btnNewButton_15, gbc_btnNewButton_15);
		
		
		JButton btnNewButton_5 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 4;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		//btn for display 4,1
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_6.setText("-");
				board.jogadas.add(new Jogada(4, 1,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_6.setEnabled(false);
			}
		});
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 4;
		panel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 4;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
	
		//btn for display 4,3
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_13.setText("|");
				board.jogadas.add(new Jogada(4, 3,1));
				if(isClicked) {
					
					isClicked = true;
					board.gerarFilhos(1);
					
					
				}btnNewButton_13.setEnabled(false);
			}
		});
		btnNewButton_13.setFont(new Font("Lucida Grande", Font.PLAIN, 59));
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_13.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_13.gridx = 3;
		gbc_btnNewButton_13.gridy = 4;
		panel.add(btnNewButton_13, gbc_btnNewButton_13);
		
		JButton btnNewButton_16 = new JButton("X");
		GridBagConstraints gbc_btnNewButton_16 = new GridBagConstraints();
		gbc_btnNewButton_16.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_16.gridx = 4;
		gbc_btnNewButton_16.gridy = 4;
		panel.add(btnNewButton_16, gbc_btnNewButton_16);
	}

}
