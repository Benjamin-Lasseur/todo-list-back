package benjamin.todolistback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import benjamin.todolistback.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

}
