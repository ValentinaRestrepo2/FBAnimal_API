/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const daticos_informe = document.querySelector("#daticos_informetq");
const listarUsuariosxFechaRegistro = document.querySelector("#listarUsuariosxFechaRegistro");
let datosTransform = [];
let usuariosFEchaRegistro = [];
(function () {
    const datosTransformx = JSON.parse(daticos_informe.textContent);
    const listarUsuariosxFechaRegistroTransform = JSON.parse(listarUsuariosxFechaRegistro.textContent);
    usuariosFEchaRegistro = listarUsuariosxFechaRegistroTransform;
    datosTransform = datosTransformx;
    listarInfo();
})();

function listarInfo() {
    const mascotasandrazas = document.querySelector('#mascotasandrazas');
    const usuariosxregistro = document.querySelector('#usuariosxregistro');
    let listaDatos = datosTransform.map(item => {
        return  `<tr>
                <td>${item.nombre}</td>
                <td>${item.apellido}</td>
                <td>${item.correo}</td>
                <td>${item.celular}</td>
                <td>${item.nombre_mascota}</td>
                <td>${item.raza_mascota}</td>
            </tr>`;
    });
    //<button id="generate_excel" onclick="generateExcelData()">Generar EXCEL</button>
    const usuarioxregistroArray = usuariosFEchaRegistro.map(item => {
        const date = new Date(item.registro);
        return  `<tr>
                <td>${item.nombre}</td>
                <td>${item.apellido}</td>
                <td>${item.apellidodos}</td>
                <td>${date.getDate() +
                "/" + (date.getMonth() + 1) +
                "/" + date.getFullYear() +
                " " + date.getHours() +
                ":" + date.getMinutes() +
                ":" + date.getSeconds()}</td>
            </tr>`;
    });
    listaDatos.pop();
    usuarioxregistroArray.pop();
    usuariosxregistro.innerHTML = usuarioxregistroArray.join('');
    mascotasandrazas.innerHTML = listaDatos.join('');
    console.log(JSON.parse(document.querySelector('#listarMascotasInformacion').textContent));
}

var ctx = document.getElementById("myChart").getContext("2d");
var myChart = new Chart(ctx, {
    type: "pie",
    data: {
        labels: ["Disponibles", "NO Disponibles", "Adoptados", "Fallecidos"],
        datasets: [
            {
                label: "",
                data: JSON.parse(document.querySelector('#listarMascotasInformacion').textContent),
                backgroundColor: [
                    "rgba(255, 99, 132, 0.2)",
                    "rgba(54, 162, 235, 0.2)",
                    "rgba(255, 206, 86, 0.2)",
                    "rgba(75, 192, 192, 0.2)",
                    "rgba(153, 102, 255, 0.2)",
                    "rgba(255, 159, 64, 0.2)",
                ],
                borderColor: [
                    "rgba(255, 99, 132, 1)",
                    "rgba(54, 162, 235, 1)",
                    "rgba(255, 206, 86, 1)",
                    "rgba(75, 192, 192, 1)",
                    "rgba(153, 102, 255, 1)",
                    "rgba(255, 159, 64, 1)",
                ],
                borderWidth: 1,
            },
        ],
    },
    options: {
        scales: {
            yAxes: [
                {
                    ticks: {
                        beginAtZero: true,
                    },
                },
            ],
        },
    },
});

var ctxContactos = document.getElementById("chartContactos").getContext("2d");
var chartContactos = new Chart(ctxContactos, {
    type: "bar",
    data: {
        labels: ["Contestados", "Sin contestar"],
        datasets: [
            {
                label: "Contactos contestados y sin responder",
                data: JSON.parse(document.querySelector('#listarCantidaddeContactosSinResponder').textContent),
                backgroundColor: [
                    "rgba(60, 179, 113, 0.8)",
                    "rgba(106, 90, 205,0.8)",
                ],
                borderColor: [
                    "rgb(60, 179, 113)",
                    "rgb(106, 90, 205)",
                ],
                borderWidth: 1,
            },
        ],
    },
    options: {
        scales: {
            yAxes: [
                {
                    ticks: {
                        beginAtZero: true,
                    },
                },
            ],
        },
    },
});

function generateExcelData() {
    console.log(usuariosFEchaRegistro)
    const columns = [{label: 'NOMBRE', field: 'nombre'}, {label: 'PRIMER APELLIDO', field: 'apellido'}, {label: 'SEGUNDO APELLIDO', field: 'apellidodos'}, {label: 'FECHA REGISTRO', field: 'registro'}];
    exportExcel(columns, usuariosFEchaRegistro, "UsuariosFechaRegistro", "UsuariosFechaRegistro", "xlsx");
}

function exportExcel(columns = [ {label: 'Created by', field: 'created_by'}], data = [{created_by: 'buenas'}], fileName = 'Buenasge', sheetName = 'USeCases', fileType = 'xlsx') {
    const createXLSLFormatObj = [];
    const newXlsHeader = [];
    if (columns.length === 0) {
        console.log("Add columns!");
        return;
    }
    if (data.length === 0) {
        console.log("Add data!");
        return;
    }
    columns.map((column) => {
        newXlsHeader.push(column.label);
    });

    createXLSLFormatObj.push(newXlsHeader);
    data.map((value) => {
        const innerRowData = [];
        columns.map((val) => {
            let fieldValue = value[val.field];
            if (val.field.split(".").length > 1) {
                fieldValue = getNestedValue(value, val.field);
            }
            if (val.dataFormat && typeof val.dataFormat === "function") {
                innerRowData.push(val.dataFormat(fieldValue));
            } else {
                innerRowData.push(fieldValue);
            }
        });
        createXLSLFormatObj.push(innerRowData);
    });

    const name = fileName + "." + fileType;

    const ws_name = sheetName;

    let wb = XLSX.utils.book_new(),
            ws = XLSX.utils.aoa_to_sheet(createXLSLFormatObj);
    XLSX.utils.book_append_sheet(wb, ws, ws_name);
    XLSX.writeFile(wb, name);
}

function getNestedValue(object, string) {
    string = string.replace(/\[(\w+)\]/g, ".$1");
    string = string.replace(/^\./, "");
    let a = string.split(".");
    for (let i = 0, n = a.length; i < n; ++i) {
        let k = a[i];
        if (k in object) {
            object = object[k];
        } else {
            return;
        }
    }
    return object;
}

