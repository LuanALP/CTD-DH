function modoDark() {

    let buttonDark = document.querySelector('body')
    buttonDark.classList.toggle('dark')

}

let contentRef = document.querySelector('.container')
const userTitleRef = document.querySelector("#title")
const userDescricaoRef = document.querySelector("#descricao")
const loginUrlRef = document.querySelector("#url")
const btnIncluir = document.querySelector("#incluir");


let cards = [
    
] 

function adicionarCard() {
    // Coletar os dados do usuário dos campos de entrada
    const title = userTitleRef.value;
    const descricao = userDescricaoRef.value;
    const url = loginUrlRef.value;
    
    // Criar um novo objeto de card
    const novoCard = {
      img: url,
      title: title,
      description: descricao
    };
    
    // Adicionar o novo card ao array
    cards.push(novoCard);
    
    // Atualizar o HTML com o novo card
    let contentHTML = "";
    for (let card of cards) {
      contentHTML += `
        <div class="item">
          <img src="${card.img}">
          <h2>${card.title}</h2>
          <p>${card.description}<p>
        </div>
      `;
    }
    contentRef.innerHTML = contentHTML;
  }

  btnIncluir.addEventListener("click", adicionarCard);

  /*
let card = {
    title:"",
    descricao:"",
    url:""
}

const cards = [
    {
        img: './imagens/tiger.jpg',
        title: 'O tigre',
        description: ' O tigre (Panthera tigris) é uma das espécies da subfamília Pantherinae (família Felidae) pertencente ao gênero Panthera. '
        + 'É encontrado de forma nativa apenas no continente asiático; é um predador carnívoro e é a maior espécie de felino do mundo junto com o leão.'
    }

] 

for(let card of cards) {
    
    contentRef.innerHTML += `
        <div class="item">
            <img src="${card.img}">
            <h2>${card.title}</h2>
            <p>${card.description}<p>
        </div>
    `

}
*/
