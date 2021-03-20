/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Rodrigo
 */
public class SPractica2 {

    public static char[][] llenarMatriz(char[][] matriz, String[] palabras){
        
        
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
        
        String[][] categorias = {animales, escuela, deportes, casa};
        String[] categoriasS = {"animales", "escuela", "deportes", "casa"};
        int letrasEnviadas = 15;
        int randIndex = ThreadLocalRandom.current().nextInt(0, 4);
        String[] categoria = categorias[randIndex];
        String categoriaS = categoriasS[randIndex];
        String[] palabras = new String[letrasEnviadas];
        
        int i = 0;
        int[] palabraI = new int[letrasEnviadas];
        while(i<15){
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
      
    }
    
}
