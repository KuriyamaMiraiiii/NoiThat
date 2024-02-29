package online.noithat.be.service;

import online.noithat.be.Entity.Account;
import online.noithat.be.Entity.Blog;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.request.BlogRequestDTO;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.repository.BlogRepository;
import online.noithat.be.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    AccountUtils accountUtils;

    public Blog createBlog(BlogRequestDTO blogRequestDTO) {

        Blog blog = new Blog();
        blog.setBlogName(blogRequestDTO.getBlogName());
        blog.setDatePost(blogRequestDTO.getDatePost());
        blog.setAccount(accountUtils.getCurrentAccount());
        List<Resource> resources = new ArrayList<>();
        for (ResourceDTO resourceDTO : blogRequestDTO.getResourceDTO()) {
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setBlog(blog);
            resources.add(resource);
        }
        blog.setResources(resources);
        return blogRepository.save(blog);
    }


    public List<Blog> getAllBlogs() {
        List<Blog> blogs = blogRepository.findBlogsByIdNotNull();
        return blogs;
    }

    public Blog delete(long id) {
        Blog blog = blogRepository.findBlogById(id);
        blog.setDeleted(true);
        return blogRepository.save(blog);
    }

    public Blog update(long id, BlogRequestDTO blogRequestDTO) {
        Blog blog = blogRepository.findBlogById(id);
        blog.setBlogName(blogRequestDTO.getBlogName());
        blog.setDatePost(blogRequestDTO.getDatePost());
        List<Resource> resources = new ArrayList<>();
        for (ResourceDTO resourceDTO : blogRequestDTO.getResourceDTO()) {
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setBlog(blog);
            resources.add(resource);
        }
        blog.setResources(resources);
        return blogRepository.save(blog);
    }
}
