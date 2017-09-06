package de.appcom.model.transformers;

import de.appcom.model.entities.database.PokemonDatabaseEntity;
import de.appcom.model.entities.web.PokemonWebEntity;
import de.appcom.model.models.Pokemon;

/**
 * @author Stefan Neidig
 */

public interface PokemonTransformer {

  Pokemon toModel(PokemonWebEntity entity);

  Pokemon toModel(PokemonDatabaseEntity entity);

  PokemonWebEntity toWebEntity(Pokemon model);

  PokemonDatabaseEntity toDatabaseEntity(Pokemon model);
}
