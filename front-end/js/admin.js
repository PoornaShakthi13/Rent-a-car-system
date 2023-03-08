let baseUrl= "http://localhost:8080/back_end_war_exploded/";


var lastId;
idGen();
function idGen(){
    $.ajax({
        url: baseUrl+"Admin",
        method:'get',
        dataType: 'json',

        success: function (resp) {
            const idList=[0];
            for (let Admin of resp.data){
                idList.push(Admin.id)
            }
            lastId=idList.slice(-1);
        }
    })
}


$("#AdminSignIn").click(function () {
    saveAdmin();
    alert("fffffffffffffffffff");


})



function saveAdmin() {
    console.log("200");

    let id=parseInt(lastId)+1;
    let firstname=$("#firstName").val();
    let lastname=$("#lastName").val();
    let email=$("#emailAddress").val();
    let phonenumber=$("#phoneNumber").val();
    let password=$("#adminPassword").val();

    var Admin = {
        id: id,
        firstName:firstname,
        lastName:lastname,
        email:email,
        phoneNumber:phonenumber,
        password:password,

    }

    $.ajax({
        url: baseUrl+'Admin',
        method: 'post',
        contentType: "application/json",
        data:JSON.stringify(Admin),
        dataType:'json',

        success: function (resp) {
            alert(resp.message);
        },
        error: function (error) {
            let cause=JSON.parse(error.responseText).message;
            alert(cause);
        }
    });
}