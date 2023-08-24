package auladia2806;

import java.util.ArrayList;

public class ProgramaIntensivo extends OfertaAcademica {
    private double porcentagemBoni;
    private List<OfertaAcademica> ofertasAcademicas;

    public ProgramaIntensivo(String nome, String descricao, double porcentagemBoni) {
        super(nome, descricao);
        this.porcentagemBoni = porcentagemBoni;
        this.ofertasAcademicas = new ArrayList<>();
    }

    public void adicionar(OfertaAcademica ofertaAcademica) {
        ofertasAcademicas.add(ofertaAcademica);
    }

    @Override
    public double calcularPreco() {
        double precoTotal = 0.0;

        for (OfertaAcademica ofertaAcademica : ofertasAcademicas) {
            precoTotal += ofertaAcademica.calcularPreco();
        }

        return precoTotal - (precoTotal * porcentagemBoni);
    }
}

