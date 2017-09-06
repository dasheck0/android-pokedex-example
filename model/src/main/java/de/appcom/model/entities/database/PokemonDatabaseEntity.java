package de.appcom.model.entities.database;

/**
 * @author Stefan Neidig
 */

public class PokemonDatabaseEntity {

  public int id;
  public String name;

  public PokemonDatabaseEntity() {
  }

  public PokemonDatabaseEntity(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override public String toString() {
    return "{" + "\"id\": " + id + ", \"name\": " + '"' + name + '"' + '}';
  }
}
