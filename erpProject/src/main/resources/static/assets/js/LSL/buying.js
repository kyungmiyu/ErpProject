// datePicker 검색
$(document).ready(function() {
    $('#datePicker').change(function() {
        var buy_date = $(this).val();
        var formattedDate = buy_date.replace(/-/g, ''); 

		location.href="selectedDateSearch?buy_date="+formattedDate;
    
    });
      $('#optionBox').change(function(){
		var buy_status = $(this).val();
		
		location.href = "selectedSearch?buy_status=" + buy_status;
		
		console.log(buy_status);
	});
    
});

