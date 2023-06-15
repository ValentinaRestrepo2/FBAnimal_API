/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const formaddmascota = document.getElementById("formaddmascota");

document.getElementById("btnaddmas").addEventListener("click", () => {

    const nombre = document.querySelector('[name=name_mascota]').value;
    const desc = document.querySelector('[name=desc_mascota]').value;
    const edad = document.querySelector('[name=edad_mascota]').value;
    const raza = document.querySelector('[name=raza_mascota]').value;
    console.log("EEQEQELQLEQL")
    if (nombre.trim() === "" && desc.trim() === "" && edad.trim() === "") {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Llena por favor todos los campos',
            showConfirmButton: false,
            timer: 1500
        });
    } else if (edad.length < 0) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Solo numeros positivos.',
            showConfirmButton: true,
            timer: 1500
        });
    } else {
        document.getElementById("btnaddmas").value = "Registrar";
        formaddmascota.method = "POST";
        formaddmascota.action = "ControladorMascota";
        document.getElementById("btnaddmas").type = "submit";
        console.log("holaa");
        console.log(formaddmascota);
    }
    console.log("HOllaaaa btnn");

});