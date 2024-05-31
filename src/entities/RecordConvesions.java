package entities;

import entitiesDTO.MonedaDTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordConvesions {

    private String moneda;
    private String toMoneda;
    private Date fecha;
    private double valor;
    private double cant;

    public RecordConvesions(String moneda, String toMoneda,double cant, double valor) {

        this.moneda = moneda;
        this.toMoneda = toMoneda;
        this.fecha = new Date();
        this.valor = valor;
        this.cant = cant;
    }

    @Override
    public String toString() {

        String patron = "E, dd MMM yyyy HH:mm:ss";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(patron);

        return "[" + formatoFecha.format(fecha) + "] moneda = " + moneda+" a "+toMoneda +", Cantidad = "+cant +"["+ moneda + "], convesion = $" + valor+"["+toMoneda+"]\n";
    }
}
