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
    //PARA EL DECIMAL LEER LA LINEA Y SI YA HAY UN PUNTO QUE TIRE ERROR
    
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
                
                valorAsciiSiguiente = texto[i].codePointAt(j+1);    //posicion siguiente en ascii
                
                
                //superAUTOMATA 
                switch(estado){
                    /*case 1:
                    break;*/
                    case 1:
                        expresion = expresion + texto[i].charAt(j);       //1 caracter
                        if ((valorAsciiSiguiente >= 97 && valorAsciiSiguiente <= 122) || (valorAsciiSiguiente >= 65 && valorAsciiSiguiente <= 90)) {  //letra
                            estado = 1;
                            
                        } else if (valorAsciiSiguiente >= 48 && valorAsciiSiguiente <= 57) {  //digito
                            estado = 1;
                            
                        } else {
                            numeroToken = 1;
                            tipoToken = "IDENTIFICADOR";
                            estado = 0;
                        }
                    break;
                    
                    
                    
                        
                }//fin switch
                
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
