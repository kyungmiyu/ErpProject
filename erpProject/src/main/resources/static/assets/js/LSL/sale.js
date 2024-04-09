// datePicker 검색
$(document).ready(function() {
    $('#datePicker').change(function() {
        var s_date = $(this).val();
        var formattedDate = s_date.replace(/-/g, ''); 

		location.href="salectedSaleDateSearch?s_date="+formattedDate;
    
    });
      $('#optionBox').change(function(){
		var s_status = $(this).val();
		
		location.href = "salectedStatusSearch?s_status=" + s_status;
		
		console.log(s_status);
	});
    
    
});

