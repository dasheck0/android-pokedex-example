package de.appcom.model.entities.web;

/**
 * @author Stefan Neidig
 */

public class PokemonWebEntity {

  public int id;
  public String name;

  public PokemonWebEntity() {
  }

  public PokemonWebEntity(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override public String toString() {
    return "{" + "\"id\": " + id + ", \"name\": " + '"' + name + '"' + '}';
  }
}
