$('table #deleteButton').on('click', function(event){
    event.preventDefault();

    var href = $(this).attr('href');
    console.log(href);
    $("#deleteModal #delRef").attr('href', href);
    $('#deleteModal').modal();
})

