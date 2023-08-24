package aula26;

public interface EstadoReparo {

    void mudarEndereco(String novoEndereco);
    void darOrcamento(double valor);
    void adicionarItensExtras(double custo);
    void passarParaProximoEstado();
    void exibirDetalhes();
}
