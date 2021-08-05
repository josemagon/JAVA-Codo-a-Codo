document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("cerrar-modal").addEventListener("click", function(){
        document.getElementById("ingreso-modal").style.display = "none";
    });
    
    setTimeout(() => {
        document.getElementById("mensajes").display = "none";
    }, 3000);
});

function showLoginForm(){
    document.getElementById("ingreso-modal").style.display = "flex";
    document.getElementsByName("email").item(0).focus();
}