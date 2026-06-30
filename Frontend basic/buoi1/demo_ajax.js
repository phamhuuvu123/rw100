var accounts = [];
var v_idupdate=-1;
var idUpdate=-1;
loadData();
var vThem='';
vThem =localStorage.getItem('theme');
changethem(vThem);
function loadData() {
    // call api  mockapi.oi lay  ds account
    $.ajax({
        type: "GET",
        url: "https://6a3bc8f2e4a07f202e15da10.mockapi.io/api/v1/account",
        // data: "data",
        dataType: "JSON",
        success: function (response) {
            accounts = response;
            var tablecontent = "";
            for (let i = 0; i < accounts.length; i++) {
                tablecontent += "<tr>";
                tablecontent += "<td>" + accounts[i].id + "</td>";
                tablecontent +=
                    "<td><img src=" +
                    accounts[i].avartar +
                    " style='height: 50px' alt='IMG'+'></td>";
                tablecontent += "<td>" + accounts[i].username + "</td>";
                tablecontent += "<td>" + accounts[i].fullname + "</td>";
                tablecontent += "<td>" + accounts[i].age + "</td>";
                tablecontent +=
                    "<td><button onclick='onHanldeEdit(" +
                    accounts[i].id +
                    ")'>Edit    </button> <button onclick='onDelete(" +
                    accounts[i].id +
                    ")'>Delete</button></td>";
                tablecontent += "</tr>";
            }
            // document.getElementById("tableBody").innerHTML=tablecontent;
            //jqemty
            $("#tableBody").empty();
            // //jqAppend
            $("#tableBody").append(tablecontent);
        },
        error: function (error) {
            alert("call that bai");
        },
    });
}
function onDelete(idDelete)
{   var isconfirm= confirm(" ban muon xoa account nay");
    if( isconfirm==true){
    $.ajax({
        type: "DELETE",
        url: "https://6a3bc8f2e4a07f202e15da10.mockapi.io/api/v1/account/"+ idDelete,
        // data: "data",
        // dataType: "dataType",
        success: function (response) {
            alert("xoa thanh cong");
            loadData()
        },
        error: function (error) {
            alert("call xoa that bai");
        },
    });
    }
}
function onHanldeEdit(idUpdate)
{
    $.ajax({
        type: "GET",
        url: "https://6a3bc8f2e4a07f202e15da10.mockapi.io/api/v1/account/"+idUpdate,
        // data: "data",
        dataType: "JSON",
        success: function (response) {
            console.log(response.username);
            console.log(response.age);
            $("#inputavartar").val(response.avartar);
            $("#inputfullname").val(response.fullname);
            $("#inputuesrname").val(response.username);
            $("#inputAge").val(response.age);
            v_idupdate=response.id;
            $('#modal-id').modal('show');
        },
           error: function (error) {
            alert("call update that bai");
        },
    });
}
    function Oncreate()
        {  
                 if(v_idupdate>0)
    {
        alert("đang update, ko thể tạo mới");
        return;
    }       var v_avartar=$("#inputavartar").val();
            var v_username= $("#inputUsername").val();
            var v_fullname= $("#inputfullname").val();
            var v_age= $("#inputAge").val();
        
        // dua du lieu vao 
            var account={
                avartar:v_avartar,
                username:v_username,
                fullname:v_fullname,
                age:v_age
            };
            $.ajax({
                type: "POST",
                url: "https://6a3bc8f2e4a07f202e15da10.mockapi.io/api/v1/account",
                data: JSON.stringify(account),
                contentType: "application/Json",
                success: function (response) {
                    alert("them thanh cong"),
                        loadData()
                $("#inputavartar").val();
                 $("#inputUsername").val();
                 $("#inputfullname").val();
                 $("#inputAge").val();
                },
                 error: function (error) {
                 alert("call them that bai");
                 },
            });
    
        
        }
function onUpdate()
{           var v_avartar=$("#inputavartar").val();
            var v_username= $("#inputuesrname").val();
            var v_fullname= $("#inputfullname").val();
            var v_age= $("#inputAge").val();
        
                 var account={
                avartar:v_avartar,
                username:v_username,
                fullname:v_fullname,
                age:v_age
            };
            $.ajax({
                type: "PUT",
                url: "https://6a3bc8f2e4a07f202e15da10.mockapi.io/api/v1/account/"+ v_idupdate,
                data: JSON.stringify(account),
                contentType: "application/json",
                success: function (response) {
                    alert("update du lieu thanh cong")
                    loadData();
                    v_idupdate=-1;
                 $("#inputavartar").val("");
                 $("#inputuesrname").val("");
                 $("#inputfullname").val("");
                 $("#inputAge").val("");
                }
            });

}
$('#submit').click(function (e) { 
     if(v_idupdate<=0)
    {
        Oncreate();
    }else{
        onUpdate();
    }
    
});
$('#onHanldeEdit').click(function (e) { 
     $.ajax({
        type: "GET",
        url: "https://6a3bc8f2e4a07f202e15da10.mockapi.io/api/v1/account/"+idUpdate,
        // data: "data",
        dataType: "JSON",
        success: function (response) {
            console.log(response.username);
            console.log(response.age);
            $("#inputavartar").val(response.avartar);
            $("#inputfullname").val(response.fullname);
            $("#inputuesrname").val(response.username);
            $("#inputAge").val(response.age);
            v_idupdate=response.id;
            $('#modal-id').modal('show');
        },
           error: function (error) {
            alert("call update that bai");
        },
    });
 
});
function resetForm(){
     $("#inputavartar").val("");
     $("#inputuesrname").val("");
     $("#inputfullname").val("");
     $("#inputAge").val("");
    v_idupdate=-1;
}
function changethem(themValue)
{ 
    if(themValue==='dark')
    {
        $("body").addClass("dark-theme");
    }else{
        $("body").removeClass("dark-theme");
    }
    localStorage.setItem('theme',themValue)
}