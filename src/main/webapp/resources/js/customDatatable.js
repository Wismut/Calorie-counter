function makeEditable(ajaxUrl) {
    $('#add').click(function () {
        $('#id').val(0);
        $('#detailsForm').modal();
    });

    $('delete').click(function () {
        deleteRow($(this).attr('id'));
    });

    $('#rowForm').submit(function () {
        save();
        return false;
    });
}
