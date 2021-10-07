/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexicop1;

/**
 *
 * @author orcha
 */
public class tokensLexemas {
    //variabels
    private String palabra;
    private String nombreDelToken;
    private int lexema;
    private int fila;
    private int columna;
    
    
    //constructor
    public tokensLexemas(String palabra, String nombreDelToken, int lexema, int fila, int columna) {
        this.palabra = palabra;
        this.nombreDelToken = nombreDelToken;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        
    }//fin del constructor
    
    
    //constructor vacio
    public tokensLexemas(){
        
    }//fin del constructor vacio
    
    
    //getters-setters
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getNombreDelToken() {
        return nombreDelToken;
    }

    public void setNombreDelToken(String nombreDelToken) {
        this.nombreDelToken = nombreDelToken;
    }

    public int getLexema() {
        return lexema;
    }

    public void setLexema(int lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
        
    //to string
    @Override
    public String toString() {
        return "Palabra: " + palabra + ",     Tipo de Token: " + nombreDelToken + ",     Lexema: " + lexema + ",     Fila: " + fila + ",     Columna: " + columna;
    }
    
    
    

    
}//fin de la clase
