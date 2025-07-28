let user_Id = parseInt(sessionStorage.getItem("userId"), 10)
let topbar_username = sessionStorage.getItem("userName")
let bar_firstname = sessionStorage.getItem("firstName")
let bar_lastname = sessionStorage.getItem("lastName")
let newlyAddedTags = [];
$(document).ready(function(){

    $('#topbar_username').text(topbar_username);
    $('#bar_firstname').text(bar_firstname);
    $('#bar_lastname').text(bar_lastname);

    $.ajax({
        url: "/users/user/get-userbyid/" + encodeURIComponent(user_Id),
        type: "GET",
        success: function(data) {
            $("#fName").text(data.firstName);
            $("#lName").text(data.lastName);
            $("#ag").text(data.age);
            if(data.gender === 0 ) {
                $("#gend").text("Female");
            } else if(data.gender === 1) {
                $("#gend").text("Male");
            } else {
                $("#gend").text("");
            }
            $("#ema").text(data.email);
            $("#contactNum").text(data.contactNumber);
            $("#dateofBirth").text(data.dateOfBirth.split('T')[0]);
            $("#Nation").text(data.nationality);

            $("#id").text(6);
            $("#firstName").val(data.firstName);
            $("#lastName").val(data.lastName);
            $("#age").val(data.age);
            $("#email").val(data.email);
            $("#phone").val(data.contactNumber);
            $("#dob").val(data.dateOfBirth.split('T')[0]);
            $("#nationality").val(data.nationality);
            if(data.gender === 0) {
                $("#gender").val("0");
            } else if(data.gender === 1) {
                $("#gender").val("1");
            } else {
                $("#gender").val("");
            }
        }
    });
});

let selectedTags = [];
let toBeDeletedIds = [];

$(document).ready(function() {
    $.ajax({
        url: "/user-userintrests/user-userintrest/get-user-userintrestbyid/" + user_Id,
        type: "GET",
        success: function(tags) {
            tags.forEach(tag => {
                let div = '<div class="selected-tag" data-value="' + tag.userIntrestEntity.intrestValue + '" data-id= "'+tag.userintrestId +'">' + tag.userIntrestEntity.intrestValue +'</div>'
                $('#selectedList').append(div);
                selectedTags.push({ value: tag.userIntrestEntity.intrestValue, id: tag.userintrestId });
            });

            $.ajax({
                url: "/userintrests/userintrest/get-alluserintrests",
                type: "GET",
                success: function(allTags) {
                    allTags.forEach(tag => {
                        if (!selectedTags.some(t => t.id === tag.userintrestId)) {
                            let div = '<div class="tag" data-value="' + tag.intrestValue + '" data-id= "'+tag.userintrestId +'">' + tag.intrestValue +'</div>'
                            $('#tagsList').append(div);
                        }
                    });
                },
                error: function(error) {
                    console.error('Error fetching tags:', error);
                }
            });
        },
        error: function(error) {
            console.error('Error fetching tags:', error);
        }
    });
});

document.addEventListener("DOMContentLoaded", function() {
    document.querySelector(".tag-container").addEventListener("click", function(e) {
        if (e.target.classList.contains("tag")) {
            let tagValue = e.target.getAttribute("data-value");
            let tagId = parseInt(e.target.getAttribute("data-id"), 10);
            if (!selectedTags.some(t => t.value === tagValue)) {
                selectedTags.push({ value: tagValue, id: tagId });
                const div = document.createElement("div");
                div.className = "selected-tag";
                div.setAttribute("data-value", tagValue);
                div.setAttribute("data-id", tagId);
                div.innerText = tagValue;
                document.querySelector(".selected-tags").appendChild(div);
                e.target.remove();
            }
            newlyAddedTags.push({ userId: user_Id, userintrestId: tagId });
            const index = toBeDeletedIds.indexOf(tagId);
            if (index !== -1) {
                toBeDeletedIds.splice(index, 1);
            }
        }
    });

    document.querySelector(".selected-tags").addEventListener("click", function(e) {
        if (e.target.classList.contains("selected-tag")) {
            let tagValue = e.target.getAttribute("data-value");
            let tagId = parseInt(e.target.getAttribute("data-id"), 10)
            selectedTags = selectedTags.filter(t => t.value !== tagValue);
            toBeDeletedIds.push(tagId)
            const div = document.createElement("div");
            div.className = "tag";
            div.setAttribute("data-value", tagValue);
            div.setAttribute("data-id", tagId);
            div.innerText = tagValue;
            document.querySelector(".tag-container").appendChild(div);
            e.target.remove();
            newlyAddedTags = newlyAddedTags.filter(t => t.userintrestId !== tagId);
        }
    });
});


document.addEventListener("DOMContentLoaded", function() {
    document.querySelector('button[value="saveInterest"]').addEventListener("click", function () {
        $.ajax({
            url: "/user-userintrests/user-userintrest/add-user-userintrest",
            type: "POST",
            data: JSON.stringify(newlyAddedTags),
            contentType: "application/json",
            success: function (response) {
                console.log("Successfully updated user interests!", response);
                newlyAddedTags = [];
            },
            error: function (error) {
                console.error('Error updating user interests:', error);
            }
        });

        if (toBeDeletedIds.length >0){
            const dataToDelete = toBeDeletedIds.map(id => ({
                userId: parseInt(user_Id, 10),
                userintrestId: parseInt(id, 10)
            }));

            $.ajax({
                url: "/user-userintrests/user-userintrest/delete-user-userintrestbyid",
                type: "DELETE",
                data: JSON.stringify(dataToDelete),
                contentType: "application/json",
                success: function(response) {
                    console.log("Deleted successfully:", response);
                    toBeDeletedIds = [];
                },
                error: function(error) {
                    console.error('Error deleting interests:', error);
                }
            });
        }
    });
})

$(document).ready(function() {

    // Prevent the form from submitting the default way
    $('button[value="saveChanges"]').click(function(event) {
        event.preventDefault();
        // Create an object to store form data
        let formData = {
            userId: user_Id,
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            age: parseInt($("#age").val(),10),
            gender: parseInt($("#gender").val(),10),
            email: $("#email").val(),
            contactNumber: $("#phone").val(),
            dateOfBirth: $("#dob").val(),
            nationality: $("#nationality").val()
        };

        // Send the data to the server using AJAX
        $.ajax({
            type: "PUT",
            url: "/users/user/update-user-withoutpassword",
            data: JSON.stringify(formData),
            contentType: "application/json",
            success: function(response) {
                // Handle a successful response from the server
                alert("Profile saved successfully");
            },
            error: function(error) {
                // Handle any errors from the server
                alert("Error saving data");
            }
        });
    });

    $('button[value="changePassword"]').click(function(event) {
        event.preventDefault();

        const currentPassword = $("#currentPassword").val();
        const newPassword = $("#newPassword").val();
        const renewPassword = $("#renewPassword").val();

        if (newPassword === currentPassword) {
            alert("New password should not same as old password!");
            return;
        }
        if (newPassword !== renewPassword) {
            alert("New password and re-entered password do not match!");
            return;
        }

        const formData = {
            userName: topbar_username,
            password: newPassword
        };

        $.ajax({
            type: "PUT",
            url: "/users/user/update-userpassword",
            data: JSON.stringify(formData),
            contentType: "application/json",
            success: function() {
                $("#currentPassword").val("");
                $("#newPassword").val("");
                $("#renewPassword").val("");
                alert("Password changed successfully!");
            },
            error: function(error) {
                alert("Something wrong happen with update service, please try again.");
            }
        });
    });
});

