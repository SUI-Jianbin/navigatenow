$(document).ready(function() {
    $(".needs-validation").on("submit", function(event) {
        event.preventDefault();  // Prevent default form submission behavior

        // Extract values from form
        let formData = {
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            age: parseInt($("#age").val(),10),
            contactNumber: $("#contactNumber").val(),
            email: $("#email").val(),
            gender: parseInt($("#gender").val(),10),
            dateOfBirth: $("#dob").val(),
            nationality: $("#nationality").val(),
            userName: $("#username").val(),
            password: $("#password").val()
        };

        // Send data to backend via AJAX
        $.ajax({
            url: "/users/user/add-user",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function() {
                setTimeout(function() {
                    getUserInfo(formData.userName);
                }, 1500);  // Waits for 2 seconds before calling getUserInfo
            },
            error: function() {
                alert("Register failed, please fill in all the information below and try again.");
            }
        });
    });
});
function getUserInfo (userName){
    sessionStorage.setItem("userName", userName);
    $.ajax({
        url: "/users/user/get-userbyusername/" +encodeURIComponent(userName) ,
        method: "GET",
        contentType: "application/json",
        success: function (response) {
            if(response){
                let userId = response.userId;
                let firstname = response.firstName;
                let lastname =  response.lastName;
                sessionStorage.setItem("userId",userId);
                sessionStorage.setItem("firstName",firstname);
                sessionStorage.setItem("lastName",lastname);
                window.location.href = "http://localhost:8080/View/UserPages/RegisterSuccessfully.html";
            }
        },
        error: function () {
            alert("Unable to retrieve data from server!");
        }
    });
}