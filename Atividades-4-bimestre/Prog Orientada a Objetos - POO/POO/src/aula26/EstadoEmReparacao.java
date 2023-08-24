package aula26;

public class EstadoEmReparacao implements EstadoReparo {
private Reparo reparo;

public EstadoEmReparacao(Reparo reparo) {
        this.reparo = reparo;
        }

@Override
public void mudarEndereco(String novoEndereco) {
        System.out.println("Ação inválida. O endereço só pode ser alterado após o estado de 'Para Envio'.");
        }

@Override
public void darOrcamento(double valor) {
        System.out.println("Ação inválida. O orçamento já foi definido.");
        }

@Override
public void adicionarItensExtras(double custo) {
        reparo.adicionarCustoItensExtras(custo);
        }

@Override
public void passarParaProximoEstado() {
        reparo.setEstado(new EstadoParaEnvio(reparo));
        }

@Override
public void exibirDetalhes() {
        System.out.println("Detalhes do reparo:");
        System.out.println("Nome do item: " + reparo.getNomeItem());
        System.out.println("Estado: Em Reparação");
        System.out.println("Orçamento: " + reparo.getOrcamento());
        System.out.println("Endereço de entrega: " + reparo.getEnderecoEntrega());
        System.out.println();
        }
        }
