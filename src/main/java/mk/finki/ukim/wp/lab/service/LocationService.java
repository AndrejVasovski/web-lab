package mk.finki.ukim.wp.lab.service;
import mk.finki.ukim.wp.lab.model.Location;

import java.util.List;

public interface LocationService  {


    public List<Location> findAll();

    public Location findById(Long id);
}
