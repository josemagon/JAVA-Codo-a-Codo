document.addEventListener("DOMContentLoaded", function(){
    
    document.getElementById("cerrar-modal").addEventListener("click", function(){
        document.getElementById("editar-cafe-modal").style.display = "none";
    });
});

function editarCafe(){
    document.getElementById("editar-cafe-modal").style.display = "flex";
}

function eliminarCafe(idCafe){
    if(window.confirm("¿Está seguro que desea eliminar el café " + idCafe + "?")){
        $.post("eliminar-cafe", 
        {id: idCafe},
        function(data){
            window.location = "";
        });
    }
}

