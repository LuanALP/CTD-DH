//usuário irá confirmar se quer jogar ou não, passando um booleano para a variável
var userWanttoPlay = confirm("Você gostaria de jogar???");
//função acionada caso o usuário desejar jogar
function comecarJogo() {
    //variáveis a serem incrementadas visando definir quando o jogo será encerrada
    let pontosUsuario = 0;
    let pontosScript = 0;
    //irá repetir enquando a pontuação de dos dois jogadores for menor que 2
    do {
        let jogadaUsuario = Number(
            prompt("O que você deseja jogar? 1 = pedra, 2 = papel, 3 = tesoura")
        );
        //valida se a jogada do usuário é válida
        while (jogadaUsuario !== 1 && jogadaUsuario !== 2 && jogadaUsuario !== 3) {
            alert("Jogada inválida. Digite uma jogada válida (1, 2 ou 3)");
            jogadaUsuario = Number(
                prompt("O que você deseja jogar? 1 = pedra, 2 = papel, 3 = tesoura")
            );
        }

        let jogadaScript = Math.floor(Math.random() * 3) + 1;

        console.log(
            "Jogada usuário: " + jogadaUsuario + " e jogada Script: " + jogadaScript
        );
        if (jogadaUsuario === 1 && jogadaScript === 2) {
            console.log("Você perdeu!");
            pontosScript++;
        } else if (jogadaUsuario === 2 && jogadaScript === 3) {
            console.log("Você perdeu");
            pontosScript++;
        } else if (jogadaUsuario === 3 && jogadaScript === 1) {
            console.log("Você perdeu");
            pontosScript++;
        } else if (jogadaUsuario ===  jogadaScript) {
            console.log("Empate JokenPo!");
        } else {
            console.log("Você venceu");
            pontosUsuario++;
        }
    } while (pontosScript < 2 && pontosUsuario < 2);
    //validando quem foi campeão do jogo
    if (pontosUsuario === 2) {
        alert("Você foi o grande campeão!");
    } else if (pontosScript === 2) {
        alert("Você perdeu para o BOT!");
    }
    //verifica se o usuário quer jogar novamente
    userWanttoPlay = confirm("Você gostaria de jogar novamente???");
    validarInicio();
}
//função que valida se o usuário quer jogar ou não
function validarInicio() {
    if (userWanttoPlay === true) {
        comecarJogo();
    } else {
        alert("Obrigado por visitar a página");
    }
}

validarInicio();