
package intro_final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//Marlene Morales 11756
//Marisol Hernández 9068

public class Intro_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {

     ArrayList<String> tablas = new ArrayList();
     ArrayList<String> columnas = new ArrayList();
     String tab,col;
     int contArray=0,lastC;
    
     //LEER ARCHIVO .TXT E IDENTIFICAR TABLAS Y COLUMNAS
    try {
        // Abrimos el archivo
	FileInputStream fstream = new FileInputStream("lectur.txt");
	// Creamos el objeto de entrada
	DataInputStream archivo = new DataInputStream(fstream);
	// Creamos el Buffer de Lectura
	BufferedReader br = new BufferedReader(new InputStreamReader(archivo));
	String strLinea;
        
	    // Leer el archivo linea por linea mientras haya aun
               while ((strLinea = br.readLine()) != null) {

               //Si en la linea encuentra ON stu.forum_username = com.forum_username
                     
                    if(strLinea.contains("ON")){
                      //primero separa en el igual
                      StringTokenizer token = new StringTokenizer(strLinea,"=");
                      tab= token.nextToken();
                      String tab2=token.nextToken();
                      //luego en punto cada tabla
                      StringTokenizer token2 = new StringTokenizer(tab,".");
                      tab=token2.nextToken();
                      col=token2.nextToken();
                      StringTokenizer token3 = new StringTokenizer(tab2,".");
                      String tab3=token3.nextToken();
                      String col3=token3.nextToken();
                    
                      
                      //Añadir al arreglo ambas
                      if(tab.equals("ON stu")){
                        tab="STUDENTS";
                        tablas.add(contArray,tab);
                       
                        }
                      columnas.add(contArray,col); 
                      contArray++;
                       
                       
                      if(tab3.equals(" com")){
                        tab3="COMMENTS";
                        tablas.add(contArray,tab3);
                        }
                       
                      columnas.add(contArray,col); 
                       
                      contArray++;
    
                    }
                   
                    //Si en la linea encuentra WHERE
                     if (strLinea.contains("WHERE")){    
                    //añadir valor a los arrays constringtokenizer
                    StringTokenizer token = new StringTokenizer(strLinea,".");    
                
                    tab=token.nextToken();
                    col=token.nextToken();
                    if(tab.equals("WHERE stu")){
                        tab="STUDENTS";
                        tablas.add(contArray,tab);
                        }
                        
                     col=col.substring(0,4);
                     columnas.add(contArray,col); 
                     contArray++;
     
                    }
                                       
                    //si en la linea encuentra stu.
	            if ((strLinea.contains("stu."))&&(strLinea.contains(","))){
                    //añadir valor a los arrays constringtokenizer
                    StringTokenizer token = new StringTokenizer(strLinea,".");    
                    tab=token.nextToken();
                    col=token.nextToken();
                    
                    //quitar coma del String
                    lastC=col.length();
                    col=col.substring(0,lastC-1);
                    columnas.add(contArray,col);   
                    //añade a tablas segun el prefijo 
                        if(tab.equals("stu")){
                        tab="STUDENTS";
                        tablas.add(contArray,tab);
                        }
                        //aumenta contador si se guarda algo en los ArrayList
                        contArray++;
                    }
                    
                    //si en la linea encuentra com.
                    else if ((strLinea.contains("com."))&&(strLinea.contains(","))){
                    //añadir valor a los arrays constringtokenizer
                    StringTokenizer token = new StringTokenizer(strLinea,".");    
                    tab=token.nextToken();
                    col=token.nextToken();
                    
                    //quitar coma del String
                    lastC=col.length();
                    col=col.substring(0,lastC-1);
                    columnas.add(contArray,col);   
                    //añade a tablas segun el prefijo 
                        if(tab.equals("com")){
                        tab="COMMENTS";
                        tablas.add(contArray,tab);
                        }
                        //aumenta contador si se guarda algo en los ArrayList
                        contArray++;
                    }
                    
                    
                                         
        }               
                             	       
	// Cerramos el archivo
	archivo.close();
	} catch (Exception e) { // Catch de excepciones
        System.err.println("Ocurrio un error: " + e.getMessage()); }
                
 //EXCEL
 File archivo = new File("C:\\Users\\Marlene Morales\\Documents\\NetBeansProjects\\intro_final\\archivo.xls");
 BufferedWriter bw;
 bw = new BufferedWriter(new FileWriter(archivo));
 
 if(archivo.exists()) {
//escribe encabezados de la tabla
bw.write("TABLA");
bw.write("\t"); //pasamos a la siguiente columna
bw.write("COLUMNA");


//escribir la info con ciclo segun el tamaño del ArrayList
 for(int i=0;i<tablas.size();i++){
bw.write("\n"); //pasamos a la siguiente fila
bw.write(tablas.get(i));
bw.write("\t"); //pasamos a la siguiente columna
bw.write(columnas.get(i));

 }
}
bw.close(); 
   
}
}


    
    

