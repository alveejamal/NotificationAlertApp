
$(function(){

    $('#navigation').load('NavBar.jsp');
	$('#journal').flexible();
	$("#editEntry" ).click(function() {
	    alert("im in editEntry");
	    $('#subject').removeAttr("readonly");
	    $('#journal').removeAttr("readonly");
	    $("#submitEdit").attr("action","submitEdit");
	    var saveButton= $('<input type="submit" value="Save" action="submitEdit">');
	    $("#submitEdit").append(saveButton);
	    
	    var cancelButton= $('<input type="submit" value="Cancel" action="Login">');
	    $("body").append(cancelButton);
	   
	    alert("im done editEntry");

	});

	
}
);





