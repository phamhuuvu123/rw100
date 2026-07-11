var deparment = [];
var v_idupdate = -1;
var idUpdate = -1;
var vThem = "";
var baseUrlDepartment = "http://localhost:8080/api/v1/departments";
loadData();
function loadData() {

    $.ajax({
        type: "GET",
        url: baseUrlDepartment,
        dataType: "JSON",
        success: function (response) {
            deparment = response;
            var tablecontent = "";

            for (let i = 0; i < deparment.length; i++) {
                            tablecontent += "<tr>";
                tablecontent += "<td>" + deparment[i].id + "</td>";
                tablecontent += "<td>" + deparment[i].name + "</td>";
                tablecontent +=
                    "<td><button onclick='onHanldeEdit(" +deparment[i].id +
                    ")'>Edit</button> <button onclick='onDelete(" +
                    deparment[i].id +
                    ")'>Delete</button></td>";
                tablecontent += "</tr>";
                console.log("abc")
            }
            $("#tabledepartment").empty();
            $("#tabledepartment").html(tablecontent);
        },
        error: function (error) {
    

            alert("call that bai");
        },
    });
}
function Oncreate()
{   if(v_idupdate>0)
    {   alert("dang update,ko the tao moi ");
    return;
    }
        var deparmentname=$("#inputDepartmentName").val();
        var deparment={
            name:deparmentname
        }
        $.ajax({
            type: "POST",
            url: baseUrlDepartment,
            data: JSON.stringify(deparment),
            contentType: "application/Json",
            success: function (response) {
                alert("them thanh cong");
                $("#inputDepartmentName").append("");
               
                $("#modal-id").modal("hide");
            },
             error: function (error) {
                 alert("call  asthat bai");
                 },
        });
}
$('#departmentForm').submit(function (e) {  
        e.preventDefault();
    if(v_idupdate<0)
    {Oncreate();}else
    {
    onUpdate();
    }
    
});
function onHanldeEdit(idUpdate)
{       
        $.ajax({
        type: "GET",
        url: baseUrlDepartment +"/" + idUpdate,
        dataType: "JSON",
        success: function (response) {
            $("#inputDepartmentName").val(response.name);
            v_idupdate=idUpdate;
            $('#modal-id').modal('show');
        },
         error: function (error) {
                 alert("call deapartment that bai");
                 },
    });
}
function onDelete(idDelete)
{
    var isFiniteconfirm =confirm("ban muon xoa");
    if(isFiniteconfirm==true)
    {$.ajax({
        type: "DELETE",
        url: baseUrlDepartment+"/"+idDelete,
        // data: "dat",
        // dataType: "dataType",
        success: function (response) {
            alert("xoa thanh cong");
            loadData();
        },
        error: function (error) {
                 alert("call deapartment xoa that bai");
                 },
    });

    }
}
function onUpdate()
{
    var deparmentName= $("#inputDepartmentName").val();
    var deparment ={ name:deparmentName}
    $.ajax({
        type: "PUT",
        url: baseUrlDepartment+"/"+v_idupdate,
        data: JSON.stringify(deparment),
                contentType: "application/json",
        success: function (response) {
              alert("up date du lieu thanh cong")
              loadData();
              v_idupdate=-1;
              $("#inputDepartmentName").val("");
              $('#modal-id').modal('hide');
        },
         error: function (error) {
                 alert("call deapartment update that bai");
                 },
    });
}
