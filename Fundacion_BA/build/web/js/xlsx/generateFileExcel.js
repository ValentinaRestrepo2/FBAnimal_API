
document.querySelector("#generate_excel").addEventListener("click", () => {
   console.log("Helloxxx") 
});

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

