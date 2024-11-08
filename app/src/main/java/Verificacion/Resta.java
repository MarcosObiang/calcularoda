package Verificacion;

public class Resta implements Operacion{

    Number operando1;
    Number operando2;
    int prioridad=0;
    public Resta(Number operando1, Number operando2){
        this.operando1=operando1;
        this.operando2=operando2;
    }

    @Override
    public Number operar() {
        return operando1.doubleValue()-operando2.doubleValue();
    }

    @Override
    public void asignarPrioridad(int prioridad) {
        this.prioridad=prioridad;

    }

    @Override
    public int getPrioridad() {
        return this.prioridad;
    }
}
