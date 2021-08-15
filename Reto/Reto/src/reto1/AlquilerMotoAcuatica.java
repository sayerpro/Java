package reto1;

public class AlquilerMotoAcuatica {

    private int Id;
    private String CedulaCliente;
    private int AnoNacimientoCliente;
    private String IdentificadorMoto;
    private int HorasAlquiler;

    public static void main(String[] args) {
        double result = TerminarAlquiler(8);
        System.out.println(result);
    }

    public AlquilerMotoAcuatica(int _Id, String _Cedula, int _AnoNacimiento, String _Identificador, int _Horas) {
        setId(_Id);
        setCedulaCliente(_Cedula);
        setAnoNacimientoCliente(_AnoNacimiento);
        setIdentificadorMoto(_Identificador);
        setHorasAlquiler(_Horas);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        CedulaCliente = cedulaCliente;
    }

    public int getAnoNacimientoCliente() {
        return AnoNacimientoCliente;
    }

    public void setAnoNacimientoCliente(int anoNacimientoCliente) {
        AnoNacimientoCliente = anoNacimientoCliente;
    }

    public String getIdentificadorMoto() {
        return IdentificadorMoto;
    }

    public void setIdentificadorMoto(String identificadorMoto) {
        IdentificadorMoto = identificadorMoto;
    }

    public int getHorasAlquiler() {
        return HorasAlquiler;
    }

    public void setHorasAlquiler(int horasAlquiler) {
        HorasAlquiler = horasAlquiler;
    }

    public static double TerminarAlquiler(int cantidadHoras) {
        double cobroTotal = 0;
        if (cantidadHoras > 0) {
            cobroTotal = 40000 * cantidadHoras;
            if (cantidadHoras > 5 && cantidadHoras < (5 + 3)) {
                cobroTotal = (cantidadHoras * 40000) * 1.15;
            }
            if (cantidadHoras > (5 + 2)) {
                cobroTotal = (cantidadHoras * 40000) * 1.30;
            }
        }
        return cobroTotal;
    }
}
