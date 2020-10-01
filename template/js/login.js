const url = "http://localhost:8080/login";
const loginForm = document.querySelector("#loginForm");

loginForm.onsubmit = async function(event){
    event.preventDefault();

    let user = {
        userName: this.login.value,
        pwd: this.password.value,
    }

    await login(user);
    this.reset();
}

async function login(user){
    try {
        let response = await post(`${url}`, user);
    } catch(error) {
        console.log(Error(error));
    }
}

function post(url, user){
    return new Promise(function(resolved, rejected){
        let request = new XMLHttpRequest();
        request.open("POST", url, true);
        request.setRequestHeader('Content-Type', 'application/json');

        request.onload = function(){
            if (request.status <= 300){
                resolved(request.getResponseHeader('Authorization'));
            } else {
                rejected(Error("Login failed"));
            }
        }

        request.onerror = function(){
            rejected("Login failed");
        }

        request.send(JSON.stringify(user));
    })
}