// datePicker 검색
$(document).ready(function() {
    $('#datePicker').change(function() {
        var buy_date = $(this).val();
        var formattedDate = buy_date.replace(/-/g, ''); 
       
        
        $.ajax({
            type: 'GET',
            url: '/selectedDateSearch',
            data: { buy_date: formattedDate }, 
            success: function(response) {
                   console.log(buy_date);
            },
            error: function(error) {
                console.error('에러:', error);
                   
                
            }
        });
    });
});
