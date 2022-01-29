package io.github.pedroagrs.server.cache;

import io.github.pedroagrs.server.model.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PlayerLocalCache {

    private final Map<String, Player> cache = new HashMap<>();

    public Collection<Player> getPlayers() {
        return cache.values();
    }

}
