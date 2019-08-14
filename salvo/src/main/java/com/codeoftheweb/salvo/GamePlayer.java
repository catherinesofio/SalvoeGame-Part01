package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    private List<Ship> ships;

    public GamePlayer() { }

    public GamePlayer(Date createdDate, Player player, Game game) {
        this.createdDate = createdDate;
        this.player = player;
        this.game = game;
    }

    public Long getId() { return this.id; }

    public Player getPlayer() { return this.player; }

    public Object getPlayerData() { return this.player.getMappedData(); }

    public Game getGame() { return this.game; }

    public List<Ship> getShips() { return this.ships; }

    public Map<String, Object> getMappedData() {
        Map<String, Object> data = this.game.getMappedData();

        List<Map<String, Object>> ships = new ArrayList<Map<String, Object>>();

        for (Ship ship : this.ships) {
            ships.add(ship.getMappedData());
        }

        data.put("ships", ships);

        return data;
    }
}