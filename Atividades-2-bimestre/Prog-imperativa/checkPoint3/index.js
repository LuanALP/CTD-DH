  /*1- Crie uma função construtora ou Classe Aluno que tenha como atributos: nome (string), 
quantidade de faltas (number) e notas (array de números).*/
class Aluno {
  constructor(nome = "", faltas = 0, notas = []) {
    this.nome = nome;
    this.faltas = faltas;
    this.notas = notas;
  }
}
  /*2-Na função construtora crie o método calcularMedia que retorna a média de suas notas. 
Também terá um método chamado faltas, que simplesmente aumenta o número de faltas em 1. 
Crie alguns alunos para testar a sua função construtora.*/
const escola = {
  alunos: [],
  buscarAluno(alunoBusca) {
    for (let aluno of this.alunos) {
      if (alunoBusca === aluno.nome) {
        return aluno;
      }
    }
  },
  calcularMedia(alunoMedia) {
    const alunoBusca = this.buscarAluno(alunoMedia);
    if (alunoBusca) {
      let media = 0;
      let soma = 0;
      for (let i = 0; i < alunoBusca.notas.length; i++) {
        soma += alunoBusca.notas[i];
      }
      media = soma / alunoBusca.notas.length;
      console.log("A média das notas do aluno",alunoBusca.nome,"é:",media.toFixed(2));
    }
  },
  faltas(alunoFalta) {
    const alunoBusca = this.buscarAluno(alunoFalta);
    if (alunoBusca) {
      alunoBusca.faltas++;
      console.log("O total de faltas do aluno",alunoBusca.nome,"agora é:",alunoBusca.faltas);
    }
  },
};

  /*3-crie o objeto literal curso que tem como atributos: nome do curso 
(string), nota de aprovação (number), faltas máximas (number) e uma 
lista de estudantes (um array composto pelos alunos criados no passo 2).*/

const curso = {
  nomeCurso: "Curso CTD",
  notaAprovacao: 7.0,
  faltasMaximas: 5,
  estudantes: escola.alunos,

    /*4-Crie o método que permite adicionar alunos à lista do curso, ou seja, quando chamamos nosso método 
  em nosso objeto curso, deverá adicionar um aluno a mais na propriedade lista de estudantes do objeto 
  curso.*/

  adicionarAluno(nome, faltas, notas = []) {
    const novoAluno = new Aluno(nome, faltas, notas);
    this.estudantes.push(novoAluno);
  },

  /*5-Crie um método para o objeto curso que receba um aluno (como parâmetro) e retorne true se ele aprovou no curso ou false em caso de reprovação. 
Para ser aprovado, o aluno tem que ter uma média igual ou acima da nota de aprovação  e ter menos faltas que faltas máximas. 
Se tiver a mesma quantidade, tem que estar 10% acima da nota de aprovação.*/

  avaliador(alunoAvaliado) {
    for (let estudante of this.estudantes) {
      if (alunoAvaliado === estudante.nome) {
        const alunoBusca = estudante;
        
        media = 0;
        soma = 0;

        for (let i = 0; i < alunoBusca.notas.length; i++) {
          soma += alunoBusca.notas[i];
        }
        media = soma / alunoBusca.notas.length;

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
      }
    }
  },

  /*6- Crie um método para o objeto curso que percorra a lista de estudantes e retorne um array de booleanos com os resultados
  se os alunos aprovaram ou não.*/

  listaAvaliador(){
    let aprovados = [];
    let reprovados = [];

    for(let estudante of this.estudantes){
      const alunoBusca = estudante;
      let media = 0;
      let soma = 0;

      for (let i = 0; i < alunoBusca.notas.length; i++) {
        soma += alunoBusca.notas[i];
      }
      media = soma / alunoBusca.notas.length;

      if (
        media >= this.notaAprovacao && alunoBusca.faltas < this.faltasMaximas) {
        aprovados.push("Aluno "+alunoBusca.nome+":",true);
      } else if (
        media >= this.notaAprovacao + (this.notaAprovacao * 0.1) && alunoBusca.faltas == this.faltasMaximas) {
        aprovados.push("Aluno "+alunoBusca.nome+":",false);
      } else {
        reprovados.push("Aluno "+alunoBusca.nome+":",false);
      }
    }  
    console.log("Lista de aprovados: ",aprovados);
    console.log("Lista de reprovados: ",reprovados);
  }
};
curso.adicionarAluno("Caue", 4, [10, 9, 7]);
curso.adicionarAluno("Luan", 3, [5, 6, 9]);
curso.adicionarAluno("Zé Ricardo", 6, [10, 10, 10]);
curso.adicionarAluno("Eduardo", 7, [8, 9.5, 6]);

//escola.calcularMedia("Luan");
//escola.faltas("Zé Ricardo");
//curso.avaliador("Eduardo");
curso.listaAvaliador();
