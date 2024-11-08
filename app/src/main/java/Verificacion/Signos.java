package Verificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Signos {

    public static final char SUMA = '+';
    public static final char RESTA = '-';
    public static final char MULTIPLICACION = '*';
    public static final char DIVISION = '/';

    ArrayList<Integer> posicionesDeSignosParaOperacionEnExpresionCache = new ArrayList<>();
    ArrayList<Integer> posicionesDeSignosParaOperacionEnExpresion = new ArrayList<>();


    public void buscarSignosDeOperaciones(String expresion) {
        for (int i = 1; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '*' || expresion.charAt(i) == '/') {
                posicionesDeSignosParaOperacionEnExpresion.add(i);
                posicionesDeSignosParaOperacionEnExpresionCache.add(i);
            }
        }

        for (int i = 1; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '+' || expresion.charAt(i) == '-') {
                posicionesDeSignosParaOperacionEnExpresion.add(i);
                posicionesDeSignosParaOperacionEnExpresionCache.add(i);
            }
        }


    }



}
