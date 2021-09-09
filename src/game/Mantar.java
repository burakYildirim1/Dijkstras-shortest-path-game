package game;

public class Mantar extends ObjeSýnýfý {

	private int mushroomValue=50;
	private int maxMushroomCount=1;
	
	public int getMaxMushroomCount() {
		return maxMushroomCount;
	}

	public void setMaxMushroomCount(int maxMushroomCount) {
		this.maxMushroomCount = maxMushroomCount;
	}

	@Override
	public int getMaxShownTime() {
		// TODO Auto-generated method stub
		return super.getMaxShownTime();
	}

	@Override
	public void setMaxShownTime(int maxShownTime) {
		// TODO Auto-generated method stub
		super.setMaxShownTime(maxShownTime);
	}

	

	public int getMushroomValue() {
		return mushroomValue;
	}

	public void setMushroomValue(int mushroomValue) {
		this.mushroomValue = mushroomValue;
	}


}
