package io.github.pedroagrs.server.boostrap;

import io.github.pedroagrs.server.model.ServerInfo;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("Server Bootstrap")
@Getter
public class ServerBootstrap {

    private final ServerInfo info;

    private final Logger logger = Logger.getLogger("Server -> ");

    public ServerBootstrap() {
        this.info = new ServerInfo("Rarley", "jogar.rarley.com");

        enable();
    }

    public void enable() {
        logger.info("Server starting...");
    }
}
