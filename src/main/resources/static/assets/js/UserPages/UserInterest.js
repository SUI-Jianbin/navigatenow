$(document).ready(function() {
    $.ajax({
        url: "/userintrests/userintrest/get-alluserintrests",
        type: "GET",
        success: function(tags) {
            tags.forEach(tag => {
                let div = '<div class="tag" data-value="' + tag.intrestValue + '" data-id= "'+tag.userintrestId +'">' + tag.intrestValue +'</div>'
                $('#tagsList').append(div);
            });
        },
        error: function(error) {
            console.error('Error fetching tags:', error);
        }
    });
});

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    }

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
});

document.querySelector('.error-message').classList.remove('d-block');
document.querySelector('.sent-message').classList.remove('d-block');

let selectedTags = [];
document.addEventListener("DOMContentLoaded", function() {

    document.querySelector(".tag-container").addEventListener("click", function(e) {
        if (e.target.classList.contains("tag")) {
            let tagValue = e.target.getAttribute("data-value");
            let tagId = e.target.getAttribute("data-id");
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
        }
    });

    document.querySelector(".selected-tags").addEventListener("click", function(e) {
        if (e.target.classList.contains("selected-tag")) {
            let tagValue = e.target.getAttribute("data-value");
            let tagId = e.target.getAttribute("data-id");
            selectedTags = selectedTags.filter(t => t.value !== tagValue);

            const div = document.createElement("div");
            div.className = "tag";
            div.setAttribute("data-value", tagValue);
            div.setAttribute("data-id", tagId);
            div.innerText = tagValue;
            document.querySelector(".tag-container").appendChild(div);
            e.target.remove();
        }
    });

});

document.getElementById('browseNowBtn').addEventListener('click', function(event) {
    if (selectedTags.length < 3) {
        let sentMessageElement = document.querySelector('.error-message');
        sentMessageElement.classList.add('d-block');
        setTimeout(function() {
            sentMessageElement.classList.remove('d-block');
        }, 3000);

        event.preventDefault();
    }else {
        submitSelectedTags(selectedTags);
    }
});

function submitSelectedTags(tags) {
    let userId = sessionStorage.getItem("userId")
    if(!userId){
        alert("No user found in this page, please login first!");
        return
    }

    let payload = tags.map(tag =>({
        userId: userId,
        userintrestId: tag.id
    }));

    $.ajax({
        type: "POST",
        url: "/user-userintrests/user-userintrest/add-user-userintrest",
        contentType: "application/json",
        data: JSON.stringify(payload),
        success: function(){
            let sentMessageElement = document.querySelector('.sent-message');
            sentMessageElement.classList.add('d-block');

            setTimeout(function() {
                //window.location.href="http://localhost:8080/View/NewPlans/NewPlans.html";
                window.location.href="http://localhost:8080/View/MyPlans/MyPlans.html";
            }, 1000);
        },
        error: function(error){
            console.error('Error:', error);
        }
    });
}