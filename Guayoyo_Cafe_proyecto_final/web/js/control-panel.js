var cafe_editado = "";
document.addEventListener("DOMContentLoaded", function(){
    
    document.getElementById("cerrar-modal").addEventListener("click", function(){
        document.getElementById("editar-cafe-modal").style.display = "none";
        document.getElementById("cafe-editado").textContent = "Cargando...";
        document.getElementById("cafe-editado-input").value = "";
        $("#editar-cafe-modal input").attr("disabled");
    });
    
    document.getElementById("cerrar-agregar-cafe-modal").addEventListener("click", function(){
        document.getElementById("agregar-cafe-modal").style.display = "none";
    });
});

function editarCafe(idCafe){
    cafe_editado = idCafe;
    document.getElementById("editar-cafe-modal").style.display = "flex";
    document.getElementById("cafe-editado").textContent = idCafe;
    document.getElementById("cafe-editado-input").value = idCafe;
    getCafeByID(idCafe);
}

function nuevoCafe(){
    document.getElementById("agregar-cafe-modal").style.display = "flex";
}

function getCafeByID(anID){
    $.get("get-cafe-by-id", {id : anID},
    function(data){
       var cafe = JSON.parse(data);
       document.getElementById("nombre-editado").value = cafe.nombre;
       document.getElementById("origen-editado").value = cafe.origen;
       document.getElementById("stock-editado").value = cafe.stock;
       
       $("#editar-cafe-modal input").removeAttr("disabled");
    });
}

function eliminarCafe(){
    if(window.confirm("¿Está seguro que desea eliminar el café " + cafe_editado + "?")){
        $.post("eliminar-cafe", 
        {id: cafe_editado},
        function(data){
            window.location.reload();
        });
    }
}
