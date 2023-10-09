/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ALexico.analizador;

import ALexico.Token;
import java.util.ArrayList;

/**
 *
 * @author Kenny
 */
public class Constantes {
     private ArrayList<Token> tokens;
    public ArrayList<Constantes> constantes = new ArrayList<>();
    private String lexema;
    private Token.Tipo tipo;
    
    
       public Constantes(String lex, Token.Tipo tipo){
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
 

    public Constantes(){
        
    }
}

