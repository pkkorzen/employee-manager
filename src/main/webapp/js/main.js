
$("document").ready(function(){

$('#position').on("change", function(){
	$('#positionName').val($('#position option:selected').val());
    $('#salary').val($(this).find('option:selected').attr('data-number'));
});
});

