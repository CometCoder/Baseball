package com.gman.baseball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


//Pitches: Curveball = 0, slider = 1, fastball = 2, changeup = 3, splitfinger = 4
public class Baseball {
	JFrame frame = new JFrame();
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image img;
	
	int outs = 0;
	int playerOne;
	int playerTwo;
	int player = 1;
	int inning = 1;
	
	//Boolean for bases
	boolean first = false;
	boolean second = false;
	boolean third = false;
	
	//Load base photos
	JLabel base1 = new JLabel();
	JLabel base2 = new JLabel();
	JLabel base3 = new JLabel();
	JLabel base12 = new JLabel();
	JLabel base123 = new JLabel();
	JLabel base13 = new JLabel();
	JLabel base23 = new JLabel();
	
	JLabel image = new JLabel();
	JPanel teamRight = new JPanel();
	JPanel teamLeft = new JPanel();
	public int guess = -1;
	
	public Baseball() {
		//Get base photos
		base1.setIcon(new ImageIcon(getImage("base1.png")));
		base2.setIcon(new ImageIcon(getImage("base2.png")));
		base3.setIcon(new ImageIcon(getImage("base3.png")));
		base12.setIcon(new ImageIcon(getImage("base12.png")));
		base123.setIcon(new ImageIcon(getImage("base123.png")));
		base13.setIcon(new ImageIcon(getImage("base13.png")));
		base23.setIcon(new ImageIcon(getImage("base23.png")));
		
		setLookAndFeel();
		frame.setTitle("Baseball");
		frame.setSize(toolkit.getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setResizable(false);
		image.setIcon(new ImageIcon(getImage("base0.png")));
		frame.add(image);
		teamRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel rightLabel = new JLabel("Team 2");
		rightLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		teamRight.add(rightLabel);
		teamLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel leftLabel = new JLabel("Team 1");
		leftLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		teamLeft.add(leftLabel);
		teamLeft.add(new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         "));	
		teamLeft.add(teamRight);
		//frame.add(teamRight, BorderLayout.SOUTH);
		frame.add(teamLeft, BorderLayout.SOUTH);
		repaint();
		showPlayDialog();
	}
	
	private int getPitch() {
		Random random = new Random();
		return random.nextInt(5);
	}
	
	private void pitch() {
		int answer = getPitch();
		System.out.println(answer);
		if (answer == guess) {
			Random random = new Random();
			int randomNum = random.nextInt(6);
			switch (randomNum) {
				case 0:
					showDialog("HOMERUN!");
					removeAll();
					if (player == 1) {
						playerOne += third ? 1 : 0;
						playerOne += second ? 1 : 0;
						playerOne += first ? 1 : 0;
						playerOne++;
					} else {
						playerTwo += third ? 1 : 0;
						playerTwo += second ? 1 : 0;
						playerTwo += first ? 1 : 0;
						playerTwo++;
					}
					
					first = false;
					second = false;
					third = false;
					setImage();
					repaint();
					break;
				case 1:
					showDialog("Single");
					removeAll();
					if (third) {
						if (player == 1) {
							playerOne += 1;
						} else {
							playerTwo += 1;
						}
						third = false;
					}
					if (second) {
						second = false;
						third = true;
					}
					if (first) {
						second = true;
					}
					first = true;
					setImage();
					repaint();
					break;
				case 2:
					showDialog("Double");
					removeAll();
					if (second) {
						if (player == 1) {
							playerOne++;
						} else {
							playerTwo++;
						}
					}
					
					if (third) {
						if (player == 1) {
							playerOne++;
						} else {
							playerTwo++;
						}
						third = false;
					}
					
					if (first) {
						first = false;
						third = true;
					}
					second = true;
					setImage();
					repaint();
					break;
				case 3:
					showDialog("Triple");
					removeAll();
					if (first) {
						if (player == 1) {
							playerOne++;
						} else {
							playerTwo++;
						}
						first = false;
					}
					
					if (second) {
						if (player == 1) {
							playerOne++;
						} else {
							playerTwo++;
						}
						second = false;
					}
					
					if (third) {
						if (player == 1) {
							playerOne++;
						} else {
							playerTwo++;
						}
						third = false;
					}
					third = true;
					setImage();
					repaint();
					break;
				case 4:
					showDialog("Out!");
					outs++;
					break;
				case 5:
					showDialog("Out!");
					outs++;
					break;
			}	
		} else {
			Random random = new Random();
			int randomNum = random.nextInt(6);
			switch (randomNum) {
				case 0:
					showDialog("Out!");
					outs++;
					break;
				case 1:
					showDialog("Out!");
					outs++;
					break;
				case 2:
					showDialog("Out!");
					outs++;
					break;
				case 3:
					showDialog("Single");
					removeAll();
					if (third) {
						if (player == 1) {
							playerOne += 1;
						} else {
							playerTwo += 1;
						}
						third = false;
					}
					if (second) {
						second = false;
						third = true;
					}
					if (first) {
						second = true;
					}
					first = true;
					setImage();
					repaint();
					break;
				case 4:
					showDialog("Single");
					removeAll();
					if (third) {
						if (player == 1) {
							playerOne += 1;
						} else {
							playerTwo += 1;
						}
						third = false;
					}
					if (second) {
						second = false;
						third = true;
					}
					if (first) {
						second = true;
					}
					first = true;
					setImage();
					repaint();
					break;
				case 5:
					showDialog("Out!");
					outs++;
					break;
			}
		}
		if (outs == 3) {
			if (player == 2) {
				inning++;
			}
			
			if (inning != 9) {
				player = player == 1 ? 2: 1;
				showDialog("Player " + player);
				outs = 0;
				first = second = third = false;
			}
			
			removeAll();
			setImage();
			repaint();
		}
		if (!(inning == 9)) {
			showPlayDialog();
		} else {
			removeAll();
			//frame.add
		}
		return;
	}
	private void setImage() {
		if (first && second && third) {
			frame.add(base123);
			return;
		}
		
		if (first && second && !third) {
			frame.add(base12);
			return;
		}
		
		if (first && third && !second) {
			frame.add(base13);
			return;
		}
		
		if (second && third && !first) {
			frame.add(base23);
			return;
		}
		
		if (third && !second && !first) {
			frame.add(base3);
			return;
		}
		
		if (second && !third && !first) {
			frame.add(base2);
			return;
		}
		
		if (first && !second && !third) {
			frame.add(base1);
			return;
		}
		
		if (!first && !second && !third) {
			frame.add(image);
			return;
		}
	}
	
	private void repaint() {
		frame.repaint();
		frame.revalidate();
	}
	
	private void removeAll() {
		try {
			frame.remove(base1);
			frame.remove(base12);
			frame.remove(base123);
			frame.remove(base13);
			frame.remove(base2);
			frame.remove(base23);
			frame.remove(base3);
			frame.remove(image);
		} catch (Exception e) {
			
		}
	}
	
	private void showScore() {
		final JDialog dialog = new JDialog();
		dialog.setLayout(new FlowLayout());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel dialogPanel = new JPanel();
		dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
		JLabel score = new JLabel();
		score.setFont(new Font("Serif", Font.PLAIN, 25));
		score.setText(playerOne + "-" + playerTwo);
		dialogPanel.add(score);
		dialog.add(dialogPanel);
		dialog.pack();
		dialog.setVisible(true);
	}
	
	private Image getImage(String name) {
		try {
			return ImageIO.read(getClass().getResource(name)).getScaledInstance(toolkit.getScreenSize().width, toolkit.getScreenSize().height, Image.SCALE_SMOOTH);
		} catch (Exception e2) {
			
		}
		return null;
	}
	
	private void showDialog(String phrase) {
		JDialog homerun = new JDialog();
		homerun.setLayout(new FlowLayout());
		JLabel label = new JLabel(phrase);
		label.setFont(new Font("Serif", Font.PLAIN, 250));
		homerun.add(label);
		homerun.pack();
		homerun.setVisible(true);
		homerun.setAlwaysOnTop(true);
	}
	
	private void showPlayDialog() {
		final JDialog dialog = new JDialog();
		dialog.setLayout(new FlowLayout());
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		JPanel dialogPanel = new JPanel();
		dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new FlowLayout());
		JButton curveball = new JButton("Curveball");
		JPanel curveballPanel = new JPanel();
		curveballPanel.setLayout(new FlowLayout());
		curveballPanel.add(curveball);
		curveball.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guess = 0;
				dialog.dispose();
				repaint();
				pitch();
			}
			
		});
		
		JButton slider = new JButton("Slider");
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new FlowLayout());
		sliderPanel.add(slider);
		slider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guess = 1;
				dialog.dispose();
				repaint();
				pitch();
			}
			
		});
		
		JButton fastball = new JButton("Fastball");
		JPanel fastballPanel = new JPanel();
		fastballPanel.setLayout(new FlowLayout());
		fastballPanel.add(fastball);
		fastball.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guess = 2;
				dialog.dispose();
				repaint();
				pitch();
			}
			
		});
		
		JButton changeup = new JButton("Changeup");
		JPanel changeupPanel = new JPanel();
		changeupPanel.setLayout(new FlowLayout());
		changeupPanel.add(changeup);
		changeup.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guess = 3;
				dialog.dispose();
				repaint();
				pitch();
			}
			
		});
		
		JButton splitfinger = new JButton("Splitfinger");
		JPanel splitfingerPanel = new JPanel();
		splitfingerPanel.setLayout(new FlowLayout());
		splitfingerPanel.add(splitfinger);
		splitfinger.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guess = 4;
				dialog.dispose();
				repaint();
				pitch();
			}
			
		});
		JLabel layoutLabel = new JLabel("What pitch do you think is going to be thrown?");
		layoutLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		JLabel score = new JLabel();
		score.setFont(new Font("Serif", Font.PLAIN, 20));
		score.setText(playerOne + "-" + playerTwo);
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new FlowLayout());
		scorePanel.add(score);
		dialogPanel.add(layoutLabel);
		dialogPanel.add(scorePanel);
		dialogPanel.add(curveballPanel);
		dialogPanel.add(sliderPanel);
		dialogPanel.add(fastballPanel);
		dialogPanel.add(changeupPanel);
		dialogPanel.add(splitfingerPanel);

		layoutPanel.add(dialogPanel);
		
		dialog.add(layoutPanel);
		dialog.setSize(500, 500);
		dialog.setVisible(true);
	}
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception exc){
			
		}
	}
	public static void main(String[] args) {
		@SuppressWarnings("all")
		Baseball b = new Baseball();
	}
}