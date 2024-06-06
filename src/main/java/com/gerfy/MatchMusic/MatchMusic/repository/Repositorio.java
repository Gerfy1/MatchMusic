package com.gerfy.MatchMusic.MatchMusic.repository;

import com.gerfy.MatchMusic.MatchMusic.model.Artista;
import com.gerfy.MatchMusic.MatchMusic.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Repositorio extends JpaRepository<Artista, Long> {
 Optional<Artista> findByNomeArtistaContainingIgnoreCase(String nome);

 @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nomeArtista ILIKE %:nome%")
 List<Musica> buscarMusicaPorArtista(String nome);

}
