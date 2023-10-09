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
public class ClaseError {
    private ArrayList<Token> tokens;
    public ArrayList<ClaseError> tipoError = new ArrayList<>();
    private Token.Tipo tipo;

    public ClaseError(Token.Tipo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<ClaseError> getTipoError() {
        return tipoError;
    }

    public void setTipoError(ArrayList<ClaseError> tipoError) {
        this.tipoError = tipoError;
    }

    public Token.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Token.Tipo tipo) {
        this.tipo = tipo;
    }
    
    public ClaseError(){
        tipoError.add(new ClaseError(Tipo.ERROR));
    }
    
}

