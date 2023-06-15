package model;

public class TipoUsuario {
    private int  id = 0;
    private String  tipo;

    public TipoUsuario(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoUsuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
