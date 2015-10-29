
public class Scientist {
	public int [] position = {0,0,0,0,0};
	public int color;
	World world = new World();
	int FullData [] = new int[6];
	public int[] Move(int dimension, int units){
		
		
		FullData[dimension-1] = (FullData[dimension-1] + ((units % 10) + 10) % 10) % 10;
		//color = world.getColor(FullData);
		color = (FullData[0]+FullData[1]+FullData[2]+FullData[3]+FullData[4])%10;
		FullData[5]=color;
		return FullData;
	}
}
