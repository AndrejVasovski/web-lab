package mk.finki.ukim.wp.lab.repository.jpa;


import mk.finki.ukim.wp.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Override
    Optional<Location> findById(Long aLong);

    @Override
    List<Location> findAll();
}
