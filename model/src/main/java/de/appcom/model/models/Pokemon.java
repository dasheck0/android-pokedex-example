package de.appcom.model.models;

/**
 * @author Stefan Neidig
 */

public class Pokemon {

  public int id;
  public String name;

  public Pokemon() {
  }

  public Pokemon(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override public String toString() {
    return "{" + "\"id\": " + id + ", \"name\": " + '"' + name + '"' + '}';
  }
}
