$("#addItemBtn").on("click", function() {
    let rowNumber = $('#checklistTable tbody tr').length + 1;
    let rowHtml = `
        <tr>
            <td>${rowNumber}</td>
            <td><input type="text" class="form-control" name="itemName[]"></td>
            <td><input type="text" class="form-control" name="itemDescription[]"></td>
            <td>
                <select class="form-control" name="itemImportance[]">
                    <option value="Not Important">Not Important</option>
                    <option value="Medium">Medium</option>
                    <option value="Important">Important</option>
                </select>
            </td>
            <td><button type="button" class="btn btn-danger removeItem">Remove</button></td>
        </tr>`;
    $("#checklistTable tbody").append(rowHtml);
});

$(document).on("click", ".removeItem", function() {
    $(this).closest("tr").remove();
    $('#checklistTable tbody tr').each(function (index, element) {
        $(element).find('td:first').text(index + 1);
    });
});

$("#createEditBtn").on("click", function() {
    let itemNames = $("input[name='itemName[]']").map(function(){return $(this).val();}).get().join(';');
    let itemDescriptions = $("input[name='itemDescription[]']").map(function(){return $(this).val();}).get().join(';');
    let itemImportances = $("select[name='itemImportance[]']").map(function(){return $(this).val();}).get().join(';');

    let dataToSend = {
        tripPlanId: 1,
        itemName: itemNames,
        itemDescription: itemDescriptions,
        itemImportance: itemImportances
    };
    $.ajax({
        url: '/checklists/checklist/add-checklist',
        type: 'POST',
        data: JSON.stringify(dataToSend),  // 转化为JSON格式
        contentType: 'application/json',
        success: function(response) {
            // Handle the success response (maybe close the modal or show a success message)
        },
        error: function(error) {
            // Handle the error (show an error message or any other UI interaction)
        }
    });
});
$(document).ready(function() {

    $('#editcl').on('click', function() {

        $.ajax({
            url: '/checklists/checklist/get-checklistbyid/74',
            type: 'GET',
            success: function(data) {
                // 分析获取到的数据，并填充到#checklisteditTable表格中
                let names = data.itemName.split(';');
                let descriptions = data.itemDescription.split(';');
                let importances = data.itemImportance.split(';');

                let tbody = $('#checklisteditTable tbody');
                tbody.empty(); // 清空之前的数据

                for (let i = 0; i < names.length; i++) {
                    let row = `
                        <tr>
                            <td>${i + 1}</td>
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
                }
            }
        });
    });
});
$(document).ready(function() {
    $('#addItemBtned').on('click', function() {
        let tbody = $('#checklisteditTable tbody');
        let rowNumber = tbody.children().length + 1;

        let newRow = `
            <tr>
                <td>${rowNumber}</td>
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

    $('#createEditBtned').on('click', function() {
        let names = [];
        let descriptions = [];
        let importances = [];

        $('#checklisteditTable .itemName').each(function() {
            names.push($(this).val());
        });

        $('#checklisteditTable .itemDescription').each(function() {
            descriptions.push($(this).val());
        });

        $('#checklisteditTable .itemImportance').each(function() {
            importances.push($(this).val());
        });

        let dataToSend = {
            tripPlanId: 1, // 这里假设tripPlanId为1
            itemName: names.join(';'),
            itemDescription: descriptions.join(';'),
            itemImportance: importances.join(';')
        };

        $.ajax({
            url: '/checklists/checklist/update-checklist',
            type: 'POST',
            data: JSON.stringify(dataToSend),  // 转化为JSON格式
            contentType: 'application/json',
            success: function(response) {
                alert("Checklist updated successfully!");
            }
        });
    });
});

function updateRowNumbers(tableId) {
    $(tableId + ' tbody tr').each(function(index) {
        $(this).children('td:first').text(index + 1);
    });
}
