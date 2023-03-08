let baseUrl= "http://localhost:8080/back_end_war_exploded/";


var lastId;
idGen();
function idGen(){
    $.ajax({
        url: baseUrl+"driver",
        method:'get',
        dataType: 'json',

        success: function (resp) {
            const idList=[0];
            for (let driver of resp.data){
                idList.push(driver.id)
            }
            lastId=idList.slice(-1);
        }
    })
}


$("#btnDriverSignIn").click(function () {
    saveDriver();
    alert("fffffffffffffffffff");


})



function saveDriver() {
    console.log("200");

    let id=parseInt(lastId)+1;
    let firstname=$("#firstName").val();
    let lastname=$("#lastName").val();
    let birthday=$("#birthdayDate").val();
    let img=$("#Drivingimg").val();
    let email=$("#emailAddress").val();
    let phonenumber=$("#phoneNumber").val();
    let password=$("#driverpass").val();

    var driver = {
        id: id,
        firstname:firstname,
        lastname:lastname,
        birthday:birthday,
        img:img,
        email:email,
        mobile:phonenumber,
        password:password

    }

    $.ajax({
        url: baseUrl+'driver',
        method: 'post',
        contentType: "application/json",
        data:JSON.stringify(driver),
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