document.addEventListener("DOMContentLoaded", function() {
    let currentEditingTable;

    document.querySelector(".editChecklist").addEventListener("click", function() {
        currentEditingTable = this.closest(".card-body").querySelector("table tbody");
        let editTable = document.getElementById("editTable").querySelector("tbody");
        editTable.innerHTML = "";

        currentEditingTable.querySelectorAll("tr").forEach(row => {
            let newRow = editTable.insertRow();
            newRow.innerHTML = `
                <th scope="row">${row.children[0].textContent}</th>
                <td><input type="text" class="form-control" value="${row.children[1].textContent}"></td>
                <td><input type="text" class="form-control" value="${row.children[2].textContent}"></td>
                <td><input type="text" class="form-control" value="${row.children[3].textContent.replace('$','')}"></td>
                <td><button type="button" class="btn btn-danger btn-sm removeRow">Remove</button></td>
            `;

            newRow.querySelector(".removeRow").addEventListener("click", function() {
                this.closest("tr").remove();
            });
        });
    });

    document.getElementById("addRow").addEventListener("click", function() {
        let editTable = document.getElementById("editTable").querySelector("tbody");
        let newRow = editTable.insertRow();
        newRow.innerHTML = `
            <th scope="row">${editTable.children.length}</th>
            <td><input type="text" class="form-control"></td>
            <td><input type="text" class="form-control"></td>
            <td><input type="text" class="form-control" placeholder="$"></td>
            <td><button type="button" class="btn btn-danger btn-sm removeRow">Remove</button></td>
        `;

        newRow.querySelector(".removeRow").addEventListener("click", function() {
            this.closest("tr").remove();
        });
    });

    document.getElementById("saveEdit").addEventListener("click", function() {
        currentEditingTable.innerHTML = "";

        let editTable = document.getElementById("editTable").querySelector("tbody");
        let totalExpenses = 0;

        editTable.querySelectorAll("tr").forEach(row => {
            let newRow = currentEditingTable.insertRow();
            let priceValue = row.children[3].querySelector("input").value;

            newRow.innerHTML = `
                <th scope="row">${row.children[0].textContent}</th>
                <td>${row.children[1].querySelector("input").value}</td>
                <td>${row.children[2].querySelector("input").value}</td>
                <td>$${priceValue}</td>
            `;

            totalExpenses += parseFloat(priceValue);
        });

        document.getElementById("totalExpenses").innerText = "Total Expenses: $" + totalExpenses.toFixed(2);
    });
});
