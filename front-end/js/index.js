let baseUrl= "http://localhost:8080/back_end_war_exploded/";


var lastId;
idGen();
function idGen(){
    $.ajax({
        url: baseUrl+"customer",
        method:'get',
        dataType: 'json',

        success: function (resp) {
            const idList=[0];
            for (let cus of resp.data){
                idList.push(cus.id)
            }
            lastId=idList.slice(-1);
        }
    })
}


$("#cusSignIn").click(function () {
     savecustomer();
    alert("fffffffffffffffffff");


})



function savecustomer() {
    console.log("200");

    let id=parseInt(lastId)+1;
    let firstname=$("#firstName").val();
    let lastname=$("#lastName").val();
    let birthday=$("#birthdayDate").val();
    let email=$("#emailAddress").val();
    let phonenumber=$("#phoneNumber").val();
    let password=$("#txtpassword").val();

    var customer = {
        id: id,
        first_name:firstname,
        last_name:lastname,
        birthday:birthday,
        email:email,
        mobile:phonenumber,
        password:password

    }

    $.ajax({
        url: baseUrl+'customer',
        method: 'post',
        contentType: "application/json",
        data:JSON.stringify(customer),
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