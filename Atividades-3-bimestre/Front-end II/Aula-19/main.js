var loginButtonRef = document.querySelector('#login')

function authUser(event){

    event.preventDefault()
    const userLoginData = {
        email: 'ivin32@mail.com.br',
        password: '1234'
    }

    const requestHeaders ={
        'Accept': 'application/json',
        'Content-Type':'application/json'
    }

    var requestConfig = {
        method: 'POST',
        headers: requestHeaders,
        body: JSON.stringify(userLoginData)
    }

    fetch('https://todo-api.ctd.academy/v1/users/login', requestConfig).then{
        response => {
            if (response.ok){
                    response.json().then(
                        token => {
                            localStorage.setItem('Token', token.jwt)
                            console.log(token)
                        }
                    )
            } else {

            }
        }
    }
}
loginButtonRef.addEventListener('click', (event) => authUser(event))