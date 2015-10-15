import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Lab06 {
	public static void main(String [] args) throws IOException{
		Scanner s = new Scanner (System.in);
		System.out.println("Welcome to the Numericon story. How big would you like your universe?");
		int size = s.nextInt();
		char[] world = generateUniverse(size);
		System.out.println(world);
		boolean loop = true;
		while(loop){
			System.out.println("How shall we proceed?\nAdvance (A)\nQuit (Q)\nSave (S)");
			String choice = s.next();
			switch(choice){
			case "a": world = Advance(world);
					  System.out.println(world);
					  break;
			case "q": loop = false;
					  System.exit(0);
					  break;
			case "s": Save(world);
					  break;
			default:  System.out.println("That is not a valid option.");
					  s.next();
					  break;
			}
		}
	}
	public static char[] generateUniverse(int size){
		char[] world = new char[size];
		for(int i = 0; i<world.length; i++){
			world[i] = '.';
		}
		for(int i = 0; i<world.length; i+=5){
			world[i] = '^';
		}
		for(int i = 0; i<world.length; i+=7){
			world[i] = '0';
		}
		return world;
	}
	public static char[] Advance(char[] world){
		for(int i = 0; i<world.length; i++){
			if(world[i]=='0'){
				world[i]='1';
			}
			else if(world[i]=='1'){
				world[i]='2';
			}
			else if(world[i]=='2'){
				if(i != world.length-1){
					if(world[i+1]=='.'){
						world[i]='.';
						world[i+1]='2';		
						i++;
					}
					else if(world[i+1]=='^'){
						world[i+1]='0';
						world[i]='.';
						i++;
					}
				}
			}
		}
		
		return world;
	}
	public static void Save(char[] world) throws IOException{
		BufferedWriter writer = null;
		int babies = 0;
    	int children = 0;
    	int adults = 0;
	    try {

	        writer = new BufferedWriter(new FileWriter("universe.txt"));
	        for ( int i = 0; i<world.length; i++)
	        {      
	          writer.write(world[i]);
	          writer.flush();
	          
	        }
	        writer.newLine();
	        for ( int i = 0; i<world.length; i++)
	        {
	        	
	        	if(world[i]=='0'){
	        		babies++;
	        	}
	        	if(world[i]=='1'){
	        		children++;
	        	}
	        	if(world[i]=='2'){
	        		adults++;
	        	} 
	        }
	        writer.write("Babies: " + babies);
	        writer.newLine();
	        writer.write("Children: " + children);
	        writer.newLine();
	        writer.write("Adults: " + adults);
	        writer.newLine();
	        writer.flush();
	        } finally{
	        if(writer!=null){
	            writer.close();
	        }  
	    }
	}
}

