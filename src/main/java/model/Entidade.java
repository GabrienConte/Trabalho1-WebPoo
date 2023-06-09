package model;

public class Entidade {
    private int id = 0;
    private String nome;
    private String cpf;
    private String telefone;

    public Entidade(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Entidade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
