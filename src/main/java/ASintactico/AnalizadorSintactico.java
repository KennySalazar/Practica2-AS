/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASintactico;

import ALexico.Token;
import ALexico.Token.Tipo;
import Reportes.FuncionesYSusParametros;
import Reportes.ReporteCantidadLLamadasFunctions;
import Reportes.ReporteTablaDeSimbolos;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.Vista;

/**
 *
 * @author Kenny
 */
public class AnalizadorSintactico {

    public ArrayList<String> erroresSintacticos;
    public ArrayList<String> erroresLexicos;
    public ArrayList<Token> EtokensLexicos;
    public ArrayList<Token> EtokensSintacticos;//errores
    int estadoActual = 0;
    public DefaultTableModel tabla1 = new DefaultTableModel();

    public AnalizadorSintactico() {
        erroresSintacticos = new ArrayList<>();
        erroresLexicos = new ArrayList<>();
    }
    public Transiciones transicion = new Transiciones();
    public ArrayList<ReporteTablaDeSimbolos> listaRepTS;
    public ArrayList<ReporteTablaDeSimbolos> listaRepTSXBloqueCodigo;//reportes por bloque de codigo
    public ArrayList<ReporteTablaDeSimbolos> cantidadFuncionesOMetodos;
    public ArrayList<ReporteCantidadLLamadasFunctions> funcionesLLamadasCantidad;

    public ArrayList<FuncionesYSusParametros> funcionesYsusParametros;//reporte de parametros de las funciones
    String simbolo = "N";
    String tipo = "N";
    Tipo tipoS1;
    Tipo tipoS2;
    String valorTS = "";
    int linea = -1;
    int columna = -1;
    String signo = "N";

    public String analizarSintatico(ArrayList<Token> tokens) {
        erroresSintacticos = new ArrayList<>();
        erroresLexicos = new ArrayList<>();
        listaRepTS = new ArrayList<>();
        listaRepTSXBloqueCodigo = new ArrayList<>();
        cantidadFuncionesOMetodos = new ArrayList<>();
        funcionesLLamadasCantidad = new ArrayList<>();
        funcionesYsusParametros = new ArrayList<>();
        EtokensLexicos = new ArrayList<>();
        EtokensSintacticos = new ArrayList<>();
        tabla1 = new DefaultTableModel();
        tabla1.addColumn("#");
        tabla1.addColumn("ESTADO ACTUAL");
        tabla1.addColumn("TOKEN");
        tabla1.addColumn("SIGUIENTE ESTADO");
        //variables para los parametros de una funcion
        Boolean isfunction = false;
        FuncionesYSusParametros funcionYParametro = new FuncionesYSusParametros("", "");

        String valor = "Error sintactico";
        estadoActual = 1;
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getTipo() == Token.Tipo.ERROR) {
                EtokensLexicos.add(tokens.get(i));
                erroresLexicos.add("Error Léxico en la linea: " + tokens.get(i).getLinea() + ", columna: " + tokens.get(i).getColumna());
            } else if (tokens.get(i).getTipo() != Token.Tipo.COMENTARIO) {
                System.out.println("Estado: " + estadoActual + " Token: " + tokens.get(i).getLexema() + ", transicion a: " + transicion.tabla[estadoActual][transicion.devolverNumeroPorToken(tokens.get(i))]);
                llenarTabla(estadoActual, tokens.get(i), transicion.tabla[estadoActual][transicion.devolverNumeroPorToken(tokens.get(i))], i);
                estadoActual = transicion.tabla[estadoActual][transicion.devolverNumeroPorToken(tokens.get(i))];

                try {
                    if (estadoActual == 7
                            || ((estadoActual == 12 && (tokens.get(i + 1).getTipo() != Token.Tipo.CORCHETE_CIERRE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMA)))
                            || estadoActual == 14
                            || estadoActual == 20
                            || estadoActual == 23
                            || estadoActual == 25
                            || estadoActual == 31
                            || estadoActual == 35
                            || estadoActual == 41
                            || estadoActual == 44
                            || (estadoActual == 46 && (tokens.get(i + 1).getTipo() != Token.Tipo.PARENTESI_APERTURA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_SUMA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_RESTA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_MULTIPLICACION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_DIVISION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_MODULO
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_EXPONENTE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_IGUAL
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_DIFERENTE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MAYOR_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MAYOR_O_IGUAL_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MENOR_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MENOR_O_IGUAL_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.PALABRA_RESERVADA_IN
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_NEGACION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_Y
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_O))
                            || estadoActual == 55
                            || estadoActual == 56
                            || (estadoActual == 62 && (tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_SUMA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_RESTA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_MULTIPLICACION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_DIVISION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_MODULO
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_EXPONENTE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMA))
                            || (estadoActual == 64 && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_NEGACION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_Y
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_O)
                            || estadoActual == 77
                            || estadoActual == 88
                            || estadoActual == 93) {
                        estadoActual = 1;
                    } else if (((estadoActual == 4 && (tokens.get(i + 1).getTipo() != Token.Tipo.COMA && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_SUMA
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_RESTA && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_MULTIPLICACION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_DIVISION && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_MODULO
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ARITMETICO_EXPONENTE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_IGUAL
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_DIFERENTE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MAYOR_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MAYOR_O_IGUAL_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MENOR_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.COMPARACION_MENOR_O_IGUAL_QUE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.PALABRA_RESERVADA_IS
                            && tokens.get(i + 1).getTipo() != Token.Tipo.PALABRA_RESERVADA_IN
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_NEGACION
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_Y
                            && tokens.get(i + 1).getTipo() != Token.Tipo.OPERADOR_LOGICO_O
                            && tokens.get(i + 1).getTipo() != Token.Tipo.PARENTESI_CIERRE
                            && tokens.get(i + 1).getTipo() != Token.Tipo.ERROR
                            && tokens.get(i + 1).getTipo() != Token.Tipo.PARENTESI_APERTURA)))) {
                        estadoActual = 1;
                        valorTS = valorTS + tokens.get(i).getLexema();
                        if (signo.equals("N")) {
                            tipo = asignarTipo(tokens.get(i).getTipo());
                            //tipoS1 = tokens.get(i).getTipo();
                        } else if (signo.equals("=")) {
                            if (tipoS1 == null) {
                                tipo = asignarTipo(tokens.get(i).getTipo());
                            } else if (tipoS1.equals(tokens.get(i).getTipo())) {
                                tipo = asignarTipo(tokens.get(i).getTipo());
                            } else {
                                tipo = "indefinido";
                                valorTS = "indefinido";
                            }
                        } else {
                            tipo = "indefinido";
                            valorTS = "indefinido";
                        }
                        System.out.println("Simbolo: " + simbolo + ",Valor: " + valorTS + ", Tipo: " + tipo + ", Linea: " + linea
                                + ", Columna: " + columna);
                        agregarRepATablaSimbolos(simbolo, valorTS, tipo, linea, columna, this.listaRepTS);

                    } else if (((estadoActual == 4 && (tokens.get(i + 1).getTipo() == Token.Tipo.ARITMETICO_SUMA
                            || tokens.get(i + 1).getTipo() == Token.Tipo.ARITMETICO_RESTA || tokens.get(i + 1).getTipo() == Token.Tipo.ARITMETICO_MULTIPLICACION
                            || tokens.get(i + 1).getTipo() == Token.Tipo.ARITMETICO_DIVISION || tokens.get(i + 1).getTipo() == Token.Tipo.ARITMETICO_MODULO
                            || tokens.get(i + 1).getTipo() == Token.Tipo.ARITMETICO_EXPONENTE
                            || tokens.get(i + 1).getTipo() == Token.Tipo.ERROR)))) {
                        tipoS1 = tokens.get(i).getTipo();
                        valorTS = valorTS + tokens.get(i).getLexema();

                    } else if (estadoActual == 2) {
                        simbolo = tokens.get(i).getLexema();
                        linea = tokens.get(i).getLinea();
                        columna = tokens.get(i).getColumna();
                        signo = "N";
                        valorTS = "";
                        tipoS1 = null;
                        tipo = "";
                    } else if (estadoActual == 3) {
                        if (tokens.get(i).getTipo().equals(Tipo.ARITMETICO_SUMA) || tokens.get(i).getTipo().equals(Tipo.ARITMETICO_RESTA)
                                || tokens.get(i).getTipo().equals(Tipo.ARITMETICO_DIVISION) || tokens.get(i).getTipo().equals(Tipo.ARITMETICO_MULTIPLICACION)
                                || tokens.get(i).getTipo().equals(Tipo.ARITMETICO_MODULO) || tokens.get(i).getTipo().equals(Tipo.ARITMETICO_EXPONENTE)) {
                            valorTS = valorTS + tokens.get(i).getLexema();
                        } else {
                            signo = tokens.get(i).getLexema();
                        }
                    } else if (estadoActual == 43) {
                        isfunction = true;
                    } else if (estadoActual == 38 && isfunction) {
                        funcionYParametro.setNombre(tokens.get(i).getLexema());
                    } else if (estadoActual == 42 && isfunction) {
                        if (tokens.get(i + 1).getTipo() == Tipo.PARENTESI_CIERRE) {

                            funcionYParametro.setParametros(funcionYParametro.getParametros() + tokens.get(i).getLexema());

                        } else {
                            funcionYParametro.setParametros(funcionYParametro.getParametros() + tokens.get(i).getLexema() + ", ");
                        }
                    } else if (estadoActual == 40 && isfunction) {
                        funcionesYsusParametros.add(funcionYParametro);
                        funcionYParametro = new FuncionesYSusParametros("", ""); //nombre,parametro
                        isfunction = false;
                    } else if (estadoActual == 0) {
                        erroresSintacticos.add("Error sintactico en la linea: " + tokens.get(i).getLinea() + ", columna: " + tokens.get(i).getColumna());
                        EtokensSintacticos.add(tokens.get(i));
                    }
                } catch (IndexOutOfBoundsException e) {//excepcion de que ya no hay ningun token mas, para el estado cuatro
                    if (estadoActual == 4) {
                        valorTS = valorTS + tokens.get(i).getLexema();
                        if (signo.equals("N")) {
                            tipo = asignarTipo(tokens.get(i).getTipo());
                            tipoS1 = tokens.get(i).getTipo();
                        } else if (signo.equals("=")) {
                            if (tipoS1 == null) {
                                tipo = asignarTipo(tokens.get(i).getTipo());
                            } else if (tipoS1.equals(tokens.get(i).getTipo())) {
                                tipo = asignarTipo(tokens.get(i).getTipo());
                            } else {
                                tipo = "indefinido";
                                valorTS = "indefinido";
                            }
                        } else {
                            tipo = "indefinido";
                            valorTS = "indefinido";
                        }
                        System.out.println("Simbolo: " + simbolo + ",Valor: " + valorTS + ", Tipo: " + tipo + ", Linea: " + linea
                                + ", Columna: " + columna);
                        agregarRepATablaSimbolos(simbolo, valorTS, tipo, linea, columna, this.listaRepTS);
                        estadoActual = 1;
                    } else {
                        estadoActual = 1;
                    }

                }

                valor = verificarEstado(estadoActual);
            }
            try {
                if (tokens.get(i).getTipo() == Tipo.PALABRA_RESERVADA_DEF) {
                    verificarTipoSimbolo(tokens.get(i + 1), tokens.get(i));
                } else if (tokens.get(i).getTipo() == Tipo.IDENTIFICADOR && tokens.get(i + 1).getTipo() == Tipo.PARENTESI_APERTURA
                        && tokens.get(i - 1).getTipo() != Tipo.PALABRA_RESERVADA_DEF
                        && tokens.get(i - 1).getTipo() != Tipo.PALABRA_RESERVADA_IN) {
                    if (!existeFuncion(tokens.get(i).getLexema(), this.funcionesLLamadasCantidad)) {
                        this.funcionesLLamadasCantidad.add(new ReporteCantidadLLamadasFunctions(tokens.get(i).getLexema(), 1));
                    }
                } else {
                    verificarTipoSimbolo(tokens.get(i), tokens.get(i));
                }
            } catch (IndexOutOfBoundsException e) {
            }

        }

        System.out.println(valor);
        return valor;
    }

    public void verificarTipoSimbolo(Token token, Token token1) {
        switch (token.getTipo()) {
            case IDENTIFICADOR:
                if (token1.getTipo() == Tipo.PALABRA_RESERVADA_DEF) {
                    agregarRepATablaSimbolos(token.getLexema(), "-", "FUNCIÓN", token.getLinea(), token.getColumna(), this.listaRepTS);
                    agregarRepATablaSimbolosXBloqueCodigo(token.getLexema(), "-", "FUNCIÓN", token.getLinea(), token.getColumna());
                    agregarRepATablaSimbolos(token.getLexema(), "-", "FUNCIÓN", token.getLinea(), token.getColumna(), this.cantidadFuncionesOMetodos);
                }

                break;
            case PALABRA_RESERVADA_IF:
                agregarRepATablaSimbolos(token.getLexema(), "-", "CONDICIONAL", token.getLinea(), token.getColumna(), this.listaRepTS);
                agregarRepATablaSimbolosXBloqueCodigo(token.getLexema(), "-", "CONDICIONAL", token.getLinea(), token.getColumna());
                break;
            case PALABRA_RESERVADA_ELSE:
                agregarRepATablaSimbolos(token.getLexema(), "-", "CONDICIONAL", token.getLinea(), token.getColumna(), this.listaRepTS);
                agregarRepATablaSimbolosXBloqueCodigo(token.getLexema(), "-", "CONDICIONAL", token.getLinea(), token.getColumna());
                break;
            case PALABRA_RESERVADA_ELIF:
                agregarRepATablaSimbolos(token.getLexema(), "-", "CONDICIONAL", token.getLinea(), token.getColumna(), this.listaRepTS);
                agregarRepATablaSimbolosXBloqueCodigo(token.getLexema(), "-", "CONDICIONAL", token.getLinea(), token.getColumna());
                break;
            case PALABRA_RESERVADA_WHILE:
                agregarRepATablaSimbolos(token.getLexema(), "-", "CICLO", token.getLinea(), token.getColumna(), this.listaRepTS);
                agregarRepATablaSimbolosXBloqueCodigo(token.getLexema(), "-", "CICLO", token.getLinea(), token.getColumna());
                break;
            case PALABRA_RESERVADA_FOR:
                agregarRepATablaSimbolos(token.getLexema(), "-", "CICLO", token.getLinea(), token.getColumna(), this.listaRepTS);
                agregarRepATablaSimbolosXBloqueCodigo(token.getLexema(), "-", "CICLO", token.getLinea(), token.getColumna());
                break;
            case PALABRA_RESERVADA_PRINT:
                agregarRepATablaSimbolos(token.getLexema(), "-", "INSTRUCCIÓN", token.getLinea(), token.getColumna(), this.listaRepTS);
                break;
            case PALABRA_RESERVADA_YIELD:
                agregarRepATablaSimbolos(token.getLexema(), "-", "INSTRUCCIÓN", token.getLinea(), token.getColumna(), this.listaRepTS);
                break;
            case PALABRA_RESERVADA_RETURN:
                agregarRepATablaSimbolos(token.getLexema(), "-", "INSTRUCCIÓN", token.getLinea(), token.getColumna(), this.listaRepTS);
                break;
            case PALABRA_RESERVADA_IN:
                agregarRepATablaSimbolos(token.getLexema(), "-", "INSTRUCCION", token.getLinea(), token.getColumna(), this.listaRepTS);
                break;
            default:

        }
    }

    public void agregarRepATablaSimbolos(String simbolo, String valor, String tipo, int linea, int columna, ArrayList<ReporteTablaDeSimbolos> lista) {
        ReporteTablaDeSimbolos repTS = new ReporteTablaDeSimbolos(simbolo, tipo, valor, linea, columna);

        lista.add(repTS);
        simbolo = "";
        signo = "N";
        valor = "";
        tipoS1 = null;
        tipo = "";

    }

    public void agregarRepATablaSimbolosXBloqueCodigo(String simbolo, String valor, String tipo, int linea, int columna) {
        ReporteTablaDeSimbolos repTS = new ReporteTablaDeSimbolos(simbolo, tipo, valor, linea, columna);

        listaRepTSXBloqueCodigo.add(repTS);
        simbolo = "";
        signo = "N";
        valor = "";
        tipoS1 = null;
        tipo = "";

    }

    public boolean existeFuncion(String nombreFuncion, ArrayList<ReporteCantidadLLamadasFunctions> lista) {
        boolean exist = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombreFuncion().equals(nombreFuncion)) {
                exist = true;
                lista.get(i).setCantidad(lista.get(i).getCantidad() + 1);
                i = lista.size();
            }

        }

        return exist;
    }

    public String asignarTipo(Tipo tipo) {
        String retorno = "Indefinido";
        switch (tipo) {
            case CONSTANTE_ENTERA:
                retorno = "entero";
                break;
            case CONSTANTE_DECIMAL:
                retorno = "decimal";
                break;
            case CADENA:
                retorno = "cadena";
                break;
            case BOOLEANA_FALSE:
                retorno = "booleana";
                break;
            case BOOLEANA_TRUE:
                retorno = "booleana";
                break;
        }
        return retorno;
    }

    public void llenarTabla(int estadoActual, Token token, int sigEstado, int i) {

        String[] columna = new String[4];
        columna[0] = String.valueOf(i);
        columna[1] = String.valueOf(estadoActual);
        columna[2] = token.getLexema();
        columna[3] = String.valueOf(sigEstado);

        this.tabla1.addRow(columna);

    }

    public String verificarEstado(int estado) {
        String var = "";
        if (estado == 1) {
            var = "Analisis Sintactico correctamente";
        } else {
            var = "Analisis Sintactico incorrecto";
        }
        return var;
    }
}
