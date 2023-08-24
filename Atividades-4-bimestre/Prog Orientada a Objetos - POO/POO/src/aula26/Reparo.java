package aula26;

public class Reparo {
    private String nomeItem;
    private double orcamento;
    private String enderecoEntrega;
    private EstadoReparo estado;

    public Reparo(String nomeItem) {
        this.nomeItem = nomeItem;
        this.estado = new EstadoNoOrcamento(this);
    }

    public void setOrcamento(double orcamento) {
        estado.darOrcamento(orcamento);
    }

    public void adicionarCustoItensExtras(double custo) {
        estado.adicionarItensExtras(custo);
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        estado.mudarEndereco(enderecoEntrega);
    }

    public void setEstado(EstadoReparo estado) {
        this.estado = estado;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void passarParaProximoEstado() {
        estado.passarParaProximoEstado();
    }

    public void exibirDetalhes() {
        estado.exibirDetalhes();
    }
}
