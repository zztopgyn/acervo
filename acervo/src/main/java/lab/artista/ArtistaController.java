package lab.artista;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
  
  @Autowired
  private ArtistaService artistaService;
  
  @RequestMapping(value = "/consultar", method = GET)
  public Artista consultar(@RequestParam Integer codigo) {
    return artistaService.obterArtista(codigo);
  }

  @RequestMapping("/listar")
  public Iterable<Artista> listar() {
    return artistaService.obterTodos();
  }

  @RequestMapping(value = "/novo", method = POST)
  public Artista novo(@RequestBody Artista artista) {
    return artistaService.registrarArtista(artista);
  }
}