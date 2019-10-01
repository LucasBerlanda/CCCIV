$('#modal-excluir').on('show.bs.modal', function(e) {
	var id1 = $('data-codigo').val();
	var id = $(e.relatedTarget).data('id');
	console.log(id1);
	$(e.currentTarget).find("#excluir").val(id);
})

$('#excluir').on("click", function(e) {

	const id = e.target.value;

	$.ajax({
		method: "post",
		url:"excluir",
		data: pessoa = {'id': id }
	}).done(res => {
		console.log(res);
	})
});
