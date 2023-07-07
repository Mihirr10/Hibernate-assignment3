package com.hibernate.assignment3.repository;

import com.hibernate.assignment3.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface PlayerRepository extends JpaRepository<Player, Integer> {

  Player findByPlayerName(String playerName);

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  <S extends Player> S save(S entity);

}
