//

public class Fractal{
	//
	public static void main (String [] args){
		figure(4, 0);
	}
	public static void figure(int i, int s){
		char c='*';
		if(i==0){
			for(int j=0;j<s;j++){
				System.out.print(" ");
			}
			System.out.println(c);
			return;
		}
		figure(i-1,s);
		Line(i,s);
		//for monitoring
		System.out.println("\t"+i);
		s+=Math.pow(2, i-1);
		figure(i-1,s);		
	}
	public static void Line(int i, int s){
		for(int j=0;j<s;j++){
			System.out.print(" ");
		}
		for(int j=0;j<Math.pow(2, i);j++){
			System.out.print('*');
		}
	}
}
