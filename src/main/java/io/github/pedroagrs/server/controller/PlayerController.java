package io.github.pedroagrs.server.controller;

import io.github.pedroagrs.server.model.Player;
import io.github.pedroagrs.server.repository.PlayerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor(
        access = AccessLevel.PRIVATE
)
@RequestMapping("/api/players/")
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping
    List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping
    Player createPlayer(@RequestBody Player data) {
        if (!getPlayers().contains(data))
            return playerRepository.save(data);
        else
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Player already exists.");
    }

    // Singleton

    @GetMapping("{name}")
    Player getPlayer(@PathVariable String name) {
        final Player player = playerRepository.getPlayerByName(name);

        if (player == null) throwsPlayerNotFound();

        return player;
    }

    @DeleteMapping("{name}")
    void deletePlayer(@PathVariable String name) {
        if (playerRepository.deleteByName(name) == 0) throwsPlayerNotFound();
    }

    private void throwsPlayerNotFound() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found.");
    }

}
