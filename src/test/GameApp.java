package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.Alt�n;
import game.Azman;
import game.DusmanS�n�f�;
import game.GameBoard;
import game.Gargamel;
import game.GozlukluSirin;
import game.Mantar;
import game.OyuncuS�n�f�;
import game.TembelSirin;


public class GameApp implements KeyListener, ActionListener  {

	GameBoard gameboard1 = new GameBoard();
	GozlukluSirin player1 = new GozlukluSirin();
	TembelSirin player2 = new TembelSirin();
	Gargamel gargamel1 = new Gargamel();
	Azman azman1 = new Azman();
	Alt�n alt�n1 = new Alt�n();
	Mantar mantar1 = new Mantar();
 	
	
	
	ArrayList<String> lineList = new ArrayList<String>();
	List<String> list1 = new ArrayList<String>();
	ArrayList<JLabel> listMantar = new ArrayList<JLabel>();
	ArrayList<JLabel> listAlt�n = new ArrayList<JLabel>();
	
	ArrayList<JPanel> azmanPath = new ArrayList<JPanel>();
	ArrayList<JPanel> gargamelPath = new ArrayList<JPanel>();
	
	OyuncuS�n�f� players[] = new OyuncuS�n�f�[1];
	HashMap<DusmanS�n�f�, Integer> enemies = new HashMap<DusmanS�n�f�, Integer>();

	int startGargamelX, startGargamelY, startAzmanX, startAzmanY;
	int playerType, moveCount = 1;

	boolean stat=false;
	boolean stat2=false;
	
	private JFrame frame;
	JLabel lblPlayer;
	JLabel lblAzman;
	JLabel lblGargamel;
	
	JLabel lblAzmanReach;
	JLabel lblGargamelReach;
	
	JLabel lblPlayerBalance;
	


	public static void main(String[] args) 
	{
		
	 
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					GameApp window = new GameApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	
	public GameApp() throws FileNotFoundException 
	{
		initialize();
		
		   Timer myTimer = new Timer();
		   Timer myTimer2 = new Timer();
		   myTimer.schedule(taskGold, 0, 5000);
		   myTimer2.schedule(taskMantar, 0,7000);
		
	}

    TimerTask taskGold = new TimerTask()
    {
        @Override
        public void run() {
            
        	if(!stat)
        	{
        		gameboard1.setGold();
        		
        		int count=0;
        		for (int i = 0; i < gameboard1.getGameMatrix().length; i++) 
        		{
        			for (int j = 0; j < gameboard1.getGameMatrix()[i].length; j++) 
        			{
        				if (gameboard1.getGameMatrix()[i][j] == 5) 
        				{
        					listAlt�n.get(count).setLocation(j*64, i*64);
        					listAlt�n.get(count).setVisible(true);
        					count++;
        				}
        			}
        		}     		
        		 stat=true;
        	}
         		
        	else
        	{
        		int count=0;
        		for (int i = 0; i < gameboard1.getGameMatrix().length; i++) 
        		{
        			for (int j = 0; j < gameboard1.getGameMatrix()[i].length; j++) 
        			{
        				if (gameboard1.getGameMatrix()[i][j] == 5) 
        				{
        					listAlt�n.get(count).setVisible(false);
        					count++;
        				}
        			}
        		}
        		gameboard1.deleteGold();
        		stat=false;
        	}
        		
        	
        }
    };

    TimerTask taskMantar = new TimerTask()
    {
        @Override
        public void run() {
            
        	if(!stat2)
        	{
        		gameboard1.setMushroom();
        		
        		int count=0;
        		for (int i = 0; i < gameboard1.getGameMatrix().length; i++) 
        		{
        			for (int j = 0; j < gameboard1.getGameMatrix()[i].length; j++) 
        			{
        				if (gameboard1.getGameMatrix()[i][j] == 50) 
        				{
        					listMantar.get(count).setLocation(j*64, i*64);
        					listMantar.get(count).setVisible(true);
        					count++;
        				}
        			}
        		}     		
        		 stat2=true;
        	}
         		
        	else
        	{
        		int count=0;
        		for (int i = 0; i < gameboard1.getGameMatrix().length; i++) 
        		{
        			for (int j = 0; j < gameboard1.getGameMatrix()[i].length; j++) 
        			{
        				if (gameboard1.getGameMatrix()[i][j] == 50) 
        				{
        					listMantar.get(count).setVisible(false);
        					count++;
        				}
        			}
        		}
        		gameboard1.deleteMushroom();
        		stat2=false;
        	}
        		
        	
        }
    };

	private void initialize() throws FileNotFoundException {
		
		frame = new JFrame();
		frame.setTitle("�irin Yakalama Oyunu");
		frame.setBounds(100, 100, 1200, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.addKeyListener(this);
		
		ImageIcon imgPlayerG = new ImageIcon("images\\gozluklu.png");
		ImageIcon imgPlayerT = new ImageIcon("images\\tembel.png");
		ImageIcon imgSiyahKutu = new ImageIcon("images\\siyahkutu.png");
		ImageIcon imgMaviKutu = new ImageIcon("images\\mavikutu.png");
		ImageIcon imgAKap�s� = new ImageIcon("images\\Akap�s�.jpg");
		ImageIcon imgBKap�s� = new ImageIcon("images\\Bkap�s�.jpg");
		ImageIcon imgCKap�s� = new ImageIcon("images\\Ckap�s�.jpg");
		ImageIcon imgDKap�s� = new ImageIcon("images\\Dkap�s�.jpg");
		ImageIcon imgSirine = new ImageIcon("images\\sirine.png");
		ImageIcon imgGargamel = new ImageIcon("images\\gargamel.png");
		ImageIcon imgAzman = new ImageIcon("images\\azman.png");
		ImageIcon imgAlt�n = new ImageIcon("images\\gold.png");
		ImageIcon imgMantar = new ImageIcon("images\\mantar.png");
		
		lblPlayer = new JLabel("");
		lblPlayer.setBounds(6 * 64, 5 * 64, 64, 64);
		frame.getContentPane().add(lblPlayer);

		lblGargamel = new JLabel();
		lblGargamel.setIcon(imgGargamel);
		frame.getContentPane().add(lblGargamel);
		
		lblAzman = new JLabel();
		lblAzman.setIcon(imgAzman);
		frame.getContentPane().add(lblAzman);
		
		lblAzmanReach = new JLabel();
		lblAzmanReach.setBounds(14*64, 64*1, 300, 300);
		frame.getContentPane().add(lblAzmanReach);
		
		lblGargamelReach = new JLabel();
		lblGargamelReach.setBounds(14*64, 64*3, 300, 300);
		frame.getContentPane().add(lblGargamelReach);
		
		lblPlayerBalance = new JLabel();
		lblPlayerBalance.setBounds(14*64,64*5,300,300);
		frame.getContentPane().add(lblPlayerBalance);
		
		int lineNum = 0;
		try {
			File myFile = new File("C:\\Users\\90536\\eclipse-workspace\\Prolab2.1\\src\\deneme.txt");
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) 
			{
				String data = myReader.nextLine();
				if (data.startsWith("0")) 				
					break; 			
				else 
				{
					lineList.add(data);
					String str[] = lineList.get(lineNum).split(":|\\,");
					lineNum++;
					list1.add(str[1]);
					list1.add(str[3]);
				}

			}
			//System.out.println(list1);
			myReader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
				
		Object[] options = { "G�zl�kl� �irin", "Tembel �irin" };
		int secim = JOptionPane.showOptionDialog(null, "L�tfen �irin Se�imi Yap�n�z! ", "�irin Se�imi",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		
		if (secim == 0) 
		{
			lblPlayer.setIcon(imgPlayerG);
			playerType = 1;
			players[0] = player1;
		} 
		else if (secim == 1) 
		{
			lblPlayer.setIcon(imgPlayerT);
			playerType = 2;
			players[0] = player2;
		}
//		System.out.println("secilen oyuncu : " + players[0].getOyuncuAdi());
		
		for (int i = 0; i < list1.size(); i++) 
		{
			if (list1.get(i).equals("Gargamel")) 
			{
				char door = list1.get(i + 1).charAt(0);
				enemies.put(gargamel1, (int) door);
			}

			if (list1.get(i).equals("Azman")) 
			{
				char door = list1.get(i + 1).charAt(0);
				enemies.put(azman1, (int) door);
			}

		}
		//System.out.println("list1:"+list1);
		//System.out.println("enemies:"+enemies);
	
		for (int i = 0; i < alt�n1.getMaxGoldCount(); i++)
		{
			JLabel lblAlt�n = new JLabel();
			lblAlt�n.setBounds(-1, -1, 64, 64);
			lblAlt�n.setVisible(false);
			lblAlt�n.setIcon(imgAlt�n);
			frame.getContentPane().add(lblAlt�n);
			listAlt�n.add(lblAlt�n);
			
			
		}
		for (int i = 0; i < mantar1.getMaxMushroomCount(); i++)
		{
			JLabel lblMantar = new JLabel();
			lblMantar.setBounds(-1, -1, 64, 64);
			lblMantar.setVisible(false);
			lblMantar.setIcon(imgMantar);
			frame.getContentPane().add(lblMantar);
			listMantar.add(lblMantar);
			
		}
		


		
		JLabel[][] buton = new JLabel[gameboard1.getGameMatrix().length][gameboard1.getGameMatrix()[1].length];
		javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.gray);
		
//		System.out.println(gameboard1.getGameMatrix().length);
//		System.out.println(gameboard1.getGameMatrix()[1].length);
		
		
		for (int i = 0; i < gameboard1.getGameMatrix().length; i++) 
		{
			for (int j = 0; j < gameboard1.getGameMatrix()[i].length; j++) 
			{

				buton[i][j] = new JLabel();

				if (gameboard1.getGameMatrix()[i][j] == 0) 
				{
					buton[i][j].setIcon((imgSiyahKutu));
				}
				if (gameboard1.getGameMatrix()[i][j] == 83) 
				{
					buton[i][j].setIcon((imgMaviKutu));
				}					
				if (gameboard1.getGameMatrix()[i][j] == 65) 
				{
					buton[i][j].setIcon((imgAKap�s�));
					if (enemies.get(gargamel1) == 65) 
					{
						startGargamelX = j * 64;
						startGargamelY = i * 64;
						lblGargamel.setBounds(startGargamelX, startGargamelY, 64, 64);

					}
					if (enemies.get(azman1) == 65) 
					{
						startAzmanX = j * 64;
						startAzmanY = i * 64;
						lblAzman.setBounds(startAzmanX, startAzmanY, 64, 64);
					}
				}
				if (gameboard1.getGameMatrix()[i][j] == 66) 
				{
					buton[i][j].setIcon((imgBKap�s�));				
					if (enemies.get(gargamel1) == 66) 
					{
						startGargamelX = j * 64;
						startGargamelY = i * 64;
						lblGargamel.setBounds(startGargamelX, startGargamelY, 64, 64);
					}
					if (enemies.get(azman1) == 66) 
					{
						startAzmanX = j * 64;
						startAzmanY = i * 64;
						lblAzman.setBounds(startAzmanX, startAzmanY, 64, 64);
					}
				}
				if (gameboard1.getGameMatrix()[i][j] == 67) 
				{
					buton[i][j].setIcon((imgCKap�s�));					
					if (enemies.get(gargamel1) == 67) 
					{
						startGargamelX = j * 64;
						startGargamelY = i * 64;
						lblGargamel.setBounds(startGargamelX, startGargamelY, 64, 64);
					}
					if (enemies.get(azman1) == 67) 
					{
						startAzmanX = j * 64;
						startAzmanY = i * 64;
						lblAzman.setBounds(startAzmanX, startAzmanY, 64, 64);
					}
				}
				if (gameboard1.getGameMatrix()[i][j] == 68) 
				{
					buton[i][j].setIcon((imgDKap�s�));					
					if (enemies.get(gargamel1) == 68) 
					{
						startGargamelX = j * 64;
						startGargamelY = i * 64;
						lblGargamel.setBounds(startGargamelX, startGargamelY, 64, 64);
					}
					if (enemies.get(azman1) == 68) 
					{
						startAzmanX = j * 64;
						startAzmanY = i * 64;
						lblAzman.setBounds(startAzmanX, startAzmanY, 64, 64);
					}
				}
				if (gameboard1.getGameMatrix()[i][j] == 70) 
				{
					buton[i][j].setIcon((imgSirine));
				}
				buton[i][j].setBounds(j * 64, i * 64, 64, 64);				
				buton[i][j].setBorder(blackline);
				frame.getContentPane().add(buton[i][j]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int playerCurrentPosX = players[0].getPlayerX();
		int playerCurrentPosY = players[0].getPlayerY();

		int playerPos[][] = new int[2][2];
		playerPos[0][0] = playerCurrentPosX;
		playerPos[0][1] = playerCurrentPosY;

		int w = 0, a = 0, s = 0, d = 0;

		switch (e.getKeyCode()) 
		{
		case 38:
			w = 1;
			playerCurrentPosX = playerCurrentPosX - 1;
			break;
		case 37:
			a = 1;
			playerCurrentPosY = playerCurrentPosY - 1;
			break;
		case 40:
			s = 1;
			playerCurrentPosX = playerCurrentPosX + 1;
			break;
		case 39:
			d = 1;
			playerCurrentPosY = playerCurrentPosY + 1;
			break;
		default:
			return;
		}

		playerPos[1][0] = playerCurrentPosX;
		playerPos[1][1] = playerCurrentPosY;

		int isDone = gameboard1.makeMove(playerPos, 3, 1);

		if (isDone != -1)
		{
			if (w == 1)
				lblPlayer.setLocation(lblPlayer.getX(), lblPlayer.getY() - 64);
			if (a == 1)
				lblPlayer.setLocation(lblPlayer.getX() - 64, lblPlayer.getY());
			if (s == 1)
				lblPlayer.setLocation(lblPlayer.getX(), lblPlayer.getY() + 64);
			if (d == 1)
				lblPlayer.setLocation(lblPlayer.getX() + 64, lblPlayer.getY());

	
			
			
			for (int i = 0; i < listAlt�n.size(); i++) 
			{
				
				
				if( (lblPlayer.getX()==listAlt�n.get(i).getX()) && (lblPlayer.getY()==listAlt�n.get(i).getY()) )
				{
					
					listAlt�n.get(i).setVisible(false);
				}
					
			}
			
			
			for (int i = 0; i < listMantar.size(); i++) 
			{
				
				
				if( (lblPlayer.getX()==listMantar.get(i).getX()) && (lblPlayer.getY()==listMantar.get(i).getY()) )
				{
					
					listMantar.get(i).setVisible(false);
				}
					
			}

			
			
			
			if(azmanPath.size()>0 || gargamelPath.size()>0)
			{
				for (int i = 0; i < azmanPath.size(); i++)
				{
					frame.remove(azmanPath.get(i));
					frame.revalidate();
					frame.repaint();
				}
				for (int i = 0; i < gargamelPath.size(); i++)
				{
					frame.remove(gargamelPath.get(i));
					frame.revalidate();
					frame.repaint();
				}
				azmanPath.clear();
				gargamelPath.clear();
			}
			
			players[0].setPlayerX(playerCurrentPosX);
			players[0].setPlayerY(playerCurrentPosY);
			players[0].setBalance(players[0].getBalance() + isDone);
			
			lblPlayerBalance.setText("Oyuncu Puan� : "+players[0].getBalance());

			//System.out.println(moveCount);
			if (playerType == 1) 
			{
				moveCount++;
			}
			if (playerType == 2 || moveCount > 2) 
			{
				for (DusmanS�n�f� player : enemies.keySet()) 
				{
//					System.out.println("Player X pos : " + players[0].getPlayerX() + " Player Y pos : " + players[0].getPlayerY());
//					System.out.println("Player balance : " + players[0].getBalance());
//					gameboard1.printMatrix();
//					System.out.println("######################################");
//					System.out.println("oyuncu s�ras� : " + player.getDusmanAdi() + " : " + (enemies.get(player)));

					int oldPos[] = gameboard1.getPos(enemies.get(player));
					int matrixCur[][] = player.setMatrix(gameboard1.getMapMatrix());
					
					int start = player.getIndex(gameboard1.getMapMatrix(), oldPos[0], oldPos[1]);
					int hedef = player.getIndex(gameboard1.getMapMatrix(), playerCurrentPosX, playerCurrentPosY);
					player.dijkstra(matrixCur, start, hedef);
					
					int badPlayerPos[][] = new int[2][2];

					int moveChane = 1;
					if (player.getDusmanAdi().equals("Gargamel"))
					{
						moveChane = 2;
						lblGargamelReach.setText("Gargamel ("+oldPos[0]+","+oldPos[1]+")'dan "
								+"("+playerCurrentPosX+","+playerCurrentPosY+")'ya "+(player.getPathPlayer().size()-1)
								+" Ad�mda ula�maktad�r.");
					}
						if(player.getDusmanAdi().equals("Azman"))
						{
							lblAzmanReach.setText("Azman ("+oldPos[0]+","+oldPos[1]+")'dan "
							+"("+playerCurrentPosX+","+playerCurrentPosY+") "+(player.getPathPlayer().size()-1)
							+" Ad�mda ula�maktad�r.");
						}
					
					
					if (player.getPathPlayer().size() == 2)
					{
						moveChane = 1;
						
					}

					int newPos[] = player.getNextMove(gameboard1.getMapMatrix(), player.getPathPlayer().get(moveChane));
					
					
					
					for (int i = 0; i < player.getPathPlayer().size(); i++) 
					{
						int pathPos[] = player.getNextMove(gameboard1.getMapMatrix(), player.getPathPlayer().get(i));
						if (player.getDusmanAdi().equals("Gargamel"))
						{
							JPanel lblPath = new JPanel();
							lblPath.setBounds(pathPos[1]*64, pathPos[0]*64, 64, 64);
							lblPath.setBackground(new Color(28, 227, 101, 75));
							lblPath.setVisible(true);
							frame.getContentPane().add(lblPath);
							gargamelPath.add(lblPath);
						}						
						else
						{
							JPanel lblPath = new JPanel();
							lblPath.setBounds(pathPos[1]*64, pathPos[0]*64, 64, 64);
							lblPath.setBackground(new Color(227, 28, 177, 75));
							lblPath.setVisible(true);
							frame.getContentPane().add(lblPath);
							azmanPath.add(lblPath);
						}					
					}
					
					player.cleanPath();

//					System.out.println("old x " + oldPos[0]);
//					System.out.println("old y " + oldPos[1]);
//					System.out.println("new x " + newPos[0]);
//					System.out.println("new y " + newPos[1]);

					badPlayerPos[0][0] = oldPos[0];
					badPlayerPos[0][1] = oldPos[1];
					badPlayerPos[1][0] = newPos[0];
					badPlayerPos[1][1] = newPos[1];
					
					int catchPoint = gameboard1.makeMove(badPlayerPos, moveChane, enemies.get(player));

					if (player.getDusmanAdi().equals("Gargamel"))
						lblGargamel.setLocation(newPos[1] * 64, newPos[0] * 64);
					else
						lblAzman.setLocation(newPos[1] * 64, newPos[0] * 64);

					if (catchPoint != -1) 
					{
						if(players[0].getBalance()+catchPoint <= 0)
						{
							JOptionPane.showMessageDialog(frame, "Bakiye 0'�n Alt�na D��t�! Kaybettin!", "KAYBETT�N!",
							        JOptionPane.WARNING_MESSAGE);
							System.exit(0);
						}
						players[0].setBalance(players[0].getBalance() + catchPoint);
						
						if (player.getDusmanAdi().equals("Gargamel"))
							lblGargamel.setLocation(startGargamelX, startGargamelY);
						else
							lblAzman.setLocation(startAzmanX, startAzmanY);
					}

				}
				moveCount = 1;
			}
			
			//gameboard1.printMatrix();
			//System.out.println("######################################");

		}

		if (players[0].getPlayerX() == 7 && players[0].getPlayerY() == 12) 
		{
			JOptionPane.showMessageDialog(frame, "Bakiye : "+players[0].getBalance(), "BAK�YE",
			        JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(frame, "KAZANDIN! ", "Oyun Sonu",
			        JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) 
	{

	}
}









