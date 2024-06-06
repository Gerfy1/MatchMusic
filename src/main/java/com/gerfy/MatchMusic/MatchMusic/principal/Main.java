package com.gerfy.MatchMusic.MatchMusic.principal;

import com.gerfy.MatchMusic.MatchMusic.model.Artista;
import com.gerfy.MatchMusic.MatchMusic.model.Musica;
import com.gerfy.MatchMusic.MatchMusic.model.TipoDoArtista;
import com.gerfy.MatchMusic.MatchMusic.repository.Repositorio;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Scanner leitura = new Scanner(System.in);
    private final Repositorio repositorio;

    public Main(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
    public void exibirMenu(){
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    Escolha dentre as opções a seguir:
                    
                    1 - Cadastrar artista
                    2 - Cadastrar música
                    3 - Listar músicas
                    4 - Pesquisar música por artista
                    
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Buscar músicas de qual artista?: ");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscarMusicaPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a-> a.getMusicas().forEach(System.out::println));
    }
    private void cadastrarMusica() {
        System.out.println("Qual nome do artista?");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeArtistaContainingIgnoreCase(nomeArtista);
        if (artista.isPresent()) {
            System.out.println("Qual é o título da música?: ");
            var musica = leitura.nextLine();
            Musica musicaAdd = new Musica(musica);
            musicaAdd.setArtista(artista.get());
            artista.get().getMusicas().add(musicaAdd);
            repositorio.save(artista.get());
        } else {
            System.out.println("Não encontrado!");
        }
    }

    private void cadastrarArtista() {
        var cadastrarUmNovoArtista = "S";

        while (cadastrarUmNovoArtista.equalsIgnoreCase("S")) {
            System.out.println("Qual é o nome do artista?: ");
            var nomeDoArtista = leitura.nextLine();
            System.out.println("Qual é o tipo desse artista: (solo, dupla ou banda)?: ");
            var tipoArt = leitura.nextLine();
            TipoDoArtista tipoArtista = TipoDoArtista.valueOf(tipoArt.toUpperCase());
            Artista artista = new Artista(nomeDoArtista, tipoArtista);
            repositorio.save(artista);
            System.out.println("Deseja cadastrar um novo artista?: (S/N)");
            cadastrarUmNovoArtista = leitura.nextLine();
        }
    }

}
