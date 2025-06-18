

  function addSelect(button) {
    const parent = button.previousElementSibling;

    const newSelect = document.createElement("select");
    newSelect.name = "work";
    newSelect.innerHTML = optionsHtml;

    parent.appendChild(newSelect);
  }
