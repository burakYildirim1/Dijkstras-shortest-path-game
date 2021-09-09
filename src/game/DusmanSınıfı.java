package game;

import java.util.ArrayList;


public class DusmanS�n�f� extends KarakterS�n�f� {
	

	private int dusmanID;
	private String dusmanAdi;
	private String dusmanTur;
	
	public final int ebeveynYok = -1;
	private ArrayList<Integer> pathPlayer;
	
	public int getDusmanID() {
		return dusmanID;
	}

	public void setDusmanID(int dusmanID) {
		this.dusmanID = dusmanID;
	}

	public String getDusmanAdi() {
		return dusmanAdi;
	}

	public void setDusmanAdi(String dusmanAdi) {
		this.dusmanAdi = dusmanAdi;
	}

	public String getDusmanTur() {
		return dusmanTur;
	}

	public void setDusmanTur(String dusmanTur) {
		this.dusmanTur = dusmanTur;
	}



	public DusmanS�n�f�() {
		pathPlayer = new ArrayList<Integer>();
	}
	
	public void cleanPath()
	{
		pathPlayer.clear();
	}

	public int[] getNextMove(int mapMatrix[][],int targetPos) {
		int counter = 0;
		int posXY[] = new int [2];
		for (int i = 0; i < mapMatrix.length; i++) {
			for (int j = 0; j < mapMatrix[i].length; j++) {
				if (mapMatrix[i][j] == 1)
				{
					if(counter==targetPos)
					{
						posXY[0]=i;
						posXY[1]=j;
						return posXY;
					}
					counter++;
				}
			}
		}
		return posXY;
	}
	
	public int[][] setMatrix(int mapMatrix[][]) 
	{
		int matrix[][] = new int[78][78];

		for (int i = 0; i < mapMatrix.length; i++) {
			for (int j = 0; j < mapMatrix[i].length; j++) {
				if (mapMatrix[i][j] == 1) {
					int up, down, right, left, first;
					first = getIndex(mapMatrix, i, j);
					up = control(mapMatrix, i - 1, j);
					down = control(mapMatrix, i + 1, j);
					right = control(mapMatrix, i, j + 1);
					left = control(mapMatrix, i, j - 1);
					// System.out.println("---------------------");
					// System.out.println("i: "+i+" j: "+j+" | "+getIndex(mapMatrix, i, j)+" -> Up:
					// "+up+" down: "+down+" right: "+right+" left: "+left);

					if (up == 1) {
						int toNode = getIndex(mapMatrix, i - 1, j);
						matrix[first][toNode] = 1;
					}
					if (down == 1) {
						int toNode = getIndex(mapMatrix, i + 1, j);
						matrix[first][toNode] = 1;
					}
					if (right == 1) {
						int toNode = getIndex(mapMatrix, i, j + 1);
						matrix[first][toNode] = 1;
					}
					if (left == 1) {
						int toNode = getIndex(mapMatrix, i, j - 1);
						matrix[first][toNode] = 1;
					}
				}
			}

		}
		return matrix;
	}

	public void dijkstra(int[][] KomsulukMatrisi, int baslang�cDugum, int bitisDugum) {
		int koseler = KomsulukMatrisi[0].length;

		int[] enK�saMesafeler = new int[koseler];

		boolean[] ekle = new boolean[koseler];

		for (int dugumIndex = 0; dugumIndex < koseler; dugumIndex++) {
			enK�saMesafeler[dugumIndex] = Integer.MAX_VALUE;
			ekle[dugumIndex] = false;
		}

		enK�saMesafeler[baslang�cDugum] = 0;

		int[] ebeveyn = new int[koseler];

		ebeveyn[baslang�cDugum] = ebeveynYok;

		for (int i = 1; i < koseler; i++) {

			int enYak�nDugum = -1;
			int enK�saMesafe = Integer.MAX_VALUE;
			for (int dugumIndex = 0; dugumIndex < koseler; dugumIndex++) {
				if (!ekle[dugumIndex] && enK�saMesafeler[dugumIndex] < enK�saMesafe) {
					enYak�nDugum = dugumIndex;
					enK�saMesafe = enK�saMesafeler[dugumIndex];
				}
			}

			ekle[enYak�nDugum] = true;

			for (int dugumIndex = 0; dugumIndex < koseler; dugumIndex++) {
				int kenarUzakl�g� = KomsulukMatrisi[enYak�nDugum][dugumIndex];

				if (kenarUzakl�g� > 0 && ((enK�saMesafe + kenarUzakl�g�) < enK�saMesafeler[dugumIndex])) {
					ebeveyn[dugumIndex] = enYak�nDugum;
					enK�saMesafeler[dugumIndex] = enK�saMesafe + kenarUzakl�g�;
				}
			}
		}

		sonucYazd�r(baslang�cDugum, enK�saMesafeler, ebeveyn, bitisDugum);
	
	}

	public void sonucYazd�r(int baslang�cDugum, int[] mesafeler, int[] ebeveyn, int bitisDugum) {
		int koseler = mesafeler.length;
//		System.out.print("Dugum\t\t Mesafe\t\t Rota");

		for (int dugumIndex = 0; dugumIndex < koseler; dugumIndex++) {
			if (dugumIndex != baslang�cDugum) {
				if (dugumIndex == bitisDugum) {
//					System.out.print("\n|" + baslang�cDugum + " -> ");
//					System.out.print(dugumIndex + "| \t ");
//					System.out.print("|" + mesafeler[dugumIndex] + "|\t\t| ");
					rotaYazd�r(dugumIndex, ebeveyn); 
				}

			}
		}
		
	}

	public ArrayList<Integer> getPathPlayer() {
		return pathPlayer;
	}

	public void rotaYazd�r(int eleAl�nanDugum, int[] ebeveyn) {

		if (eleAl�nanDugum == ebeveynYok)
		{
			return;
		}
		rotaYazd�r(ebeveyn[eleAl�nanDugum], ebeveyn);
//		System.out.print(eleAl�nanDugum + " ");
		pathPlayer.add(eleAl�nanDugum);
//		System.out.print("| ");
	}

	public int getNumber(int x, int y) {
		int pos = 0;

		pos = x * 13 + y + 1;

		return pos;
	}

	public int getIndex(int mapMatrix[][], int x, int y) {
		int pos = 0;

		for (int i = 0; i < mapMatrix.length; i++) {
			for (int j = 0; j < mapMatrix[i].length; j++) {
				if (i == x && j == y) {
					return pos;
				}
				if (mapMatrix[i][j] == 1) {
					pos++;
				}
			}
		}
		if (pos == 78)
			pos = 0;
		return pos;
	}

	public int control(int mapMatrix[][], int x, int y) {
		int stat = 0;
		if (x == -1 || y == -1 || x == 11 || y == 13) {
			return 0;
		}
		if (mapMatrix[x][y] == 1) {
			return 1;
		}
		return stat;
	}

	public void printMatrix(int gameMatrix[][]) {
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < gameMatrix.length; i++) {
			for (int j = 0; j < gameMatrix[i].length; j++) {
				System.out.print("| " + gameMatrix[i][j] + " ");
			}
			System.out.println("\n------------------------------------------------------");
		}
	}

		
}
