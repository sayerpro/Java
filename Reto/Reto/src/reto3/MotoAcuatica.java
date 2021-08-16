package reto3;

public class MotoAcuatica {

    private String Id;
    private String Modelo;
    private String Marca;

    public MotoAcuatica(String id, String modelo, String marca) {
        setId(id);
        setModelo(modelo);
        setMarca(marca);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }
}
