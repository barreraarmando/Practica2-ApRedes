/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
/**
 *
 * @author Rodrigo
 */
public class SPractica2 {

    public static char[][] llenarMatriz(char[][] matriz, String[] palabras){
        Random r = new Random();
        int[][] ocupacion = new int[15][15];
        
        for (int i =0; i<15; i++){
            for (int j=0; j<15; j++){
                matriz[i][j] = (char)(r.nextInt(26) +97);
            }
        }
        for (int i =0; i<15; i++){
            for (int j=0; j<15; j++){
                ocupacion[i][j] = 0;
            }
        }
        
        //Colocar palabras en la matriz
        for(String palabra:palabras){
            System.out.println(palabra);
            char[] palabraC = palabra.toCharArray();
            int tam = palabraC.length;
            boolean flag = true;
            
            while (flag == true){
                int iR = r.nextInt(15);
                int jR = r.nextInt(15);
                
                if (jR + tam < 15){
                    //Diagonal hacia arriba
                    if (iR + tam < 15){
                        for (int i=0; i<tam; i++){
                            if(ocupacion[iR+i][jR+i] == 0 || matriz[iR+i][jR+i] == palabraC[i]){
                                flag = false; 
                            }else{
                                flag = true;
                                break;
                            }       
                        }
                        if(flag == false){
                            for (int i=0; i<tam; i++){
                                ocupacion[iR+i][jR+i] = 1;
                                matriz[iR+i][jR+i] = palabraC[i];
                            }
                        }
                    //Diagonal hacia abajo
                    }else if(iR - tam > 0){
                        for (int i=0; i<tam; i++){
                            if(ocupacion[iR-i][jR+i] == 0 || matriz[iR-i][jR+i] == palabraC[i]){
                                flag = false; 
                            }else{
                                flag = true;
                                break;
                            }       
                        }
                        if(flag == false){
                            for (int i=0; i<tam; i++){
                                ocupacion[iR-i][jR+i] = 1;
                                matriz[iR-i][jR+i] = palabraC[i];
                            }
                        }
                    //Recta a la derecha
                    }else{
                        for (int i=0; i<tam; i++){
                            if(ocupacion[iR][jR+i] == 0 || matriz[iR][jR+i] == palabraC[i]){
                                flag = false; 
                            }else{
                                flag = true;
                                break;
                            }       
                        }
                        if(flag == false){
                            for (int i=0; i<tam; i++){
                                ocupacion[iR][jR+i] = 1;
                                matriz[iR][jR+i] = palabraC[i];
                            }
                        }
                    }
                //Hacia abajo
                }else if(iR + tam < 15){
                    for (int i=0; i<tam; i++){
                        if(ocupacion[iR+i][jR] == 0 || matriz[iR+i][jR] == palabraC[i]){
                            flag = false; 
                        }else{
                            flag = true;
                            break;
                        }       
                    }
                    if(flag == false){
                        for (int i=0; i<tam; i++){
                            ocupacion[iR+i][jR] = 1;
                            matriz[iR+i][jR] = palabraC[i];
                        }
                    }
                //Sentido inverso
                }else if (jR - tam > 0){
                    //Diagonal hacia arriba
                    if (iR + tam < 15){
                        for (int i=0; i<tam; i++){
                            if(ocupacion[iR+i][jR-i] == 0 || matriz[iR+i][jR-i] == palabraC[i]){
                                flag = false; 
                            }else{
                                flag = true;
                                break;
                            }       
                        }
                        if(flag == false){
                            for (int i=0; i<tam; i++){
                                ocupacion[iR+i][jR-i] = 1;
                                matriz[iR+i][jR-i] = palabraC[i];
                            }
                        }
                    //Diagonal hacia abajo
                    }else if(iR - tam > 0){
                        for (int i=0; i<tam; i++){
                            if(ocupacion[iR-i][jR-i] == 0 || matriz[iR-i][jR-i] == palabraC[i]){
                                flag = false; 
                            }else{
                                flag = true;
                                break;
                            }       
                        }
                        if(flag == false){
                            for (int i=0; i<tam; i++){
                                ocupacion[iR-i][jR-i] = 1;
                                matriz[iR-i][jR-i] = palabraC[i];
                            }
                        }
                    //Recta a la izquierda
                    }else{
                        for (int i=0; i<tam; i++){
                            if(ocupacion[iR][jR-i] == 0 || matriz[iR][jR-i] == palabraC[i]){
                                flag = false; 
                            }else{
                                flag = true;
                                break;
                            }       
                        }
                        if(flag == false){
                            for (int i=0; i<tam; i++){
                                ocupacion[iR][jR-i] = 1;
                                matriz[iR][jR-i] = palabraC[i];
                            }
                        }
                    }
                //Hacia arriba
                }else if (iR - tam > 0){
                    for (int i=0; i<tam; i++){
                        if(ocupacion[iR-i][jR] == 0 || matriz[iR-i][jR] == palabraC[i]){
                            flag = false; 
                        }else{
                            flag = true;
                            break;
                        }       
                    }
                    if(flag == false){
                        for (int i=0; i<tam; i++){
                            ocupacion[iR-i][jR] = 1;
                            matriz[iR-i][jR] = palabraC[i];
                        }
                    }
                }
               
            }
            
        }
        
        //Imprimir
        for (int i =0; i<15; i++){
            for (int j=0; j<15; j++){
                char letra = matriz[i][j];
                if (ocupacion[i][j] == 1){
                    letra = (char) (letra & 0x5f);
                }
                System.out.print(letra + " ");
            }
            System.out.println("");
        }
        
        return matriz;
    }
    
    public static void main(String[] args) {
        
        char[][] matriz = new char[15][15];
        String[] animales = {"perro", "gato", "abeja", "ballena", "burro",
                            "camello", "caracol", "cerdo", "ciervo", "elefante",
                            "cisne", "foca", "gallina", "hormiga", "jirafa", 
                            "mosca", "oso", "oveja", "pollo", "serpiente"};
        String[] escuela = {"mochila", "libro", "librero", "recreo", "cafeteria",
                            "calculadora", "pizarron", "clase", "computadora", "lapiz",
                            "goma", "escritorio", "diploma", "pegamento", "gimnasio",
                            "tarea", "laboratorio", "biblioteca", "pluma", "profesor"};
        String[] deportes = {"uniforme", "balon", "canasta", "arbitro", "silbato",
                            "bicicleta", "casco", "agua", "meta", "raqueta", 
                            "pelota", "pasto", "porteria", "red", "jugada",
                            "portero", "tenis", "futbol", "basquetbol", "beisbol"};
        String[] casa = {"alacena", "regadera", "alfombra", "almohada", "armario",
                        "aspiradora", "foco", "cama", "lampara", "cazuela",
                        "cepillo", "champu", "colchon", "cortina", "tenedor",
                        "cuchara", "cuchillo", "escoba", "espejo", "flor"};
        
        try{
            String[][] categorias = {animales, escuela, deportes, casa};
            String[] categoriasS = {"animales", "escuela", "deportes", "casa"};
            int letrasEnviadas = 15;
        
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Servidor iniciado");
            
            for(;;){
                int randIndex = ThreadLocalRandom.current().nextInt(0, 4);
                String[] categoria = categorias[randIndex];
                String categoriaS = categoriasS[randIndex];
                String[] palabras = new String[letrasEnviadas];
        
                int i = 0;
                int[] palabraI = new int[letrasEnviadas];
                while(i<letrasEnviadas){
                    int randI = ThreadLocalRandom.current().nextInt(0, categoria.length);
                    boolean flag = true;
                    for (int j =0; j<palabraI.length; j++){
                        if (palabraI[j] == randI){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        palabras[i] = categoria[randI];
                        palabraI[i] = randI;
                        i++;
                    }
                }

                matriz = llenarMatriz(matriz, palabras);
                Objeto ob = new Objeto(categoriaS, palabras, matriz);
                
                Socket cl = ss.accept();
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(cl.getInputStream()));
                
                oos.writeObject(ob);
                oos.flush();
                System.out.println("Cliente conectado.. Enviando objeto " );
                
                long tiempoMandar = System.currentTimeMillis();
                String flagGanar = br.readLine();
                long tiempoRecibir = System.currentTimeMillis();
                long tiempoTotal = (tiempoRecibir - tiempoMandar)/1000;
                String tiempoDevolver = Long.toString(tiempoTotal);
                pw.println(tiempoDevolver);
                pw.flush();
                    
            }//for
            
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
    
}
