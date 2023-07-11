package com.hibernate.assignment3.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Data
@AllArgsConstructor
@NoArgsConstructor

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "player")
@Entity
@Table(name = "player")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int playerId;
  private String playerName;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "team_id")
  @JsonIgnore
  private Team team;
}
