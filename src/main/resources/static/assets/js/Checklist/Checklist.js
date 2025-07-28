let checklistCount = 1; // 初始化Checklist计数
let currentEditingTable; // 当前正在编辑的表格

function setupModalCloseListeners() {
    const modalElement = document.getElementById("edit");
    const modal = bootstrap.Modal.getInstance(modalElement) || new bootstrap.Modal(modalElement);

    document.querySelector(".modal-footer .btn-secondary").onclick = () => modal.hide();
    document.querySelector(".modal-header .btn-close").onclick = () => modal.hide();
}

function setupRemoveListener(button) {
    button.addEventListener("click", function() {
        this.closest(".col-lg-7").remove();
        checklistCount--;
    });
}

function setupEditListener(button) {
    button.addEventListener("click", function() {
        currentEditingTable = this.closest(".card-body").querySelector("table tbody");
        let editTable = document.getElementById("editTable").querySelector("tbody");
        editTable.innerHTML = "";

        currentEditingTable.querySelectorAll("tr").forEach(row => {
            let newRow = editTable.insertRow();
            newRow.innerHTML = `
                <th scope="row">${row.children[0].textContent}</th>
                <td><input type="text" class="form-control" value="${row.children[1].textContent}"></td>
                <td><input type="text" class="form-control" value="${row.children[2].textContent}"></td>
                <td>
                    <select class="form-select">
                        <option value="Not Important" ${row.children[3].textContent === "Not Important" ? "selected" : ""}>Not Important</option>
                        <option value="Medium" ${row.children[3].textContent === "Medium" ? "selected" : ""}>Medium</option>
                        <option value="Important" ${row.children[3].textContent === "Important" ? "selected" : ""}>Important</option>
                    </select>
                </td>
                <td><button type="button" class="btn btn-danger btn-sm removeRow">Remove</button></td>
            `;
            newRow.querySelector(".removeRow").addEventListener("click", function() {
                this.closest("tr").remove();
            });
        });
    });
}

document.getElementById("addChecklist").addEventListener("click", function() {
    checklistCount++;

    const newChecklist = document.createElement("div");
    newChecklist.classList.add("col-lg-7");
    newChecklist.innerHTML = `
        <!-- 新生成的Checklist -->
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Checklist ${checklistCount} for Plan x</h5>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Item Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Importance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Edit Needed</td>
                            <td>Edit Needed</td>
                            <td>Edit Needed</td>
                        </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-primary editChecklist" data-bs-toggle="modal" data-bs-target="#edit">Edit</button>
                <button type="button" class="btn btn-danger removeChecklist">Remove</button>
            </div>
        </div>
    `;

    document.getElementById("checklistContainer").appendChild(newChecklist);
    setupEditListener(newChecklist.querySelector(".editChecklist"));
    setupRemoveListener(newChecklist.querySelector(".removeChecklist"));
});

document.getElementById("addRow").addEventListener("click", function() {
    let editTable = document.getElementById("editTable").querySelector("tbody");
    let newRow = editTable.insertRow();
    newRow.innerHTML = `
        <th scope="row">${editTable.children.length}</th>
        <td><input type="text" class="form-control"></td>
        <td><input type="text" class="form-control"></td>
        <td>
            <select class="form-select">
                <option value="Not Important">Not Important</option>
                <option value="Medium">Medium</option>
                <option value="Important">Important</option>
            </select>
        </td>
        <td><button type="button" class="btn btn-danger btn-sm removeRow">Remove</button></td>
    `;

    newRow.querySelector(".removeRow").addEventListener("click", function() {
        this.closest("tr").remove();
    });
});

document.getElementById("saveEdit").addEventListener("click", function() {
    let editTable = document.getElementById("editTable").querySelector("tbody");
    currentEditingTable.innerHTML = "";

    editTable.querySelectorAll("tr").forEach(row => {
        let newRow = currentEditingTable.insertRow();
        newRow.innerHTML = `
            <th scope="row">${row.children[0].textContent}</th>
            <td>${row.children[1].querySelector("input").value}</td>
            <td>${row.children[2].querySelector("input").value}</td>
            <td>${row.children[3].querySelector("select").value}</td>
        `;
    });

    let modalElement = document.getElementById("edit");
    let modal = bootstrap.Modal.getInstance(modalElement);
    modal.hide();
});

// 设置初始的Edit和Remove按钮监听器
document.querySelectorAll(".editChecklist").forEach(setupEditListener);
document.querySelectorAll(".removeChecklist").forEach(setupRemoveListener);
setupModalCloseListeners();