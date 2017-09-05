package de.appcom.pokedexapp4.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Stefan Neidig
 */
@Target(ElementType.TYPE) @Inherited @Retention(RetentionPolicy.RUNTIME) public @interface Layout {
  int value();
}