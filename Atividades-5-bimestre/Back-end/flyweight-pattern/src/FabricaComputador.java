import java.util.HashMap;
import java.util.Map;

public class FabricaComputador {
    private static Map<String, Computador> flyweight = new HashMap<>();

    // Map<CHAVE, VALOR> variavel;

    public Computador getComputador(int ram, int hd) {
        String id = "id:%s:%s".formatted(ram, hd);

        System.out.println("O identificador sendo buscado é: " + id);

        boolean computadorExiste = flyweight.containsKey(id);
        if (!computadorExiste) {
            Computador computador = new Computador(ram, hd);
            flyweight.put(id, computador);
            System.out.println("Um novo computador foi criado!!!");
        }

        Computador computadorObtido = flyweight.get(id);
        System.out.println("Computador obtido");
        return computadorObtido;
    }

}
