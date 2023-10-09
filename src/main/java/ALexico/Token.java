/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ALexico;

/**
 *
 * @author Kenny
 */
public class Token {

    Token() {
    }

    public enum Tipo {
        PALABRA_RESERVADA_AND,
        PALABRA_RESERVADA_AS,
        PALABRA_RESERVADA_ASSERT,
        PALABRA_RESERVADA_BREAK,
        PALABRA_RESERVADA_CLASS,
        PALABRA_RESERVADA_CONTINUE,
        PALABRA_RESERVADA_DEF,
        PALABRA_RESERVADA_DEL,
        PALABRA_RESERVADA_ELIF,
        PALABRA_RESERVADA_ELSE,
        PALABRA_RESERVADA_EXCEPT,
        PALABRA_RESERVADA_FALSE,
        PALABRA_RESERVADA_FINALLY,
        PALABRA_RESERVADA_FOR,
        PALABRA_RESERVADA_FROM,
        PALABRA_RESERVADA_GLOBAL,
        PALABRA_RESERVADA_IF,
        PALABRA_RESERVADA_IMPORT,
        PALABRA_RESERVADA_IN,
        PALABRA_RESERVADA_IS,
        PALABRA_RESERVADA_LAMBDA,
        PALABRA_RESERVADA_NONE,
        PALABRA_RESERVADA_NONLOCAL,
        PALABRA_RESERVADA_NOT,
        PALABRA_RESERVADA_OR,
        PALABRA_RESERVADA_PASS,
        PALABRA_RESERVADA_RAISE,
        PALABRA_RESERVADA_RETURN,
        PALABRA_RESERVADA_TRUE,
        PALABRA_RESERVADA_TRY,
        PALABRA_RESERVADA_WHILE,
        PALABRA_RESERVADA_WITH,
        PALABRA_RESERVADA_YIELD,
        PALABRA_RESERVADA_PRINT,
        IDENTIFICADOR,
        //ASIGNACION
        ASIGNACION_IGUAL,
        ASIGNACION_MULTIPLICACION,
        ASIGNACION,
        ASIGNACION_SUMA,
        ASIGNACION_RESTA,
        ASIGNACION_DIVISION,
        ASIGNACION_EXPONENTE,
        ASIGNACION_MODULO,
        //ARITMETICOS
        ARITMETICO_SUMA,
        ARITMETICO_RESTA,
        ARITMETICO_EXPONENTE,
        ARITMETICO_DIVISION,
        ARITMETICO_MODULO,
        ARITMETICO_MULTIPLICACION,
        //COMPARACION
        COMPARACION_IGUAL,
        COMPARACION_DIFERENTE,
        COMPARACION_MAYOR_QUE,
        COMPARACION_MENOR_QUE,
        COMPARACION_MAYOR_O_IGUAL_QUE,
        COMPARACION_MENOR_O_IGUAL_QUE,
        //LOGICOS
        OPERADOR_LOGICO_Y,
        OPERADOR_LOGICO_O,
        OPERADOR_LOGICO_NEGACION,
        //CONSTANTES
        CONSTANTE_ENTERA,
        CONSTANTE_DECIMAL,
        CADENA,
        BOOLEANA_TRUE,
        BOOLEANA_FALSE,
        //COMENTARIO
        COMENTARIO,
        //OTROS
        PARENTESI_APERTURA,
        PARENTESI_CIERRE,
        LLAVE_APERTURA,
        LLAVE_CIERRE,
        CORCHETE_APERTURA,
        CORCHETE_CIERRE,
        COMA,
        PUNTO,
        PUNTO_COMA,
        DOS_PUNTOS,
        //------
        //COMPARADOR,
        ERROR,
        VALOR,
        
        
    }

    public Token(Tipo tipo) {
        this.tipo = tipo;
    }

    private Tipo tipo;
    private String lexema;
    private int linea;
    private int columna;

    public Token(Tipo tipo, String lexema, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea=linea;
        this.columna=columna;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    @Override
    public String toString() {
        return "Token { "
                + "tipo = " + tipo
                + ", lexema = '" + lexema + '\''
                +", linea = " +linea
                +", columna = " +columna
                + '}';
    }
    
    
}