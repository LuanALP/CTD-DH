package auladia2806;

public class Teste {
    public static void main(String[] args) {
        OfertaAcademicaFactory factory = OfertaAcademicaFactory.getInstancia();
        Instituto instituto = new Instituto("Instituto ABC");

        // Criação dos cursos
        OfertaAcademica curso1 = factory.criarOfertaAcademica("curso", "FrontEnd", "Curso de FrontEnd", 1000);
        ((Curso) curso1).duracao = 2;
        ((Curso) curso1).cargaHoraria = 16;

        OfertaAcademica curso2 = factory.criarOfertaAcademica("curso", "BackEnd", "Curso de BackEnd", 900);
        ((Curso) curso2).duracao = 2;
        ((Curso) curso2).cargaHoraria = 20;

        // Criação do programa intensivo
        OfertaAcademica programaIntensivo = factory.criarOfertaAcademica("programa", "FullStack", "Programa FullStack", 0.2);
        ((ProgramaIntensivo) programaIntensivo).adicionar(curso1);
        ((ProgramaIntensivo) programaIntensivo).adicionar(curso2);

        instituto.adicionar(curso1);
        instituto.adicionar(curso2);
        instituto.adicionar(programaIntensivo);

        instituto.gerarInforme();
    }
}
