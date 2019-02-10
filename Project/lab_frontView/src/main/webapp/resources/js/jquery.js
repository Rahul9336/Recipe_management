$(document).ready(function(){
	$('#searchbox').autocomplete({ source: '/lab_frontView/searchid'	
});
});
$(document).ready(function() {
    var max_fields      = 100; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input type="text" name="myIngredient[]"/><a href="#" class=" btn btn-primary remove_field">Remove</a></div>'); //add input box
        }
    });
    
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});
 Ingredients = $("input[name='myIngredient[]']")
.map(function(){return $(this).val();}).get();

function setIngredient(){
	$("#addingredient").hide();
	Ingredients = $("input[name='myIngredient[]']")
	.map(function(){return $(this).val();}).get();
	document.getElementById('ingredient').value =Ingredients;
}