package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {

	private Random rand = new Random();
	private Altýn altýnClass = new Altýn();
	private Mantar mantarClass = new Mantar();

	private int mapMatrix[][];
	private int gameMatrix[][];

	ArrayList<Integer> mapList = new ArrayList<Integer>();
	List<String> lastList = new ArrayList<String>();

	public GameBoard() throws FileNotFoundException {

		Scanner sc = new Scanner((Readable) new BufferedReader(
				new FileReader("C:\\Users\\90536\\eclipse-workspace\\asdasd\\src\\dadad.txt")));
		
		int rows = 11;
		int columns = 13;
		mapMatrix = new int[rows][columns];
		while (sc.hasNextLine()) 
		{
			if (sc.hasNextInt()) 
			{
				for (int i = 0; i < mapMatrix.length; i++) 
				{
					String[] line = sc.nextLine().trim().split("\t");
					for (int j = 0; j < line.length; j++) 
					{
						mapMatrix[i][j] = Integer.parseInt(line[j]);
					}
				}
			}

		}


		gameMatrix = new int[][] 
		{ 
				{ 0, 0, 0, 65, 0, 0, 0, 0, 0, 0, 66, 0, 0 },
				{ 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0 },
				{ 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0 },
				{ 67, 1, 0, 1, 1, 1, 83, 0, 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 70 },
				{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 68, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		}

	public int[][] getGameMatrix() 
	{
		return gameMatrix;
	}

	public void setGameMatrix(int[][] gameMatrix) 
	{
		this.gameMatrix = gameMatrix;
	}

	public int makeMove(int movePos[][], int playerType, int gateNum) 
	{
		

		int oldPosX = movePos[0][0];
		int oldPosY = movePos[0][1];
		int newPosX = movePos[1][0];
		int newPosY = movePos[1][1];
		int prizeValue = 0;

		if (playerType == 3) 
		{
			if (gameMatrix[newPosX][newPosY] == 1 || gameMatrix[newPosX][newPosY] == 70
					|| gameMatrix[newPosX][newPosY] == 5 || gameMatrix[newPosX][newPosY] == 50) 
			{
				if (gameMatrix[newPosX][newPosY] == 70) 
				{
					gameMatrix[oldPosX][oldPosY] = 1;
					gameMatrix[newPosX][newPosY] = 83;
					//System.out.println("Tebrikler Þirineye Ulaþtýn!");

				}
				prizeValue = getPrize(newPosX, newPosY);

				gameMatrix[oldPosX][oldPosY] = 1;
				gameMatrix[newPosX][newPosY] = 83;

				return prizeValue;
			}
		} 
		else if (playerType == 2) 
			{
			if (gameMatrix[newPosX][newPosY] == 83) 
			{
				gameMatrix[oldPosX][oldPosY] = 1;
				if (gateNum == 66) 
				{
					newPosX = 0;
					newPosY = 10;
					gameMatrix[newPosX][newPosY] = gateNum;
				}
				if (gateNum == 65) 
				{
					newPosX = 0;
					newPosY = 3;
					gameMatrix[newPosX][newPosY] = gateNum;
				}

				if (gateNum == 67)
				{
					newPosX = 5;
					newPosY = 0;
					gameMatrix[newPosX][newPosY] = gateNum;
				}

				if (gateNum == 68) 
				{
					newPosX = 10;
					newPosY = 3;
					gameMatrix[newPosX][newPosY] = gateNum;
				}
				return -15;

			} 
			else 
			{
				gameMatrix[oldPosX][oldPosY] = 1;
				gameMatrix[newPosX][newPosY] = gateNum;
			}

		}

		else if (playerType == 1) 
		{
			if (gameMatrix[newPosX][newPosY] == 83) 
			{
				gameMatrix[oldPosX][oldPosY] = 1;
				if (gateNum == 66) 
				{
					newPosX = 0;
					newPosY = 10;
					gameMatrix[newPosX][newPosY] = gateNum;
				}
				if (gateNum == 65) 
				{
					newPosX = 0;
					newPosY = 3;
					gameMatrix[newPosX][newPosY] = gateNum;
				}

				if (gateNum == 67)
				{
					newPosX = 5;
					newPosY = 0;
					gameMatrix[newPosX][newPosY] = gateNum;
				}

				if (gateNum == 68) 
				{
					newPosX = 10;
					newPosY = 3;
					gameMatrix[newPosX][newPosY] = gateNum;
				}
				return -5;

			} else 
			{
				gameMatrix[oldPosX][oldPosY] = 1;
				gameMatrix[newPosX][newPosY] = gateNum;
			}
		}

		return -1;
	}

	private int getPrize(int posX, int posY) 
	{
		int prizeValue = 0;
		if (gameMatrix[posX][posY] == 5 || gameMatrix[posX][posY] == 50) 
		{
			prizeValue = gameMatrix[posX][posY];
			return prizeValue;
		}
		return prizeValue;
	}

	public int[] getPos(int target) 
	{
		int posXY[] = new int[2];
		for (int i = 0; i < gameMatrix.length; i++) 
		{
			for (int j = 0; j < gameMatrix[i].length; j++) 
			{
				if (gameMatrix[i][j] == target) 
				{
					posXY[0] = i;
					posXY[1] = j;
					return posXY;
				}
			}
		}
		return posXY;
	}

	public void setGold() 
	{
		int goldCount = 0;
		int maxGoldCount = altýnClass.getMaxGoldCount();
		while (goldCount < maxGoldCount) 
		{
			int randomX, randomY;
			randomX = rand.nextInt(11);
			randomY = rand.nextInt(13);

			int statusPos = gameMatrix[randomX][randomY];
			if (statusPos == 1) 
			{
				// System.out.println("ranX= "+randomX+" - ranY= "+randomY);
				gameMatrix[randomX][randomY] = altýnClass.getGoldValue();
				goldCount++;
			}
		}
	}

	public void deleteGold() {
		for (int i = 0; i < gameMatrix.length; i++) 
		{
			for (int j = 0; j < gameMatrix[i].length; j++) 
			{
				if (gameMatrix[i][j] == 5) 
				{
					gameMatrix[i][j] = 1;
				}
			}
		}
	}

	public void setMushroom() 
	{
		int mushroomCount = 0;
		int maxMushCount = mantarClass.getMaxMushroomCount();
		while (mushroomCount < maxMushCount) 
		{
			int randomX, randomY;
			randomX = rand.nextInt(11);
			randomY = rand.nextInt(13);
			int statusPos = gameMatrix[randomX][randomY];
			
			if (statusPos == 1) 
			{
				// System.out.println("M:ranX= "+randomX+" - M:ranY= "+randomY);
				gameMatrix[randomX][randomY] = mantarClass.getMushroomValue();
				mushroomCount++;
			}
		}
	}

	public void deleteMushroom() 
	{
		for (int i = 0; i < gameMatrix.length; i++) 
		{
			for (int j = 0; j < gameMatrix[i].length; j++) 
			{
				if (gameMatrix[i][j] == 50) 
				{
					gameMatrix[i][j] = 1;
				}
			}
		}
	}

	public int[][] getMapMatrix() 
	{
		return mapMatrix;
	}

	public void setMapMatrix(int mapMatrix[][]) 
	{
		this.mapMatrix = mapMatrix;
	}

	public void printMatrix() 
	{
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < gameMatrix.length; i++) 
		{
			for (int j = 0; j < gameMatrix[i].length; j++) 
			{
				System.out.print("| " + gameMatrix[i][j] + " ");
			}
			System.out.println("\n------------------------------------------------------");
		}
	}

}
