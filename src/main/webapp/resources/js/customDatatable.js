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
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            // success('Deleted');
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
            // success('Saved');
        }
    });
}
