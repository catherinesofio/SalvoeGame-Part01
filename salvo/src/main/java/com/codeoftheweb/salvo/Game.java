package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private Date creationDate;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    List<GamePlayer> gamePlayers;

    public Game() { }

    public Game(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() { return this.id; }

    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Date getCreationDate() { return this.creationDate; }
}