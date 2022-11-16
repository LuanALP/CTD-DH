/*while -> enquanto
enquanto alguma condição for verdadeira repretirei algum bloco de código
Toda estrutura de repetição terá um critério de parada (condicional)
Loop infinito*/
/*
let contador = 0
while(contador <= 10){
    console.log("Contando... ", contador)
    contador++;//Adiciona 1 na variável contador
}

//do while --> faça alguma coisa enquanto algo for verdadeiro, pelo menos uma vez o bloco de código vai ser executado

do {
    console.log("Contando... ", contador)
    contador++;
}while(contador <= 10);
*/

//for: Para um critério inicial. Até uma determinada condição e um passo (incremento) de x faça alguma coisa
/*
for(let contador = 0; contador <=10;contador++){
    console.log("Contando...", contador)
}
*/
let numeros = [10, 15, 20, 30, 40];
let soma=0
for(let indice= 0; indice < numeros.length; indice++){
   const numero = numeros[indice]
   soma += numero;
}

console.log("Soma: ",soma);