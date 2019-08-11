function makeEditable(ajaxUrl) {
    $('#add').click(function () {
        $('#item_id').val(0);
        $('#editRow').modal();
    });

    $('delete').click(function () {
        deleteRow($(this).attr('id'));
    });

    $('#detailsForm').submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        fail(event, jqXHR, options, jsExc);
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
    })
    ;
}

function updateTable() {
    $.get(ajaxUrl, function (data) {
        oTable_dataTable.fnClearTable();
        $.each(data, function (key, item) {
            oTable_dataTable.fnAddData(item);
        });
        oTable_dataTable.fnDraw();
    });
}

function save() {
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
