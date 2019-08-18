package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private float score;
    private Date finishDate;

    @OneToMany(mappedBy = "score", fetch = FetchType.EAGER)
    private GamePlayer gamePlayer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    public Score() { }

    public Score(float score, Date finishDate, GamePlayer game, Player player) {
        this.score = score;
        this.finishDate = finishDate;
        this.gamePlayer = game;
        this.player = player;
    }

    public Long getId() { return this.id; }

    public void setScore(float score) { this.score = score; }

    public float getScore() { return this.score; }

    public void setFinishDate(Date finishDate) { this.finishDate = finishDate; }

    public Date getFinishDate() { return this.finishDate; }
}