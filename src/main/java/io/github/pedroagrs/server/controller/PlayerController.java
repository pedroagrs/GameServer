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
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping("/get")
    List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    void createPlayer(@RequestBody Player player) {
        playerRepository.save(player);
    }

    @DeleteMapping("/delete/{name}")
    void deletePlayer(@PathVariable String name) {
        if (playerRepository.deleteByName(name) == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found!");
    }

}
