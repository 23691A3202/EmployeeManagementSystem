/* =============================================
   search.js — Live Employee Search
   ============================================= */

var BASE = window.location.href.substring(0, window.location.href.lastIndexOf('/') + 1);

document.addEventListener('DOMContentLoaded', function() {
  var input = document.getElementById('liveSearch');
  if (!input) return;
  input.addEventListener('input', debounce(performSearch, 350));
});

function performSearch() {
  var query = document.getElementById('liveSearch').value.trim();
  var resultsEl = document.getElementById('searchResults');
  if (!resultsEl) return;

  if (!query) { resultsEl.innerHTML = ''; return; }

  resultsEl.innerHTML = '<div class="spinner"></div>';

  fetch(BASE + 'searchEmployee?query=' + encodeURIComponent(query))
    .then(function(r) { return r.json(); })
    .then(function(data) { renderSearchResults(data, resultsEl); })
    .catch(function() {
      resultsEl.innerHTML = '<p style="color:var(--danger);text-align:center;padding:20px">Search failed — check server</p>';
    });
}

function renderSearchResults(employees, container) {
  if (!employees.length) {
    container.innerHTML = '<div class="empty-state"><i class="fa-solid fa-user-slash"></i><p>No employees found</p></div>';
    return;
  }

  container.innerHTML = employees.map(function(emp) {
    return '<div class="result-card">' +
      '<div class="result-header">' +
        '<div class="result-avatar">' + emp.name.charAt(0).toUpperCase() + '</div>' +
        '<div><div class="result-name">' + emp.name + '</div>' +
        '<div class="result-id">ID: #' + emp.id + '</div></div>' +
      '</div>' +
      '<div class="result-grid">' +
        '<div class="result-item"><label>Department</label><span>' + emp.department + '</span></div>' +
        '<div class="result-item"><label>Salary</label><span style="color:var(--success)">' + formatCurrency(emp.salary) + '</span></div>' +
      '</div></div>';
  }).join('');
}
