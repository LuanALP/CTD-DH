import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ComputadorTest {

    @Test
    void dadoAlgumasInstancias_quandoChamamosContador_entaoRetornarQuantasInstanciasJaForamCriadas() {
        new Computador(8, 500);
        new Computador(8, 500);
        new Computador(8, 500);
        new Computador(8, 500);
        new Computador(8, 500);
        new Computador(8, 500);

        int valorEsperado = 6;
        Assertions.assertEquals(valorEsperado, Computador.contador);

    }

    @Test
    void dadoUmaFabricaComputador_quandoChamamosGetComputador_entaoValidaResultado() {
        FabricaComputador fabricaComputador = new FabricaComputador();

        Computador computador = fabricaComputador.getComputador(8, 500);

        int contadorEsperado = 1;
        Assertions.assertEquals(contadorEsperado, Computador.contador);
        Assertions.assertEquals(8, computador.getRam());
        Assertions.assertEquals(500, computador.getHd());
    }

    @Test
    void dadoUmaFabricaComputador_quandoChamamosGetComputador1000000000_entaoValidaResultado() {
        FabricaComputador fabricaComputador = new FabricaComputador();
        Computador computador = null;
        for (long i = 0; i < 100; i++) {
            computador = fabricaComputador.getComputador(8, 500);
        }

        int contadorEsperado = 1;
        Assertions.assertEquals(contadorEsperado, Computador.contador);
        Assertions.assertEquals(8, computador.getRam());
        Assertions.assertEquals(500, computador.getHd());
    }
}