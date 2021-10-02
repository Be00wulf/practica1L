/*

NUMERO        1            2           3           4            5            6           7         8
TOKEN   IDENTIFICADOR    NUMERO     DECIMAL    PUNTUACION    OPERADOR    AGRUPACION    ERROR    ESPACIO
 
*/
package analizadorlexicop1;

/**
 *
 * @author orcha
 */

public class Analizador {
    //lista de tokens
    
    
    //ESTABLECER SALTO DE LINEA
    //metodos
    //analisis    matriz del automata
    //ESTABLECE EN LA MATRIZ EL NUMERO EN EL SALTO DE LINEA Y QUE NO LA IGNORE  
    //AGREGAR VARIABLE PARA ESCRIBIR ... SALTO DE LINEA?
    //SACAR ERRORES PARA LA PRIMERA TEXTAREA
    //LECTURA DE LINEA LUEGO DEL SALTO DE LINEA QUE DA UN NUMERO Y UN ESPACIO
    
    
    public void analizar(String cadena){
        String[] texto = separadorLineas(cadena, '\n');         //salto da fin en la ultima linea se debe dar salto de linea
        String tipoToken = "";
        int numeroToken = 0;
        String lexema = "";
        int estado = 0;
        
        for (int i = 0; i < texto.length; i++) {            //lee linea         
            for (int j = 0; j < texto[i].length(); j++) {   //lee caracter      
                int actual;
                int siguiente = -1;
                
                //  0123
                //  hola
                
                
                
                
                
            }//fin forCaracter
            
        }//fin forLinea
        
    }//fin analizar
    
    
    
    
    
    
    
    //ALFABETO   LEXEMAS    POSICION   ASCII                RECORDAR=>CODEPOINTAT
    public  int caracter(int posicionAscii){
        //(minusculas ASCII 97-122       o       mayusculas ASCII 65-90)
        if ((posicionAscii >= 97 && posicionAscii <= 122) || (posicionAscii >= 65 && posicionAscii <= 90)) {
            return 1;//identificador
            
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
