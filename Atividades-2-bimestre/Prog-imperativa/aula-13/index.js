function microondas(tempo,opcao){
    let tempoPadrao = 0;
    //switch case
    switch (opcao) {
        case 1:
            tempoPadrao = 10;
            break;

        case 2:
            tempoPadrao = 8;
            break;
        
        case 3:
            tempoPadrao = 15;
            
            break;

        case 4:
            tempoPadrao = 12;
            break;

        case 5:
            tempoPadrao = 8;
            break;

        default:
            console.log('Prato inexistente')
            return;
    }
    if(tempo < tempoPadrao){
        console.log("Tempo insuficiente");
    }
    else if (tempo > 2*tempoPadrao && tempo <= 3*tempoPadrao){
        console.log("Comida queimou");
    }
    else {
        console.log("Kabumm");
    }
    console.log("Prato pronto, bom apetite!!!");
}


//if else
function microondas2(tempo,opcao){
    let tempoPadrao = 0;
    if(opcao == 1 || opcao == 'pipoca'){
        tempoPadrao=10;
    }
    else if (opcao == 2 || opcao == 'macarrao'){
        tempoPadrao=8;
    }
    else if (opcao == 3 || opcao == 'carne'){
        tempoPadrao=15;
    }

    else if (opcao == 4 || opcao == 'feijao'){
        tempoPadrao=12;
    }
    else if (opcao == 5 || opcao == 'brigadeiro'){
        tempoPadrao=8;
    }
    else {
        console.log("Prato inexistente")
    }
    
    if(tempo < tempoPadrao){
        console.log("Tempo insuficiente");
    }
    else if (tempo > 2*tempoPadrao && tempo <= 3*tempoPadrao){
        console.log("Comida queimou");
    }
    else if (tempo > 3* tempoPadrao){
        console.log("Kabumm");
    }
    console.log("Prato pronto, bom apetite!!!");
}

function microondas3(tempo,opcao){
    console.log("Prato pronto, bom apetite!!!")
}