package game;

public abstract class OyuncuSýnýfý extends KarakterSýnýfý {
	
	
	private int playerX=5;
	private int playerY=6;
	private int balance=20; //skor
	
	private int oyuncuID;
	private String oyuncuAdi;
	private String oyuncuTur;
	
	public int getOyuncuID() {
		return oyuncuID;
	}

	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}

	public String getOyuncuAdi() {
		return oyuncuAdi;
	}

	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}

	public String getOyuncuTur() {
		return oyuncuTur;
	}

	public void setOyuncuTur(String oyuncuTur) {
		this.oyuncuTur = oyuncuTur;
	}



	
	public int getBalance() { //skorGoster
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	
	public abstract void puanGoster();

	public void enKisaYol() {
		// TODO Auto-generated method stub
	
		
	}

	
	

}
