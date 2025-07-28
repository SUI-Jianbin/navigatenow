
const userid = sessionStorage.getItem("userId");
let topbar_username = sessionStorage.getItem("userName")
let bar_firstname = sessionStorage.getItem("firstName")
let bar_lastname = sessionStorage.getItem("lastName")
//Get created groups
let selectedPlanId;
////123
$('#topbar_username').text(topbar_username);
$('#bar_firstname').text(bar_firstname);
$('#bar_lastname').text(bar_lastname);

$(document).ready(function() {

    $.ajax({
        url: `/tripplans/tripplan/get-tripplansbyuserid/` + userid,
        method: 'GET',
        success: function(tripplans) {
            console.log(tripplans);
            // 遍历所有的tripPlanId
            for(let i = 0; i < tripplans.length; i++) {
                const tripPlanId = tripplans[i].tripPlanId;

                $.ajax({
                    url: `/tripgroups/tripgroup/get-tripgroupbytripplanid/` + tripPlanId,
                    method: 'GET',
                    success: function(data) {
                        if (!data.tripGroupId) {
                            console.warn('Incomplete group data for tripPlanId:', tripPlanId);
                            return;
                        }
                        let createdAt1 = data.createdAt.replace("T", "  ").split(".")[0];
                        let box = `
                            <div class="col-lg-4" data-group-id="${data.tripGroupId}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${data.groupName}</h5>
                                <button type="button" class="btn btn-outline-secondary rounded-pill btn-sm" style="margin-top: -20px; margin-bottom: 5px" data-bs-toggle="modal" data-bs-target="#editGroupModal-${data.tripGroupId}">
                                Edit Group
                                </button>
                                <p>Created at: ${createdAt1}</p>
                                <p>Number of Tourists: ${data.numberOfTourists}</p>
                                <p>Capacity Limit: ${data.groupNumberLemit}</p>
                                <p>Description: ${data.groupDescription}</p>
                                <button type="button" class="btn btn-primary" id="planinfo-${tripPlanId}" data-group-id="${tripPlanId}">Plan info</button>
                                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#removemg-${data.tripGroupId}">
                                    Remove
                                </button>
                                <div class="modal fade" id="removemg-${data.tripGroupId}" tabindex="-1">
                                    <div class="modal-dialog modal-dialog-centered">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Confirm</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Are you sure you want to remove?</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary" id="removec1-${data.tripGroupId}" data-group-id="${data.tripGroupId}">Confirm</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                            </div>
                            <div class="modal fade" id="editGroupModal-${data.tripGroupId}" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Edit Group</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form id="editGroupForm-${data.tripGroupId}">
                                            <div class="mb-3">
                                                <label>Group Name:</label>
                                                <input type="text" class="form-control" name="groupName" required>
                                            </div>
                                            <div class="mb-3">
                                                <label>Group Description:</label>
                                                <input type="text" class="form-control" name="groupDescription" required>
                                            </div>
                                           
                                            <div class="mb-3">
                                                <label>Capacity Number:</label>
                                                <input type="number" class="form-control" name="groupNumberLemit" min="1" max="20" placeholder="Input should be less than 20" required>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary edit-group-confirm" data-group-id="${data.tripGroupId}">Edit</button>
                                    </div>
                                </div>
                            </div>
                     </div>`;

                        $('#container1').append(box);
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.error('Error fetching group information:', textStatus, errorThrown);
                    }
                });
            }
            $('body').on('click', "button[id^='removec1-']", function() {
                const userGroupId = $(this).data('group-id');

                // 调用API来删除数据
                $.ajax({
                    url: "/tripgroups/tripgroup/delete-tripgroupbyid/" + userGroupId,
                    type: "DELETE",
                    success: function() {
                        $(`div[data-group-id='${userGroupId}']`).remove();
                        location.reload();
                    },
                    error: function(error) {
                        console.error("Error deleting group: ", error);
                    }
                });
            });

            $('body').on('click', ".edit-group-confirm", function() {
                const tripGroupId = $(this).data('group-id');
                const formData = $(`#editGroupForm-${tripGroupId}`).serializeArray();
                let updateData = {
                    tripGroupId: tripGroupId
                };
                formData.forEach(item => {
                    updateData[item.name] = item.value;
                });

                // 调用API更新群组信息
                $.ajax({
                    url: "/tripgroups/tripgroup/update-tripgroup",
                    type: "PUT",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(updateData),
                    success: function(response) {
                        location.reload(); // 刷新页面
                    },
                    error: function(error) {
                        console.error("Error updating group:", error);
                    }
                });
            });

            $('body').on('click', "button[id^='planinfo-']", function() {
                const planId = $(this).data('group-id');

                // 调用API来获取Plan Info
                $.ajax({
                    url: "/tripplans/tripplan/get-tripplanbyid/" + planId,
                    type: "GET",
                    dataType: "json",
                    success: function(planData) {
                        let formattedStartDate2 = planData.startDate.replace("T", "  ").split(".")[0];
                        let formattedEndDate2 = planData.endDate.replace("T", "  ").split(".")[0];

                        // 使用另一个API获取旅游景点的信息
                        $.ajax({
                            url: "/touristyplaces-tripplans/touristyplaces-tripplan/get-touristyplaces-tripplanbytripplanid/" + planId,
                            type: "GET",
                            dataType: "json",
                            success: function(placesDataArray) {
                                let placesContent = `
                                                            <hr>
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

                                const modalContent = `
                    <div class="modal fade" id="planInfoModal-${planId}" tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Plan Info</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p style="font-weight: bolder">Name: </p>
                                    <p>${planData.planName}</p>
                                    <p style="font-weight: bolder">Description: </p>
                                    <p>${planData.planDescription}</p>
                                    <p style="font-weight: bolder">Start Date: </p>
                                    <p>${formattedStartDate2}</p>
                                    <p style="font-weight: bolder">End Date: </p>
                                    <p>${formattedEndDate2}</p>
                                    ${placesContent}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>`;

                                $('body').append(modalContent);
                                $(`#planInfoModal-${planId}`).modal('show');
                            },
                            error: function(error) {
                                console.error("Error fetching places info: ", error);
                            }
                        });
                    },
                    error: function(error) {
                        console.error("Error fetching plan info: ", error);
                    }
                });



            });

        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error('Error fetching trip plans:', textStatus, errorThrown);
        }
    });
});
$.ajax({
    url: '/user-tripplans-tripgroups/user-tripplan-tripgroup/get-user-tripplan-tripgroupbyid',
    type: 'GET',
    data: { userid: userid },
    success: function(data) {
        if(data.length ===0){
            return;
        }
        let createdmessage1 = `
                 <h4 style="font-weight: bolder">Groups you joined:</h4>
                `;
        $('#container').append(createdmessage1);
        let container = $('#container'); // 假设你有一个ID为'container'的元素用于容纳这些盒子，你可能需要调整这个选择器

        for (let item of data) {
            let tripGroupData = item.tripGroupGetDTOS;
            let tripPlanData = item.tripPlanGetDTOS;
            let planId = tripPlanData.tripPlanId;
            let userTripGroupId = item.user_TripPlan_TripGroupId;
            let groupName = tripGroupData.groupName;
            let groupDescription = tripGroupData.groupDescription;
            let numberOfTourists = tripGroupData.numberOfTourists || "Not available";
            let groupNumberLimit = tripGroupData.groupNumberLemit;
            let createdAt = tripGroupData.createdAt.replace("T", "  ").split(".")[0];
            let box = `
                    <div class="col-lg-4" data-group-id="${userTripGroupId}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${groupName}</h5>
                                <p>Created at: ${createdAt}</p>
                                <p>Number of Tourists: ${numberOfTourists}</p>
                                <p>Capacity Limit: ${groupNumberLimit}</p>
                                <p>Description: ${groupDescription}</p>
                                <button type="button" class="btn btn-primary" id="planinfo-${planId}" data-group-id="${planId}">Plan info</button>
                                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#removemg-${userTripGroupId}">
                                    Leave
                                </button>
                                <div class="modal fade" id="removemg-${userTripGroupId}" tabindex="-1">
                                    <div class="modal-dialog modal-dialog-centered">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Confirm</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Are you sure you want to leave?</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary" id="removec-${userTripGroupId}" data-group-id="${userTripGroupId}">Confirm</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>`;

            container.append(box);
        }

        $("button[id^='removec-']").click(function() {
            const userTripGroupId = $(this).data('group-id');

            // 调用API来删除数据
            $.ajax({
                url: "/user-tripplans-tripgroups/user-tripplan-tripgroup/leaveJoinedGroup/" + userTripGroupId,
                type: "DELETE",
                success: function() {
                    $(`div[data-group-id='${userTripGroupId}']`).remove();
                    location.reload();
                },
                error: function(error) {
                    console.error("Error deleting group: ", error);
                }
            });
        });
        $("button[id^='planinfo-']").click(function() {
            const planId = $(this).data('group-id');

            $.ajax({
                url: "/tripplans/tripplan/get-tripplanbyid/" + planId,
                type: "GET",
                dataType: "json",
                success: function(planData) {
                    let formattedStartDate1 = planData.startDate.replace("T", "  ").split(".")[0];
                    let formattedEndDate1 = planData.endDate.replace("T", "  ").split(".")[0];

                    // 内嵌的$.ajax调用来获取Places信息
                    $.ajax({
                        url: "/touristyplaces-tripplans/touristyplaces-tripplan/get-touristyplaces-tripplanbytripplanid/" + planId,
                        type: "GET",
                        dataType: "json",
                        success: function(placesDataArray) {
                            let placesContent = `
                                                        <hr>
                                                        <h3>Chosen Activities</h3>`;

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

                            const modalContent = `
                    <div class="modal fade" id="planInfoModal-${planId}" tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Plan Info</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p style="font-weight: bolder">Plan Name: </p>
                                    <p>${planData.planName}</p>
                                    <p style="font-weight: bolder">Description: </p>
                                    <p>${planData.planDescription}</p>
                                    <p style="font-weight: bolder">Start Date: </p>
                                    <p>${formattedStartDate1}</p>
                                    <p style="font-weight: bolder">End Date: </p>
                                    <p>${formattedEndDate1}</p>
                                    ${placesContent}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>`;

                            $('body').append(modalContent);
                            $(`#planInfoModal-${planId}`).modal('show');
                        },
                        error: function(error) {
                            console.error("Error fetching places info: ", error);
                        }
                    });
                },
                error: function(error) {
                    console.error("Error fetching plan info: ", error);
                }
            });

        });
    },
    error: function(error) {
        console.error("Error fetching data: ", error);
    }
});


$(document).on('click', '[data-bs-target="#createg"]', function() {
    $.ajax({
        url: "/tripplans/tripplan/get-tripplansbyuserid/" + userid,
        type: "GET",
        success: function(data) {
            $('#plansContainer').empty();

            for (let item of data) {
                let planId = item.tripPlanId;
                let planName = item.planName;
                $('#plansContainer').append('<button class="btn btn-outline-primary plan-btn" data-plan-id="' + planId + '">' + planName + '</button>');
            }
        },
        error: function(error) {
            console.error("Error fetching user plans:", error);
        }
    });
});


$(document).on('click', '.plan-btn', function() {
    $('.plan-btn').removeClass('active');
    $(this).addClass('active');
    selectedPlanId = $(this).data('plan-id');
});


$(document).on('click', '#createg .btn-primary', function() {
    let groupName = $('#groupName').val();
    let capacityLimit = $('#limit').val();
    let description = $('#des').val();


    $.ajax({
        type: "GET",
        url: "/tripgroups/tripgroup/get-tripgroupbytripplanid/" + selectedPlanId,
        success: function(data) {

            if (!data || data.length === 0) {
                //ajax创建群组
                $.ajax({
                    type: "POST",
                    url: "/tripgroups/tripgroup/add-tripgroup",
                    contentType: "application/json",
                    data: JSON.stringify({
                        groupName: groupName,
                        groupDescription: description,
                        groupNumberLemit: capacityLimit,
                        tripplan_id: selectedPlanId
                    }),
                    success: function(data) {
                        console.log(data);
                        let container1 = $('#container1');

                        let groupCard = `
                        <div class="col-lg-6" >
                            <div class="card">

                            </div>
                        </div>`;
                        container1.append(groupCard);
                        location.reload();
                    },
                    error: function(error) {
                        console.error("Error creating group:", error);
                    }
                });
            } else {

                alert("You have already created a group based on this plan. Please choose another plan.");
            }
        },
        error: function(error) {
            console.error("Error checking group existence:", error);
        }
    });
});


