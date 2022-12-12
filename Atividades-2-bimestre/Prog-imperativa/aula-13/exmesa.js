
const participanteA  = [ 5, 8, 4, 9, 5];
const participanteB = [8, 7, 8, 6, 8];
const participanteC = [7, 5, 10, 8, 3]

function pontuacaoMedia(participante) {
  let media = 0;
  let soma = 0;
    for (let i = 0; i < participante.length; i++) {
        soma += participante[i];
        media = soma / 5;        
   }
   console.log('Média: ',media);
   return media;
} 

function pontuacaoMaior (participante) {
  let maiorNota = Math.max.apply(null, participante);        
  console.log('Maior Nota: ',maiorNota);
  return maiorNota;
}

function competicao(participanteA, participanteB, participanteC) {
  
let resultadoMedia = 0;
let resultadoMaior = 0;
console.log("-----------------Participante A------------------")
let mediaA = pontuacaoMedia(participanteA);
let maiorA = pontuacaoMaior(participanteA);
console.log("-----------------Participante B------------------")
let mediaB = pontuacaoMedia(participanteB);
let maiorB = pontuacaoMaior(participanteB);
console.log("-----------------Participante C------------------")
let mediaC = pontuacaoMedia(participanteC);
let maiorC = pontuacaoMaior(participanteC);

if (mediaA > mediaB && mediaA > mediaC) {
  resultadoMedia = mediaA;
  console.log("O vencedor da melhor média é o Participante A com a média: ", resultadoMedia);
  
} else if (mediaB > mediaA && mediaB > mediaC) {
  resultadoMedia = mediaB;
  console.log("O vencedor da melhor média é o Participante B com a média: ", resultadoMedia)
}
else{
  resultadoMedia = mediaC;
  console.log("O vencedor da melhor média é o Participante C com a média: ", resultadoMedia)
}

if (maiorA > maiorB && maiorA > maiorC) {
  resultadoMaior = maiorA;
  console.log("O vencedor da melhor média é o Participante A com a nota: ", resultadoMaior);
  
} else if (maiorB > maiorA && maiorB > maiorC) {
  resultadoMaior = maiorB;
  console.log("O vencedor da melhor média é o Participante B com a nota: ", resultadoMaior)
}
else {
  resultadoMaior = maiorC;
  console.log("O vencedor da maior nota é o Participante C com a nota: ", resultadoMaior)
}
  
}

competicao(participanteA,participanteB,participanteC);

 
/*
function microondas3(tempo,opcao){
  let tempoPadrao = opcao === 1 ? 10
  : opcao === 2 ? 8
  : opcao === 3 ? 15
  : opcao === 4 ? 12
  : opcao === 5 ? 8
  : -1
  
  if(tempoPadrao == -1){
    console.log("Prato inexistente");
    return;
  }*/