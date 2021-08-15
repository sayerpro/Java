package reto2;

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

    @Override
    public String toString() {
        return "" + this.Cliente.getNombre() + " con cédula" + this.Cliente.getCedula() + " renta la moto "
                + this.Moto.getId() + " modelo " + this.Moto.getModelo() + ".";
    }
}
