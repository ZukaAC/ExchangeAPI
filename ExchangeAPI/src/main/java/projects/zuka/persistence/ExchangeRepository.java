package projects.zuka.persistence;

import projects.zuka.persistence.model.Data;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRepository extends CrudRepository<Data,String> {

}
