package auladia2806;

public class Curso extends OfertaAcademica {
    double cargaHoraria;
    double duracao;
    private double valorHora;

    public Curso(String nome, String descricao, double cargaHoraria, double duracao, double valorHora) {
        super(nome, descricao);
        this.cargaHoraria = cargaHoraria;
        this.duracao = duracao;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPreco() {
        return cargaHoraria * duracao * valorHora;
    }
}
