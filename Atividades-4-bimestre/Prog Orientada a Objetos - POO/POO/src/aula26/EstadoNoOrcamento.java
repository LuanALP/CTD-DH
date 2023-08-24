package aula26;

public class EstadoNoOrcamento implements EstadoReparo {
private Reparo reparo;

public EstadoNoOrcamento(Reparo reparo) {
        this.reparo = reparo;
        }

@Override
public void mudarEndereco(String novoEndereco) {
        System.out.println("Ação inválida. O endereço só pode ser alterado após o estado de 'Para Envio'.");
        }

@Override
public void darOrcamento(double valor) {
        reparo.setOrcamento(valor);
        }

@Override
public void adicionarItensExtras(double custo) {
        System.out.println("Ação inválida. Os itens extras só podem ser adicionados após o estado de 'Em Reparação'.");
        }

@Override
public void passarParaProximoEstado() {
        reparo.setEstado(new EstadoEmReparacao(reparo));
        }

@Override
public void exibirDetalhes() {
        System.out.println("Detalhes do reparo:");
        System.out.println("Nome do item: " + reparo.getNomeItem());
        System.out.println("Estado: No Orçamento");
        System.out.println("Orçamento: " + reparo.getOrcamento());
        System.out.println("Endereço de entrega: " + reparo.getEnderecoEntrega());
        System.out.println();
        }
        }

