$(document).ready(function() {
    const userId = sessionStorage.getItem("userId");

    $.ajax({
        url: "/tripplans/tripplan/get-tripplansbyuserid/" + userId,
        method: "GET",
        contentType: "application/json",
        success: function(response) {
            response.forEach(tripPlan => {
                let boxTemplate = `
                <div class="row align-items-top" data-tripPlanId="${tripPlan.tripPlanId}">
                    <div class="col-lg-4">
                <!-- Default Card -->
                    <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${tripPlan.planName}</h5>
                        <button type="button" class="btn btn-outline-secondary rounded-pill btn-sm" data-bs-toggle="modal" data-bs-target="#checklistModal" id="addcl" data-tripPlanId="${tripPlan.tripPlanId}">
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
                        <p style="margin-top: -10px">Start at: ${tripPlan.startDate}</p>
                        <p>End at: ${tripPlan.endDate}</p>
                        <p>Description: ${tripPlan.planDescription}</p>
                        <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#viewact" data-tripPlanId="${tripPlan.tripPlanId}">
                            View My Activity
                        </button>
                        <div class="modal fade" id="viewact" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Activity of This Plan</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Activity Info
                                    </div>
                                    <div class="modal-footer">
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
                                        <button type="button" class="btn btn-primary">Confirm</button>
                                    </div>
                                </div>
                            </div>
                        </div><!-- End Vertically centered Modal-->
                        <button type="button" class="btn btn-outline-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#checklisteditModal" id="editcl" data-tripPlanId="${tripPlan.tripPlanId}">
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
                        </div>
                    </div>
                </div>`;

                $(".containerp").append(boxTemplate);
            });
        },
        error: function() {
            alert("Error fetching trip plans.");
        }
    });
});













if (data.length === 0) {
    let emptySection = `
                        <section class="section">
                            <div class="row align-items-top">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-lg-3 centerbox">
                                            <h1 style="text-align: center; font-weight: bolder; margin-top: 30px; font-size: 5em; color: #51678f">Oops!</h1>
                                            <h1 style="text-align: center; font-weight: normal; margin-top: 30px; font-size: 1.5em;color: #51678f">You don't have any groups, use the create button to create one</h1>
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    `;

    // 将emptySection添加到body或其他合适的元素中
    $("#container1").append(emptySection);
    return;
}

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
                            <td><button type="button" class="btn btn-danger removeItem">Remove</button></td>
                        </tr>
                    `;
tbody.append(row);







<button type="button" class="btn btn-outline-secondary rounded-pill btn-sm editExpenses" data-bs-toggle="modal" data-bs-target="#editex">
    Add Expenses
</button>
<button type="button" class="btn btn-outline-secondary rounded-pill btn-sm" data-bs-toggle="modal" data-bs-target="#viewex" id="viewExpenses">
    View Expenses
</button>