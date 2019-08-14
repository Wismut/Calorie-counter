function mealActionsHandler() {
    $('#add').click(function () {
        $('#item_id').val(0);
        $('#editRow').modal();
    });

    $('#detailsForm').submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        fail(event, jqXHR, options, jsExc);
    });
}

function save() {
    console.log(12345);
    var frm = $('#detailsForm');
    $.ajax({
        type: 'POST',
        url: ajaxUrl,
        data: frm.serialize(),
        success: function (data) {
            $('#editRow').modal('hide');
            // updateTable();
            success('Saved');
        },
        error: function (e) {
            console.log('error ' + e);
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
    console.log(jqXHR.text);
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + '<br>',
        type: 'error',
        layout: 'bottomRight'
    });
}
