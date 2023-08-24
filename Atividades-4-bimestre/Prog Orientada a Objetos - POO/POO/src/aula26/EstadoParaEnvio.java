package aula26;

public class EstadoParaEnvio  implements EstadoReparo {
    private Reparo reparo;

    public EstadoParaEnvio(Reparo reparo) {
        this.reparo = reparo;
    }

    @Override
    public void mudarEndereco(String novoEndereco) {
        reparo.setEnderecoEntrega(novoEndereco);
    }

    @Override
    public void darOrcamento(double valor) {
        System.out.println("Ação inválida. O orçamento já foi definido.");
    }

    @Override
    public void adicionarItensExtras(double custo) {
        System.out.println("Ação inválida. Os itens extras só podem ser adicionados durante o estado de 'Em Reparação'.");
    }

    @Override
    public void passarParaProximoEstado() {
        reparo.setEstado(new EstadoFinalizado(reparo));
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Detalhes do reparo:");
        System.out.println("Nome do item: " + reparo.getNomeItem());
        System.out.println("Estado: Para Envio");
        System.out.println("Orçamento: " + reparo.getOrcamento());
        System.out.println("Endereço de entrega: " + reparo.getEnderecoEntrega());
        System.out.println();
    }
}

