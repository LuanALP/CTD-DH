package auladia2806;

public class Workshop extends OfertaAcademica {
    private double valorTrabalhoPratico;

    public Workshop(String nome, String descricao, double valorTrabalhoPratico) {
        super(nome, descricao);
        this.valorTrabalhoPratico = valorTrabalhoPratico;
    }

    @Override
    public double calcularPreco() {
        return valorTrabalhoPratico;
    }
}