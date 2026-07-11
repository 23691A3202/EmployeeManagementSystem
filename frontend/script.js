// ADD EMPLOYEE

const form = document.getElementById("employeeForm");

if (form) {

    form.addEventListener("submit", function(e) {

        e.preventDefault();

        const id = document.getElementById("id").value;
        const name = document.getElementById("name").value;
        const department = document.getElementById("department").value;
        const salary = document.getElementById("salary").value;

        let employees =
            JSON.parse(localStorage.getItem("employees")) || [];

        employees.push({
            id,
            name,
            department,
            salary
        });

        localStorage.setItem(
            "employees",
            JSON.stringify(employees)
        );

        alert("Employee Added Successfully!");

        form.reset();
    });
}


// VIEW EMPLOYEES

const tableBody =
    document.querySelector("#employeeTable tbody");

if (tableBody) {

    let employees =
        JSON.parse(localStorage.getItem("employees")) || [];

    employees.forEach(emp => {

        let row = `
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
        </tr>
        `;

        tableBody.innerHTML += row;
    });
}


// SEARCH EMPLOYEE

function searchEmployee() {

    let id =
        document.getElementById("searchId").value;

    let employees =
        JSON.parse(localStorage.getItem("employees")) || [];

    let emp =
        employees.find(e => e.id === id);

    let result =
        document.getElementById("searchResult");

    if(emp){

        result.innerHTML =
        `
        <h3>Employee Found</h3>
        <p>ID: ${emp.id}</p>
        <p>Name: ${emp.name}</p>
        <p>Department: ${emp.department}</p>
        <p>Salary: ${emp.salary}</p>
        `;

    }else{

        result.innerHTML =
        "<p>Employee Not Found</p>";
    }
}


// UPDATE EMPLOYEE

function updateEmployee() {

    let id =
        document.getElementById("updateId").value;

    let newSalary =
        document.getElementById("newSalary").value;

    let employees =
        JSON.parse(localStorage.getItem("employees")) || [];

    let emp =
        employees.find(e => e.id === id);

    if(emp){

        emp.salary = newSalary;

        localStorage.setItem(
            "employees",
            JSON.stringify(employees)
        );

        alert("Salary Updated!");

    }else{

        alert("Employee Not Found!");
    }
}


// DELETE EMPLOYEE

function deleteEmployee() {

    let id = document.getElementById("deleteId").value.trim();
    let dept = document.getElementById("deleteDept").value.trim();

    if (!id && !dept) {
        alert("Please enter Employee ID or Department!");
        return;
    }

    let employees = JSON.parse(localStorage.getItem("employees")) || [];
    let before = employees.length;

    if (id) {
        employees = employees.filter(e => e.id !== id);
    } else {
        employees = employees.filter(e => e.department.toLowerCase() !== dept.toLowerCase());
    }

    if (employees.length < before) {
        localStorage.setItem("employees", JSON.stringify(employees));
        alert("Employee(s) Deleted Successfully!");
    } else {
        alert("No Employee Found!");
    }
}