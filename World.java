public class World {
	int[][][][][] world = new int[10][10][10][10][10];
	public int[][][][][] setWorld(){
			for(int j = 0; j < 10; j++){
				for(int k = 0; k < 10; k++){
					for(int l = 0; l < 10; l++){
						for(int m = 0; m < 10; m++){
							for(int n = 0; n < 10; n++){
								 world[j][k][l][m][n] = (j + k + l + m + n) % 10;
							}
						}
					}
				}
			}
		return world;
	}
	
	public int getColor(int [] position){
		return world[position[1]][position[2]][position[3]][position[4]][position[5]];
	}
}
