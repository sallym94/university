$(document).ready(function(){
    $('#htmlSelect').change(function() {
       $('.htmlOption').hide();
       $('.' + $(this).val()).show();
 	});

 	$('#JsSelect').change(function() {
       $('.JsOption').hide();
       $('.' + $(this).val()).show();
 	});

 	$('#PytSelect').change(function() {
       $('.PytOption').hide();
       $('.' + $(this).val()).show();
 	});

 	$('#JavaSelect').change(function() {
       $('.JavaOption').hide();
       $('.' + $(this).val()).show();
 	});

 	$('#SQLSelect').change(function() {
       $('.SQLOption').hide();
       $('.' + $(this).val()).show();
 	});
});