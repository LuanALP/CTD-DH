package auladia2806;

public abstract class OfertaAcademica {
    private String nome;
    private String descricao;

    public OfertaAcademica(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public abstract double calcularPreco();

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void gerarInforme() {
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
    }
}
