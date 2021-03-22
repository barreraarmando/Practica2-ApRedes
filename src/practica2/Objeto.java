/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2;
import java.io.*;
/**
 *
 * @author Rodrigo
 */
class Objeto implements Serializable{
    String categoria;
    String[] palabras;
    char[][] matriz;
    
    Objeto(String categoria, String[] palabras, char[][] matriz){
            this.categoria = categoria;
            this.palabras = palabras;
            this.matriz = matriz;
    }

    public String getCategoria() {
        return categoria;
    }

    public String[] getPalabras() {
        return palabras;
    }

    public char[][] getMatriz() {
        return matriz;
    }
}
