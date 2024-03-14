package online.noithat.be.repository;

import online.noithat.be.Entity.Blog;
import online.noithat.be.enums.BlogStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findBlogById(long id);
    List<Blog> findBlogsByIdNotNull();
//    List<Blog> findBlogsByStatus(BlogStatus blogStatus);
}
