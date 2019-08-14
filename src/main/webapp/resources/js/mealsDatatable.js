function mealActionsHandler() {
    $('#add').click(function () {
        $('#item_id').val(0);
        $('#editRow').modal();
    });

    $('#detailsForm').submit(function () {
        console.log(123);
    });
}
