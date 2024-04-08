// datePicker 검색
$(document).ready(function() {
    $('#datePicker').change(function() {
        var buy_date = $(this).val();
        var formattedDate = buy_date.replace(/-/g, ''); 

/*        $.ajax({
            url: '/selectedDateSearch',
            method: 'GET',
            data: { buy_date: formattedDate }, 
            success: function(response) {
                   console.log('성공'+buy_date);
                   
            },
            error: function(error) {
                console.error('에러에', error);

            }
        });
*/        
		location.href="selectedDateSearch?buy_date="+formattedDate;
    
    });
});

