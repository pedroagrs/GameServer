package io.github.pedroagrs.server.boostrap;

import io.github.pedroagrs.server.model.ServerInfo;
import lombok.Getter;

public class ServerBoostrap {

    @Getter
    private final ServerInfo info;

    public ServerBoostrap() {
        this.info = new ServerInfo("Rarley", "jogar.rarley.com");

        enable();
    }

    public void enable() {

    }
}
