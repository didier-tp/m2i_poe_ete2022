package tp.appliSpring.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.appliSpring.core.entity.Pays;

public interface PaysDao  extends JpaRepository<Pays,String> {

}
