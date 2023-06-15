/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const Identificacion_login = document.getElementById("Identificacion__login");
const password_login = document.getElementById("password__login");

function validar() {
    if (!validarID()) {
        validarID();
        return false;
    }
    return true;
}

function validarID() {
    const error = document.getElementById("error");
    if (Identificacion_login.value === "" && password_login.value === "") {
        swal({
            title: "¡Debes llenar todos los campos!",
            icon: "warning",
            text: "Completa todos los campos, por favor!",
            timer: 2500, // es ms (mili-segundos)
            buttons: false
        });
        return false;
    } else if (Identificacion_login.value === "") {
        Identificacion_login.focus({preventScroll: true});
        swal({
            title: "Debes llenar todos los campos",
            text: "Completa el campo identificación!",
            icon: "warning",
            timer: 2500, // es ms (mili-segundos)
            buttons: false
        });
        Identificacion_login.focus({preventScroll: true});
        return false;
    } else if (password_login.value === "") {
        password_login.focus({preventScroll: true});
        swal({
            title: "Debes llenar todos los campos",
            text: "Completa el campo de la contraseña!",
            icon: "warning",
            timer: 2500, // es ms (mili-segundos)
            buttons: false
        });
        password_login.focus({preventScroll: true});
        return false;
    }
    return true;
}


function validarPerfil() {
    const uname = document.form_perfil.Nombre.value;
    const apellidoPerfil = document.form_perfil.pri_ape.value;
    const ape2Perfil = document.form_perfil.seg_ape.value;
    const barrioPerfil = document.form_perfil.select_barrio.value;
    const civilPerfil = document.form_perfil.select_civil.value;
    const direccionPerfil = document.form_perfil.direccion.value;
    const celPerfil = document.form_perfil.celular.value;
    const correoPerfil = document.form_perfil.email.value;
    const puestoPerfil = document.form_perfil.puesto_trabajo.value;
    if (uname.trim() === "" || apellidoPerfil.trim() === "" || ape2Perfil.trim() === ""
            || ape2Perfil.trim() === "" || barrioPerfil.trim() === ""
            || civilPerfil.trim() === "" || direccionPerfil.trim() === ""
            || celPerfil.trim() === "" || correoPerfil.trim() === "" || puestoPerfil.trim() === "") {
        swal({
            title: "¡Debes llenar todos los campos!",
            icon: "warning",
            text: "Tenemos campos vacios, llenarlos por favor!",
            timer: 3000, // es ms (mili-segundos)
            buttons: false
        });
        return false;
    } else if (uname.trim() !== "" || apellidoPerfil.trim() !== "" || ape2Perfil.trim() !== ""
            || ape2Perfil.trim() !== "" || barrioPerfil.trim() !== ""
            || civilPerfil.trim() !== "" || direccionPerfil.trim() !== ""
            || celPerfil.trim() !== "" || correoPerfil.trim() !== "" || puestoPerfil.trim() !== "") {
        swal({
            title: "Good job!",
            text: "You clicked the button!",
            icon: "success",
            button: "Aww yiss!"
        }).then((result) => {
            if (result) {
                return true;
            }
        });
    }
}

function validacion() {
    swal({
        title: "Good job!",
        text: "You clicked the button!",
        icon: "success",
        button: "Aww yiss!",
    }).then((result) => {
        if (result) {
            return false;
        }
    });
    return true;
}

function validarCampos() {
    const nombrePerfil = document.getElementById("Nombre");
    const apellidoPerfil = document.getElementById("pri_ape");
    const ape2Perfil = document.getElementsByName("seg_ape");
    const barrioPerfil = document.getElementsByName("select-barrio");
    const civilPerfil = document.getElementsByName("select-civil");
    const direccionPerfil = document.getElementsByName("direccion");
    const celPerfil = document.getElementsByName("celular");
    const correoPerfil = document.getElementsByName("email");
    const puestoPerfil = document.getElementsByName("puesto_trabajo");
    console.log(nombrePerfil.target.value);
    return true;
}

function eliminarCount() {

    if (probando()) {
        return true;
    }
}

const probando = () => {
    swal({
        title: "¿Estás seguro que deseas eliminar tú cuenta?",
        text: "Recuerda que si aceptas no podrás recuperar tu cuenta y te tocará volver a registrar una nueva cuenta!",
        icon: "warning",
        buttons: ["Cancelar", "Sí, eliminar"],
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            swal("¡Que falla!, Sentimos que te hallas retirado de nuestra familia, regresa pronto!! un abrazo", {
                icon: "success",
            });
            return true;
        } else {
            swal("Your imaginary file is safe!");
            return false;
        }
    });
    return "holaaa";
}


function cargarDatos(nombre, descripcion, costo, id) {
    document.querySelector('[name=edit_name_anuncio]').value = nombre;
    document.querySelector('[name=desc_edit_anuncio]').value = descripcion;
    document.querySelector('[name=costo_edit_anuncio]').value = costo;

    var actualizar = document.getElementById("actualizarAnuncio");
    actualizar.onclick = function () {
        var nom = document.querySelector('[name=edit_name_anuncio]').value;
        var desc = document.querySelector('[name=desc_edit_anuncio]').value;
        var costos = document.querySelector('[name=costo_edit_anuncio]').value;

        if (nom !== nombre || desc !== descripcion || costo !== costos) {
            if (nom === "" || desc === "" || costos === "") {
                swal({
                    position: 'center',
                    icon: 'warning',
                    title: 'Llena por favor todos los campos',
                    showConfirmButton: false,
                    timer: 1500
                });
            } else {
                formulario = document.getElementById("formulario_editar");
                formulario.action = "ControladorAnuncios";
                formulario.method = "POST";
                formulario.elements["anuncio"].value = "anuncioEdit";
                formulario.elements["id"].value = id;
                formulario.submit();
            }
        } else {
            swal({
                position: 'center',
                icon: 'warning',
                title: 'No haz cambiado nada.',
                showConfirmButton: false,
                timer: 1500
            })
        }
    }
}

//const eliminarMascota = (id) => {
//    const form_detele_mascota = document.getElementById("form_detele_mascota");
//    swal({
//        title: "¿Estás seguro que deseas esta mascota?",
//        text: "Rucuerda que debes si aceptas se eliminará completamente la mascota.",
//        icon: "warning",
//        buttons: ["Cancelar", "Sí, eliminar"],
//        dangerMode: true
//    }).then((willDelete) => {
//        if (willDelete) {
//            swal({
//                position: 'center',
//                icon: 'success',
//                title: 'Se eliminará esta mascota',
//                showConfirmButton: false,
//                timer: 1500
//            });
//            setTimeout(function () {
//                form_detele_mascota.method = "POST";
//                form_detele_mascota.action = "ControladorMascota";
//                form_detele_mascota.elements["accion"].value = "Eliminar";
//                form_detele_mascota.elements["id"].value = id;
//                form_detele_mascota.submit();
//                console.log(form_detele_mascota);
//            }, 1000);
//        }
//    });
//};


const eliminarusers = () => {
    const elimusuarios = document.getElementById("elimusuarios");
    swal({
        title: "¿Estás seguro que deseas este usuario?",
        text: "Rucuerda que debes si aceptas se eliminará completamente este usuario.",
        icon: "warning",
        buttons: ["Cancelar", "Sí, eliminar"],
        dangerMode: true
    }).then((willDelete) => {
        if (willDelete) {
            swal({
                position: 'center',
                icon: 'success',
                title: 'Se eliminará esta mascota',
                showConfirmButton: false,
                timer: 1500
            });
            setTimeout(function () {
                elimusuarios.method = "POST";
                elimusuarios.action = "ControladorIniciosesion";
                elimusuarios.elements["accion"].value = "eliminarMyCuenta";
                elimusuarios.submit();
                console.log(form_detele_mascota);
            }, 1000);
        }
    });
};

function cargarDatosMascotas(nombre, descripcion, edad, raza, vacunado, esterilizado, disponibilidad, id) {
    document.querySelector('[name=name_mascota_edit]').value = nombre;
    document.querySelector('[name=desc_mascota_edit]').value = descripcion;
    document.querySelector('[name=edad_mascota_edit]').value = edad;
    //document.querySelector('[name=raza_mascota_edit]').value = raza;
    document.querySelector('[name=select_vacunado_edit]').value = vacunado;
    document.querySelector('[name=select_esterilizado_edit]').value = esterilizado;
    document.querySelector('[name=select_disponibilidad_edit]').value = disponibilidad;

    var actualizar = document.getElementById("actualizarMascotaS");
    actualizar.onclick = function () {
        const nom = document.querySelector('[name=name_mascota_edit]').value;
        const desc = document.querySelector('[name=desc_mascota_edit]').value;
        const edades = document.querySelector('[name=edad_mascota_edit]').value;
        //const razass = document.querySelector('[name=raza_mascota_edit]').value;
        const vacunass = document.querySelector('[name=select_vacunado_edit]').value;
        const esteril = document.querySelector('[name=select_esterilizado_edit]').value;
        const disponi = document.querySelector('[name=select_disponibilidad_edit]').value;
        const solonumber = /^[0-9]$/;
        if (nom !== nombre || desc !== descripcion || edades !== edad || vacunass !== vacunado || esteril !== esterilizado || disponibilidad !== disponi) {
            if (nom === "" || desc === "" || edades === "" || vacunass === 0 || esteril === 0 || disponi === 0) {
                swal({
                    position: 'center',
                    icon: 'warning',
                    title: 'Llena por favor todos los campos',
                    showConfirmButton: false,
                    timer: 1500
                });
            } else {
                formularioMascota = document.getElementById("formulario_editar_mascotas");
                formularioMascota.action = "ControladorMascota";
                formularioMascota.method = "POST";
                formularioMascota.elements["accion"].value = "actualizarMascota";
                formularioMascota.elements["id"].value = id;
                formularioMascota.submit();
            }
        } else {
            swal({
                position: 'center',
                icon: 'warning',
                title: 'No haz cambiado nada.',
                showConfirmButton: false,
                timer: 1500
            });
        }
        ;
    };
}

function cargarDatosUsuario(cedula, nomb, primerap, segunap, correouser, fdate, celusuario, barriouser, civiluser, tipouser, direeccion, puestotrab, passwordd, e) {
    document.querySelector('[name=nom_user_edit]').value = nomb;
    document.querySelector('[name=ap_user_edit]').value = primerap;
    document.querySelector('[name=segap_user_edit]').value = segunap;
    document.querySelector('[name=correo_user_edit]').value = correouser;
    document.querySelector('[name=fcha_user_edit]').value = fdate;
    document.querySelector('[name=celular_user_edit]').value = celusuario;
    document.querySelector('[name=civil_user_edit]').value = civiluser;
    document.querySelector('[name=tipo_user_edit]').value = tipouser;
    document.querySelector('[name=dir_user_edit]').value = direeccion;
    document.querySelector('[name=trabp_user_edit]').value = puestotrab;
    document.querySelector('[name=contra_user_edit]').value = passwordd;
    
    const actualizaruserrr = document.getElementById("ActualizarUserxAdmin");
    actualizaruserrr.onclick = function () {
        e.preventDefault();
        const nomuser = document.querySelector('[name=nom_user_edit]').value;
        const appuser = document.querySelector('[name=ap_user_edit]').value;
        const segapp = document.querySelector('[name=segap_user_edit]').value;
        const correousser = document.querySelector('[name=correo_user_edit]').value;
        const fechauser = document.querySelector('[name=fcha_user_edit]').value;
        const celuser = document.querySelector('[name=celular_user_edit]').value;
        const civilusser = document.querySelector('[name=civil_user_edit]').value;
        const tiposuser = document.querySelector('[name=tipo_user_edit]').value;
        const direcccionuser = document.querySelector('[name=dir_user_edit]').value;
        const puesttoss = document.querySelector('[name=trabp_user_edit]').value;
        const typeuserr = document.querySelector('[name=tipo_user_edit]').value;
        const passedit = document.querySelector('[name=contra_user_edit]').value;
        if (nomuser !== nomb || appuser !== primerap || segunap !== segapp || correousser !== correouser || celuser !== celusuario
                || tipouser !== tiposuser || direcccionuser !== direeccion || puesttoss !== puestotrab || passedit !== passwordd || civilusser !== civiluser) {
            if (nomuser === "" || appuser === "" || segapp === "" || correousser === 0 || celuser === "" || civilusser === 0 || tiposuser === 0 || direcccionuser === "" || puesttoss === "" || passedit === ""
                    ) {
                swal({
                    position: 'center',
                    icon: 'warning',
                    title: 'Llena por favor todos los campos',
                    showConfirmButton: false,
                    timer: 1500
                });
            } else {
                formactUser = document.getElementById("formactUser");
                formactUser.action = "ControladorUsuario";
                formactUser.method = "POST";
                formactUser.elements["accion"].value = "ActualizarUserxAdmin";
                formactUser.elements["id"].value = cedula;
                formactUser.submit();
            }
        } else {
            swal({
                position: 'center',
                icon: 'warning',
                title: 'No haz cambiado nada.',
                showConfirmButton: false,
                timer: 1500
            });
        }

    };
}


function eliminarMascotaaaa() {
    alert("hola");
    const eliminarMascotas = document.getElementById("eliminarMascotas");
    eliminarMascotas.onclick = function () {
        alert("holaeee")
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                swal(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                        )
                form_detele_mascota = document.getElementById("form_detele_mascota");
                form_detele_mascota.action = "ControladorMascota";
                form_detele_mascota.method = "POST";
                form_detele_mascota.elements["accion"].value = "Eliminar";
                form_detele_mascota.elements["id"].value = id;
                form_detele_mascota.submit();
            }
        });
    };
}


const formRegistro = document.querySelector("#form_register");

document.querySelector("[name=accion]").addEventListener("click", (e) => {

    const identificacion = document.querySelector('[name=identificacion]').value;
    const Nombre = document.querySelector('[name=Nombre]').value;
    const pri_ape = document.querySelector('[name=pri_ape]').value;
    const seg_ape = document.querySelector('[name=seg_ape]').value;
    const celular = document.querySelector('[name=celular]').value;
    const fecha_nac = document.querySelector('[name=fecha_nac]').value;
    const direccion = document.querySelector('[name=direccion]').value;
    const puesto_trabajo = document.querySelector('[name=puesto_trabajo]').value;
    const email = document.querySelector('[name=email]').value;
    const password = document.querySelector('[name=password]').value;
    const select_barrio = document.querySelector('[name=select_barrio]').value;
    const select_civil = document.querySelector('[name=select_civil]').value;

    if (identificacion.trim() === "" || Nombre.trim() === "" || pri_ape.trim() === ""
            || seg_ape.trim() === "" || celular.trim() === ""
            || fecha_nac.trim() === "" || direccion.trim() === "" || puesto_trabajo.trim() === ""
            || email.trim() === "" || password.trim() === "") {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Llena por favor todos los campos',
            timer: 1500
        });
        console.log("Hello")
       e.preventDefault();
    }
});
//
//const eliminarUsuarioss = (id) => {
//    var confirmar;
//    confirmar = confirm("Deseas eliminar este usuario?");
//    if (confirmar) {
//        $.ajax({
//            url: "ControladorUsuario", type: 'POST', data: 'accion=eliminarMyCuenta',
//            success: function (data) {
//                swal({
//                    position: 'center',
//                    icon: 'success',
//                    title: 'Se ha eliminado.',
//                    timer: 1500
//                });
//            }, error: function (data, xml) {
//                swal({
//                    position: 'center',
//                    icon: 'success',
//                    title: 'NO Se ha eliminado.',
//                    timer: 1500
//                });
//            }
//        })
//    }




