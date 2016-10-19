package lab.album;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
  public Iterable<Album> findByDataGreaterThan(Date data);
  public Iterable<Album> findByQuantidadeGreaterThan(Integer quantidade);
  public Album findOneByCodigo(Integer codigo);
}