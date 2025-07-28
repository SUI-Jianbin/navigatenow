$(document).ready(function () {
    $(".needs-validation").on("submit", function (event) {
        event.preventDefault();

        let email = $("#email").val();
        let password = $("#password").val();

        $.ajax({
            url: "/users/user/userlogin?email=" + encodeURIComponent(email) + "&password=" + encodeURIComponent(password),
            method: "GET",
            contentType: "application/json",

            success: function (response) {
                if(response){
                    let userId = response.userId;
                    getUserInfo (userId);
                }
            },
            error: function () {
                $('input[name="email"]').val('');
                $('input[name="password"]').val('');
                alert("Unauthorized email or password, please check your email and password!");
            }
        });
    });
});

function getUserInfo (userId){
    sessionStorage.setItem("userId",userId);
    $.ajax({
        url: "/users/user/get-userbyid/" +encodeURIComponent(userId) ,
        method: "GET",
        contentType: "application/json",
        success: function (response) {
            if(response){
                let username = response.userName;
                let firstname =response.firstName;
                let lastname = response.lastName;
                sessionStorage.setItem("userName",username);
                sessionStorage.setItem("firstName",firstname);
                sessionStorage.setItem("lastName",lastname);
               // window.location.href = "http://localhost:8080/View/NewPlans/NewPlans.html?userid=" + userId;
                window.location.href="http://localhost:8080/View/MyPlans/MyPlans.html";
            }
        },
        error: function () {
            alert("Unable to retrieve data from server!");
        }
    });
}