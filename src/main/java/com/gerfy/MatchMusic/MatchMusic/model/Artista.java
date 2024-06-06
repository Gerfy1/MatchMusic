package com.gerfy.MatchMusic.MatchMusic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomeArtista;
    @Enumerated(EnumType.STRING)
    private TipoDoArtista tipoDoArtista;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Artista() {}
    public Artista(String nome, TipoDoArtista tipo) {
        this.nomeArtista = nome;
        this.tipoDoArtista = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeArtista() {

        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public TipoDoArtista getTipoDoArtista() {
        return tipoDoArtista;
    }

    public void setTipoDoArtista(TipoDoArtista tipoDoArtista) {
        this.tipoDoArtista = tipoDoArtista;
    }
    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    @Override
    public String toString() {
        return
                "Artista: " + nomeArtista + "| " +
                "Tipo: " + tipoDoArtista + "| " +
                "Musicas: " + musicas + "| ";
    }
}
