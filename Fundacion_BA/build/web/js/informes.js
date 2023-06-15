/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validacionInformeForm(e) {
    const mensaje_admin = document.getElementById("mensaje_admin");
    const descripcion_informe = document.getElementById("descripcion_informe");
    const mascota_informe = document.getElementById("mascota_informe");
    if (mensaje_admin.value.length === 0 || descripcion_informe.value.length === 0 || mascota_informe.value === '0') {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Llena por favor todos los campos',
            timer: 1500
        });
        e.preventDefault();
    } else {
        swal({
            position: 'center',
            icon: 'success',
            title: 'Enviado',
            timer: 1500
        });
    }
}