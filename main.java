import java.util.Scanner;

public class main{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int colTovars;
		String name;
		float price;
		int collichestvo;

		System.out.print("Vvedite collichestvo tovarov v vashey aptece: ");
		colTovars = s.nextInt();
		s.nextLine();
		Object[][] towars = new Object[colTovars][3];

		for (int i = 1;i<=colTovars;i++) {
			
			System.out.print("Vvedite imya tovara №"+i+" : ");
			name = s.nextLine();
			System.out.print("Vvedite cenu tovara №"+i+" : ");
			price = s.nextFloat();
			System.out.print("Vvedite collichestvo tovara №"+i+" : ");
			collichestvo = s.nextInt();
			s.nextLine();

			towars[i-1][0]=name;
			towars[i-1][1]=price;
			towars[i-1][2]=collichestvo;
		}
	}


}