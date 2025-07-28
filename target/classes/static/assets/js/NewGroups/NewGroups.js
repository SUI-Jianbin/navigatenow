const userid = sessionStorage.getItem("userId");
let topbar_username = sessionStorage.getItem("userName")
let bar_firstname = sessionStorage.getItem("firstName")
let bar_lastname = sessionStorage.getItem("lastName")


$('#topbar_username').text(topbar_username);
$('#bar_firstname').text(bar_firstname);
$('#bar_lastname').text(bar_lastname);




$(document).ready(function() {

    $.ajax({
        type: "GET",
        url: "/tripgroups/tripgroup/get-allothersgroupsbyuserid/" + userid,
        success: function(allGroups) {

            $.ajax({
                url: '/user-tripplans-tripgroups/user-tripplan-tripgroup/get-user-tripplan-tripgroupbyid',
                type: 'GET',
                data: { userid: userid },
                success: function(joinedGroups) {
                    console.log(joinedGroups);
                    let joinedGroupIds = [];
                    if (Array.isArray(joinedGroups)) {
                        joinedGroupIds = joinedGroups.map(item => item.tripGroupId);
                    }

                    let container = $('.row');
                    allGroups.forEach(group => {
                        if (joinedGroupIds.length === 0 || !joinedGroupIds.includes(group.tripGroupId)) {
                            let formattedStartDate = group.tripPlanGetDTO.startDate.replace("T", "  ").split(".")[0];
                            let formattedEndDate = group.tripPlanGetDTO.endDate.replace("T", "  ").split(".")[0];
                            let groupCard = `
                            <div class="col-lg-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${group.groupName}</h5>
                                        <p style="font-size: 15px">Created By: ${group.tripPlanGetDTO.userEntity.userName}</p>
                                        <p style="font-size: 15px">Description: ${group.groupDescription}</p>
                                        <p style="font-size: 15px">Number of User: ${group.numberOfTourists}</p>
                                        <p style="font-size: 15px">Capacity Limit: ${group.groupNumberLemit}</p>
                                        <button type="button" class="btn btn-primary join-group" 
                                                data-group-id="${group.tripGroupId}"
                                                data-plan-id="${group.tripPlanGetDTO.tripPlanId}"
                                                data-bs-toggle="modal" data-bs-target="#joinConfirmModal-${group.tripGroupId}">
                                                Join
                                        </button>
                                        <button type="button" class="btn btn-primary show-plan-info" 
                                                data-plan1-id="${group.tripPlanGetDTO.tripPlanId}" >Plan info</button>
                                    </div>
                                </div>
                            </div>`;
                            container.append(groupCard);
                            let planId = group.tripPlanGetDTO.tripPlanId;  // 获取当前的planId

                            $.ajax({
                                url: "/touristyplaces-tripplans/touristyplaces-tripplan/get-touristyplaces-tripplanbytripplanid/" + planId,
                                type: "GET",
                                dataType: "json",
                                success: function(placesDataArray) {
                                    let placesContent = `<hr>
                                                            <h3>Chosen Activities </h3>`;

                                    placesDataArray.forEach(placesData => {
                                        placesContent += `
                                                        <br>
                                                        <br>
                                                <p style="font-weight: bolder">Place Name:</p>
                                                <p>${placesData.placeName} (${placesData.placeRate})</p>
                                                <p style="font-weight: bolder">Location:</p>
                                                <p>${placesData.placeLocation}</p>
                                                <p style="font-weight: bolder">Opening Days:</p>
                                                <p>${placesData.placeOpeningDays}</p>
                                                <p style="font-weight: bolder">Opening Times:  </p>
                                                <p>${placesData.placeOpeningTimes}</p>
                                                <p style="font-weight: bolder">Closing Times:</p>
                                                <p>${placesData.placeClosingTime}</p>
                                         `;
                                    });

                                    let modalHTML = `
            <div class="modal fade" id="planInfoModal-${planId}" tabindex="-1">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Plan Info</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p style="font-weight: bolder">Plan Name: </p>
                            <p>${group.tripPlanGetDTO.planName}</p>
                            <p style="font-weight: bolder">Description: </p>
                            <p>${group.tripPlanGetDTO.planDescription}</p>
                            <p style="font-weight: bolder">Start Date: </p>
                            <p>${formattedStartDate}</p>
                            <p style="font-weight: bolder">End Date: </p>
                            <p>${formattedEndDate}</p>
                            ${placesContent}
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>`;

                                    container.append(modalHTML);
                                },
                                error: function(error) {
                                    console.error("Error fetching places info: ", error);
                                }
                            });
                            let joinConfirmModal = `
                            <div class="modal fade" id="joinConfirmModal-${group.tripGroupId}" tabindex="-1">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Confirm</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to join this group?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary confirm-join-group" 
                                                    data-group-id="${group.tripGroupId}"
                                                    data-plan-id="${group.tripPlanGetDTO.tripPlanId}">Confirm</button>
                                        </div>
                                    </div>
                                </div>
                            </div>`;
                            container.append(joinConfirmModal);
                        }
                    });
                },
                error: function(error) {
                    console.error("Error fetching user's joined groups:", error);
                }
            });
        },
        error: function(error) {
            console.error("Error fetching all groups:", error);
        }
    });
});

//Search Function here
$('.search-form').on('submit', function(e) {
    e.preventDefault(); // 阻止默认提交

    let query = $('input[name="query"]').val();

    if(query) {
        fetchGroupsBySearch(query);
    }
});

function fetchGroupsBySearch(query) {
    $.ajax({
        type: "GET",
        url: "/tripgroups/tripgroup/get-alltripgroupsbyname/" + query,
        success: function(allGroups) {
            // 获取当前用户已加入的群组的tripGroupId
            $.ajax({
                url: '/user-tripplans-tripgroups/user-tripplan-tripgroup/get-user-tripplan-tripgroupbyid',
                type: 'GET',
                data: { userid: userid },
                success: function(joinedGroups) {
                    let joinedGroupIds = [];
                    if (Array.isArray(joinedGroups)) {
                        joinedGroupIds = joinedGroups.map(item => item.tripGroupId);
                    }

                    let container = $('#groupcon .row');
                    let container6 = $('#groupcon');
                    let goBackButton = `
        <div style="text-align: center; width: 100%; margin-top: 20px;">
            <button class="btn btn-secondary go-back-btn">Go back</button>
        </div>
    `;

                    container6.append(goBackButton);
                    $('.go-back-btn').on('click', function() {
                        location.reload();
                    });
                    container.html('');

                    allGroups.forEach(group => {

                        userid1 = parseInt(userid, 10);
                        if (!joinedGroupIds.includes(group.tripGroupId) && group.tripPlanGetDTO.userEntity.userId !== userid1) {
                            console.log(group.tripPlanGetDTO.userEntity.userId)
                            displayGroupCard(group, container);
                        }
                    });
                },
                error: function(error) {
                    console.error("Error fetching user's joined groups:", error);
                }
            });
        },
        error: function(error) {
            console.error("Error fetching all groups:", error);
        }
    });
}

function displayGroupCard(group, container) {
    let groupCard = `
                            <div class="col-lg-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">${group.groupName}</h5>
                                        <p style="font-size: 15px">Created By: ${group.tripPlanGetDTO.userEntity.userName}</p>
                                        <p style="font-size: 15px">Description: ${group.groupDescription}</p>
                                        <p style="font-size: 15px">Number of User: ${group.numberOfTourists}</p>
                                        <p style="font-size: 15px">Capacity Limit: ${group.groupNumberLemit}</p>
                                        <button type="button" class="btn btn-primary join-group" 
                                                data-group-id="${group.tripGroupId}"
                                                data-plan-id="${group.tripPlanGetDTO.tripPlanId}"
                                                data-bs-toggle="modal" data-bs-target="#joinConfirmModal-${group.tripGroupId}">
                                                Join
                                        </button>
                                        <button type="button" class="btn btn-primary show-plan-info" 
                                                data-plan1-id="${group.tripPlanGetDTO.tripPlanId}" >Plan info</button>
                                    </div>
                                </div>
                            </div>`;
    container.append(groupCard);
    let formattedStartDate1 = group.tripPlanGetDTO.startDate.replace("T", "  ").split(".")[0];
    let formattedEndDate1 = group.tripPlanGetDTO.endDate.replace("T", "  ").split(".")[0];
    let modalHTML = `
                            <div class="modal fade" id="planInfoModal-${group.tripPlanGetDTO.tripPlanId}" tabindex="-1">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Plan Info</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <p style="font-weight: bolder">Plan Name: </p>
                                            <p>${group.tripPlanGetDTO.planName}</p>
                                            <p style="font-weight: bolder">Description: </p>
                                            <p>${group.tripPlanGetDTO.planDescription}</p>
                                            <p style="font-weight: bolder">Start Date: </p>
                                            <p>${formattedStartDate1}</p>
                                            <p style="font-weight: bolder">End Date: </p>
                                            <p>${formattedEndDate1}</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>`;
    container.append(modalHTML);

    let joinConfirmModal = `
                            <div class="modal fade" id="joinConfirmModal-${group.tripGroupId}" tabindex="-1">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Confirm</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to join this group?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary confirm-join-group" 
                                                    data-group-id="${group.tripGroupId}"
                                                    data-plan-id="${group.tripPlanGetDTO.tripPlanId}">Confirm</button>
                                        </div>
                                    </div>
                                </div>
                            </div>`;
    container.append(joinConfirmModal);
}

// End of the search function

$(document).on('click', '.show-plan-info', function() {
    let planId = $(this).data('plan1-id');
    let modal = new bootstrap.Modal(document.getElementById(`planInfoModal-${planId}`));
    modal.show();
});


$(document).on('click', '.confirm-join-group', function() {
    let groupId = $(this).data('group-id');
    let planId = $(this).data('plan-id');

    let requestData = {
        "userId": userid,
        "tripPlanId": planId,
        "tripGroupId": groupId
    };

    $.ajax({
        type: "POST",
        url: "/user-tripplans-tripgroups/user-tripplan-tripgroup/add-user-tripplan-tripgroup",
        contentType: "application/json",
        data: JSON.stringify(requestData),
        success: function(response) {
            window.location.reload();

        },
        error: function(error) {
            console.error("Error joining the group:", error);
        }
    });
});