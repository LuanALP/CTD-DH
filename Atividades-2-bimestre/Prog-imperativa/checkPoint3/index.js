  /*1- Crie uma função construtora ou Classe Aluno que tenha como atributos: nome (string), 
quantidade de faltas (number) e notas (array de números).*/
class Aluno {
  constructor(nome = "", faltas = 0, notas = []) {
    this.nome = nome;
    this.faltas = faltas;
    this.notas = notas;
  };

   /*2-Na função construtora crie o método calcularMedia que retorna a média de suas notas. 
Também terá um método chamado faltas, que simplesmente aumenta o número de faltas em 1. 
Crie alguns alunos para testar a sua função construtora.*/

  calcularMedia() {
      let media = 0;
      let soma = 0;
      for (let i = 0; i < this.notas.length; i++) {
        soma += this.notas[i];
      }
      media = soma / this.notas.length;
      return (`${media.toFixed(2)}`);;
  };
  addfaltas() {
      this.faltas++;
    };
    
  };

/*const aluno1 = new Aluno("José", 6, [5.0, 7.5, 8.0, 9.0]);
console.log(aluno1.calcularMedia());
aluno1.addfaltas();
console.log(aluno1.faltas);*/

  /*3-crie o objeto literal curso que tem como atributos: nome do curso 
(string), nota de aprovação (number), faltas máximas (number) e uma 
lista de estudantes (um array composto pelos alunos criados no passo 2).*/

const curso = {
  nomeCurso: "Curso CTD",
  notaAprovacao: 7.0,
  faltasMaximas: 5,
  alunos: [],

    /*4-Crie o método que permite adicionar alunos à lista do curso, ou seja, quando chamamos nosso método 
  em nosso objeto curso, deverá adicionar um aluno a mais na propriedade lista de estudantes do objeto 
  curso.*/

  adicionarAluno(nome, faltas, notas = []) {
    const novoAluno = new Aluno(nome, faltas, notas);
    this.alunos.push(novoAluno);
  },

  buscarAluno(alunoBusca) {
    for (let aluno of this.alunos) {
      if (alunoBusca === aluno.nome) {
        return aluno;
      }
    }
  },

  /*5-Crie um método para o objeto curso que receba um aluno (como parâmetro) e retorne true se ele aprovou no curso ou false em caso de reprovação. 
Para ser aprovado, o aluno tem que ter uma média igual ou acima da nota de aprovação  e ter menos faltas que faltas máximas. 
Se tiver a mesma quantidade, tem que estar 10% acima da nota de aprovação.*/

  avaliador(alunoAvaliado) {
    
        const alunoBusca = this.buscarAluno(alunoAvaliado);
        const media = alunoBusca.calcularMedia();
        
        if (
          media >= this.notaAprovacao && alunoBusca.faltas < this.faltasMaximas) {
          console.log("O aluno", alunoBusca.nome,"foi aprovado.","Retorno do programa: ",true);
          return true;
        } else if (
          media >= this.notaAprovacao + (this.notaAprovacao * 0.1) && alunoBusca.faltas == this.faltasMaximas) {
          console.log("O aluno",alunoBusca.nome,"foi aprovado.","Retorno do programa: ",true);
          return true;
        } else {
          console.log("O aluno ",alunoBusca.nome,"foi reprovado.","Retorno do programa: ",false);
          return false;
        }
      },

  /*6- Crie um método para o objeto curso que percorra a lista de estudantes e retorne um array de booleanos com os resultados
  se os alunos aprovaram ou não.*/

  listaAvaliador() {
    let aprovados = [];
    for(let aluno of this.alunos){
      aprovados.push({ nome: aluno.nome, aprovado: this.avaliador(aluno.nome) })
    }
  }
};

curso.adicionarAluno("Caue", 4, [10, 9, 7]);
curso.adicionarAluno("Luan", 3, [5, 6, 9]);
curso.adicionarAluno("Ederson", 6, [10, 10, 10]);
curso.adicionarAluno("Eduardo", 2, [8, 9.5, 6]);
curso.adicionarAluno("Vanessa", 2, [8, 9.5, 10]);
curso.adicionarAluno("Pedro", 5, [7, 9, 10]);

//curso.avaliador("Eduardo");
//curso.avaliador("Caue");
console.log(curso.listaAvaliador());
//console.log(curso.alunos);
