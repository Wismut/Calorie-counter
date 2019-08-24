var form = $('#detailsForm');

function makeEditable(ajaxUrl) {
    $('#add').click(function () {
        $('#item_id').val(0);
        $('#editRow').modal();
    });

    $('delete').click(function () {
        deleteRow($(this).attr('id'));
    });

    $('#detailsForm').submit(function () {
        saveUser();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        fail(event, jqXHR, options, jsExc);
    });

    init();
}

function updateByData(data) {
    oTable_datatable.fnClearTable();
    $.each(data, function (key, item) {
        oTable_datatable.fnAddData(item);
    });
    oTable_datatable.fnDraw();
}

function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            success('Deleted');
        }
    });
}

function saveUser() {
    var frm = $('#detailsForm');
    $.ajax({
        type: 'POST',
        url: ajaxUrl,
        data: frm.serialize(),
        success: function (data) {
            $('#editRow').modal('hide');
            updateTable();
            success('Saved');
        }
    });
}

var failedNote;

function closeNote() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function success(text) {
    closeNote();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function fail(event, jqXHR, options, jsExc) {
    closeNote();
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + '<br>',
        type: 'error',
        layout: 'bottomRight'
    });
}

function renderDate(date, type, row) {
    if (type == 'display') {
        var dateObject = new Date(date);
        return '<span>' + dateObject.toISOString().substring(0, 10) + '</span>';
    }
    return date;
}

function renderEmail(data, type, row) {
    if (type == 'display') {
        return '<a href="mailto:' + data + '">' + data + '</a>';
    }
    return data;
}

function renderUpdateBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ')">Update</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ')">Delete</a>';
    }
    return data;
}

function renderCheckbox(data, type, row) {
    if (type == 'display') {
        return '<input type="checkbox"' + (data ? ' checked ' : ' ') + 'onclick="enable(' + row.id + ',$(this))"/>';
    }
    return data;
}
