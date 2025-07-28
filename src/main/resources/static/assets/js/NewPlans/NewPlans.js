let user_Id = parseInt(sessionStorage.getItem("userId"), 10)
let topbar_username = sessionStorage.getItem("userName")
let bar_firstname = sessionStorage.getItem("firstName")
let bar_lastname = sessionStorage.getItem("lastName")

$(document).ready(function() {

    $('#topbar_username').text(topbar_username);
    $('#bar_firstname').text(bar_firstname);
    $('#bar_lastname').text(bar_lastname);

    $.ajax({
        url: "/touristyplacess/touristyplaces/get-touristyplacesbyuserid/" + user_Id,
        type: "GET",
        success: function(response) {
            console.log(response)
            response.forEach(function(place) {
                console.log(place)
                const cardHtml = `
                <div id="activity-card" class="card">
                <div class="card-content">
                    <div class="card-img-section">
                        <img src="${place.placePicture || '../../assets/img/opera%20house.png'}" alt="Image of ${place.activityName || 'Activity'}">
                        <button type="button" id="choose-btn" class="btn btn-primary rounded-pill btn-sm" data-id = ${place.touristyPlacesId} >Choose</button>
                    </div>
                    <div class="card-info">
                        <p id="activity-name">&nbsp;&nbsp;${place.placeName || ''}</p>
                        <p id="location">&nbsp;&nbsp;${place.placeLocation || ''}</p>
                        <p id="Opening-time">&nbsp;&nbsp;${place.placeOpeningTimes || ''}</p>
                        <p id="closing-time">&nbsp;&nbsp;${place.placeClosingTime || ''}</p>
                        <p id="place-rate">&nbsp;&nbsp;${place.placeRate || ''}</p>
                    </div>
                </div>
            </div>`;
                $(".section-card .row").append(cardHtml);
            });
        },
        error: function(error) {
            console.error("Failed to fetch data: ", error);
        }
    });
    });

let addedActivities = [];

$(document).ready(function() {
    $(document).on('click', '#choose-btn', function() {
        const activityId = $(this).data('id');
        if (!addedActivities.includes(activityId)) {
            addedActivities.push(activityId);
            const activityName = $(this).closest('.card-content').find('#activity-name').text();
            const location = $(this).closest('.card-content').find('#location').text();
            const placeRate = $(this).closest('.card-content').find('#place-rate').text();
            const newRow = `
            <tr data-id="${activityId}">
            <th scope="row">${addedActivities.length}</th>
            <td>${activityName}</td>
            <td>${location}</td>
            <td>${placeRate}</td>
            <td><button class="btn btn-danger btn-sm remove-btn">Delete</button></td>
            </tr>`;
            $('#plan-table tbody').append(newRow);
        } else {
            alert("This activity has already been added!");
        }
    });
});

$(document).on('click', '.remove-btn', function() {
    const activityId = $(this).closest('tr').data('id');
    const rowIndex = addedActivities.indexOf(activityId);

    if (rowIndex > -1) {
        addedActivities.splice(rowIndex, 1);
    }

    $(this).closest('tr').remove();
    $('#plan-table tbody tr').each(function(index) {
        $(this).find('th').text(index + 1);
    });
});

$(document).ready(function() {
    const createButton = $('#addtoplan .btn-primary'); // reference to the 'Create' button

    createButton.on('click', function() {
        // Fetching values from the input fields
        const planName = $('#pname').val()
        const startDate = $('#sdate').val();
        const endDate = $('#edate').val();
        const description = $('#des').val();

        const touristyPlacesTripPlanPostDTOS = [];
        $('#plan-table tbody tr').each(function() {
            const touristyPlacesId = $(this).data('id');
            touristyPlacesTripPlanPostDTOS.push({ touristyPlacesId });
        });
        // Storing them in an object
        const activityPlan = {
            planName: planName,
            planDescription: description,
            startDate: startDate,
            endDate:endDate,
            user_id: user_Id,
            touristyPlacesTripPlanPostDTOS:touristyPlacesTripPlanPostDTOS
        };
        //123
        console.log(activityPlan)
        $.ajax({
            url: '/tripplans/tripplan/add-tripplan',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(activityPlan),
            success: function(response) {
                alert('Plan successfully created!');
                //window.location.reload();
                window.location.href="http://localhost:8080/View/MyPlans/MyPlans.html";

            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('Error in creating plan: ' + textStatus);
            }
        });
        // Disabling the 'Create' button to prevent duplicate object creation
        createButton.prop('disabled', true);

    });

    // When the modal is hidden (closed), re-enable the 'Create' button
    $('#addtoplan').on('hidden.bs.modal', function() {
        createButton.prop('disabled', false);
    });
});



