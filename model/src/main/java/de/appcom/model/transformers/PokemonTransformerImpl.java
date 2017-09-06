package de.appcom.model.transformers;

import de.appcom.model.entities.database.PokemonDatabaseEntity;
import de.appcom.model.entities.web.PokemonWebEntity;
import de.appcom.model.models.Pokemon;
import javax.inject.Inject;

/**
 * @author Stefan Neidig
 */

public class PokemonTransformerImpl implements PokemonTransformer {

  @Inject public PokemonTransformerImpl() {
  }

  @Override public Pokemon toModel(PokemonWebEntity entity) {
    if (entity != null) {
      Pokemon model = new Pokemon();
      model.id = entity.id;
      model.name = entity.name;

      return model;
    }

    return null;
  }

  @Override public Pokemon toModel(PokemonDatabaseEntity entity) {
    if (entity != null) {
      Pokemon model = new Pokemon();
      model.id = entity.id;
      model.name = entity.name;

      return model;
    }

    return null;
  }

  @Override public PokemonWebEntity toWebEntity(Pokemon model) {
    if (model != null) {
      PokemonWebEntity entity = new PokemonWebEntity();
      entity.id = model.id;
      entity.name = model.name;

      return entity;
    }

    return null;
  }

  @Override public PokemonDatabaseEntity toDatabaseEntity(Pokemon model) {
    if (model != null) {
      PokemonDatabaseEntity entity = new PokemonDatabaseEntity();
      entity.id = model.id;
      entity.name = model.name;

      return entity;
    }

    return null;
  }
}
