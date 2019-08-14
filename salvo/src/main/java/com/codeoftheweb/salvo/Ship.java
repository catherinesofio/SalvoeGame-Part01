package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String type;

    @ElementCollection
    @Column(name = "location")
    private List<String> locations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ship_id")
    private GamePlayer gamePlayer;

    public Ship() { }

    public Ship(String type, List<String> locations, GamePlayer gamePlayer) {
        this.type = type;
        this.locations = locations;
        this.gamePlayer = gamePlayer;
    }

    public Long getId() { return this.id; }

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    public List<String> getLocations() { return this.locations; }

    public void setLocations(List<String> locations) { this.locations = locations; }

    public GamePlayer getGamePlayer() { return this.gamePlayer; }

    public Map<String, Object> getMappedData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("type", this.type);
        data.put("locations", this.locations);

        return data;
    }
}