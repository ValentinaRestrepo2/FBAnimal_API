
// Aquí van todas las exxpresiones regulares de validaciones de los inputs, busca la que necesites y en caso de que no este la agregas.
const expressions = {
    script:
            /[-a-zA-Z0-9@:%_\+.~#?&//=]{2,256}\.[a-z]{2,4}\b(\/[-a-zA-Z0-9@:%_\+.~#?&//=]*)?/gi,
    Letters: /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
    digits: /^.{4,12}$/,
    email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
    telephone: /^\d{10}$/,
    numbersLetters: /^[a-z0-9_-]{3,16}$/,
    minfourDigits: /^.{4,20}$/,
    minFour: /^.{4,50}$/,
    namebussines: /^.{4,50}$/,
    max200: /^.{4,200}$/,
    zipCode: /^[0-9]{5}$/,
    city: /^.{2,200}$/,
    CC: /^\d{7,10}$/,
    password: /^.{8,15}$/,
    mensaje: /^.{5,500}$/,
    asunto: /^.{1,100}$/,
    nombreAnuncio: /^.{1,60}$/,
    costo: /^\d+$/
};

function formRegistroUsuario(e) {
    // PARA PODER VALIDAR EN LOS OTROS FORMULARIOS DEBES DE QUITARLE EL REQUIRED Y LAS VALIDACIONES DEL HTML, es decir, el MINLENGTH, MAXLENGTH, REQUIRED,ETC.
    const form = new FormData(e.target); // Recuerda mirar el registro.jsp para guiarte con los otros debes agregar esto: onsubmit="NombreFunction(event)"
    const identificacion = form.get("identificacion"); // Estos GETS son los name de los inputs que estan dentro del formulario.
    const Nombre = form.get("Nombre");
    const pri_ape = form.get("pri_ape");
    const seg_ape = form.get("seg_ape");
    const celular = form.get("celular");
    const fecha_nac = form.get("fecha_nac");
    const direccion = form.get("direccion");
    const puesto_trabajo = form.get("puesto_trabajo");
    const email = form.get("email");
    const password = form.get("password");
    const select_civil = form.get("select_civil");
    const select_barrio = form.get("select_barrio");
    
    
    if (!expressions.CC.test(identificacion.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La identificación debe contener de 7 a 10 dígitos solo numéricos',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.Letters.test(Nombre.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo nombre es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.Letters.test(pri_ape.trim())) {
        console.log("Buenasseqeqes");
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El primer apellido debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!seg_ape.trim() === '') {
        if (!expressions.Letters.test(seg_ape.trim())) {
            swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'El segundo apellido solo debe tener letras.',
                timer: 1500
            });
            e.preventDefault();
        }
        return;
    }

    if (!expressions.telephone.test(celular.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo celular solo debe contener 10 dígitos numéricos.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (select_barrio === null || select_civil === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona el barrio y/o el estado civil.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (calcularEdad(fecha_nac) < 18) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Lo sentimos, debes ser mayor de 18 años.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (puesto_trabajo === '') {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar tu puesto de trabajo.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (direccion === '') {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar la dirección de tu vivienda.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.email.test(email.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar un email válido.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.password.test(password.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La contraseña debe contener mínimo 8 caracteres y máximo 15',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function formEditarUsuario(e) {
    const form = new FormData(e.target);
    const Nombre = form.get("nom_user_edit");
    const pri_ape = form.get("ap_user_edit");
    const seg_ape = form.get("segap_user_edit");
    const email = form.get("correo_user_edit");
    const password = form.get("contra_user_edit");
    const puesto_trabajo = form.get("trabp_user_edit");
    const fecha_nac = form.get("fcha_user_edit");
    const celular = form.get("celular_user_edit");
    const direccion = form.get("dir_user_edit");
    const select_civil = form.get("civil_user_edit");
    const select_tipoUser = form.get("tipo_user_edit");

    if (!expressions.Letters.test(Nombre.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El campo nombre es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.Letters.test(pri_ape.trim())) {
        console.log("Buenasseqeqes");
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El primer apellido debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!seg_ape.trim() === '') {
        if (!expressions.Letters.test(seg_ape.trim())) {
            swal({
                position: 'center',
                icon: 'warning',
                title: 'El segundo apellido solo debe tener letras.',
                timer: 1500
            });
            e.preventDefault();
        }
        return;
    }

    if (!expressions.telephone.test(celular.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El campo celular solo debe contener 10 dígitos numéricos.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (select_tipoUser === null || select_civil === null) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona el tipo de usuario y/o el estado civil.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (calcularEdad(fecha_nac) < 18) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Lo sentimos, debes ser mayor de 18 años.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (puesto_trabajo === '') {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar tu puesto de trabajo.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (direccion === '') {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar la dirección de tu vivienda.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.email.test(email.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar un email válido.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.password.test(password.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'La contraseña debe contener mínimo 8 caracteres y máximo 15',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function formLogin(e) {
    const form = new FormData(e.target);
    const identificacion = form.get("Identificacion");
    const password = form.get("password");

    if (identificacion.trim() === '' && password.trim() === '') {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes llenar todos los campos.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.CC.test(identificacion.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La identificación debe contener de 7 a 10 dígitos solo numéricos',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.password.test(password.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La contraseña debe contener mínimo 8 caracteres y máximo 15',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function formContacto(e) {
    // PARA PODER VALIDAR EN LOS OTROS FORMULARIOS DEBES DE QUITARLE EL REQUIRED Y LAS VALIDACIONES DEL HTML, es decir, el MINLENGTH, MAXLENGTH, REQUIRED,ETC.
    const form = new FormData(e.target); // Recuerda mirar el registro.jsp para guiarte con los otros debes agregar esto: onsubmit="NombreFunction(event)"
    const Nombre = form.get("nombre");
    const email = form.get("email");
    const celular = form.get("celular");
    const tipo = form.get("select_pqrs");
    const mensaje = form.get("mensaje");
    
    if (!expressions.Letters.test(Nombre.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo nombre es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.email.test(email.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes ingresar un email válido.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.telephone.test(celular.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo celular solo debe contener 10 dígitos numéricos.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (tipo === null || tipo === '' || tipo === 0) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona el tipo de PQRS que quieres enviar.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.mensaje.test(mensaje.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes enviar un mensaje de mínimo 5 y máximo 500 caracteres',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    document.querySelector("[name=accion]").value = "ContactoIndex";
    formContacto.method = "POST";
    formContacto.action = "ControladorContacto";
    document.querySelector("[name=accion]").type = "submit";
}

const cargarDatosContacto = (id, correo) => {

    const formContactoCorreo = document.getElementById("formCorreoCon");
    document.getElementById("enviarCorreoContac").addEventListener("click", (e) => {

        const form = new FormData(formContactoCorreo);
        const asunto = form.get("asunto_contacto_admin");
        const mensaje = form.get("mail_contacto_admin");

        if (!expressions.asunto.test(asunto.trim())) {
            swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'El asunto del anuncio es obligatorio.',
                timer: 1500
            });
            e.preventDefault();
            return;
        }
        if (!expressions.mensaje.test(mensaje.trim())) {
            swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'Debes enviar un mensaje de mínimo 5 y máximo 500 caracteres',
                timer: 1500
            });
            e.preventDefault();
            return;
        }
        document.getElementById("enviarCorreoContac").value = "enviarCorreoContactoAdmin";
        formContactoCorreo.method = "POST";
        formContactoCorreo.action = "ControladorContacto";
        document.getElementById("enviarCorreoContac").type = "submit";
        formContactoCorreo.elements["id"].value = id;
        formContactoCorreo.elements["correo"].value = correo;

    });
};

function cargarDatosAnuncios(nombre, descripcion, costo, id) {
    document.querySelector('[name=edit_name_anuncio]').value = nombre;
    document.querySelector('[name=desc_edit_anuncio]').value = descripcion;
    document.querySelector('[name=costo_edit_anuncio]').value = costo;

    var actualizar = document.getElementById("actualizarAnuncio");
    actualizar.onclick = function (e) {
        var nom = document.querySelector('[name=edit_name_anuncio]').value;
        var desc = document.querySelector('[name=desc_edit_anuncio]').value;
        var costos = document.querySelector('[name=costo_edit_anuncio]').value;

        if (nom !== nombre || desc !== descripcion || costo !== costos) {
            const form = new FormData(document.querySelector('#formulario_editar'));
            const Nombre = form.get("edit_name_anuncio");
            const descripcion = form.get("desc_edit_anuncio");
            const costo_anuncio = form.get("costo_edit_anuncio");
            if (!expressions.nombreAnuncio.test(Nombre.trim())) {
                swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'El nombre del anuncio es obligatorio y debe tener solo letras.',
                    timer: 1500
                });
                e.preventDefault();
                return;
            }
            if (!expressions.max200.test(descripcion.trim())) {
                swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'El campo descripción es obligatorio y debe tener solo letras.',
                    timer: 1500
                });
                e.preventDefault();
                return;
            }
            if (!expressions.costo.test(costo_anuncio.trim())) {
                swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'El costo solo debe contener números',
                    timer: 1500
                });
                e.preventDefault();
                return;
            }
            formulario = document.getElementById("formulario_editar");
            formulario.action = "ControladorAnuncios";
            formulario.method = "POST";
            formulario.elements["anuncio"].value = "anuncioEdit";
            formulario.elements["id"].value = id;
            formulario.submit();
        } else {
            swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'No haz cambiado nada.',
                showConfirmButton: false,
                timer: 1500
            })

        }
    }
}

function formResponderPQRS(e) {
    const form = new FormData(e.target);
    const asunto = form.get("asunto_contacto_admin");
    const mensaje = form.get("mail_contacto_admin");

    if (asunto.trim() === '' || mensaje.trim() === '') {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes llenar todos los campos.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.asunto.test(asunto.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El asunto del anuncio es obligatorio.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.mensaje.test(mensaje.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes enviar un mensaje de mínimo 5 y máximo 500 caracteres',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function formRegistroMascota(e) {
    const form = new FormData(e.target);
    const Nombre = form.get("name_mascota");
    const descripcion = form.get("desc_mascota");
    const edad_mas = form.get("edad_mascota");
    const genero_mas = form.get("genero_mascota");
    const raza_mas = form.get("raza_mascota");
    const select_vacunado = form.get("select_vacunado");
    const select_esterilizado = form.get("select_esterilizado");
    const select_disponibilidad = form.get("select_disponibilidad");
    const foto_mascota = form.get("foto_mascota");
    const mascot_photo = document.querySelector('[name="foto_mascota"]');

    if (!expressions.Letters.test(Nombre.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El campo nombre es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.Letters.test(descripcion.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El campo descripción es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (edad_mas <= 0 || edad_mas === '0' || edad_mas === '' || edad_mas >= 25) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Lo sentimos, la edad de la mascota debe ser mayor a 0 y menor a 25.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (genero_mas === null) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona un género para la mascota ',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (raza_mas === null) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona la raza de la mascota ',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (select_vacunado === null) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona si está vacunada ',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (select_esterilizado === null) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona si está esterilizada ',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (select_disponibilidad === null) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona la disponibilidad de la mascota ',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!fileValidation(mascot_photo)) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'La imagen es obligatoria y debe ser tipo imagen.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}


function cargarDatosMascotas(nombre, descripcion, edad, raza, vacunado, esterilizado, disponibilidad, id, e) {
    document.querySelector('[name=name_mascota_edit]').value = nombre;
    document.querySelector('[name=desc_mascota_edit]').value = descripcion;
    document.querySelector('[name=edad_mascota_edit]').value = edad;
    document.querySelector('[name=select_vacunado_edit]').value = vacunado;
    document.querySelector('[name=select_esterilizado_edit]').value = esterilizado;
    document.querySelector('[name=select_disponibilidad_edit]').value = disponibilidad;

    var actualizar = document.getElementById("actualizarMascotaS");
    actualizar.onclick = function (e) {
        const nom = document.querySelector('[name=name_mascota_edit]').value;
        const desc = document.querySelector('[name=desc_mascota_edit]').value;
        const edades = document.querySelector('[name=edad_mascota_edit]').value;
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
                e.preventDefault();
            } else {
                const form = new FormData(document.querySelector('#formulario_editar_mascotas'));
                const Nombre = form.get("name_mascota_edit");
                const descripcion = form.get("desc_mascota_edit");
                const edad_mas = form.get("edad_mascota_edit");
                const select_vacunado = form.get("select_vacunado_edit");
                const select_esterilizado = form.get("select_esterilizado_edit");
                const select_disponibilidad = form.get("select_disponibilidad_edit");
                document.querySelector("#idEditarMascota").value = id;
                if (!expressions.Letters.test(Nombre.trim())) {
                    swal({
                        position: 'center',
                        icon: 'warning',
                        title: 'El campo nombre es obligatorio y debe tener solo letras.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }
                if (!expressions.Letters.test(descripcion.trim())) {
                    swal({
                        position: 'center',
                        icon: 'warning',
                        title: 'El campo descripción es obligatorio y debe tener solo letras.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (edad_mas <= 0 || edad_mas === '0' || edad_mas === '' || edad_mas >= 25) {
                    swal({
                        position: 'center',
                        icon: 'warning',
                        title: 'Lo sentimos, la edad de la mascota debe ser mayor a 0 y menor a 25.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (select_vacunado === null) {
                    swal({
                        position: 'center',
                        icon: 'warning',
                        title: 'Selecciona si está vacunada ',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }
                if (select_esterilizado === null) {
                    swal({
                        position: 'center',
                        icon: 'warning',
                        title: 'Selecciona si está esterilizada ',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }
                if (select_disponibilidad === null) {
                    swal({
                        position: 'center',
                        icon: 'warning',
                        title: 'Selecciona la disponibilidad de la mascota ',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }
            }
        } else {
            swal({
                position: 'center',
                icon: 'warning',
                title: 'No haz cambiado nada.',
                showConfirmButton: false,
                timer: 1500
            });
            e.preventDefault();
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

    console.log(cedula, nomb, primerap, segunap, correouser, fdate, celusuario, barriouser, civiluser, tipouser, direeccion, puestotrab, passwordd, e)
    e.preventDefault();
    const actualizaruserrr = document.getElementById("ActualizarUserxAdmin");
    actualizaruserrr.onclick = function (e) {
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
                swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Llena por favor todos los campos',
                    showConfirmButton: false,
                    timer: 1500
                });
                e.preventDefault();
            } else {
                const form = new FormData(document.querySelector('#formactUser'));
                const Nombre = form.get("nom_user_edit");
                const pri_ape = form.get("ap_user_edit");
                const seg_ape = form.get("segap_user_edit");
                const email = form.get("correo_user_edit");
                const password = form.get("contra_user_edit");
                const puesto_trabajo = form.get("trabp_user_edit");
                const fecha_nac = form.get("fcha_user_edit");
                const celular = form.get("celular_user_edit");
                const direccion = form.get("dir_user_edit");
                const select_civil = form.get("civil_user_edit");
                const select_tipoUser = form.get("tipo_user_edit");
                document.querySelector("#cedula").value = cedula;
                if (!expressions.Letters.test(Nombre.trim())) {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'El campo nombre es obligatorio y debe tener solo letras.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (!expressions.Letters.test(pri_ape.trim())) {
                    console.log("Buenasseqeqes");
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'El primer apellido debe tener solo letras.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (!seg_ape.trim() === '') {
                    if (!expressions.Letters.test(seg_ape.trim())) {
                        swal.fire({
                            position: 'center',
                            icon: 'warning',
                            title: 'El segundo apellido solo debe tener letras.',
                            timer: 1500
                        });
                        e.preventDefault();
                    }
                    return;
                }

                if (!expressions.telephone.test(celular.trim())) {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'El campo celular solo debe contener 10 dígitos numéricos.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (select_tipoUser === null || select_civil === null) {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'Selecciona el tipo de usuario y/o el estado civil.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (calcularEdad(fecha_nac) < 18) {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'Lo sentimos, debes ser mayor de 18 años.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (puesto_trabajo === '') {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'Debes ingresar tu puesto de trabajo.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (direccion === '') {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'Debes ingresar la dirección de tu vivienda.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (!expressions.email.test(email.trim())) {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'Debes ingresar un email válido.',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }

                if (!expressions.password.test(password.trim())) {
                    swal.fire({
                        position: 'center',
                        icon: 'warning',
                        title: 'La contraseña debe contener mínimo 8 caracteres y máximo 15',
                        timer: 1500
                    });
                    e.preventDefault();
                    return;
                }
            }
        } else {
            swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'No haz cambiado nada.',
                showConfirmButton: false,
                timer: 1500
            });
            e.preventDefault();
        }

    };

}

function formCrearInformeMascota(e) {
    const form = new FormData(e.target);
    const descripcion_informe = form.get("descripcion_informe");
    const mensaje_admin = form.get("mensaje_admin");
    const mascota_informe = form.get("mascota_informe");
    const foto_informe = form.get("foto_informe");
    const photo_informe = document.querySelector('#foto_informe');
    if (!expressions.mensaje.test(descripcion_informe.trim())) {
        Swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El texto debe contener mínimo 5 y máximo 500 caracteres',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.mensaje.test(mensaje_admin.trim())) {
        Swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El texto debe contener mínimo 5 y máximo 500 caracteres',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (mascota_informe === null) {
        Swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes seleccionar la mascota a informar.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!fileValidation(photo_informe)) {
        Swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La imagen es obligatoria y debe ser tipo imagen.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function formRtaInformeMascota(e) {
    const form = new FormData(e.target);
    const texto_adop = form.get("respuesta_informe");

    if (!expressions.mensaje.test(texto_adop.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes enviar un mensaje de mínimo 5 y máximo 500 caracteres',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function formRegistrarAnuncio(e) {
    const form = new FormData(e.target);
    const Nombre = form.get("nom_anuncio");
    const descripcion = form.get("desc_anuncio");
    const costo_anuncio = form.get("costo_anuncio");
    const foto_anuncio = form.get("foto_anuncio");
    const photo_anuncio = document.querySelector("[name='foto_anuncio']");
    if (!expressions.Letters.test(Nombre.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El nombre del anuncio es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.Letters.test(descripcion.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo descripción es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.costo.test(costo_anuncio.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El costo solo debe contener números.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!fileValidation(photo_anuncio)) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La imagen es obligatoria y debe ser tipo imagen.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

}

function formEditarAnuncio(e) {
    const form = new FormData(e.target);
    const Nombre = form.get("edit_name_anuncio");
    const descripcion = form.get("desc_edit_anuncio");
    const costo_anuncio = form.get("costo_edit_anuncio");

    if (!expressions.nombreAnuncio.test(Nombre.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El nombre del anuncio es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.max200.test(descripcion.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El campo descripción es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.costo.test(costo_anuncio.trim())) {
        swal({
            position: 'center',
            icon: 'warning',
            title: 'El costo solo debe contener números',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

}


function formSolicitudAdopcion(e) {
    // PARA PODER VALIDAR EN LOS OTROS FORMULARIOS DEBES DE QUITARLE EL REQUIRED Y LAS VALIDACIONES DEL HTML, es decir, el MINLENGTH, MAXLENGTH, REQUIRED,ETC.
    const form = new FormData(e.target); // Recuerda mirar el registro.jsp para guiarte con los otros debes agregar esto: onsubmit="NombreFunction(event)"
    const identificacion = form.get("identificacion"); // Estos GETS son los name de los inputs que estan dentro del formulario.
    const Nombre = form.get("Nombre");
    const pri_ape = form.get("pri_ape");
    const seg_ape = form.get("seg_ape");
    const celular = form.get("celular");
    const nombrefamiliar = form.get("nombrefamiliar");
    const ocupacionfamiliar = form.get("ocupacionfamiliar");
    const celularfamiliar = form.get("celularfamiliar");
    const tuvo_mascotas = form.get("tuvo_mascotas");
    const nom_mascotas_tuvo = form.get("nom_mascotas_tuvo");
    const motivo_adopcion = form.get("motivo_adopcion");
    const tiene_mascota = form.get("tiene_mascota");
    const estrato = form.get("estrato");
    const tipo_vivienda = form.get("tipo_vivienda");
    const propia_vivienda = form.get("propia_vivienda");
    const vivo_con = form.get("vivo_con");
    const rango_salarial = form.get("rango_salarial");

    if (!expressions.Letters.test(nombrefamiliar.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo nombre es obligatorio y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.Letters.test(ocupacionfamiliar.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'La ocupación del familiar es obligatoria y debe tener solo letras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (!expressions.telephone.test(celularfamiliar.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'El campo celular solo debe contener 10 dígitos numéricos.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (tuvo_mascotas === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona si has tenido mascotas.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (nom_mascotas_tuvo === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona que especie de mascotas has tenido.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }

    if (!expressions.mensaje.test(motivo_adopcion.trim())) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Debes darnos un motivo de adopción de mínimo 5 y máximo 500 caracteres',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (tiene_mascota === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona si actualmente tienes mascotas.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (estrato === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona tu estrato socioeconómico.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (tipo_vivienda === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona en qué tipo de vivienda resides.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (propia_vivienda === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona si tu casa es propia.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (vivo_con === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona con cuántas personas vives actualmente.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
    if (rango_salarial === null) {
        swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Selecciona en qué rango salarial te encuentras.',
            timer: 1500
        });
        e.preventDefault();
        return;
    }
}

function calcularEdad(fecha) {
    const hoy = new Date();
    const cumpleanos = new Date(fecha || hoy);
    let edad = hoy.getFullYear() - cumpleanos.getFullYear();
    let m = hoy.getMonth() - cumpleanos.getMonth();

    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }

    return edad;
}


function confirmEliminarUsuario(e) {
    const seguroEliminar = false;
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                    );
            seguroElimina = true;
        }
    })

    if (seguroEliminar) {
        console.log("HEllo")
        e.preventDefault();
    }
}

function fileValidation(fileInput) {
    const filePath = fileInput.value;
    const allowedExtensions = /(.jpg|.jpeg|.png|.gif)$/i;
    if (!allowedExtensions.exec(filePath)) {
        fileInput.value = '';
        return false;
    }
    return true;
}