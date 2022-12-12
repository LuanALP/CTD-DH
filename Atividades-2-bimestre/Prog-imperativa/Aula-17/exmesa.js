class ContaBancaria {
    // Construção do objeto de fato
    constructor(numero,tipo,saldo,titular){
      // novo this -> {} -> Objeto vazio 
      this.numero = numero;
      this.tipo = tipo;
      this.saldo = saldo;
      this.titular = titular;
    }
}

const banco = {
clientes:[],
adicionarConta(numero,tipo,saldo,titular){
    const novaConta = new ContaBancaria(numero,tipo,saldo,titular);
    this.clientes.push(novaConta);
  },
  consultarCliente(valorDeBusca){
    const arrayDeEncontrados = [];
    for(let cliente of this.clientes){
      if(cliente.titular.includes(valorDeBusca)){
        arrayDeEncontrados.push(cliente);
      }
    }
    console.log(arrayDeEncontrados);
  },
  deposito(valorDeBusca, valorDeposito){
    for(let cliente of this.clientes){
      if(cliente.titular.includes(valorDeBusca)){
        let novoSaldo = cliente.saldo + valorDeposito;
        console.log("Depósito realizado, seu novo saldo é: ", novoSaldo);
      }
    }
  },
  saque(valorDeBusca, valorSaque){
    for(let cliente of this.clientes){
      if(cliente.titular.includes(valorDeBusca)){
        let novoSaldo = cliente.saldo - valorSaque;
        if (novoSaldo <= 0){
            console.log("Fundos insuficientes!");
        } else {
            console.log("Extração feita com sucesso, seu novo saldo é: ", novoSaldo);
        }
      }
    }
  },
  mostraClientes() {
    console.table(this.clientes);
}
}

banco.adicionarConta(01,"Conta corrente",1000,"Rafael Nardini");
banco.adicionarConta(5486273622,"Conta corrente",27771,"Abigael Natte");
banco.adicionarConta(1183971869,"Conta Poupança",8675,"Ramon Connell");
banco.adicionarConta(9582019689,"Conta Poupança",27363,"Jarret Lafuente");
banco.adicionarConta(1761924656,"Conta Poupança",32415,"Ansel Ardley");
banco.adicionarConta(7401971607,"Conta Poupança",18789,"Jacki Shurmer");
banco.adicionarConta(630841470,"Conta Poupança",28776,"Jobi Mawtus");
banco.adicionarConta(4223508636,"Conta Corrente",2177,"Thomasin Latour");
banco.adicionarConta(185979521,"Conta Poupança",25994,"Lonnie Verheijden");
banco.adicionarConta(3151956165,"Conta Corrente",7601,"Alonso Wannan");
banco.adicionarConta(2138105881,"Conta Poupança",33196,"Bendite Huggett");

//console.log(banco.clientes);
//banco.consultarCliente("Alonso");
//banco.deposito("Rafael", 1000);
//banco.saque("Ramon", 8675);
banco.mostraClientes();
