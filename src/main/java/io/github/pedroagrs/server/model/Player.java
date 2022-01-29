package io.github.pedroagrs.server.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Player {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private final Long id;

    @Setter(AccessLevel.NONE)
    @Column(nullable = false, unique = true, updatable = false, length = 16, columnDefinition = "get the player name")
    private final String name;

}
