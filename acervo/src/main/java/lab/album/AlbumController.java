package lab.album;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumController {
  
  @Autowired
  private AlbumService albumService;
  
  @RequestMapping(value = "/consultar", method = GET)
  public Album consultar(@RequestParam Integer codigo) {
    return albumService.obterAlbum(codigo);
  }

  @RequestMapping("/listar")
  public Iterable<Album> listar() {
    return albumService.obterTodos();
  }

  @RequestMapping(value = "/novo", method = POST)
  public Album novo(@RequestBody Album album) {
    return albumService.registrarAlbum(album);
  }
}