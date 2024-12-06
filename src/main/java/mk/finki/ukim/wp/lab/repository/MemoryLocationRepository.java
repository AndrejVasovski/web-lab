package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoryLocationRepository {


    public List<Location> findAll() {
        return DataHolder.locations;
    }

    public Location findById(long id) {
        return DataHolder.locations.stream().filter(location -> location.getId().equals(id)).findFirst().orElse(null);
    }

}

