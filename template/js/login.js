const url = "http://localhost:8080/login";
const loginForm = document.querySelector("#loginForm");
const userName = document.querySelector("#login");
const pwd = document.querySelector("#password");

loginForm.onsubmit = function(){
    let user = {
        userName: userName.value,
        pwd: pwd.value,
    }

    login(user);
}

async function login(user){
    try {
        let response = await post(`${url}`, user);
    } catch(error) {
        console.log((error));
        console.log(Error(error));
    }
}

function post(url, user){
    return new Promise(function(resolved, rejected){
        let request = new XMLHttpRequest();
        request.open("POST", url, false);
        request.setRequestHeader('Content-Type', 'application/json');
        
        request.onload = function(){
            if (request.status <= 300){
                resolved(request.response.headers);
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