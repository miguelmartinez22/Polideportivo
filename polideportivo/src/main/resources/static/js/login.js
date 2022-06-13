var usuarioAnalizar = document.getElementById("usuarioErroneo").value;

window.onload = function usuarioErroneo(){
    if(usuarioAnalizar === "El usuario o la contraseña introducidos son incorrectos"){
        alert(document.getElementById("usuarioErroneo").value);
    }
}
