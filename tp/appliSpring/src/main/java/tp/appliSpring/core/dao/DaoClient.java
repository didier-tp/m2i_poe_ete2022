package tp.appliSpring.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.appliSpring.core.entity.Client;

public interface DaoClient  extends JpaRepository<Client,Long>{
         
    //...
}