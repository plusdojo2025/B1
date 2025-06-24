// manual.js
function toggleManual(id) {
  const el = document.getElementById(id);
  const isVisible = el.style.display === "block";

  if (isVisible) {
    el.style.display = "none";
    el.classList.remove("active");
  } else {
    el.style.display = "block";
    el.classList.add("active");
  }
}