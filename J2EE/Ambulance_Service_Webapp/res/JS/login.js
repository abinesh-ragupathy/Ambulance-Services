//Admin Login Form

$(function() {
    var button = $('#loginButton');
    var box = $('#loginBox');//div
    var form = $('#loginForm');
   
    button.removeAttr('href');
    
    button.mouseup(function(login) 
    {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() 
    { 
        return false;
    });
    $(this).mouseup(function(login) 
    {
        if(!($(login.target).parent('#loginButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });

});

//User Login

$(
	function get()
	{
			//alert("Hello");
			var button1 = $('#loginButton1');
		    var box1 = $('#loginBox1');
		    var form1 = $('#loginForm1');
		   
		    button1.removeAttr('href');
		    
		    button1.mouseup(function(login1) 
		    {
		        box1.toggle();
		        button1.toggleClass('active');
		    });
		    form1.mouseup(function() 
		    { 
		        return false;
		    });
		    $(this).mouseup(function(login1) 
		    {
		        if(!($(login1.target).parent('#loginButton1').length > 0)) {
		            button1.removeClass('active');
		            box1.hide();
		        }
		    });
	}
);
