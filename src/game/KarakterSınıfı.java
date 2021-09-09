package game;

public abstract class KarakterSýnýfý {
	
	
	private int ID;
	private String ad;
	private String tur;
	
	KarakterSýnýfý()
	{
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}
	public abstract void dijkstra(int[][] KomsulukMatrisi, int baslangýcDugum , int bitisDugum);
	
	

	
}
