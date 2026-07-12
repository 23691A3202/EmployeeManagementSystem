/* Legacy script.js — kept for backward compatibility.
   All new functionality is in /js/app.js, dashboard.js, search.js, theme.js */

function toggleMode() {
    document.body.classList.toggle("dark");
    localStorage.setItem("theme", document.body.classList.contains("dark"));
}

window.onload = function () {
    if (localStorage.getItem("theme") === "true") {
        document.body.classList.add("dark");
    }
};
