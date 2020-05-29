function hideMessage1()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 2000);  // 5000 milliseconds = 5 seconds
}

$(document).ready(function()
{
  $("#admin_login").click(function()
	{
	 $(".login").fadeOut(2000,function()
	   {
		 document.frm.submit();
	   });
	});
  $("#account_option1").click(function()
	{
	 $("body").fadeOut(2000,function()
	   {
		 document.frm.submit();
	   });
	});
  $("#account_option2").click(function()
	{
	 $("body").fadeOut(2000,function()
	   {
		 document.frm.submit();
	   });
	});
  $("#account_option3").click(function()
	{
	 $("body").fadeOut(2000,function()
	   {
		 document.frm.submit();
	   });
	});
  $("#add_account").click(function()
	{
	  $("body").fadeOut(2000,function()
	   {
		 document.frm.submit();
	   });
	});
});

(function($)
	{
		hideMessage = function() 
		{
			$("#message").animate({top:'-10000px'},{queue:false,duration:10000})
		};
	}
)(jQuery);

