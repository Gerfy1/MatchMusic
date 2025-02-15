# MatchMusic
MatchMusic é uma aplicação relacionado a criar playlist e salvar musicas, armazenar dados de nossos artistas e músicas preferidos em um banco de dados relacional.

## Tecnologias e Práticas Utilizadas
- **Postgree**
- **Maven**
- **POO**
- **DTO**
- **JQPL**

## Exemplo de Código

```
@Entity
@Table(name ="musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    @ManyToOne
    private Artista artista;

    public Musica() {}
    public Musica(String nomeDaMusica) {
        this.titulo=nomeDaMusica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica: " + "| "+
                "Titulo: " + titulo + "| " +
                "Artista: " + artista.getNomeArtista() + "| " ;
    }
}
```
