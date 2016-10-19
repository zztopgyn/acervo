package lab.album;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {

  public static final String VINYL = "vinyl";

  @Id
  private Integer codigo;

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  private String tipo;

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  private Integer quantidade;

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  private Date data;

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Album() {
  }

  public Album(Integer codigo, String nome, String tipo, Integer quantidade) {
    this.codigo = codigo;
    this.nome = nome;
    this.tipo = tipo;
    this.quantidade = quantidade;
  }

}
