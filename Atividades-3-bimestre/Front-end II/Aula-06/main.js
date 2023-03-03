let contentRef = document.querySelector('#content')

let noticia = {

}

const noticias = [
    {
        titulo: 'Esse é o primeiro Post',
        descricao: 'Lorem ipsum dolor sit amet consectetur adipisicing elit.',
        url: '#'
    },
    {
        titulo: 'Esse é o segundo Post',
        descricao: 'Lorem ipsum dolor sit amet consectetur adipisicing elit.',
        url: '#'
    },
    {
        titulo: 'Esse é o terceiro Post',
        descricao: 'Lorem ipsum dolor sit amet consectetur adipisicing elit.',
        url: '#'
    }
] 

for(let noticia of noticias) {

    contentRef.innerHTML += `
        <article>
            <h1>${noticia.titulo}</h1>
            <p>${noticia.descricao}</p>
            <a href="">${noticia.url}</a>
        </article>
    `

}