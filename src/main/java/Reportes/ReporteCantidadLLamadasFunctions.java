/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

/**
 *
 * @author Kenny
 */
public class ReporteCantidadLLamadasFunctions {
    private String nombreFuncion;
    private int cantidad;

    public ReporteCantidadLLamadasFunctions(String nombreFuncion, int cantidad) {
        this.nombreFuncion = nombreFuncion;
        this.cantidad = cantidad;
    }

    public ReporteCantidadLLamadasFunctions() {
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
