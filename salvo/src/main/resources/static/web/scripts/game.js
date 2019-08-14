$(document).ready(function() {
    let param = getParamObj(window.location.search);
    $.ajax("/api/game_view/"+param.gp).done((data) => loadGrid(data, param.gp));
});

function getParamObj(search) {
  var obj = {};
  var reg = /(?:[?&]([^?&#=]+)(?:=([^&#]*))?)(?:#.*)?/g;

  search.replace(reg, function(match, param, val) {
    obj[decodeURIComponent(param)] = val === undefined ? "" : decodeURIComponent(val);
  });

  return obj;
}

function loadGrid(data, id) {
    let count = 10;
    let cols = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
    let cells = data.ships.map(x => x.locations).flat();
    let player = (data.gamePlayers[0].id == id) ? data.gamePlayers[0].player.email : data.gamePlayers[1].player.email;
    let enemy = (data.gamePlayers[0].id != id) ? data.gamePlayers[0].player.email : data.gamePlayers[1].player.email;

    let table = $("#grid")[0];

    let caption = document.createElement("caption");
    caption.innerHTML = player.split("@")[0] + " vs " + enemy.split("@")[0];
    table.appendChild(caption);

    let thead = document.createElement("thead");
    table.appendChild(thead);

    let tbody = document.createElement("tbody");
    table.appendChild(tbody);

    let th = document.createElement("th");
    th.setAttribute("scope", "col");
    thead.appendChild(th);

    for (let i = 0; i < count; i++) {
        th = document.createElement("th");
        th.setAttribute("scope", "col");
        th.innerHTML = cols[i];
        thead.appendChild(th);

        let tr = document.createElement("tr");
        tbody.appendChild(tr);

        th = document.createElement("th");
        th.setAttribute("scope", "row");
        th.innerHTML = rows[i];
        tr.appendChild(th);

        let empty = true;
        for (let j = 0; j < count; j++) {
            empty = (!cells.includes(rows[i] + cols[j]));

            let td = document.createElement("td");
            td.setAttribute("empty", empty);
            tr.appendChild(td);
        }
    }
}