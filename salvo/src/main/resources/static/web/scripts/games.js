$(document).ready(function () {
    $.ajax("/api/games").done((data) => loadGameList(data));
});

function loadGameList(data) {
    let tbody = $("#gameContainer")[0];

    for (var i = 0; i < data.length; i++) {
        let tr = document.createElement("tr");

        let game = document.createElement("td")
        game.innerHTML = data[i].id;
        tr.appendChild(game);

        let player1 = document.createElement("td")
        player1.innerHTML = data[i].gamePlayers[0].player.email;
        tr.appendChild(player1);

        let player2 = document.createElement("td")
        player2.innerHTML = (data[i].gamePlayers.length > 1) ? data[i].gamePlayers[1].player.email : "N/A";
        tr.appendChild(player2);

        tbody.appendChild(tr);
    }
}