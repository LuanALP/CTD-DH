
window.addEventListener('load', () => console.log('carregou'))

const userEmailRef = document.querySelector("#userEmail")
const userPwdRef = document.querySelector("#pwd")
const loginButtonRef = document.querySelector("#loginButton")

var userData = {
    email: '',
    password: ''
}

function validarSenha(pwd){

    userData.password = pwd

}

function validarEmail(email) {
    if(email.length < 4) {
        loginButtonRef.disable = true
    }
    userData.email = email
        userData.email = email
        loginButtonRef.enable = true
}

function login(event) {
    event.preventDefault()
    console.log(userData)
}

userEmailRef.addEventListener('keyup', (event) => validarEmail(event.target.value))
userPwdRef.addEventListener('keyup', (event) => validarSenha(event.target.value))
loginButtonRef.addEventListener('click', (event) => login(event))