/* =============================================
   theme.js — Dark Mode Toggle
   ============================================= */

(function initTheme() {
  if (localStorage.getItem('theme') === 'dark') {
    document.body.classList.add('dark');
  }
})();

function toggleTheme() {
  document.body.classList.toggle('dark');
  const isDark = document.body.classList.contains('dark');
  localStorage.setItem('theme', isDark ? 'dark' : 'light');

  const icon = document.getElementById('theme-icon');
  if (icon) {
    icon.className = isDark ? 'fa-solid fa-sun' : 'fa-solid fa-moon';
  }

  const label = document.getElementById('theme-label');
  if (label) label.textContent = isDark ? 'Light Mode' : 'Dark Mode';
}

// Sync icon on page load
document.addEventListener('DOMContentLoaded', () => {
  const isDark = document.body.classList.contains('dark');
  const icon  = document.getElementById('theme-icon');
  const label = document.getElementById('theme-label');
  if (icon)  icon.className = isDark ? 'fa-solid fa-sun' : 'fa-solid fa-moon';
  if (label) label.textContent = isDark ? 'Light Mode' : 'Dark Mode';
});
