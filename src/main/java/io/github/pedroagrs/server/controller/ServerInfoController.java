package io.github.pedroagrs.server.controller;

import io.github.pedroagrs.server.boostrap.ServerBootstrap;
import io.github.pedroagrs.server.model.ServerInfo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/api/server")
public class ServerInfoController {

    private final ServerBootstrap serverBootstrap;

    @GetMapping
    public ServerInfo getInfo() {
        return serverBootstrap.getInfo();
    }

}
