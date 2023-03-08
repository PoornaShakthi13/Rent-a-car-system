let baseUrl= "http://localhost:8080/back_end_war_exploded/";


var lastId;
idGen();
function idGen(){
    $.ajax({
        url: baseUrl+"Vehicle",
        method:'get',
        dataType: 'json',

        success: function (resp) {
            const idList=[0];
            for (let Vehicle of resp.data){
                idList.push(Vehicle.id)
            }
            lastId=idList.slice(-1);
        }
    })
}


$("#btnSaveCustomer").click(function () {
    saveVehicle();
    alert("fffffffffffffffffff");


})



function saveVehicle() {
    console.log("200");

    let id=parseInt(lastId)+1;
    let vehicleModel=$("#txtVehicleModel").val();
    let vehicleNumber=$("#txtVehicleNumber").val();
    // let vehicleMileage=$("#txtVehicleMileage").val();
    let vehiclePrice=$("#vehiclePrice").val();
    let fuelType=$("#fuelType").val();

    var Vehicle = {
        id: id,
        vehicleModel:vehicleModel,
        vehicleNumber:vehicleNumber,
        fuelType:fuelType,
        vehiclePrice:vehiclePrice,



    }

    $.ajax({
        url: baseUrl+'Vehicle',
        method: 'post',
        contentType: "application/json",
        data:JSON.stringify(Vehicle),
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