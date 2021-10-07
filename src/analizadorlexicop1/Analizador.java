/*

NUMERO        1            2           3           4            5            6           7         8
TOKEN   IDENTIFICADOR    NUMERO     DECIMAL    PUNTUACION    OPERADOR    AGRUPACION    ERROR    ESPACIOsalto
 
    lista de tokens
    ESTABLECER SALTO DE LINEA
    analisis    matriz del automata
    ESTABLECE EN LA MATRIZ EL NUMERO EN EL SALTO DE LINEA Y QUE NO LA IGNORE  
    AGREGAR VARIABLE PARA ESCRIBIR ... SALTO DE LINEA?
    SACAR ERRORES PARA LA PRIMERA TEXTAREA
    LECTURA DE LINEA LUEGO DEL SALTO DE LINEA QUE DA UN NUMERO Y UN ESPACIO
    PARA EL DECIMAL LEER LA LINEA Y SI YA HAY UN PUNTO QUE TIRE ERROR
*/
package analizadorlexicop1;

import java.util.ArrayList;

    /**
     *
     * @author orcha
     */

public class Analizador {
    //variables
    ArrayList<tokensLexemas> listaTokensLexemas = new ArrayList();
    
    
    //constructores
    public Analizador(ArrayList<tokensLexemas> listaTokensLexemas){
        this.listaTokensLexemas = listaTokensLexemas;
    }
    
    
    //metodos
    //analizar
    public void analizar(String cadena){
        String[] texto = separadorLineas(cadena, '\n');         //salto da fin en la ultima linea se debe dar salto de linea
        String tipoToken = "";
        int numeroToken = 0;
        String expresion = "";
        int estado = 0;
        
        for (int i = 0; i < texto.length; i++) {            //lee linea         
            for (int j = 0; j < texto[i].length(); j++) {   //lee caracter      
                int valorAsciiActual;         
                int valorAsciiSiguiente = -1;     //para la deteccion de errores antes de que termine el token valido
                valorAsciiActual = texto[i].codePointAt(j); //obteniendo la posicion del caracter en ascii
                
                //  0123
                //  hola            hola8
                
                if (estado == 0) {
                    estado = caracter(valorAsciiActual);    //el estado reconoce con que caracter empieza
                }
                
                try {
                    valorAsciiSiguiente = texto[i].codePointAt(j+1);    //posicion siguiente en ascii
                } catch(Exception e){
                    
                }
                
                //superAUTOMATA 
                switch(estado){
                    /*case 1:
                    break;*/
                    case 1:
                        expresion = expresion + texto[i].charAt(j);       //1 caracter
                        if ((valorAsciiSiguiente >= 97 && valorAsciiSiguiente <= 122) || (valorAsciiSiguiente >= 65 && valorAsciiSiguiente <= 90)) {  //letra
                            estado = 1;//abecedario mayusculas minusculas
                            
                        } else if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 1;
                            
                        } else if (valorAsciiSiguiente == 46 || valorAsciiSiguiente == 44 || valorAsciiSiguiente == 58 || valorAsciiSiguiente == 59) {
                            estado = 7;           //puntuacion   . , : ;
            
                        } else if (valorAsciiSiguiente == 43 || valorAsciiSiguiente == 45 || valorAsciiSiguiente == 42 || valorAsciiSiguiente == 47 || valorAsciiSiguiente == 37) {
                            estado = 7;            //operador     + - * / %

                        } else if (valorAsciiSiguiente == 40 || valorAsciiSiguiente == 41 || valorAsciiSiguiente == 91 || valorAsciiSiguiente == 93 || valorAsciiSiguiente == 123 || valorAsciiSiguiente == 125) {
                            estado = 7;            //agrupacion     ()  []  {}

                        } else {
                            numeroToken = 1;
                            tipoToken = "IDENTIFICADOR";
                            estado = 0;
                        }
                    break;
                    
                    case 2:
                        expresion = expresion + texto[i].charAt(j);       //1 caracter
                        if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 2;
                            
                        } else if ((valorAsciiSiguiente >= 97 && valorAsciiSiguiente <= 122) || (valorAsciiSiguiente >= 65 && valorAsciiSiguiente <= 90)) {  //letra
                            estado = 7;//abecedario mayusculas minusculas
                            
                        } else if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 2;
                            
                        } else if (/*valorAsciiSiguiente == 46 || */valorAsciiSiguiente == 44 || valorAsciiSiguiente == 58 || valorAsciiSiguiente == 59) {
                            estado = 7;           //puntuacion   [.] , : ;
            
                        } else if (valorAsciiSiguiente == 43 || valorAsciiSiguiente == 45 || valorAsciiSiguiente == 42 || valorAsciiSiguiente == 47 || valorAsciiSiguiente == 37) {
                            estado = 7;            //operador     + - * / %

                        } else if (valorAsciiSiguiente == 40 || valorAsciiSiguiente == 41 || valorAsciiSiguiente == 91 || valorAsciiSiguiente == 93 || valorAsciiSiguiente == 123 || valorAsciiSiguiente == 125) {
                            estado = 7;            //agrupacion     ()  []  {}

                        } else {
                            numeroToken = 2;
                            tipoToken = "NUMERO";
                            estado = 0;
                        }
                    break;

                    /*case 3:                   //ESPACIO PARA PLANIFICAR DECIMALES
                    
                    break;*/
                    
                    case 4:
                        expresion = expresion + texto[i].charAt(j);       //1 caracter
                        if (valorAsciiSiguiente == 46 || valorAsciiSiguiente == 44 || valorAsciiSiguiente == 58 || valorAsciiSiguiente == 59) {  //PUNTUACION
                            estado = 4;
                            
                        } else if ((valorAsciiSiguiente >= 97 && valorAsciiSiguiente <= 122) || (valorAsciiSiguiente >= 65 && valorAsciiSiguiente <= 90)) {  //letra
                            estado = 7;//abecedario mayusculas minusculas
                            
                        } else if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 7;
                            
                        } else if (valorAsciiSiguiente == 46 || valorAsciiSiguiente == 44 || valorAsciiSiguiente == 58 || valorAsciiSiguiente == 59) {
                            estado = 4;           //puntuacion   . , : ;
            
                        } else if (valorAsciiSiguiente == 43 || valorAsciiSiguiente == 45 || valorAsciiSiguiente == 42 || valorAsciiSiguiente == 47 || valorAsciiSiguiente == 37) {
                            estado = 7;            //operador     + - * / %

                        } else if (valorAsciiSiguiente == 40 || valorAsciiSiguiente == 41 || valorAsciiSiguiente == 91 || valorAsciiSiguiente == 93 || valorAsciiSiguiente == 123 || valorAsciiSiguiente == 125) {
                            estado = 7;            //agrupacion     ()  []  {}

                        } else {
                            numeroToken = 4;
                            tipoToken = "PUNTUACION";
                            estado = 0;
                        }
                    break;
                    
                    case 5:
                        expresion = expresion + texto[i].charAt(j);       //1 caracter
                        if (valorAsciiSiguiente == 43 || valorAsciiSiguiente == 45 || valorAsciiSiguiente == 42 || valorAsciiSiguiente == 47 || valorAsciiSiguiente == 37) {  //OPERADORES
                            estado = 5;
                            
                        } else if ((valorAsciiSiguiente >= 97 && valorAsciiSiguiente <= 122) || (valorAsciiSiguiente >= 65 && valorAsciiSiguiente <= 90)) {  //letra
                            estado = 7;//abecedario mayusculas minusculas
                            
                        } else if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 7;
                            
                        } else if (valorAsciiSiguiente == 46 || valorAsciiSiguiente == 44 || valorAsciiSiguiente == 58 || valorAsciiSiguiente == 59) {
                            estado = 7;           //puntuacion   . , : ;
            
                        } else if (valorAsciiSiguiente == 43 || valorAsciiSiguiente == 45 || valorAsciiSiguiente == 42 || valorAsciiSiguiente == 47 || valorAsciiSiguiente == 37) {
                            estado = 5;            //operador     + - * / %

                        } else if (valorAsciiSiguiente == 40 || valorAsciiSiguiente == 41 || valorAsciiSiguiente == 91 || valorAsciiSiguiente == 93 || valorAsciiSiguiente == 123 || valorAsciiSiguiente == 125) {
                            estado = 7;            //agrupacion     ()  []  {}

                        } else {
                            numeroToken = 5;
                            tipoToken = "OPERADOR";
                            estado = 0;
                        }
                    break;
                    
                    case 6:
                        expresion = expresion + texto[i].charAt(j);       //1 caracter
                        if (valorAsciiSiguiente == 40 || valorAsciiSiguiente == 41 || valorAsciiSiguiente == 91 || valorAsciiSiguiente == 93 || valorAsciiSiguiente == 123 || valorAsciiSiguiente == 125) {  //AGRUPACION
                            estado = 6;
                            
                        } else if ((valorAsciiSiguiente >= 97 && valorAsciiSiguiente <= 122) || (valorAsciiSiguiente >= 65 && valorAsciiSiguiente <= 90)) {  //letra
                            estado = 7; //abecedario mayusculas minusculas
                            
                        } else if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 7;     //digito
                            
                        } else if (valorAsciiSiguiente == 46 || valorAsciiSiguiente == 44 || valorAsciiSiguiente == 58 || valorAsciiSiguiente == 59) {
                            estado = 7;           //puntuacion   . , : ;
            
                        } else if (valorAsciiSiguiente == 43 || valorAsciiSiguiente == 45 || valorAsciiSiguiente == 42 || valorAsciiSiguiente == 47 || valorAsciiSiguiente == 37) {
                            estado = 7;            //operador     + - * / %

                        } else if (valorAsciiSiguiente == 40 || valorAsciiSiguiente == 41 || valorAsciiSiguiente == 91 || valorAsciiSiguiente == 93 || valorAsciiSiguiente == 123 || valorAsciiSiguiente == 125) {
                            estado = 6;            //agrupacion     ()  []  {}

                        } 
                        else {
                            numeroToken = 6;
                            tipoToken = "AGRUPACION";
                            estado = 0;
                        }
                    break;
                    
                    case 7:   
                        expresion = String.valueOf(texto[i].charAt(j));   //char a string
                        numeroToken = 7;
                        tipoToken = "ERROR";
                        estado = 0;
                    break;

                    case 8:
                        estado = 8;
                    break;
                }//fin switch
                
                if (estado == 0) {
                    listaTokensLexemas.add(new tokensLexemas(expresion, tipoToken, numeroToken, i+1, j+1));
                    expresion = ""; //reset
                }
                
                if (estado == 8) {
                    estado = 0; //ignorando espacios y saltos
                }
                
            }//fin forCaracter
            
        }//fin forLinea
        
    }//fin analizar
    
    
    
    
    
    
    
    //ALFABETO    POSICION   TABLA ASCII                RECORDAR=>CODEPOINTAT
    public  int caracter(int posicionAscii){//primer caracter
        //(minusculas ASCII 97-122       o       mayusculas ASCII 65-90)
        if ((posicionAscii >= 97 && posicionAscii <= 122) || (posicionAscii >= 65 && posicionAscii <= 90)) {
            return 1;//abecedario
            
        }   else if (posicionAscii >= 48 && posicionAscii <= 57) {      //numeros ascii
            return 2;           //numeros 0-9
            
        }   else if (posicionAscii == 46 || posicionAscii == 44 || posicionAscii == 58 || posicionAscii == 59) {
            return 4;           //puntuacion   . , : ;
            
        }   else if (posicionAscii == 43 || posicionAscii == 45 || posicionAscii == 42 || posicionAscii == 47 || posicionAscii == 37) {
            return 5;           //operador     + - * / %
            
        }   else if (posicionAscii == 40 || posicionAscii == 41 || posicionAscii == 91 || posicionAscii == 93 || posicionAscii == 123 || posicionAscii == 125) {
            return 6;           //agrupacion     ()  []  {}
            
        }   else if (posicionAscii == 32 || posicionAscii == 10) {        
            return 8;         //espacio y salto de linea
        
        }else {
            return 7;       //ERROR
        }
        
    }//fin establecerAlfabeto
    
    
    
    
    
    
    
    
    //salto de linea y concatenaciones
    //SE TIENE QUE DAR UN SALTO DE LINEA AL FINAL PARA QUE RECONOZCA LA LINEA ACTUAL Y SE DEBE IGNORAR...
    //...EL ANALISIS DE UN SALTO DE LINEA
    public String[] separadorLineas(String palabra, char salto){            //cadena y \n   ...y numero?
        String linea = "";
        int contador = 0;

        for (int i = 0; i < palabra.length(); i++) {            //    \n
            if (palabra.charAt(i) == salto) {                   //saltos             NUMERO LINEA? CUENTALINEA
                contador++;                   
            }
        }//fin forSalto
        
        String[] cadenas = new String[contador];                
        contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != salto) {
                linea += String.valueOf(palabra.charAt(i));      //concatenaciones       palabra a palabraFinal
            
            } else{
                cadenas[contador] = linea;          //palabraFinal a textoFinal
                contador++;
                linea = "";
            }
        }//fin forLectura
        
        return cadenas;             //en texto final de palabra
        
    }//fin separadorLineas 
    
    
}//fin clase
