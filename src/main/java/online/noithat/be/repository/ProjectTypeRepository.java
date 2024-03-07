package online.noithat.be.repository;

import online.noithat.be.Entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {
    ProjectType findProjectTypeById(long id);
    List<ProjectType> findProjectTypeByIdNotNull();
}
