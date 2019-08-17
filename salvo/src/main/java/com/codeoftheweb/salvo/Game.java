package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Date creationDate;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    List<GamePlayer> gamePlayers;

    public Game() { }

    public Game(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() { return this.id; }

    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Date getCreationDate() { return this.creationDate; }

    public Map<String, Object> getMappedData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", this.id);
        data.put("created", new Timestamp(this.creationDate.getTime()));

        List<Map<String, Object>> players = new ArrayList<Map<String, Object>>();

        Map<String, Object> player;

        for (GamePlayer gamePlayer : this.gamePlayers) {
            player = new HashMap<String, Object>();
            player.put("id", gamePlayer.getId());
            player.put("player", gamePlayer.getPlayerData());
            player.put("ships", gamePlayer.getShipsData());
            player.put("salvoes", gamePlayer.getSalvoesData());

            players.add(player);
        }

        data.put("gamePlayers", players);

        return data;
    }
}