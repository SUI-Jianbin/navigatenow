let user_Id =parseInt(sessionStorage.getItem("userId"), 10)


$(document).ready(function() {
    let topbar_username = sessionStorage.getItem("userName")
    let bar_firstname = sessionStorage.getItem("firstName")
    let bar_lastname = sessionStorage.getItem("lastName")
    $('#topbar_username').text(topbar_username);
    $('#bar_firstname').text(bar_firstname);
    $('#bar_lastname').text(bar_lastname);

    document.querySelector('.error-message').classList.remove('d-block');
    document.querySelector('.sent-message').classList.remove('d-block');

    $(".php-email-form").on("submit", function(event) {
        event.preventDefault();  // Prevent default form submission

        let formData = {
            firstName: $("#firstname").val(),
            lastName: $("#lastname").val(),
            email: $("#email").val(),
            description: $("#description").val(),
            experienceRate: parseInt($('input[name="star"]:checked').val(),10),
            user_id: user_Id
        };

        $.ajax({
            url: "/feedbacks/feedback/add-feadback",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(formData),
            success: function(response) {
                $(".php-email-form")[0].reset(); // Reset the form
                let sentMessageElement = document.querySelector('.sent-message');
                sentMessageElement.classList.add('d-block');

                setTimeout(function() {
                    sentMessageElement.classList.remove('d-block');
                }, 5000);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                $(".error-message").text("There was an error sending your message. Please try again.").show();
            }
        });
    });
});