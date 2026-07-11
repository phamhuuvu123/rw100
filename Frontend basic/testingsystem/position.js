var position = [];
var v_idupdate = -1;
var idUpdate = -1;
var baseUrlPOS = "http://localhost:8080/api/v1/positions";
loadData();
function loadData() {
    $.ajax({
        type: "GET",
        url: baseUrlPOS,
        dataType: "JSON",
        success: function (response) {
            position = response;
            var tablecontent = "";
            for (let i = 0; i < position.length; i++) {
                tablecontent += "<tr>";
                tablecontent += `<td>${position[i].id}</td>`;
                tablecontent += `<td>${position[i].name}</td>`;
                tablecontent += `
                    <td>
                    <button onclick="onHandleEdit(${position[i].id})">Edit</button>
                    <button onclick="deletePosition(${position[i].id})">Delete</button>
                    </td>`;
                tablecontent += "</tr>";
            }
            $("#tablepos").empty();
            $("#tablepos").html(tablecontent);
        },
        error: function (error) {
            alert("call pos that bai");
        },
    });
}
function deletePosition(idDelete)
{   var isconfirm =confirm(" bạn muốn xóa");
    if(isconfirm==true)
    {
    $.ajax({
        type: "DELETE",
        url: baseUrlPOS + "/" + idDelete,
        success: function (response) {
            alert("delete thanh cong");
            loadData()
        },
         error: function (error) {
            alert("call pos that bai");
        },
    });
    }
}
function Oncreate()
{
    if(v_idupdate<-1)
    {
        alert("dang update")
        return;
    }
    var pos = $("#inputPositioName").val();
    var positions={ name:pos}
    $.ajax({
        type: "POST",
        url: baseUrlPOS,
        data: JSON.stringify(positions),
        contentType: "application/Json",
        success: function (response) {
            alert("them thanh cong");
            $("#inputPositioName").append("");
            $("#modal-id").modal('show');
            loadData();
              $("#modal-id").modal('hide');
        },
          error: function (error) {
            alert("call pos that bai");
        },
    });
}
$('#Position').submit(function (e) { 
    e.preventDefault();
    if(v_idupdate==-1){
    Oncreate();
    }else{
        onUpdate();
    }
});
function onHandleEdit(idUpdate)
{
    $.ajax({
        type: "GET",
        url: baseUrlPOS+"/"+ idUpdate,
        // data: "JSON",
        dataType: "JSON",
        success: function (response) {
            $("#inputPositioName").val(response.name);
            v_idupdate=idUpdate;
            $("#modal-id").modal('show')
        }  , error: function (error) {
            alert("call pos that bai");
        },

    });
}
function onUpdate()
{
    var pos= $("#inputPositioName").val();
    var position={name:pos}
    $.ajax({
        type: "PUT",
        url: baseUrlPOS+ "/"+ v_idupdate,
        data: JSON.stringify(position),
        contentType: "application/json",
        success: function (response) {
            //   alert("up date du lieu thanh cong")
              loadData();
              v_idupdate=-1;
              $("#inputPositioName").val("");
              $('#modal-id').modal('hide');
        } , error: function (error) {
            alert("call pos that bai");
        },
    });

}