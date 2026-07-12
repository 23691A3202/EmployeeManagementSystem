/* =============================================
   dashboard.js — Stats Cards + Charts
   ============================================= */

var BASE = window.location.href.substring(0, window.location.href.lastIndexOf('/') + 1);

document.addEventListener('DOMContentLoaded', loadDashboard);

function loadDashboard() {
  fetch(BASE + 'stats')
    .then(function(r) { return r.json(); })
    .then(function(data) {
      if (data.error) { showToast('Could not load stats: ' + data.error, 'error'); return; }
      renderStats(data);
      renderDeptChart(data);
      renderSalaryChart(data);
    })
    .catch(function() { showToast('Failed to connect to server', 'error'); });
}

function renderStats(d) {
  setText('stat-total', d.total);
  setText('stat-depts', d.departments);
  setText('stat-max',   formatCurrency(d.maxSalary));
  setText('stat-avg',   formatCurrency(d.avgSalary));
  setText('stat-min',   formatCurrency(d.minSalary));
}

function setText(id, val) {
  var el = document.getElementById(id);
  if (el) el.textContent = val;
}

function renderDeptChart(d) {
  var ctx = document.getElementById('deptChart');
  if (!ctx || !d.deptLabels || !d.deptLabels.length) return;

  var colors = ['#6366f1','#06b6d4','#10b981','#f59e0b','#ef4444','#8b5cf6','#ec4899','#14b8a6'];

  new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: d.deptLabels,
      datasets: [{
        data: d.deptData,
        backgroundColor: colors.slice(0, d.deptLabels.length),
        borderWidth: 0,
        hoverOffset: 8
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: true,
      cutout: '65%',
      plugins: {
        legend: {
          position: 'bottom',
          labels: { padding: 16, font: { family: 'Poppins', size: 12 } }
        }
      }
    }
  });
}

function renderSalaryChart(d) {
  var ctx = document.getElementById('salaryChart');
  if (!ctx) return;

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['< ₹30K', '₹30K–60K', '₹60K–1L', '> ₹1L'],
      datasets: [{
        label: 'Employees',
        data: d.salaryBuckets,
        backgroundColor: ['#6366f1','#06b6d4','#10b981','#f59e0b'],
        borderRadius: 8,
        borderSkipped: false
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: true,
      plugins: { legend: { display: false } },
      scales: {
        x: { grid: { display: false }, ticks: { font: { family: 'Poppins', size: 12 } } },
        y: { beginAtZero: true, ticks: { stepSize: 1, font: { family: 'Poppins', size: 12 } }, grid: { color: 'rgba(0,0,0,.05)' } }
      }
    }
  });
}
