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
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
});
$(document).ready(function() {
    document.querySelector('.error-message').classList.remove('d-block');
    document.querySelector('.sent-message').classList.remove('d-block');

    $(".php-email-form").on("submit", function(event) {
        event.preventDefault();  // Prevent default form submission

                let formData = {
                    firstName: $("#firstname").val(),
                    lastName: $("#lastname").val(),
                    email: $("#email").val(),
                    description: $("#message").val()
                };

        $.ajax({
            url: "/contactuss/contactus/add-contactus",
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
