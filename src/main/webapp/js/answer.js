/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#thumbs").hide();
    $("#answerButton").click(function () {
        $("#answerButton").hide();
        $("#answerText").show();
        $("#thumbs").show();
    });
    $("#answerButton").click(function () {
        alert("zosia!");
    });
//    $("#answerButton").bind('click', function (event) {
//        alert("zosia");
//    });
});
