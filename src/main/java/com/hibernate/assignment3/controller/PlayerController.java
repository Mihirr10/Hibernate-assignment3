package com.hibernate.assignment3.controller;

import com.hibernate.assignment3.entities.Player;
import com.hibernate.assignment3.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

  @Autowired
  PlayerService playerService;

//  @GetMapping
//  public List<PlayerDto> getPlayerWithTeam() {
//    return playerService.getPlayerWithTeam();
//  }

  @GetMapping("/{id}")
  public ResponseEntity<Player> getPlayerWithId(@PathVariable int id) {
    Player playerWithId = playerService.getPlayerWithId(id);
    return new ResponseEntity<>(playerWithId, HttpStatus.FOUND);
  }

//  @GetMapping("/{playerName}")
//  public ResponseEntity<Player> getPlayerWithName(@PathVariable String playerName){
//    Player playerByPlayerName = playerService.getPlayerByPlayerName(playerName);
//    return new ResponseEntity<>(playerByPlayerName,HttpStatus.FOUND);
//  }


  @GetMapping
  public ResponseEntity<List<Player>> getAllPlayers() {
    List<Player> players = playerService.getAllPlayers();
    return new ResponseEntity<>(players, HttpStatus.FOUND);
  }

  @PostMapping
  public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
    Player player1 = playerService.createPlayer(player);
    return new ResponseEntity<>(player1, HttpStatus.CREATED);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Player> updatePlayer(@RequestBody Player player, @PathVariable int id) {
    Player updatePlayer = playerService.updatePlayer(player, id);
    return new ResponseEntity<>(updatePlayer, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePlayer(@PathVariable int id) {
    playerService.deletePlayer(id);
    return ResponseEntity.status(HttpStatus.OK).body("player deleted successfully");
  }
}
