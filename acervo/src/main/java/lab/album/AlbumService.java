package lab.album;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

  /**
   * Quantidade máxima de albums em estoque.
   */
  public static final int QTDE_MAX_PROD_PERECIVEL_ESTOQUE = 30;
  public static final String MSG_FALHA_QTDE_MAX_PROD_PERECIVEL_ESTOQUE = "A quanticade máxima de albums de vinyl em estoque foi excedida.";

  /**
   * Quantidade grande de albums em estoque.
   */

  public static final int QTDE_GRANDE_PROD_ESTOQUE = 40;
  /**
   * Quantidade de dias considerados "recentes".
   */
  public static final int QTDE_DIAS_RECENTES = 7;

  @Autowired
  private AlbumRepository albumRepository;

  private void validarAlbum(Album album) {
    if (album.getTipo().equals(Album.VINYL) && album.getQuantidade() > QTDE_MAX_PROD_PERECIVEL_ESTOQUE) {
      throw new RuntimeException(MSG_FALHA_QTDE_MAX_PROD_PERECIVEL_ESTOQUE);
    }
  }

  public Album registrarAlbum(Album album) {
    validarAlbum(album);
    album.setData(new Date());
    return albumRepository.save(album);
  }

  public Iterable<Album> obterAlbumsRecentes() {
    Calendar agora = Calendar.getInstance();
    agora.add(Calendar.DATE, - QTDE_DIAS_RECENTES);
    return albumRepository.findByDataGreaterThan(agora.getTime());
  }

  public Iterable<Album> obterAlbumsEstoqueGrande() {
    return albumRepository.findByQuantidadeGreaterThan(QTDE_GRANDE_PROD_ESTOQUE);
  }

  public Album obterAlbum(Integer codigo) {
    return albumRepository.findOneByCodigo(codigo);
  }

  public Iterable<Album> obterTodos() {
    return albumRepository.findAll();
  }
}
