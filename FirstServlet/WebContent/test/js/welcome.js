var rownum=0;

function test(){
    var r1 = document.getElementsByName("inout");
    alert($("#inout option:selected").text());
}
function insertAfter(newElement, targentElement) {
    var parent = targentElement.parentNode;
    if (parent.lastChild == targentElement) {
        parent.appendChild(newElement);
    } else {
        parent.insertBefore(newElement, targentElement.nextSibling)
    }
}
function save(obj){
    var $td = $(obj.parentElement);
    $(obj).attr("value",$(obj).val());
    var aft =$(obj).val();
    $td.html('<td style=\"border-color: transparent;\">&nbsp;&nbsp;&nbsp'+aft+'</td>');
}
function del(obj){
    obj.parentElement.parentElement.parentElement.removeChild(obj.parentElement.parentElement);
}

function change(obj){
    var $td = $(obj.parentElement);
    $td.prev().prev().prev().html("<input type='text' onblur='save(this)'>");
    $td.prev().prev().html("<input type='text' onblur='save(this)'>");
    $td.prev().html("<input type='text' onblur='save(this)'>");
}

var app = angular.module("myApp",[]);
app.controller("myCtrl", function ($scope, $timeout) {
    $scope.alert1 = function(){}
})
function add(){
    if(rownum<5){
        rownum=rownum+1;
        var table=document.getElementById("tb");
        var tr=document.createElement("tr");
        var td1=document.createElement("td");
        var td2=document.createElement("td");
        var td3=document.createElement("td");
        var td4=document.createElement("td");
        var td5=document.createElement("td");

        td1.innerHTML=$("#inout option:selected").text();
        td2.innerHTML=$("#way option:selected").text();
        td3.innerHTML=$("#number").val();
        td4.innerHTML="<input type='button' value='修改' onclick=\"change(this)\" />"; 
        td5.innerHTML="<input type='button' value='删除' onclick=\"del(this)\" />"; 
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        table.appendChild(tr);
    }else{
        bootbox.dialog({
            message: "今日可添加记录已满～",
            title: "友情提示：",
            show: true,
            backdrop: true,
            closeButton: true,
            animate: true,
            className: "my-modal",
            buttons: {
                success: {   
                label: "好的!",
                className: "btn-success",
                callback: function() {}
                },
                "取消": {
                className: "btn-danger",
                callback: function() {}
                }
            }
        });
    }   
}