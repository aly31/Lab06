import java.util.Random;
public class Lab07 {
	private static int pg = 0, mg = 0;
	public static void main(String [] args){
		Random r = new Random(System.nanoTime());
		int rutabagas = r.nextInt(5);
		//initialize EVERYTHING
		int n = 5, s = 40, i = 0;
		int total = 0;
		int[] pangloss = new int[n];
		int[] martin = new int[n];
		//for method calls 2 methods for 2 different gardens. Respectively.
		for(i = 0; i<s; i++){
			System.out.println("Season " + (i+1) + ", " + rutabagas + " rutabaga(s)");
			total+=rutabagas;
			pangloss = Pangloss(pangloss, i, rutabagas, total);
			martin = Martin(martin, i , rutabagas, total);
			rutabagas = r.nextInt(5);
		}
		//print both gardens.
		printArray(martin, i);
		System.out.println("Martin Garden Size : " + martin.length + ", Resized " + mg + " times");
		printArray(pangloss, i);
		System.out.println("Pangloss Garden Size : " + pangloss.length + ", Resized " + pg + " times");
	}
	public static int[] Pangloss(int[] pangloss, int count, int rutabagas, int total){
		pangloss[count] = rutabagas;
		if(total >= pangloss.length){
			pg++;
			int[] pan = new int[pangloss.length*2];
			for(int i = 0; i<pangloss.length; i++){
				pan[i] = pangloss[i];
			}
			System.out.println("Resized Pangloss's Garden to " + pan.length + "!");
			return pan;
		}
		else{
			return pangloss;
		}
	}
	public static int[] Martin(int[] martin, int count, int rutabagas, int total){
		martin[count] = rutabagas;
		if(total >= martin.length){
			mg++;
			int[] mar = new int[martin.length+2];
			for(int i = 0; i<martin.length; i++){
				mar[i] = martin[i];
			}
			System.out.println("Resized Martin's Garden to " + mar.length + "!");
			return mar;
		}
		else{
			return martin;
		}
	}
		

	public static void printArray(int[] arr, int numItems) {
		System.out.print("[ ");
		for (int j=0; j < (arr.length - 1); j++) {
		    if (j >= numItems) {
		    	System.out.print("***, ");
		    } 
		    else {
		        System.out.print(arr[j] + ", ");
		    }
		}

		if ((arr.length -1) >= numItems) {
		    System.out.println("*** ]");
		} 
		else {
		    System.out.println(arr[arr.length - 1] + " ]");
		}
	}
}
