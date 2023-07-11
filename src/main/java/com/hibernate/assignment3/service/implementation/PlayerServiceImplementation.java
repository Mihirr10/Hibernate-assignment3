package com.hibernate.assignment3.service.implementation;

import com.hibernate.assignment3.dto.PlayerDto;
import com.hibernate.assignment3.entities.Player;
import com.hibernate.assignment3.exception.PlayerNotFound;
import com.hibernate.assignment3.repository.PlayerRepository;
import com.hibernate.assignment3.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImplementation implements PlayerService {

  @Autowired
  PlayerRepository playerRepository;

  public PlayerServiceImplementation(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

//  @Override
//  public Player getPlayerByPlayerName(String playerName) {
//    return playerRepository.findByPlayerName(playerName);
//  }
//
//
//  public List<PlayerDto> getPlayerWithTeam() {
//    return playerRepository.findAll().stream().map(p -> new PlayerDto(p.getPlayerName(), p.getTeam().getTeamName())).collect(Collectors.toList());
//  }




  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED)
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED)
  public Player getPlayerWithId(int id) {

    Optional<Player> player = playerRepository.findById(id);

    if (player.isPresent()) {
      return player.get();
    } else {
      throw new PlayerNotFound("Player not found");
    }
  }

  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED)
  public Player createPlayer(Player player) {

    if (player != null) {
      return playerRepository.save(player);
    } else {
      throw new PlayerNotFound("failed to create the player");
    }
  }

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public Player updatePlayer(Player player, int id) {
    Player player1 = playerRepository.findById(id).orElse(null);


    if (player1 == null) {
      throw new PlayerNotFound("failed to update student");
    } else {
      player.setPlayerId(id);
    }
    return playerRepository.save(player);
  }

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void deletePlayer(int id) {
    Optional<Player> player2 = playerRepository.findById(id);

    if (player2.isPresent()) {
      playerRepository.delete(player2.get());
    } else {
      throw new PlayerNotFound("failed to delete student !! please enter valid id");
    }
  }


}
