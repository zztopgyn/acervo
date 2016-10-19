package lab.artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

  @Autowired
  private ArtistaRepository artistaRepository;

  public Artista registrarArtista(Artista artista) {
    return artistaRepository.save(artista);
  }

  public Artista obterArtista(Integer codigo) {
    return artistaRepository.findOne(codigo);
  }

  public Iterable<Artista> obterTodos() {
    return artistaRepository.findAll();
  }
}
