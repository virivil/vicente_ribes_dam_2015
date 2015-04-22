
public class CriptoCesar {

	public static void main(String[] args) {

		String sms = ("mensaje que quiero encriptar"); //texto a encriptar, solo minusculas y sin acentos.
		int k = 6 ; //incremento
		String abc = ("abcdefghijklmnñopqrstuwxyz ,.");
		char [] SMS;
		char [] ABC = new char [29]; //abecedario
		char [] XYZ = new char [29]; // abecedario encriptado

		

		
		//metodo para convertir string en char directo.
		
		SMS = sms.toCharArray();
		ABC = abc.toCharArray();


		
		//metodo para convertir string en char con incremento.
		
		for (int i=0;i<abc.length()-k;i++)
		{  
			
			XYZ [i]= abc.charAt(k+i);
			//System.out.println(i);
		};
		
		
		

		for (int j=k ;j>0;j--)
		{  //System.out.println(abc.length()-j);
			XYZ [abc.length()-j] = abc.charAt(k-j);
			
		};
		
		System.out.println(ABC);
		System.out.println(XYZ);
		
		// comparo cada caracter del mensaje fuente con el abecedario para saber su posición.
		
		
		System.out.println("Mensaje fuente:"+sms);

		System.out.println("Mensaje encriptado:");

		int h=0;

		
		
		for (int i=0;i<sms.length();i++)
		{  while (SMS [i] != ABC [h]) {
			h++;
			//System.out.print ( ABC[h-1]);
			//System.out.print ( i);

			
			};
			 System.out.print ( XYZ[h]);
			 h=0;
		};
		
	}
	
}
