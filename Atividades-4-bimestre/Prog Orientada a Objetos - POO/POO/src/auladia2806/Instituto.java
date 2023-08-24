package auladia2806;

public class Instituto {
    private String nome;
    private List<OfertaAcademica> ofertasAcademicas;

    public Instituto(String nome) {
        this.nome = nome;
        this.ofertasAcademicas = new ArrayList<>();
    }

    public void adicionar(OfertaAcademica ofertaAcademica) {
        ofertasAcademicas.add(ofertaAcademica);
    }

    public void gerarInforme() {
        for (OfertaAcademica ofertaAcademica : ofertasAcademicas) {
            ofertaAcademica.gerarInforme();
            System.out.println("Preço: " + ofertaAcademica.calcularPreco());
            System.out.println();
        }
    }
}}
