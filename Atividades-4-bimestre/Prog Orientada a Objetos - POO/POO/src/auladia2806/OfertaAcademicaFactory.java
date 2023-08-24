package auladia2806;

public class OfertaAcademicaFactory {
    private static OfertaAcademicaFactory factory;

    private OfertaAcademicaFactory() {
        // Construtor privado para evitar instanciação
    }

    public static OfertaAcademicaFactory getInstancia() {
        if (factory == null) {
            factory = new OfertaAcademicaFactory();
        }
        return factory;
    }

    public OfertaAcademica criarOfertaAcademica(String tipo, String nome, String descricao, double valor) {
        switch (tipo.toLowerCase()) {
            case "curso":
                return new Curso(nome, descricao, 0, 0, valor);
            case "programa":
                return new ProgramaIntensivo(nome, descricao, valor);
            case "workshop":
                return new Workshop(nome, descricao, valor);
            case "carreira":
                return new Carreira(nome, descricao, valor);
            default:
                throw new IllegalArgumentException("Tipo de oferta acadêmica inválido: " + tipo);
        }
    }
}


