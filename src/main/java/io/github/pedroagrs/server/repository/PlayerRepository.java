package io.github.pedroagrs.server.repository;

import io.github.pedroagrs.server.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Transactional
    Long deleteByName(String name);

    Player getPlayerByName(String name);

}
