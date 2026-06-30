var arrs=[
        {
            id:1,
            uesrname:"nguyenvanA",
            fullname:"nguyen van A",
            age:20
        },
         {
            id:2,
            uesrname:"tranvanB",
            fullname:"tran van B",
            age:22
        },
         {
            id:3,
            uesrname:"ngo thi C",
            fullname:"Ngo thi C",
            age:23
        },
         {
            id:4,
            uesrname:"le van D",
            fullname:"le van D",
            age:20
        }

    ];
    loadData();
    function loadData()
    {
    var tablecontent ="";
    for(let i=0;i<arrs.length;i++)
    {   tablecontent+= "<tr>";
        tablecontent+="<td>"+arrs[i].id+"</td>";
        tablecontent+="<td>"+arrs[i].uesrname+"</td>";
        tablecontent+="<td>"+arrs[i].fullname+"</td>";
        tablecontent+="<td>"+arrs[i].age+"</td>";
        tablecontent+="<td><button onclick='onHanldeUpdate("+arrs[i].id+")'>Edit    </button> <button onclick='onDelete("+arrs[i].id+")'>Delete</button></td>";
        tablecontent+= "</tr>";

    }
    // document.getElementById("tableBody").innerHTML=tablecontent;
    //jqemty
    $('#tableBody').empty();
    //jqAppend
    $("#tableBody").append(tablecontent);
    }   
 function onDelete(idDelete)
    {
        var isconfirm = confirm("bạn có muốn xóa id này không")
        if(isconfirm==true)
    {
        var indexDel=-1;
     for(let i=0;i<arrs.length;i++)
     {
        if(arrs[i].id===idDelete)
     {  
        indexDel=i;
        break;
     }
     }
     arrs.splice(indexDel,1);
     loadData();
     }
    }
        function Oncreate()
        {  
                 if(v_idupdate>0)
    {
        alert("đang update, ko thể tạo mới");
        return;
    }   
            var v_uesrname= $("#inputUesrname").val();
            var v_fullname= $("#inputfullname").val();
            var v_age= $("#inputAge").val();
            var v_id =arrs.length;
            // console(v_uesrname + " ," + v_fullname + " ," + v_age);
            var account={
                id: ++v_id,
                uesrname:v_uesrname,
                fullname:v_fullname,
                age:v_age
            };
            arrs.push(account);
            loadData()
            $("inputUesrname").val();
            $("inputfullname").val();
            $("inputAge").val();
        }
    $("#accountFrom").submit(function (e) { 
        e.preventDefault();
        if(v_idupdate>0)
    {
        alert("đang update, ko thể tạo mới");
        return;
    }   
        // var v_uesrname = document.getElementById("inputUesrname").value;
        // var v_fullname = document.getElementById("inputFullname").value;
        // var v_age = document.getElementById("inputAge").value;
        var v_uesrname= $("inputUesrname").val("");
         var v_fullname= $("inputfullname").val("");
          var v_age= $("inputAge").val("");
        console(v_uesrname + " ," + v_fullname + " ," +v_age)
        var account={
            id: ++v_id,
            uesrname:v_uesrname,
            fullname:v_fullname,
            age:v_age
        };
        arrs.push(account);
        loadData()
     
        $("inputUesrname").val("");
         $("inputfullname").val("");
          $("inputAge").val("");
    });
    var  v_idupdate=-1;
    function onHanldeUpdate(idUpdate)
    {
        for(let i=0;i<arrs.length;i++)
    {
        if(arrs[i].id==idUpdate)
    {   
        $("#inputUesrname").val(arrs[i].uesrname);
        $("#inputfullname").val(arrs[i].fullname);
        $("#inputAge").val(arrs[i].age);
        v_idupdate=arrs[i].id;
        break;
    }

    }
    }
    function onUpdate()
    {
         var v_uesrname= $("#inputUesrname").val();
         var v_fullname= $("#inputfullname").val();
          var v_age= $("#inputAge").val();        
          var V_indexUpdate=-1;
          for(let i=0;i<arrs.length;i++)
          {
            if(arrs[i].id==v_idupdate)
          {
            V_indexUpdate=i;
            break;
          }
          }
          if(V_indexUpdate!=-1){
          arrs[V_indexUpdate]=
          {
            id: v_idupdate ,
            uesrname: v_uesrname,
            fullname: v_fullname,
            age:v_age
          };
        
          loadData();
         $("#inputUesrname").val();
         $("#inputfullname").val();
          $("#inputAge").val();
        }
    }
    
