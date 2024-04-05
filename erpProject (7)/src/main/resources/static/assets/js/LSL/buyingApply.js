$(document).ready(function() {
    $("#customerSearchBtn").click(function() {
        $(".customerSearchPopup").css("display", "block");
    });

    $("#cusSearchXBtn").click(function() {
        $(".customerSearchPopup").css("display", "none");
    });
});