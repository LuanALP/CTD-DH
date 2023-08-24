package auladia2806;

public class Carreira extends OfertaAcademica {
    private double valorBasico;
    private List<OfertaAcademica> ofertasAcademicas;

    public Carreira(String nome, String descricao, double valorBasico) {
        super(nome, descricao);
        this.valorBasico = valorBasico;
        this.ofertasAcademicas = new ArrayList<>();
    }

    public void adicionar(OfertaAcademica ofertaAcademica) {
        if (ofertaAcademica instanceof Curso && ((Curso) ofertaAcademica).cargaHoraria < 10) {
            throw new IllegalArgumentException("Cursos com carga horária inferior a 10h não podem ser adicionados a uma carreira.");
        }

        ofertasAcademicas.add(ofertaAcademica);
    }

    @Override
    public double calcularPreco() {
        double precoTotal = valorBasico;

        for (OfertaAcademica ofertaAcademica : ofertasAcademicas) {
            precoTotal += ofertaAcademica.calcularPreco();
        }

        return precoTotal;
    }
}
