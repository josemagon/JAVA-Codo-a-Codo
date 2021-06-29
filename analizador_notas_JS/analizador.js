var cant_notas = 3;

var nombre = prompt('Ingrese su nombre');
var notas = [];
for (let index = 0; index < cant_notas; index++) {
    notas[index] = prompt('Ingrese nota (' + parseInt(index+1) +' de ' + cant_notas + ')');
}

alert('Promedio de sus notas es ' + promediar(notas));

function promediar(lasNotas){
    resultado = 0;
    for (let index = 0; index < cant_notas; index++) {
    const nota = parseFloat(notas[index]);
    resultado = resultado + nota;
    }

    return resultado / cant_notas;
}