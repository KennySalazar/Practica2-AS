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
public class PalabrasReservadas {

    private ArrayList<Token> tokens;
    public ArrayList<PalabrasReservadas> palabraClave = new ArrayList<>();
    private String lexema;
    private Tipo tipo;
 


    public PalabrasReservadas(String lex, Tipo tipo){
        this.lexema=lex;
        this.tipo=tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public PalabrasReservadas(){
      
        palabraClave.add(new PalabrasReservadas("as",Tipo.PALABRA_RESERVADA_AS));
        palabraClave.add(new PalabrasReservadas("assert",Tipo.PALABRA_RESERVADA_ASSERT));
        palabraClave.add(new PalabrasReservadas("break",Tipo.PALABRA_RESERVADA_BREAK));
        palabraClave.add(new PalabrasReservadas("class",Tipo.PALABRA_RESERVADA_CLASS));
        palabraClave.add(new PalabrasReservadas("continue",Tipo.PALABRA_RESERVADA_CONTINUE));
        palabraClave.add(new PalabrasReservadas("def",Tipo.PALABRA_RESERVADA_DEF));
        palabraClave.add(new PalabrasReservadas("del",Tipo.PALABRA_RESERVADA_DEL));
        palabraClave.add(new PalabrasReservadas("elif",Tipo.PALABRA_RESERVADA_ELIF));
        palabraClave.add(new PalabrasReservadas("else",Tipo.PALABRA_RESERVADA_ELSE));
        palabraClave.add(new PalabrasReservadas("except",Tipo.PALABRA_RESERVADA_EXCEPT));
        //palabraClave.add(new PalabrasReservadas("False",Tipo.PALABRA_RESERVADA_FALSE));
        palabraClave.add(new PalabrasReservadas("finally",Tipo.PALABRA_RESERVADA_FINALLY));
        palabraClave.add(new PalabrasReservadas("for",Tipo.PALABRA_RESERVADA_FOR));
        palabraClave.add(new PalabrasReservadas("from",Tipo.PALABRA_RESERVADA_FROM));
        palabraClave.add(new PalabrasReservadas("global",Tipo.PALABRA_RESERVADA_GLOBAL));
        palabraClave.add(new PalabrasReservadas("if",Tipo.PALABRA_RESERVADA_IF));
        palabraClave.add(new PalabrasReservadas("import",Tipo.PALABRA_RESERVADA_IMPORT));
        palabraClave.add(new PalabrasReservadas("in",Tipo.PALABRA_RESERVADA_IN));
        palabraClave.add(new PalabrasReservadas("is",Tipo.PALABRA_RESERVADA_IS));
        palabraClave.add(new PalabrasReservadas("lambda",Tipo.PALABRA_RESERVADA_LAMBDA));
        palabraClave.add(new PalabrasReservadas("None",Tipo.PALABRA_RESERVADA_NONE));
        palabraClave.add(new PalabrasReservadas("nonlocal",Tipo.PALABRA_RESERVADA_NONLOCAL));
        palabraClave.add(new PalabrasReservadas("pass",Tipo.PALABRA_RESERVADA_PASS));
        palabraClave.add(new PalabrasReservadas("raise",Tipo.PALABRA_RESERVADA_RAISE));
        palabraClave.add(new PalabrasReservadas("return",Tipo.PALABRA_RESERVADA_RETURN));
        //palabraClave.add(new PalabrasReservadas("Treu",Tipo.PALABRA_RESERVADA_TRUE));
        palabraClave.add(new PalabrasReservadas("try",Tipo.PALABRA_RESERVADA_TRY));
        palabraClave.add(new PalabrasReservadas("while",Tipo.PALABRA_RESERVADA_WHILE));
        palabraClave.add(new PalabrasReservadas("with",Tipo.PALABRA_RESERVADA_WITH));
        palabraClave.add(new PalabrasReservadas("yield",Tipo.PALABRA_RESERVADA_YIELD));
        palabraClave.add(new PalabrasReservadas("print",Tipo.PALABRA_RESERVADA_PRINT));
        palabraClave.add(new PalabrasReservadas("and", Tipo.OPERADOR_LOGICO_Y));
        palabraClave.add(new PalabrasReservadas("or", Tipo.OPERADOR_LOGICO_O));
        palabraClave.add(new PalabrasReservadas("not", Tipo.OPERADOR_LOGICO_NEGACION));
        palabraClave.add(new PalabrasReservadas("True", Tipo.BOOLEANA_TRUE));
        palabraClave.add(new PalabrasReservadas("False", Tipo.BOOLEANA_FALSE));
        
        
       
    }
}

