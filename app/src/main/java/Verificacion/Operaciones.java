package Verificacion;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Operaciones {
    ArrayList<Operacion> operacionesLista = new ArrayList<Operacion>();
   public static Operaciones operaciones = new Operaciones();
    String operacion1="";

    public  double calcular(String operacion1) {
        Signos signos = new Signos();
        signos.buscarSignosDeOperaciones(operacion1);
        operaciones.crearOperacion(signos.posicionesDeSignosParaOperacionEnExpresion, operacion1);
        System.out.println(signos.posicionesDeSignosParaOperacionEnExpresion);
        System.out.println(operaciones.operacionesLista);
       return Double.parseDouble(operacionesLista.get(operacionesLista.size()-1).operar().toString());


    }public void borrar(){
        operacionesLista.clear();
        operacion1="";

    }

    public void crearOperacion(ArrayList<Integer> posicionesDeSignos, String expresion) {
        ArrayList<Integer> posicionesDeSignosCache = new ArrayList<>();
        posicionesDeSignosCache.addAll(posicionesDeSignos);

     

        for(int i=0;i<posicionesDeSignos.size()&&posicionesDeSignosCache.isEmpty()==false;i++){
            Number operando1 =  operacionesLista.isEmpty()?operandosIzquierda(expresion, posicionesDeSignosCache): operacionesLista.get(operacionesLista.size()-1).operar();
            Number operando2 = operandosDerecha(expresion, posicionesDeSignosCache);
            char signo = expresion.charAt(posicionesDeSignosCache.get(0));
    
            if(signo=='+'){
                operacionesLista.add(new Suma(operando1,operando2));
            }
    
            if(signo=='-'){
                operacionesLista.add(new Resta(operando1,operando2));
    
            }

            
            if(signo=='*'){
                operacionesLista.add(new Multiplicacion(operando1,operando2));
            }
    
            if(signo=='/'){
                operacionesLista.add(new Division(operando1,operando2));
    
            }
     


            posicionesDeSignosCache.remove(0);
        }

       

    }

    private Number operandosDerecha(String expresion, ArrayList<Integer> operandos) {
        char[] characters = expresion.toCharArray();
        Number operandoDerecha = 0;
        String operandoDerStr = "";

        int posicionDeSigno = operandos.get(0);
        for (int i = posicionDeSigno + 1; (i < characters.length && validCharacter(characters[i])); i++) {

            operandoDerecha = Integer.parseInt(String.valueOf(characters[i]));
            operandoDerStr += characters[i];

        }
        operandoDerecha = Integer.parseInt(operandoDerStr);

        return operandoDerecha;

    }

    private String reverseString(String data) {
        String resultado = "";
        for (int i = data.length() - 1; i >= 0; i--) {

            resultado += data.charAt(i);

        }
        return resultado;
    }

    private Number operandosIzquierda(String expresion, ArrayList<Integer> operandos) {
        char[] characters = expresion.toCharArray();
        Number operandoIzquierda = 0;
        String operandoIzqStr = "";
        int posicionDeSigno = operandos.get(0);
        int posicionesrestantes=expresion.substring(0, posicionDeSigno).length();
        if(expresion.charAt(0)=='-'&&operandoIzqStr.length()==0&&operacionesLista.isEmpty()){
            operandoIzqStr+="-";

        }
        for (int i = (posicionesrestantes - 1); (i >= 0 && i < characters.length && validCharacter(characters[i])); i--) {

            operandoIzqStr += characters[i];

        }
        operandoIzquierda = Integer.parseInt((operandoIzqStr));

        return operandoIzquierda;

    }

    private boolean validCharacter(char character) {
        boolean resultado = false;
        resultado = Pattern.matches("^[+-]?\\d+(?:\\.\\d+)?$", String.valueOf(character));
        return resultado;
    }
}
