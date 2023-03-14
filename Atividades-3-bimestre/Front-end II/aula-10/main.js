const inputEmailRef = document.querySelector('#userEmail')
const inputPasswordRef = document.querySelector('#userPassword')
const loginButtonRef = document.querySelector('#loginBurron')

var formErrors = {
    userEmail: true,
    userPassword: true
}

function checkFormValidity () {

    const formErrorsArray = Object.values(formErrors)
    const formValidity = formErrorsArray.every(item => item === false)
    
    loginButtonRef.disabled = !formValidity
}

function validateInput(inputRef) {

    /* Validação manual
    if(inputEmailRef.value !== '') {
        console.log('Passou na validação')
    } else {
        console.log('Reprovou na validação')
    }
*/

//Validação mais dinâmica abaixo
    const inputValid = inputRef.checkValidity()
    const div = inputRef.parentElement
    //toda vez que é booleano não precisa colocar a condição ===
        if(inputValid){

            div.classList.remove('error')

        } else {

            div.classList.add('error')

        }
        //vai acessar o ID do objeto que ele receber como parametro
        formErrors[inputRef.id] = !inputValid

        checkFormValidity()

}

function login(event) {

    event.preventDefault()

    //continua o login

}


inputEmailRef.addEventListener('keyup', () => validateInput(inputEmailRef))
inputPasswordRef.addEventListener('keyup', () => validateInput(inputPasswordRef))
loginButtonRef.addEventListener('click'), (event) => login(event)