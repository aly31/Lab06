import java.util.Scanner;
public class Lab08 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		World world = new World();
		int [][][][][] sekai = world.setWorld();
		Scientist Misner = new Scientist();
		boolean explore = true;
		while(explore){
			System.out.println("Enter dimension to travel (1,2,3,4,5) (negative to quit) :");
			int dimension = sc.nextInt();
			if(dimension < 0){
				System.out.println("The scientist gives up on the quest for understanding.");
				System.exit(0);
			}
			System.out.println("Enter number of units to travel (negative for backwards) :");
			int units = sc.nextInt();
			units = ((units % 10) + 10) % 10;
			int [] FullData = Misner.Move(dimension, units);
			int color = FullData[5];
			String hue;
			switch(color){
			case 1: hue = "Lime";
			break;
			case 2: hue = "Cerulean";
			break;
			case 3: hue = "Goldenrod";
			break;
			default: hue = "Black";
			break;
			}
			System.out.println("Location: " + "[" + FullData[0] + " " + FullData[1] +  " " + FullData[2] +  " " + FullData[3] +  " " + FullData[4] +  "]" + " = " + hue);
		}
	}
}
