// window.onload=function(){
    function display(){
        // 当选项发生变化时，若选中内容有效则将说明写入一个div并使其可见，若内容无效则清空并隐藏div，给出提示alert();
        var temp=document.getElementById("prog");
        var div=document.getElementById("div");
        if(temp.selectedIndex==0){
            div.innerHTML=" ";
            alert("选择无效，请重新选择！");       
        }else{
            div.innerHTML="你选中了第"+temp.selectedIndex+"项，它的value属性值是"+temp.value+"，它的文本内容是"+temp.options[temp.selectedIndex].innerHTML+"。";
            insertAfter(div,temp);
        }
        
    }

    function insertAfter(newElement, targentElement) {
        var parent = targentElement.parentNode;
        if (parent.lastChild == targentElement) {
            parent.appendChild(newElement);
        } else {
            parent.insertBefore(newElement, targentElement.nextSibling)
        }
    }

    function scalePic(){
        var picture = document.getElementById("pic");
        picture.style.height = picture.clientHeight*0.9+"px";
    }

    function del(obj){
        obj.parentElement.parentElement.parentElement.removeChild(obj.parentElement.parentElement);
    }
    function add(){
        var name=document.getElementById("name").value;
        var no=document.getElementById("no").value;
        var table=document.getElementById("tb");
        var tr=document.createElement("tr");
        var td1=document.createElement("td");
        var td2=document.createElement("td");
        var td3=document.createElement("td");
        td1.innerHTML=name;
        td2.innerHTML=no;
        td3.innerHTML="<input type='button' value='删除' onclick=\"del(this)\" />"; 
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        table.appendChild(tr);
    }
// }