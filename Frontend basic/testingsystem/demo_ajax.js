var accounts = [];
var v_idupdate=-1;
var idUpdate=-1;
var vThem='';
var baseUrl="http://localhost:8080/api/v1/accounts"
var baseUrlDepartment="http://localhost:8080/api/v1/departments";
var baseURLPOS="http://localhost:8080/api/v1/positions";
var baseAvt="https://www.dienmayxanh.com/kinh-nghiem-hay/hinh-nen-cute-de-thuong-nhat-cho-dien-thoai-may-tinh-1587964?srsltid=AfmBOoq9vtoUac3Ks0QF12XaPolJxja8BkSwnOxFhClpJvboctF3Fu4I";
loadData();
LoadDePartment();
LoadPosition();
vThem =localStorage.getItem('theme');
changethem(vThem);
function loadData() {
    // call api  mockapi.oi lay  ds account
    $.ajax({
        type: "GET",
        url: baseUrl,
        dataType: "JSON",
        success: function (response) {
            console.log('success');
            
            accounts = response;
            var tablecontent = "";
            for (let i = 0; i < accounts.length; i++) {
                tablecontent += "<tr>";
                tablecontent += "<td>" + accounts[i].id + "</td>";
                // tablecontent += "<td>" + accounts[i].avartar + "</td>";
                tablecontent +="<td>"
                    "<td><img src=" +
                    accounts[i].avartar +
                    baseAvt+"</td>";
            
                    tablecontent += "<td>" + accounts[i].email + "</td>";
                 tablecontent += "<td>" + accounts[i].username + "</td>";
                    tablecontent += "<td>" + accounts[i].fullName+ "</td>";
                tablecontent += "<td>" + accounts[i].departmentName + "</td>";
                tablecontent += "<td>" + accounts[i].positionName + "</td>";
            
                tablecontent +=
                    "<td><button onclick='onHanldeEdit(" +
                    accounts[i].id +
                    ")'>Edit    </button> <button onclick='onDelete(" +
                    accounts[i].id +
                    ")'>Delete</button></td>";
                tablecontent += "</tr>";
            }
    //           {
    //     "id": 2,
    //     "fullName": "Trần Bình",
    //     "username": "helo",
    //     "departmentName": "Sale",
    //     "positionName": "TEST"
    // },
            // document.getElementById("tableBody").innerHTML=tablecontent;
            //jqemty
            $("#tableBody").empty();
            // //jqAppend
            $("#tableBody").append(tablecontent);
        },
        error: function (error) {
            console.log(error);
            
            alert("call that bai");
        },
    });
}
function onDelete(idDelete)
{   var isconfirm= confirm(" ban muon xoa account nay");
    if( isconfirm==true){
    $.ajax({
        type: "DELETE",
        url: baseUrl/+ idDelete,
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
        url: baseUrl+ "/" +idUpdate,
        // data: "data",
        dataType: "JSON",
        success: function (response) {
        
            $("#inputavartar").val(response.avartar);
            $("#inputfullname").val(response.fullName);
            $("#inputusername").val(response.username);
             $("#inputemail").val(response.email);
            $("#inputDepartmentName").val(response.departmentId);
            $("#inputPositioName").val(response.positionId);
            v_idupdate=idUpdate;
            $('#modal-id').modal('show');
        },
           error: function (error) {
            alert("call update that bai123");
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
            var v_username= $("#inputusername").val();
            var v_fullname= $("#inputfullname").val();
            var v_email= $("#inputemail").val();
            var v_departmentid= $("#inputDepartmentName").val();
            var v_positonid= $("#inputPositioName").val()
        
        // dua du lieu vao 
            var account={
               fullName:v_fullname,
               email:v_email,
               username:v_username,
               departmentId:v_departmentid,
               positionId:v_positonid
            };
            $.ajax({
                type: "POST",
                url: baseUrl,
                data: JSON.stringify(account),
                contentType: "application/Json",
                success: function (response) {
                    alert("them thanh cong"),
                        loadData()
                $("#inputavartar").val();
                 $("#inputusername").val();
                 $("#inputfullname").val();
                  $("#inputemail").val();
                 $("#inputDepartmentName").val();
                 $("#inputPositioName").val();
                 $("#modal-id").modal("hide");
                 
                },
                 error: function (error) {
                 alert("call  that bai");
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
                url: baseUrl/+ v_idupdate,
                data: JSON.stringify(account),
                contentType: "application/json",
                success: function (response) {
                    alert("up    date du lieu thanh cong")
                    loadData();
                    v_idupdate=-1;
                 $("#inputavartar").val("");
                 $("#inputuesrname").val("");
                 $("#inputfullname").val("");
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
        url: baseUrl+ "/" + idUpdate,
        dataType: "JSON",
        success: function (response) {
          
            $("#inputavartar").val(response.avartar);
            $("#inputfullname").val(response.fullname);
            $("#inputuesrname").val(response.username);
        
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
function LoadDePartment()
{
    $.ajax({
        type: "GET",
        url: baseUrlDepartment,
        dataType: "JSON",
        success: function (response) {
            var content ="";
            for(let i=0 ; i<response.length; i++)
            { content+=` <option value="${response[i].id}">${response[i].name}</option>`
            }
            $("#inputDepartmentName").empty();
             $("#inputDepartmentName").append(content);
        
        
        },
         error: function (error) {
            console.log(error);
            
            alert("call  department that bai");
        },
    });
}
function LoadPosition()
{
    $.ajax({
        type: "GET",
        url: baseURLPOS,
         dataType: "JSON",
        success: function (response) {
             var content ="";
            for(let i=0 ; i<response.length; i++)    
            {
            content+= `<option value="${response[i].id}">${response[i].name}</option>`;
            }
            $("#inputPositioName").empty();
             $("#inputPositioName").append(content);
        
        }, error: function (error) {
            console.log(error);
            
            alert("call api position that bai");
        },
    });
}
