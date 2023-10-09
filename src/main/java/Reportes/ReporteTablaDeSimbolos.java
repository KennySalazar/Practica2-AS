/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;


/**
 *
 * @author Kenny
 */
public class ReporteTablaDeSimbolos {
   String simbolo;
   String tipo;
   String valor;
   int linea;
   int columna;

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }
    

    public void setValor(String valor) {
        this.valor = (String) valor;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public ReporteTablaDeSimbolos() {
    }

    public ReporteTablaDeSimbolos(String simbolo, String tipo, String valor, int linea, int columna) {
        this.simbolo = simbolo;
        this.tipo = tipo;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
    
    
   
}
