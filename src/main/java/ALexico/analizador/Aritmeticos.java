/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ALexico.analizador;

import ALexico.Token;
import ALexico.Token.Tipo;
import java.util.ArrayList;

/**
 *
 * @author Kenny
 */
public class Aritmeticos {
    private ArrayList<Token> tokens;
    public ArrayList<Aritmeticos> simboloAritmetico = new ArrayList<>();
    private String lexema;
    private Token.Tipo tipo;
    
    
       public Aritmeticos(String lex, Token.Tipo tipo){
        this.lexema=lex;
        this.tipo=tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public Token.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Token.Tipo tipo) {
        this.tipo = tipo;
    }
 

    public Aritmeticos(){
        simboloAritmetico.add(new Aritmeticos("+", Tipo.ARITMETICO_SUMA));
        simboloAritmetico.add(new Aritmeticos("-", Tipo.ARITMETICO_RESTA));
        simboloAritmetico.add(new Aritmeticos("**", Tipo.ARITMETICO_EXPONENTE));
        simboloAritmetico.add(new Aritmeticos("/", Tipo.ARITMETICO_DIVISION));
        simboloAritmetico.add(new Aritmeticos("//", Tipo.ARITMETICO_DIVISION)); //YA
        simboloAritmetico.add(new Aritmeticos("%", Tipo.ARITMETICO_MODULO));
        simboloAritmetico.add(new Aritmeticos("*", Tipo.ARITMETICO_MULTIPLICACION));
        simboloAritmetico.add(new Aritmeticos("==", Tipo.COMPARACION_IGUAL)); // YA
        simboloAritmetico.add(new Aritmeticos("!=", Tipo.COMPARACION_DIFERENTE));//ya
        simboloAritmetico.add(new Aritmeticos(">", Tipo.COMPARACION_MAYOR_QUE));
        simboloAritmetico.add(new Aritmeticos("<", Tipo.COMPARACION_MENOR_QUE));
        simboloAritmetico.add(new Aritmeticos(">=", Tipo.COMPARACION_MAYOR_O_IGUAL_QUE)); //YA
        simboloAritmetico.add(new Aritmeticos("<=", Tipo.COMPARACION_MENOR_O_IGUAL_QUE)); //YA
        simboloAritmetico.add(new Aritmeticos("=", Tipo.ASIGNACION_IGUAL));
        simboloAritmetico.add(new Aritmeticos("*=", Tipo.ASIGNACION_MULTIPLICACION));//MULTIPLICA
        simboloAritmetico.add(new Aritmeticos("-=", Tipo.ASIGNACION_RESTA));//RESTA / ASIGNACION
        simboloAritmetico.add(new Aritmeticos("+=", Tipo.ASIGNACION_SUMA));//SUMA/ ASIGNACION
        simboloAritmetico.add(new Aritmeticos("/=", Tipo.ASIGNACION_DIVISION));//DIVIDE/ ASIGNACION
        simboloAritmetico.add(new Aritmeticos("**=", Tipo.ASIGNACION_EXPONENTE));//EXPONENTE/ ASIGNACION
        simboloAritmetico.add(new Aritmeticos("%=", Tipo.ASIGNACION_MODULO));//MODULO/ ASIGNACION
        simboloAritmetico.add(new Aritmeticos("(", Tipo.PARENTESI_APERTURA));
        simboloAritmetico.add(new Aritmeticos(")", Tipo.PARENTESI_CIERRE));
        simboloAritmetico.add(new Aritmeticos("{", Tipo.LLAVE_APERTURA));
        simboloAritmetico.add(new Aritmeticos("}", Tipo.LLAVE_CIERRE));
        simboloAritmetico.add(new Aritmeticos("[", Tipo.CORCHETE_APERTURA));
        simboloAritmetico.add(new Aritmeticos("]", Tipo.CORCHETE_CIERRE));
        simboloAritmetico.add(new Aritmeticos(",", Tipo.COMA));
        simboloAritmetico.add(new Aritmeticos(".", Tipo.PUNTO));
        simboloAritmetico.add(new Aritmeticos(";", Tipo.PUNTO_COMA));
        simboloAritmetico.add(new Aritmeticos(":", Tipo.DOS_PUNTOS));
        
        
  
    }
    
}

