package aula26;

public class Main {
    public static void main(String[] args) {
        // Criar um reparo com um item de "liquidificador"
        Reparo reparo = ReparoFactory.criarReparo("liquidificador");

        // Atribuir um orçamento
        reparo.setOrcamento(100.0);

        // Mudar para o estado de reparação
        reparo.passarParaProximoEstado();

        // Adicionar custo de peças extras
        reparo.adicionarCustoItensExtras(50.0);

        // Passar para o estado de envio
        reparo.passarParaProximoEstado();

        // Mudar o endereço de entrega
        reparo.setEnderecoEntrega("Rua A, 123");

        // Passar para o estado finalizado
        reparo.passarParaProximoEstado();

        // Exibir detalhes do reparo
        reparo.exibirDetalhes();
    }
}