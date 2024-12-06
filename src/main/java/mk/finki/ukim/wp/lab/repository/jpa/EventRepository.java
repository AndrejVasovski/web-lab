package mk.finki.ukim.wp.lab.repository.jpa;

import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
    List<Event> findAll();

    List<Event> findAllByNameContainingIgnoreCaseAndPopularityScoreGreaterThanEqual(String name, double popularityScore);

    List<Event> findAllByLocation_Id(Long locationId);

    List<Event> findAllByNameAndAndDescription(String name, String description);




    @Override
    void deleteById(Long aLong);

    @Override
    Optional<Event> findById(Long aLong);
}
