package it.giuliozelante.model.tournament;

import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@ReflectiveAccess
public record TournamentsRequest(Integer perPage, Long ownerId) {
}
