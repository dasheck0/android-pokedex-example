package de.appcom.pokedexapp4.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * @author Stefan Neidig
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
