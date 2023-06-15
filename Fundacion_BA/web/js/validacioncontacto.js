/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const formccontacto = () => {
const formContacto = document.getElementById("form_contacto");

document.querySelector("[name=accion]").addEventListener("click", () => {

    const nombre = document.querySelector('[name=nombre]').value;
    const email = document.querySelector('[name=email]').value;
    const celular = document.querySelector('[name=celular]').value;
    const mensaje = document.querySelector('[name=mensaje]').value;
    const select_pqrs = document.querySelector('[name=select_pqrs]').value;
    console.log(select_pqrs);
    console.log(typeof (select_pqrs));
    if (nombre.trim() === "" && email.trim() === "" && celular.trim() === "" && email.trim() === "") {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Llena por favor todos los campos',
            showConfirmButton: false,
            timer: 1500
        });
    } else if (celular.length < 10) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El celular debe tener al menos 10 digitos.',
            showConfirmButton: true,
            timer: 1500
        });
    } else if (select_pqrs === "1") {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'No haz selecciona el tipo de PQRS, seleccionalo por favor.',
            showConfirmButton: false,
            timer: 1500
        });
    } else {
        document.querySelector("[name=accion]").value = "ContactoIndex";
        formContacto.method = "POST";
        formContacto.action = "ControladorContacto";
        document.querySelector("[name=accion]").type = "submit";
    }
    });
};

const formaddmascota = document.getElementById("formaddmascota");

document.getElementById("btnaddmas").addEventListener("click", () => {

    const nombre = document.querySelector('[name=name_mascota]').value;
    const desc = document.querySelector('[name=desc_mascota]').value;
    const edad = document.querySelector('[name=edad_mascota]').value;
    const raza = document.querySelector('[name=raza_mascota]').value;

    if (nombre.trim() === "" && desc.trim() === "" && edad.trim() === "" && raza.trim() === "") {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Llena por favor todos los campos',
            showConfirmButton: false,
            timer: 1500
        });
    } else if (raza === '' || raza === 0) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'La raza debe ser mayor a 2 letras.',
            showConfirmButton: true,
            timer: 1500
        });
    }else if (edad.length < 0) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Solo numeros positivos, es decir, mayor o igual a 0.',
            showConfirmButton: true,
            timer: 1500
        });
    }else if (desc.length > 300) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Solo se permite el max de 300 caracteres para la descripción.',
            showConfirmButton: true,
            timer: 1500
        });
    }else {
        document.getElementById("btnaddmas").value = "Registrar";
        formaddmascota.method = "POST";
        formaddmascota.action = "ControladorMascota";
        document.getElementById("btnaddmas").type = "submit";
    }
});


const formusuario = () => {
const formconusuario = document.getElementById("formconusuario");

document.querySelector("[name=accion2]").addEventListener("click", () => {

    const nombre = document.querySelector('[name=nombre]').value;
    const email = document.querySelector('[name=email]').value;
    const celular = document.querySelector('[name=celular]').value;
    const mensaje = document.querySelector('[name=mensaje]').value;
    const select_pqrs = document.querySelector('[name=select_pqrs]').value;
    if (select_pqrs === "1" || mensaje.trim() === "") {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Llena por favor todos los campos',
            showConfirmButton: false,
            timer: 1500
        });
    }
        else {
        document.querySelector("[name=accion]").value = "contactoUsuario";
        formconusuario.method = "POST";
        formconusuario.action = "ControladorVisitante";
        document.querySelector("[name=accion]").type = "submit";
        console.log("holaa");
        console.log(formconusuario);
    }
    console.log("HOllaaaa btnn");
    });
};


//const cargarDatosContacto = (id, correo) => {
//
//    const formContactoCorreo = document.getElementById("formCorreoCon");
//    document.getElementById("enviarCorreoContac").addEventListener("click", () => {
//
//        const asunto = document.querySelector('[name=asunto_contacto_admin]').value;
//        const emaail = document.querySelector('[name=mail_contacto_admin]').value;
//
//        if (emaail.trim() === "") {
//            swal({
//                position: 'center',
//                icon: 'warning',
//                title: 'Llena por favor todos los campos',
//                showConfirmButton: false,
//                timer: 1500
//            });
//        } else {
//            document.getElementById("enviarCorreoContac").value = "enviarCorreoContactoAdmin";
//            formContactoCorreo.method = "POST";
//            formContactoCorreo.action = "ControladorContacto";
//            document.getElementById("enviarCorreoContac").type = "submit";
//            formContactoCorreo.elements["id"].value = id;
//            formContactoCorreo.elements["correo"].value = correo;
//        }
//    });
//};