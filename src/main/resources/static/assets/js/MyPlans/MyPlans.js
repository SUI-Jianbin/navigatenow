const userid = sessionStorage.getItem("userId");
let topbar_username = sessionStorage.getItem("userName")
let bar_firstname = sessionStorage.getItem("firstName")
let bar_lastname = sessionStorage.getItem("lastName")

$('#topbar_username').text(topbar_username);
$('#bar_firstname').text(bar_firstname);
$('#bar_lastname').text(bar_lastname);

$(document).ready(function() {
    $.ajax({
        url: "/tripplans/tripplan/get-tripplansbyuserid/" + userid,
        type: "GET",
        success: function(data) {
            // 检查是否有返回数据
            if (data.length === 0) {
                let emptySection = `
                        <section class="section">
                            <div class="row align-items-top">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-lg-3 centerbox">
                                            <h1 style="text-align: center; font-weight: bolder; margin-top: 30px; font-size: 5em; color: #51678f">Oops!</h1>
                                            <h1 style="text-align: center; font-weight: normal; margin-top: 30px; font-size: 1.5em;color: #51678f">Seems like you haven't create any plans, create one now!</h1>
                                            <a href="../NewPlans/NewPlans.html">
                                                <button type="button" class="btn btn-outline-secondary btn-lg rounded-pill btn-custom" style="
                                                    display: block;
                                                    margin: 20px auto;  /* 上下间距为 20px, 水平方向自动居中 */
                                                    padding: 20px 40px;
                                                    font-size: 1.5em;
                                                    color: #51678f;
                                                ">Create New Plans</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    `;


                $("#appendShow").append(emptySection);
            }
        },
        error: function(error) {
            console.log("Error fetching data:", error);
        }
    });
});
$(document).ready(function() {
    let currentTripPlanId;

    $.ajax({
        url: "/tripplans/tripplan/get-tripplansbyuserid/" + userid,
        method: "GET",
        contentType: "application/json",
        success: function(response) {
            response.forEach(tripPlan => {
                let formattedStartDate = tripPlan.startDate.replace("T", "  ").split(".")[0];
                let formattedEndDate = tripPlan.endDate.replace("T", "  ").split(".")[0];
                console.log("Current tripPlanId:", tripPlan.tripPlanId);
                console.log(response);
                let boxTemplate = `
                    <div class="col-lg-4" data-tripPlanId="${tripPlan.tripPlanId}">
                <!-- Default Card -->
                    <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${tripPlan.planName}</h5>
                        <button type="button" class="btn btn-outline-secondary rounded-pill btn-sm" data-bs-toggle="modal" data-bs-target="#checklistModal" id="addcl" style="margin-top: -15px; margin-bottom: 15px" >
                            Add Checklist
                        </button>
                        <div class="modal fade" id="checklistModal" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="checklistModalTitle">Add Checklist</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table" id="checklistTable">
                                            <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Description</th>
                                                <th scope="col">Importance</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <!-- Rows will be added dynamically -->
                                            </tbody>
                                        </table>
                                        <button type="button" class="btn btn-primary" id="addItemBtn">Add Item</button>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary" id="createEditBtn">Create</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="btn btn-outline-secondary rounded-pill btn-sm editcl" data-bs-toggle="modal" data-bs-target="#checklisteditModal" style="margin-top: -15px; margin-bottom: 15px">
                            Edit Checklist
                        </button>
                        <div class="modal fade" id="checklisteditModal" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="checklisteditTitle">Edit Checklist</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <table class="table" id="checklisteditTable">
                                            <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Description</th>
                                                <th scope="col">Importance</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <!-- Rows will be added dynamically -->
                                            </tbody>
                                        </table>
                                        <button type="button" class="btn btn-primary" id="addItemBtned">Add Item</button>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary" id="createEditBtned">Edit</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p>Start at: ${formattedStartDate}</p>
                        <p>End at: ${formattedEndDate}</p>
                        <p style="margin-bottom: 30px">Description: ${tripPlan.planDescription}</p>
                        <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#viewact">
                            View Activity
                        </button>
                        <div class="modal fade" id="viewact" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Activity of This Plan</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body" id="acContainer">
                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- End Vertically centered Modal-->
                        <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editplan">
                            Edit
                        </button>
                        <div class="modal fade" id="editplan" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Edit Plan</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <label style="margin-top: 15px;margin-bottom: 10px; font-weight: bolder">Plan Name:</label>
                                        <input type="text" class="form-control" name="planName" required>
                                        <label style="margin-top: 15px;margin-bottom: 10px; font-weight: bolder;">Plan Description:</label>
                                        <input type="text" class="form-control" name="planDescription" required>
                                        <label style="margin-top: 15px;margin-bottom: 10px; font-weight: bolder;">Start At:</label>
                                        <input type="date" class="form-control" name="startDate" required>
                                        <label style="margin-top: 15px;margin-bottom: 10px; font-weight: bolder;">End At:</label>
                                        <input type="date" class="form-control" name="endDate" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" id="btnEditPlan" data-bs-dismiss="modal" data-tripPlanId="${tripPlan.tripPlanId}">Edit</button>
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- End Vertically centered Modal-->
                        <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#remove">
                            Remove
                        </button>
                        <div class="modal fade" id="remove" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Confirm</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure you want to remove?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary confirmre" data-tripPlanId="${tripPlan.tripPlanId}">Confirm</button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- End Vertically centered Modal-->
                        
                        </div>
                       
                    </div>
                </div>`;

                $("#containerp").append(boxTemplate);
            });

            $(document).on("click", "#addcl", function() {
                let associatedDiv = $(this).closest('[data-tripPlanId]');
                currentTripPlanId = associatedDiv.data('tripplanid');
                $.ajax({
                    url: '/checklists/checklist/checkif-userhas-checklist-bytripplanid/' + currentTripPlanId,
                    type: 'GET',
                    dataType: 'json',
                    success: function(data) {
                        if(data === true) {
                            alert("You have already added a checklist on this plan, try edit the checklist");
                            location.reload();
                        }

                    },
                    error: function(error) {
                        console.error("Error occurred:", error);
                    }
                });
            });

//123

            $(document).on("click", ".confirmre", function() {
                let tripPlanId = $(this).attr("data-tripPlanId");


                console.log(tripPlanId);

                if (!tripPlanId) {
                    alert("Trip plan ID is missing. Cannot delete.");
                    return;
                }

                $.ajax({
                    url: "/tripplans/tripplan/delete-tripplanbyid/" + tripPlanId,
                    method: "DELETE",
                    success: function(response) {
                        location.reload();
                    },
                    error: function() {
                        alert("Error deleting trip plan.");
                    }
                });
            });
            $(document).on('click', '#btnEditPlan', function() {
                let tripPlanId = $(this).attr("data-tripPlanId");

                const planName = $('input[name="planName"]').val();
                const planDescription = $('input[name="planDescription"]').val();
                const startDate = $('input[name="startDate"]').val();
                const endDate = $('input[name="endDate"]').val();

                const updateData = {
                    tripPlanId: tripPlanId,
                    planName: planName,
                    planDescription: planDescription,
                    startDate: startDate,
                    endDate: endDate
                };

                $.ajax({
                    url: '/tripplans/tripplan/update-tripplan',
                    method: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(updateData),
                    success: function() {
                        console.log(updateData);
                        location.reload(); // 刷新页面
                    },
                    error: function() {
                        alert('Error updating trip plan.');
                    }
                });
            });

            //Add Checklist functions
            $(document).on("click", "#addItemBtn", function() {
                let allRows = $('#checklistTable tbody tr');
                console.log("All rows:", allRows);
                let rowNumber = allRows.length + 1;
                console.log("Row number:", rowNumber);
                let rowHtml = `
                        <tr>
                            <td>*</td>
                            <td><input type="text" class="form-control" name="itemName[]" required placeholder="Required"></td>
                            <td><input type="text" class="form-control" name="itemDescription[]" required placeholder="Required"></td>
                            <td>
                                <select class="form-control" name="itemImportance[]">
                                    <option value="Not Important">Not Important</option>
                                    <option value="Medium">Medium</option>
                                    <option value="Important">Important</option>
                                </select>
                            </td>
                            <td><button type="button" class="btn btn-danger removeItem" style="margin-top: 1px">Remove</button></td>
                     </tr>`;
                $("#checklistTable tbody").append(rowHtml);
            });

            $(document).on("click", ".removeItem", function() {
                $(this).closest("tr").remove();
                $('#checklistTable tbody tr').each(function (index, element) {
                    $(element).find('td:first').text(index + 1);
                });
            });

            $(document).on("click", "#createEditBtn", function() {
                console.log(currentTripPlanId);
                let itemNames = $("input[name='itemName[]']")
                    .map(function() { return $(this).val().trim(); })
                    .get()
                    .filter(item => item)
                    .join(';');

                let itemDescriptions = $("input[name='itemDescription[]']")
                    .map(function() { return $(this).val().trim(); })
                    .get()
                    .filter(item => item)
                    .join(';');

                let numOfValidDescriptions = itemDescriptions.split(';').length;

                let itemImportances = $("select[name='itemImportance[]']")
                    .map(function() { return $(this).val().trim(); })
                    .get()
                    .slice(0, numOfValidDescriptions)
                    .join(';');

                let dataToSend = {
                    itemName: itemNames,
                    itemDescription: itemDescriptions,
                    itemImportance: itemImportances,
                    tripplan_id: currentTripPlanId
                };
                $.ajax({
                    url: '/checklists/checklist/add-checklist',
                    type: 'POST',
                    data: JSON.stringify(dataToSend),
                    contentType: 'application/json',
                    success: function(response) {
                        location.reload();
                    },
                    error: function(error) {
                        // Handle the error (show an error message or any other UI interaction)
                    }
                });
            });



            function updateRowNumbers(tableId) {
                $(tableId + ' tbody tr').each(function(index) {
                    $(this).children('td:first').text(index + 1);
                });
            }

        },
        error: function() {
            alert("Error fetching trip plans.");
        }
    });
});


//Expenses Calculator

let touristyPlacesId;
$(document).ready(function() {


    $(document).on('click', '[data-bs-target="#viewact"]', function() {
        let associatedDiv = $(this).closest('[data-tripPlanId]');
        let currentTripPlanId = associatedDiv.data('tripplanid');


        $.ajax({
            url: '/touristyplaces-tripplans/touristyplaces-tripplan/get-touristyplaces-tripplanbytripplanid/' + currentTripPlanId,
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                let contentHtml = '';


                data.forEach(place => {
                    contentHtml += `
                        <p style="font-weight: bolder">${place.placeName}</p>
                        <p>Location: ${place.placeLocation}</p>
                        <p>Open Days: ${place.placeOpeningDays}</p>
                        <p>Opening Times: ${place.placeOpeningTimes}</p>
                        <p>Closing Time: ${place.placeClosingTime}</p>
                        <p>Rate: ${place.placeRate}</p>
                        <button type="button" class="btn btn-outline-secondary rounded-pill btn-sm editExpenses" data-touristyplaces-id="${place.touristyPlacesId}" data-bs-toggle="modal" data-bs-target="#editex" style="margin-bottom: 15px">
                             Add Expenses
                        </button>
                        <button type="button" class="btn btn-outline-secondary rounded-pill btn-sm" data-touristyplaces-id="${place.touristyPlacesId}" data-bs-toggle="modal" data-bs-target="#viewex" id="viewExpenses" style="margin-bottom: 15px">
                             View Expenses
                        </button><br>`;
                });


                $('#acContainer').html(contentHtml);
            },
            error: function(error) {
                console.error("Error occurred:", error);
            }
        });
    });

});
let currentTouristyPlacesId;
let currentTouristyPlacesId1;
$(document).ready(function() {

    // 当点击 "Add Expenses" 按钮时
    $(document).on('click', '.editExpenses', function()  {
        currentTouristyPlacesId = $(this).data('touristyplaces-id');
        // 先移除旧的模态框（如果存在）
        $('#viewact').remove();
        $.ajax({
            type: 'GET',
            url: '/expencescalculators/expencescalculator/checkif-touristyplacehas-expences-bytouristyplaceid/' + currentTouristyPlacesId,
            contentType: 'application/json',
            dataType: 'json',
            success: function(response) {
                if (response) {  // 如果API返回true
                    alert("You have already added an expenses, try edit one.");
                    location.reload();  // 刷新页面
                }
                // 如果API返回false, 进行其他操作或者不做任何事情
            },
            error: function(error) {
                alert('Failed to check data!');
            }
        });

        // 创建新的模态框
        let modalHtml = `
                                <div class="modal fade" id="editex" tabindex="-1">
                                        <div class="modal-dialog modal-dialog-centered modal-lg">
                                          <div class="modal-content">
                                            <div class="modal-header">
                                              <h5 class="modal-title">
                                                <i class="ri-edit-2-line" style="font-size: 1.1em; vertical-align: middle;"></i>
                                                Add Expenses
                                              </h5>
                                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
 
                                              <table class="table table-hover" id="editTable">
                                                <thead>
                                                <tr>
                                                  <th scope="col">#</th>
                                                  <th scope="col">Item Name</th>
                                                  <th scope="col">Description</th>
                                                  <th scope="col">Priority</th>
                                                  <th scope="col">Type</th>
                                                  <th scope="col">Price</th>
                                                  <th scope="col">Actions</th> 
                                                </tr>
                                                </thead>
                                                <tbody>

                                                </tbody>
                                              </table>
                                              <button type="button" class="btn btn-secondary" id="addRow">Add Item</button>
                                              <p id="totalExpenses">Total Expenses: $0.00</p>
                                            </div>
                                            <div class="modal-footer">
                                              <button type="button" class="btn btn-secondary addclose" data-bs-dismiss="modal">Close</button>
                                              <button type="button" class="btn btn-primary" id="saveEdit" style="margin-top: 4px">Create</button> 
                                            </div>
                                          </div>
                                        </div>
                                        </div>`;


        $('body').append(modalHtml);


        $('#editex').modal('show');
        $(document).on('click', '#saveEdit', function() {
            let names = [];
            let descriptions = [];
            let priorities = [];
            let prices = [];
            let types = [];


            $("#editTable tbody tr").each(function() {
                let name = $(this).find(".nameInputClass").val();
                let description = $(this).find(".descriptionInputClass").val();
                let priority = $(this).find(".priorityInputClass").val();
                let price = $(this).find(".priceInputClass").val();
                let type = $(this).find(".typeInputClass").val();

                names.push(name);
                descriptions.push(description);
                priorities.push(priority);
                prices.push(price);
                types.push(type);
            });


            let expensesData = {
                "name": names.join(';'),
                "description": descriptions.join(';'),
                "periority": priorities.join(';'),
                "price": prices.join(';'),
                "totalCost": $('#totalExpenses').text().split('$')[1].trim(), // 这里仍然是一个单独的值
                "type": types.join(';'),
                "touristyplaces_id": currentTouristyPlacesId
            };

            $.ajax({
                url: '/expencescalculators/expencescalculator/add-expencescalculator',
                type: 'POST',
                data: JSON.stringify(expensesData), // 将对象转化为JSON字符串
                contentType: "application/json",
                dataType: "json",
                success: function(response) {
                    location.reload();
                },
                error: function(error) {
                    console.error("Error occurred:", error);
                }
            });
        });

        $(".addclose").click(function() {
            location.reload();
        });
    });

    $(document).on('input', '#viewTable tbody tr td input[type="number"]', function() {
        updateTotalExpenses();
    });

    $(document).on('click', '#addRow', function() {
        let newRow = `
    <tr>
        <td></td> <!-- # will be recalculated after -->
        <td><input type="text" class="form-control nameInputClass1" placeholder="Item Name"></td>
    <td><input type="text" class="form-control descriptionInputClass1" placeholder="Description"></td>
    <td>
        <select class="form-control priorityInputClass1">
            <option value="First">First</option>
            <option value="Second">Second</option>
            <option value="Third">Third</option>
        </select>
    </td>
    <td>
        <select class="form-control typeInputClass1">
            <option value="Daily Necessity">Daily Necessity</option>
            <option value="Food and Drink">Food and Drink</option>
            <option value="Special Item">Special Item</option>
        </select>
    </td>
    <td><input type="number" class="form-control priceInputClass1 price-input" placeholder="Price" pattern="^[0-9]*$"></td>
        <td><button class="btn btn-danger removeRowAction">Remove</button></td>
    </tr>`;
        $("#viewTable tbody").append(newRow);
        updateRowNumbers();
        updateTotalExpenses();
    });

    $(document).on('input', '#viewTable tbody tr td:last input', function() {
        updateTotalExpenses();
    });

    function updateRowNumbers() {
        $("#viewTable tbody tr").each(function(index) {
            $(this).find("td:first").text(index + 1);
        });
    }

    function updateTotalExpenses() {
        let total = 0;
        $("#viewTable tbody tr").each(function() {
            let price = parseFloat($(this).find('td:eq(5) input').val()) || 0;
            total += price;
        });
        $("#totalExpenses").text("Total Expenses: $" + total.toFixed(2));
    }





    $(document).on('click', '#viewExpenses', function()  {
        currentTouristyPlacesId1 = $(this).data('touristyplaces-id');
        // 先移除旧的模态框（如果存在）
        $('#viewact').remove();


        let modalHtml = `
                                <div class="modal fade" id="viewex" tabindex="-1">
                                          <div class="modal-dialog modal-dialog-centered modal-lg">
                                            <div class="modal-content">
                                              <div class="modal-header">
                                                <h5 class="modal-title">Edit Expenses</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                              </div>
                                              <div class="modal-body">
                                                <table class="table table-hover" id="viewTable">
                                                  <thead>
                                                  <tr>
                                                    <th scope="col">#</th>
                                                    <th scope="col">Item Name</th>
                                                    <th scope="col">Description</th>
                                                    <th scope="col">Priority</th>
                                                    <th scope="col">Type</th>
                                                    <th scope="col">Price</th>
                                                    <th scope="col">Actions</th> 
                                                  </tr>
                                                  </thead>
                                                  <tbody>
                                                 
                                                  </tbody>
                                                </table>
                                                <button type="button" class="btn btn-secondary" id="addRow">Add Item</button>
                                              
                                              </div>
                                              <div class="modal-footer">
                                                <button type="button" class="btn btn-primary viewremove" data-bs-dismiss="modal" style="margin-top: 5px">Remove</button>
                                                <button type="button" class="btn btn-secondary viewclose" data-bs-dismiss="modal">Close</button>
                                              </div>
                                            </div>
                                         </div>
                                        </div>`;


        $('body').append(modalHtml);

        $('#viewex').modal('show');

        $(".viewclose").click(function() {
            location.reload();
        });
    });

});

let currentExpensesCalculatorId;

$(document).ready(function(){
    $(document).on('input', '.price-input', function() {
        calculateTotal();
    });

    $(document).on('click', '#addRow', function() {
        let row = `
                     <tr>
                             <td></td>
                             <td><input type="text" class="form-control nameInputClass" placeholder="Item Name"></td>
                             <td><input type="text" class="form-control descriptionInputClass" placeholder="Description"></td>
                             <td>
                                   <select class="form-control priorityInputClass">
                                      <option value="First">First</option>
                                        <option value="Second">Second</option>
                                       <option value="Third">Third</option>
                                      </select>
                                </td>
                             <td>
                            <select class="form-control typeInputClass">
                             <option value="Daily Necessity">Daily Necessity</option>
                             <option value="Food and Drink">Food and Drink</option>
                              <option value="Special Item">Special Item</option>
                             </select>
                        </td>
                         <td><input type="number" class="form-control priceInputClass price-input" placeholder="Price" pattern="^[0-9]*$"></td>
                     <td><button class="btn btn-danger btn-sm removeRow">Remove</button></td>
                        </tr>`;
        $("#editTable tbody").append(row);
        updateRowNumbers();
        calculateTotal();
    });

    $(document).on('click', '.removeRow', function() {
        $(this).closest('tr').remove();
        updateRowNumbers();
    });

    function updateRowNumbers() {
        $("#editTable tbody tr").each(function(index) {
            $(this).find("td:first").text(index + 1);
        });
    }

    function calculateTotal() {
        let total = 0;
        $("#editTable tbody tr").each(function() {
            total += parseFloat($(this).find("td:eq(5) input").val()) || 0;
        });
        $('#totalExpenses').text(`Total Expenses: $${total.toFixed(2)}`);
    }



    $(document).on('click', '.remove', function()  {
        $(this).closest('tr').remove();
        updateRowNumbers();
    });


    $("#saveEdit").click(function() {
        savedData = [];
        let names = [];
        let descriptions = [];
        let priorities = [];
        let types = [];
        let prices = [];

        $("#editTable tbody tr").each(function() {
            names.push($(this).find("td:eq(1) input").val());
            descriptions.push($(this).find("td:eq(2) input").val());
            priorities.push($(this).find("td:eq(3) select").val());
            types.push($(this).find("td:eq(4) select").val());
            prices.push($(this).find("td:eq(5) input").val());
        });

        let data = {
            name: names.join(';'),
            description: descriptions.join(';'),
            periority: priorities.join(';'),
            type: types.join(';'),
            price: prices.join(';'),
            totalCost: parseFloat($('#totalExpenses').text().split('$')[1]),
            touristyPlacesId: 1
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/expencescalculators/expencescalculator/add-expencescalculator',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(response) {
                alert('Data added successfully!');
            },
            error: function(error) {
                alert('Failed to add data!');
            }
        });
    });


    $("#editTable")
        .on('click', '.remove', function() {
            $(this).closest('tr').remove();
            updateRowNumbers();
        })
        .on('input', 'input[placeholder="Price"]', function() {
            calculateTotal();
        });
});
$(document).on('click', '#viewExpenses', function() {
    currentTouristyPlacesId1 = $(this).data('touristyplaces-id');
    $.ajax({
        type: 'GET',
        url: '/expencescalculators/expencescalculator/get-expencescalculatorbytouristyplacesid/' + currentTouristyPlacesId1,
        contentType: 'application/json',
        dataType: 'json',
        success: function(response) {
            console.log(currentTouristyPlacesId1);
            console.log(response[0].expencesCalculatorId);
            currentExpensesCalculatorId = response[0].expencesCalculatorId;
            populateViewTable(response);
        },
        error: function(error) {
            alert('You do not have any expenses on this place!');
            location.reload();
        }
    });
});
$(document).on('click', '.removeRowAction', function() {
    $(this).closest('tr').remove();
    updateRowNumbers();
    updateTotalExpenses();
});
function populateViewTable(data) {
    let names = data[0].name.split(';');
    let descriptions = data[0].description.split(';');
    let priorities = data[0].periority.split(';');
    let types = data[0].type.split(';');
    let prices = data[0].price.split(';');

    $("#viewTable tbody").empty();

    for (let i = 0; i < names.length; i++) {
        let row = `
        <tr>
            <td>${i + 1}</td>
            <td><input type="text" class="form-control nameInputClass1" placeholder="Item Name" value="${names[i]}"></td>
            <td><input type="text" class="form-control descriptionInputClass1" placeholder="Description" value="${descriptions[i]}"></td>
            <td>
                <select class="form-control priorityInputClass1">
                    <option value="First" ${priorities[i] === "First" ? "selected" : ""}>First</option>
                    <option value="Second" ${priorities[i] === "Second" ? "selected" : ""}>Second</option>
                    <option value="Third" ${priorities[i] === "Third" ? "selected" : ""}>Third</option>
                </select>
            </td>
            <td>
                <select class="form-control typeInputClass1">
                    <option value="Daily Necessity" ${types[i] === "Daily Necessity" ? "selected" : ""}>Daily Necessity</option>
                    <option value="Food and Drink" ${types[i] === "Food and Drink" ? "selected" : ""}>Food and Drink</option>
                    <option value="Special Item" ${types[i] === "Special Item" ? "selected" : ""}>Special Item</option>
                </select>
            </td>
            <td><input type="number" class="form-control priceInputClass1 price-input" placeholder="Price" pattern="^[0-9]*$" value="${prices[i]}"></td>
            <td><button class="btn btn-danger removeRowAction">Remove</button></td>
        </tr>`;
        $("#viewTable tbody").append(row);
    }
    let totalExpensesElement = `<p id="totalExpenses">Total Expenses: ${data[0].totalCost}</p>`;
    $("#viewTable").after(totalExpensesElement);
}
$(document).on('click', '.viewremove', function() {

    $.ajax({
        type: 'DELETE',
        url: '/expencescalculators/expencescalculator/delete-expencescalculatorbyid/' + currentExpensesCalculatorId, // 构建完整的 API URL
        success: function(response) {
            alert('Expenses successfully deleted!');
            location.reload();
        },
        error: function(error) {
            alert('Failed to delete expenses!');
        }
    });
});




let currentChecklistId;
let currentTripPlanId1;
//Edit checklist
$(document).ready(function() {
    $('body').on('click', '.editcl', function()  {
        let associatedDiv = $(this).closest('[data-tripPlanId]');
        currentTripPlanId1 = associatedDiv.data('tripplanid');
        console.log(currentTripPlanId1);
        $.ajax({
            url: '/checklists/checklist/get-checklistbytripplanid/' + currentTripPlanId1,
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                currentChecklistId = data[0].checklistId;
                let names = data[0].itemName.split(';');
                let descriptions = data[0].itemDescription.split(';');
                let importances = data[0].itemImportance.split(';');
                console.log(currentChecklistId);

                let tbody = $('#checklisteditTable tbody');
                tbody.empty();

                for (let i = 0; i < names.length; i++) {
                    let row = `
            <tr>
                <td>*</td>
                <td><input type="text" value="${names[i]}" class="form-control itemName"></td>
                <td><input type="text" value="${descriptions[i]}" class="form-control itemDescription"></td>
                <td>
                    <select class="form-control itemImportance">
                        <option value="Not Important" ${importances[i] === "Not Important" ? "selected" : ""}>Not Important</option>
                        <option value="Medium" ${importances[i] === "Medium" ? "selected" : ""}>Medium</option>
                        <option value="Important" ${importances[i] === "Important" ? "selected" : ""}>Important</option>
                    </select>
                </td>
                <td><button type="button" class="btn btn-danger removeItem" style="margin-top: 1px">Remove</button></td>
            </tr>
        `;

                    tbody.append(row);
                }

            }
        });
    });
});
$(document).ready(function() {
    $(document).on('click', '#addItemBtned', function() {
        let tbody = $('#checklisteditTable tbody');

        let newRow = `
            <tr>
                <td>*</td>
                <td><input type="text" class="form-control itemName"></td>
                <td><input type="text" class="form-control itemDescription"></td>
                <td>
                    <select class="form-control itemImportance">
                        <option value="Not Important">Not Important</option>
                        <option value="Medium">Medium</option>
                        <option value="Important">Important</option>
                    </select>
                </td>
                <td><button type="button" class="btn btn-danger removeItem">Remove</button></td>
            </tr>
        `;

        tbody.append(newRow);
    });

    $('#checklisteditTable').on('click', '.removeItem', function() {
        $(this).closest('tr').remove();
        updateRowNumbers('#checklisteditTable');
    });

    $(document).on('click', '#createEditBtned', function()  {
        let itemNames = $('#checklisteditTable .itemName')
            .map(function() { return $(this).val().trim(); })
            .get()
            .filter(item => item)
            .filter((item, index, self) => self.indexOf(item) === index)
            .join(';');

        let itemDescriptions = $('#checklisteditTable .itemDescription')
            .map(function() { return $(this).val().trim(); })
            .get()
            .filter(item => item)
            .join(';');

        let numOfValidDescriptions = itemDescriptions.split(';').length;


        let itemImportances = $('#checklisteditTable .itemImportance')
            .map(function() { return $(this).val().trim(); })
            .get()
            .slice(0, numOfValidDescriptions)
            .join(';');

        let dataToSend = {
            checklistId: currentChecklistId,
            itemName: itemNames,
            itemDescription: itemDescriptions,
            itemImportance: itemImportances,
            tripplan_id: currentTripPlanId1
        };

        $.ajax({
            url: '/checklists/checklist/update-checklist',
            type: 'PUT',
            data: JSON.stringify(dataToSend),
            contentType: 'application/json',
            success: function(response) {
                location.reload();
            }
        });
    });
});