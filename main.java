import java.util.Scanner;

public class main{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int colTovars;
		StringBuilder name;
		float price;
		int collichestvo;
		byte vybor;

		System.out.print("Vvedite collichestvo tovarov v vashey aptece: ");
		colTovars = s.nextInt();
		s.nextLine();
		Object[][] towars = new Object[colTovars][3];

		for (int i = 1;i<=colTovars;i++) {
			
			System.out.print("Vvedite imya tovara №"+i+" : ");
			name = new StringBuilder(s.nextLine());
			System.out.print("Vvedite cenu tovara №"+i+" : ");
			price = s.nextFloat();
			if(price<0){
				System.out.println("Cena tovara ne mojet byt otrecacelnoy.");
				i--;
				s.nextLine();
				continue;
			}
			System.out.print("Vvedite collichestvo tovara №"+i+" : ");
			collichestvo = s.nextInt();
			s.nextLine();
			if(collichestvo<0){
				System.out.println("Collichestvo tovara ne mojet byt otrecacelnoy.");
				i--;
				continue;
			}

			towars[i-1][0]=name;
			towars[i-1][1]=price;
			towars[i-1][2]=collichestvo;
		}

		for(;true;){
			System.out.println("/-------------------------------------------/");

			System.out.println("Dlya vyhoda iz programmy vvedite 0");
			System.out.println("Dlya poiska towara vvedite 1");
			System.out.println("Dlya udaleniya towara vvedite 2");
			System.out.println("Dlya prosmotra ostatkov towara na sklade vvedite 3");
			System.out.println("Dlya prodajy towara vvedite 4");
		
			System.out.println("/-------------------------------------------/");
			System.out.print(">>> ");
			vybor = s.nextByte();
			s.nextLine();

			if(vybor==1){
				System.out.println("/-------------------------------------------/");
		
				System.out.println("Dlya poiska tovara po nazvaniyu vvedite 1");
				System.out.println("Dlya poiska tovara po cene vvedite 2");
				System.out.println("Dlya poiska tovara po collichestvu vvedite 3");
				System.out.println("/-------------------------------------------/");

				System.out.print(">>> ");
				vybor = s.nextByte();
				s.nextLine();

				poisk(towars, vybor, s);

			}else if(vybor==2){
				dellTowar(towars, s);
			}else if(vybor==0){
				break;
			}else if(vybor==3){
				ostatok(towars);
			}else if(vybor==4){
				sell(towars, s);
			}
		}

	}

	static StringBuilder namePoisk;
	static float pricePoisk;
	static int collichestvoPoisk;

	public static void poisk(Object spisoc[][], byte vybor, Scanner s){

		int sovpodeniya = 0;
		
		System.out.println("/-------------------------------------------/");
		if(vybor==1){

			System.out.print("Vvedite nazvaniye iskomogo tovara: ");
			namePoisk = new StringBuilder(s.nextLine());

			System.out.println("Nachalo poisca.");

			for (int i=0;i<spisoc.length;i++ ) {



				if((namePoisk.toString()).equals(spisoc[i][0].toString())){

					System.out.println("Nazvaniye: "+spisoc[i][0]+"    Cena: "+spisoc[i][1]+"    Collicestco: "+spisoc[i][2]);
					sovpodeniya++;
				}
			
			}

			System.out.println("konec poisca. Naydeno sovpodeniy: "+sovpodeniya);

		}else if(vybor==2){

			System.out.print("Vvedite cenu iskomogo tovara: ");
			pricePoisk = s.nextFloat();
			s.nextLine();

			System.out.println("Nachalo poisca.");

			for (int i=0;i<spisoc.length;i++ ) {



				if((float)spisoc[i][1]==pricePoisk){

					System.out.println("Nazvaniye: "+spisoc[i][0]+"    Cena: "+spisoc[i][1]+"    Collicestco: "+spisoc[i][2]);
					sovpodeniya++;
				}
			
			}

			System.out.println("konec poisca. Naydeno sovpodeniy: "+sovpodeniya);

		}else if(vybor==3){

			System.out.print("Vvedite collichestvo iskomogo tovara: ");
			collichestvoPoisk = s.nextInt();
			s.nextLine();

			System.out.println("Nachalo poisca.");

			for (int i=0;i<spisoc.length;i++ ) {



				if((int)spisoc[i][2]==collichestvoPoisk){

					System.out.println("Nazvaniye: "+spisoc[i][0]+"    Cena: "+spisoc[i][1]+"    Collicestco: "+spisoc[i][2]);
					sovpodeniya++;
				}
			
			}

			System.out.println("konec poisca. Naydeno sovpodeniy: "+sovpodeniya);

		}
		

	}

	public static void dellTowar(Object spisoc[][], Scanner s){

		for(int i=0;i<spisoc.length;i++){
			if(("sedrtfyghj8764".toString()).equals(spisoc[i][0].toString())){
				continue;
			}

			System.out.println("Towar №"+(i+1)+": "+spisoc[i][0]);
		}

		System.out.println("/-------------------------------------------/");
		System.out.print("Vvedite nazvanie towara dlya ego udaleniya: ");
		namePoisk = new StringBuilder(s.nextLine());

		for(int i=0;i<spisoc.length;i++){
			
			if((namePoisk.toString()).equals(spisoc[i][0].toString())){
				System.out.println("Towar "+spisoc[i][0]+" udalen");
				spisoc[i][0]="sedrtfyghj8764";
				spisoc[i][1]=0;
				spisoc[i][2]=0;
			}
		}



	}

	public static void ostatok(Object spisoc[][]){
		for (int i=0;i<spisoc.length;i++){

			if ((int)spisoc[i][2]>0) {

				System.out.println("Nazvaniye: "+spisoc[i][0]+"    Cena: "+spisoc[i][1]+"    Collicestco: "+spisoc[i][2]);

			}
			
		}
	}

	public static void sell(Object spisoc[][], Scanner s){

		for (int i=0;i<spisoc.length;i++){

			if (!("sedrtfyghj8764".toString()).equals(spisoc[i][0].toString())) {

				System.out.println("Nazvaniye: "+spisoc[i][0]+"    Cena: "+spisoc[i][1]+"    Collicestco: "+spisoc[i][2]);

			}
			
		}

		System.out.println("/-------------------------------------------/");
		System.out.print("Vvedite nazvanie towara dlya ego prodaji: ");
		namePoisk=new StringBuilder(s.nextLine());

		System.out.println("/-------------------------------------------/");
		System.out.print("Skolko shtuk hotite prodat: ");
		collichestvoPoisk = s.nextInt();
		s.nextLine();

		if(collichestvoPoisk>0){

			for (int i=0;i<spisoc.length;i++){


				if ((namePoisk.toString()).equals(spisoc[i][0].toString())) {

					if((((int)spisoc[i][2])-collichestvoPoisk)<0){
						System.out.println("Vy ne mojete prodaty bolse chem esty na sklade");
						break;
					}

					spisoc[i][2]=(int)spisoc[i][2]-collichestvoPoisk;

					System.out.println("Vy prodali "+spisoc[i][0]+". "+collichestvoPoisk+" shtuc. Po cene "+spisoc[i][1]);
					System.out.println("Summa poluchenyh deneg sostavlaet "+(collichestvoPoisk*(float)spisoc[i][1]));
					break;

				}
			}

		}else{
			System.out.println("Vy ne mojete prodat otricacelnoe znachenie.");
		}

	}


}
