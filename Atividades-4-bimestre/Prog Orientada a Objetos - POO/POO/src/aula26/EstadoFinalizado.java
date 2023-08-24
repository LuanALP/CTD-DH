package aula26;

public class EstadoFinalizado implements EstadoReparo {
    private Reparo reparo;

    public EstadoFinalizado(Reparo reparo) {
        this.reparo = reparo;
    }

    @Override
    public void mudarEndereco(String novoEndereco) {
        System.out.println("Ação inválida. O endereço não pode ser alterado após o estado de 'Finalizado'.");
    }

    @Override
    public void darOrcamento(double valor) {
        System.out.println("Ação inválida. O orçamento não pode ser alterado após o estado de 'Finalizado'.");
    }

    @Override
    public void adicionarItensExtras(double custo) {
        System.out.println("Ação inválida. Os itens extras não podem ser adicionados após o estado de 'Finalizado'.");
    }

    @Override
    public void passarParaProximoEstado() {
        System.out.println("Ação inválida. O reparo já está no estado de 'Finalizado'.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Detalhes do reparo:");
        System.out.println("Nome do item: " + reparo.getNomeItem());
        System.out.println("Estado: Finalizado");
        System.out.println("Orçamento: " + reparo.getOrcamento());
        System.out.println("Endereço de entrega: " + reparo.getEnderecoEntrega());
        System.out.println();
    }
}