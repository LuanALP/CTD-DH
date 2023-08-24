package aula26;

public class ReparoFactory {

    public static Reparo criarReparo(String nomeItem) {
        return new Reparo(nomeItem);
    }
}
