package main;

import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Event, Long> {
}
