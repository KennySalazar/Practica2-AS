/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ALexico;

import ALexico.analizador.Aritmeticos;
import ALexico.analizador.PalabrasReservadas;
import java.util.ArrayList;

/**
 *
 * @author Kenny
 */
public class AnalizadorLexico {

    private String codigoFuente;
    private ArrayList<Token> tokens;
    private int indice;
    private int linea;
    private int columna;
    private PalabrasReservadas palabrasClave;

    public AnalizadorLexico(String codigoFuente) {
        this.codigoFuente = codigoFuente;
        this.tokens = new ArrayList<>();
        this.indice = 0;
        this.columna = 0;
        this.linea = 1;
    }

    public AnalizadorLexico() {
    }

    public ArrayList<Token> analizarCodigoFuente() {
        while (indice < codigoFuente.length()) {

            char caracter = codigoFuente.charAt(indice);
            if (caracter == '\n') {
                columna = 0;
                linea++;
                indice++;
                //IGNORA ESPACIOS EN BLANCO
            } else if (Character.isWhitespace(caracter)) {

                indice++;
                columna++;

            } //EN ESTA PARTE VERIFICA SI ES UNA COMPARACIÓN == O SOLO UNA ASIGNACION =
            else if (caracter == '=') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;

                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        columna++;
                        lexema.append(caracter);
                        tokens.add(new Token(Token.Tipo.COMPARACION_IGUAL, lexema.toString(), linea, columna));
                        indice += 2;

                    } else {
                        tokens.add(new Token(Token.Tipo.ASIGNACION_IGUAL, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ASIGNACION_IGUAL, lexema.toString(), linea, columna));
                    indice++;
                }

                // EN ESTA PARTE VERIFICA SI ES SOLO UN SIGNO MENOR < O VIENE COMO UN SIGNO MENOR QUE <=
            } else if (caracter == '<') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;

                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        columna++;
                        lexema.append(caracter);
                        tokens.add(new Token(Token.Tipo.COMPARACION_MENOR_O_IGUAL_QUE, lexema.toString(), linea, columna));
                        indice += 2;

                    } else {
                        tokens.add(new Token(Token.Tipo.COMPARACION_MENOR_QUE, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.COMPARACION_MENOR_QUE, lexema.toString(), linea, columna));
                    indice++;
                }

                // EN ESTA PARTE VERIFICA SI SOLO ES UN SIGNO MAYOR > O VIENE COMO UN SIGNO MAYOR QUE >=
            } else if (caracter == '>') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        lexema.append(caracter);
                        columna++;
                        tokens.add(new Token(Token.Tipo.COMPARACION_MAYOR_O_IGUAL_QUE, lexema.toString(), linea, columna));
                        indice += 2;

                    } else {
                        tokens.add(new Token(Token.Tipo.COMPARACION_MAYOR_QUE, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.COMPARACION_MAYOR_QUE, lexema.toString(), linea, columna));
                    indice++;
                }
                //ESTA PARTE VERIFICA SI VIENE UN SIGNO DE DIVISION / O VIENEN //
            } else if (caracter == '/') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '/') {
                        columna++;
                        lexema.append(caracter);
                        tokens.add(new Token(Token.Tipo.ARITMETICO_DIVISION, lexema.toString(), linea, columna));
                        indice += 2;
                    } else if (caracter == '=') {
                        columna++;
                        lexema.append(caracter);
                        tokens.add(new Token(Token.Tipo.ASIGNACION_DIVISION, lexema.toString(), linea, columna));
                        indice += 2;
                    } else {
                        tokens.add(new Token(Token.Tipo.ARITMETICO_DIVISION, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ARITMETICO_DIVISION, lexema.toString(), linea, columna));
                    indice++;
                }
            } //ASIGNACION +=
            else if (caracter == '+') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        columna++;
                        lexema.append(caracter);
                        tokens.add(new Token(Token.Tipo.ASIGNACION_SUMA, lexema.toString(), linea, columna));
                        indice += 2;
                    } else {
                        tokens.add(new Token(Token.Tipo.ARITMETICO_SUMA, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ARITMETICO_SUMA, lexema.toString(), linea, columna));
                    indice++;
                }
            } //EXPONENTE
            else if (caracter == '*') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '*') {
                        columna++;
                        
                        
                        if ( codigoFuente.charAt(indice + 2)=='=') {
                            lexema.append(caracter);
                            columna++;
                            lexema.append(codigoFuente.charAt(indice + 2));
                            tokens.add(new Token(Token.Tipo.ASIGNACION_EXPONENTE, lexema.toString(), linea, columna));
                            indice += 3;
                        } else {
                            lexema.append(caracter);
                            tokens.add(new Token(Token.Tipo.ARITMETICO_EXPONENTE, lexema.toString(), linea, columna));
                            indice += 2;

                        }
                    } else if (caracter == '=') {
                        lexema.append(caracter);
                        columna++;
                        tokens.add(new Token(Token.Tipo.ASIGNACION_MULTIPLICACION, lexema.toString(), linea, columna));
                        indice += 2;
                    } else {
                        tokens.add(new Token(Token.Tipo.ARITMETICO_MULTIPLICACION, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ARITMETICO_MULTIPLICACION, lexema.toString(), linea, columna));
                    indice++;
                }

            } // EN ESTA PARTE SE VERIFICA SI VIENE UN DIFERENTE QUE, SI SOLO VIENE ! LO MANDO COMO UN ERROR
            else if (caracter == '!') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        lexema.append(caracter);
                        columna++;
                        tokens.add(new Token(Token.Tipo.COMPARACION_DIFERENTE, lexema.toString(), linea, columna));
                        indice += 2;
                    } else {
                        tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                    indice++;
                }

            } //EN ESTA PARTE SE VERIFICA SI VIENE EL SIGO DE ASIGNACION -=, O SI SOLO VIENE EL - LO MANDA COMO RESTA
            else if (caracter == '-') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        lexema.append(caracter);
                        columna++;
                        tokens.add(new Token(Token.Tipo.ASIGNACION_RESTA, lexema.toString(), linea, columna));
                        indice += 2;
                    } else {
                        tokens.add(new Token(Token.Tipo.ARITMETICO_RESTA, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ARITMETICO_RESTA, lexema.toString(), linea, columna));
                    indice++;
                }

            } // %=
            else if (caracter == '%') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                columna++;
                try {
                    caracter = codigoFuente.charAt(indice + 1);
                    if (caracter == '=') {
                        lexema.append(caracter);
                        columna++;
                        tokens.add(new Token(Token.Tipo.ASIGNACION_MODULO, lexema.toString(), linea, columna));
                        indice += 2;
                    } else {
                        tokens.add(new Token(Token.Tipo.ARITMETICO_MODULO, lexema.toString(), linea, columna));
                        indice++;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    tokens.add(new Token(Token.Tipo.ARITMETICO_MODULO, lexema.toString(), linea, columna));
                    indice++;
                }

            } //RECONOCE LAS CADENAS QUE VENGAN COMO ""
            else if (caracter == '"') {

                StringBuilder lexema = new StringBuilder();
                //lexema.append(caracter);
                indice++;
                columna++;
                while (indice < codigoFuente.length() && codigoFuente.charAt(indice) != '"' && codigoFuente.charAt(indice) != '\n') {
                    lexema.append(codigoFuente.charAt(indice));
                    indice++;
                    columna++;
                }
                if (indice < codigoFuente.length() && codigoFuente.charAt(indice) == '"') {
                    //lexema.append('"');
                    tokens.add(new Token(Token.Tipo.CADENA, lexema.toString(), linea, columna));
                    indice++;
                    columna++;
                } else {
                    // Error: cadena no cerrada
                    tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                }

            } //RECONOCE LAS CADENAS QUE VENGAN COMO ”  ”
            else if (caracter == '”') {

                StringBuilder lexema = new StringBuilder();
                //lexema.append(caracter);
                indice++;
                columna++;
                while (indice < codigoFuente.length() && codigoFuente.charAt(indice) != '”' && codigoFuente.charAt(indice) != '\n') {
                    lexema.append(codigoFuente.charAt(indice));
                    indice++;
                    columna++;
                }
                if (indice < codigoFuente.length() && codigoFuente.charAt(indice) == '”') {
                    //lexema.append('"');
                    tokens.add(new Token(Token.Tipo.CADENA, lexema.toString(), linea, columna));
                    indice++;
                    columna++;
                } else {
                    // Error: cadena no cerrada
                    tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                }

            } //RECONOCE LAS CADENAS QUE VENGAN COMO ''
            else if (caracter == '\'') {

                StringBuilder lexema = new StringBuilder();

                indice++;
                columna++;
                while (indice < codigoFuente.length() && codigoFuente.charAt(indice) != '\'' && codigoFuente.charAt(indice) != '\n') {
                    lexema.append(codigoFuente.charAt(indice));
                    indice++;
                    columna++;
                }
                if (indice < codigoFuente.length() && codigoFuente.charAt(indice) == '\'') {
                    tokens.add(new Token(Token.Tipo.CADENA, lexema.toString(), linea, columna));
                    indice++;
                    columna++;
                } else {
                    // Error: cadena no cerrada
                    tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                }

                //ESTA PARTE RECONOCE LOS COMENTARIOS
            } else if (caracter == '#') {

                StringBuilder lexema = new StringBuilder();

                while (indice < codigoFuente.length() && codigoFuente.charAt(indice) != '\n') {
                    lexema.append(codigoFuente.charAt(indice));
                    indice++;
                    columna++;

                }

                if (indice < codigoFuente.length() && codigoFuente.charAt(indice) == '\n') {
                    //lexema.append('"');
                    tokens.add(new Token(Token.Tipo.COMENTARIO, lexema.toString(), linea, columna));
                    indice++;
                    columna++;
                } else {
                    tokens.add(new Token(Token.Tipo.COMENTARIO, lexema.toString(), linea, columna));
                }
                linea++;
                columna = 0;

            } // Reconocer palabras reservadas e identificadores
            else if (Character.isLetter(caracter) || caracter == '_') {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                indice++;
                columna++;
                while (indice < codigoFuente.length() && (Character.isLetterOrDigit(codigoFuente.charAt(indice))
                        || codigoFuente.charAt(indice) == '_')) {
                    lexema.append(codigoFuente.charAt(indice));
                    indice++;
                    columna++;
                }
                String lexemaString = lexema.toString();

                tokens.add(verificarPalabra(lexemaString, linea, columna));

            } // RECONOCE NUMERO ENTEROS 
            else if (Character.isDigit(caracter)) {
                StringBuilder lexema = new StringBuilder();
                lexema.append(caracter);
                indice++;
                columna++;
                while (indice < codigoFuente.length() && Character.isDigit(codigoFuente.charAt(indice))) {
                    lexema.append(codigoFuente.charAt(indice));
                    indice++;
                    columna++;

                }
                if (indice < codigoFuente.length() && Character.isLetter(codigoFuente.charAt(indice))) {

                    while (indice < codigoFuente.length()) {
                        if (Character.isWhitespace(codigoFuente.charAt(indice))) {
                            columna++;
                            break;
                        } else if (codigoFuente.charAt(indice) == '\n') {
                            linea++;
                            columna = 0;
                            break;
                        } else {
                            columna++;
                            lexema.append(codigoFuente.charAt(indice));
                        }

                        indice++;
                    }

                    //columna++;
                    tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                    indice++;

                } else if (indice < codigoFuente.length() && (codigoFuente.charAt(indice) == '.')) {
                    lexema.append(codigoFuente.charAt(indice));
                    columna++;
                    indice++;
                    while (indice < codigoFuente.length() && Character.isDigit(codigoFuente.charAt(indice))) {
                        lexema.append(codigoFuente.charAt(indice));
                        indice++;
                        columna++;

                    }
                    if (indice < codigoFuente.length() && (Character.isLetter(codigoFuente.charAt(indice)) || (Character.isWhitespace(codigoFuente.charAt(indice)) && codigoFuente.charAt(indice - 1) == '.'))) {
                        if (codigoFuente.charAt(indice) != '\n') {
                            lexema.append(codigoFuente.charAt(indice));
                        }
                        columna++;
                        tokens.add(new Token(Token.Tipo.ERROR, lexema.toString(), linea, columna));
                        indice++;

                    } else {
                        tokens.add(new Token(Token.Tipo.CONSTANTE_DECIMAL, lexema.toString(), linea, columna));
                    }
                } else {
                    tokens.add(new Token(Token.Tipo.CONSTANTE_ENTERA, lexema.toString(), linea, columna));
                }

            } //RECONOCE SIMNOLOS MATEMATICOS
            else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '%' || caracter == '('
                    || caracter == ')' || caracter == '{' || caracter == '}' || caracter == '[' || caracter == ']'
                    || caracter == ',' || caracter == ';' || caracter == ':' || caracter == '.') {
                columna++;
                tokens.add(verificarSimboloAritmetico(String.valueOf(caracter), linea, columna));
                //System.out.println(String.valueOf(caracter));
                indice++;

            } else {
                // Error: símbolo no reconocido
                columna++;
                tokens.add(new Token(Token.Tipo.ERROR, String.valueOf(caracter), linea, columna));
                indice++;

            }
        }

        return tokens;
    }

    public ArrayList<Token> analizarCodigoFuentePalabrasClave() {

        return tokens;
    }

    public Token verificarPalabra(String cadena, int linea, int columna) {
        Token tk = new Token();
        boolean exist = false;
        PalabrasReservadas pr = new PalabrasReservadas();
        for (PalabrasReservadas prv : pr.palabraClave) {
            if (cadena.equals(prv.getLexema())) {
                tk.setLexema(cadena);
                tk.setTipo(prv.getTipo());
                tk.setLinea(linea);
                tk.setColumna(columna);
                exist = true;
                break;
            }
        }
        if (!exist) {
            tk.setLexema(cadena);
            tk.setTipo(Token.Tipo.IDENTIFICADOR);
            tk.setLinea(linea);
            tk.setColumna(columna);
        }
        return tk;
    }

    public Token verificarSimboloAritmetico(String cadena, int linea, int columna) {
        Token tk = new Token();
        boolean exist = false;
        Aritmeticos aritmetico = new Aritmeticos();
        for (Aritmeticos sA : aritmetico.simboloAritmetico) {
            if (cadena.equals(sA.getLexema())) {
                tk.setLexema(cadena);
                tk.setTipo(sA.getTipo());
                tk.setLinea(linea);
                tk.setColumna(columna);
                exist = true;
                break;
            }
        }

        return tk;
    }

}
