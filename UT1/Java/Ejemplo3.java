package UT1.Java;
import java.io.*;

public class Ejemplo3 {
  public static void main(String[] args) throws IOException {

    String path = "C:\\Users\\jdueñas\\AppData\\Roaming\\Code\\User\\workspaceStorage\\599dcab3301e6bba8ae7f221e54cf707\\redhat.java\\jdt_ws\\PSP-2223_2b93cb96\\bin\\";
	//creamos objeto File al directorio donde esta Ejemplo2
	File directorio = new File(path);	

	//El proceso a ejecutar es Ejemplo2			
	ProcessBuilder pb = new ProcessBuilder("java", "UT1.Java.Ejemplo2");

    //se establece el directorio donde se encuentra el ejecutable
    pb.directory(directorio);
        
	System.out.printf("Directorio de trabajo: %s%n",pb.directory());

    //se ejecuta el proceso
	Process p = pb.start();

   //obtener la salida devuelta por el proceso
	try {
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
		is.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
  }
}// Ejemplo3
