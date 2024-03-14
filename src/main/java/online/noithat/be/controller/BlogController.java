package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Blog;
import online.noithat.be.Entity.Category;
import online.noithat.be.dto.request.BlogRequestDTO;
import online.noithat.be.dto.request.CategoryRequestDTO;
import online.noithat.be.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class BlogController {
    @Autowired
    BlogService blogService;
    @PostMapping("/blog")
    public ResponseEntity createBlog(@RequestBody BlogRequestDTO blogRequestDTO) {
        Blog createdBlog = blogService.createBlog(blogRequestDTO);
        return ResponseEntity.ok(createdBlog);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity getAllBlog(@PathVariable long id) {
        Blog blog = blogService.getBlogDetail(id);
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/blog")
    public ResponseEntity getAllBlog2() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @DeleteMapping("/blog/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(blogService.delete(id));
    }
    @PutMapping("/blog/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody BlogRequestDTO blogRequestDTO){
        return ResponseEntity.ok(blogService.update(id,blogRequestDTO));
    }

    @PatchMapping("/active-blog/{id}")
    public ResponseEntity activeBlog(@PathVariable long id){
        return ResponseEntity.ok(blogService.activeBlog(id));
    }
}
