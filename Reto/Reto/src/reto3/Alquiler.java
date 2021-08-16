package reto3;

import java.util.HashMap;

public class Alquiler {

    private int Id;
    private Persona Cliente;
    private MotoAcuatica Moto;

    public Alquiler(int id, Persona cliente, MotoAcuatica moto) {
        setId(id);
        setCliente(cliente);
        setMoto(moto);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Persona getCliente() {
        return Cliente;
    }

    public void setCliente(Persona cliente) {
        Cliente = cliente;
    }

    public MotoAcuatica getMoto() {
        return Moto;
    }

    public void setMoto(MotoAcuatica moto) {
        Moto = moto;
    }

    public double TerminarAlquiler(int cantidadHoras) {
        double costoPorHora = 0;
        if (this.Moto.getMarca().equals("Yamaha")) {
            costoPorHora = 50000 * cantidadHoras;
        }
        if (this.Moto.getMarca().equals("Kawasaki")) {
            costoPorHora = 60000 * cantidadHoras;
        }
        if (this.Moto.getMarca().equals("Sea-Doo")) {
            costoPorHora = 60000 * cantidadHoras;
        }

        if (this.Cliente.getEdad() < 18) {
            costoPorHora = costoPorHora * 2;
        }

        return costoPorHora;
    }

    public static HashMap<String, Integer> AnalizarAlquileres(Alquiler[] historial) {
        HashMap<String, Integer> response = new HashMap<String, Integer>();
        int menos18 = 0;
        int entre18_30 = 0;
        int entre31_40 = 0;
        int entre41_50 = 0;
        int mas50 = 0;

        for (int i = historial.length - 1; i >= 0; i--) {
            if (historial[i].Cliente.getEdad() <= 18) {
                menos18++;
                response.put("18 o menos", menos18);
            }
            if (historial[i].Cliente.getEdad() > 18 && historial[i].Cliente.getEdad() <= 30) {
                entre18_30++;
                response.put("18 - 30", entre18_30);
            }
            if (historial[i].Cliente.getEdad() > 30 && historial[i].Cliente.getEdad() <= 40) {
                entre31_40++;
                response.put("31 - 40", entre31_40);
            }
            if (historial[i].Cliente.getEdad() > 41 && historial[i].Cliente.getEdad() <= 50) {
                entre41_50++;
                response.put("41 - 50", entre41_50);
            }
            if (historial[i].Cliente.getEdad() > 50) {
                mas50++;
                response.put("51 o más", mas50);
            }
        }
        return response;
    }

    @Override
    public String toString() {
        return "" + this.Cliente.getNombre() + " con cédula " + this.Cliente.getCedula() + " renta la moto "
                + this.Moto.getId() + " modelo " + this.Moto.getModelo() + ".";
    }
}
