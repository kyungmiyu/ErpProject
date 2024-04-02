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


// 구매 상세 내역 제품 리스트


/*document.addEventListener("DOMContentLoaded", function() {
    var buyingDetails = ${productDetail};
    var container = document.getElementById('buyListItemsContainer');
    var buyListItems = document.getElementById('buyListItems');

    buyingDetails.forEach(function(detail) {
        var productDiv = document.createElement('div');
        productDiv.classList.add('custom-option');
        
        productDiv.innerHTML = `
            <div class="custom-option">
                <div id="p_name">${detail.p_name}</div>
                <div id="bd_price">${detail.bd_price}</div>
                <div id="bd_cnt">${detail.bd_cnt}</div>
                <div id="totalMoney">${detail.totalMoney}</div>
            </div>
        `;
        
        buyListItems.appendChild(productDiv);
    });
});
*/