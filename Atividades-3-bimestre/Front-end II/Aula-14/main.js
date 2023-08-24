const cepInputRef = document.querySelector('#cep')
const cidadeInputRef = document.querySelector('#cidade')
const bairroInputRef = document.querySelector('#bairro')

//preencher os inputs com informações da API 
function fillFormWithAddress(address){
    cidadeInputRef.value = address.localidade
    bairroInputRef.value = address.bairro
}

//para fazer requisições para API
function searchAdress(){
    if(cepInputRef.value.length === 8){
        fetch(`https://viacep.com.br/ws/${cepInputRef.value}/json/`).then(
            response => {
                response.json().then(
                    data => {
                        if(data.erro === undefined){

                            fillFormWithAddress(data)
                        } else {
                            alert('O cep informado não é valido')
                            cepInputRef.value = ''
                        }
                        
                    }
                )
            }
        )
    }
}

//Escutando o evento de keyup do campo CEP
cepInputRef.addEventListener('keyup', searchAdress)