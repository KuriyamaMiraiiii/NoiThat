package online.noithat.be.service;

import online.noithat.be.Entity.Account;
import online.noithat.be.Entity.Blog;
import online.noithat.be.Entity.BlogSection;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.request.BlogRequestDTO;
import online.noithat.be.dto.request.BlogSectionRequestDTO;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.enums.BlogStatus;
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
        List<BlogSection> blogSections = new ArrayList<>();
        blog.setBlogName(blogRequestDTO.getBlogName());
        blog.setDatePost(blogRequestDTO.getDatePost());
        blog.setAccount(accountUtils.getCurrentAccount());
        blog.setThumbnail(blogRequestDTO.getThumbnail());
        for(BlogSectionRequestDTO blogSectionRequestDTO: blogRequestDTO.getBlogSectionRequestDTOS()){
            BlogSection blogSection = new BlogSection();
            blogSection.setBlog(blog);
            List<Resource> resources = new ArrayList<>();
            blogSection.setName(blogSectionRequestDTO.getName());
            for(ResourceDTO resourceDTO: blogSectionRequestDTO.getResourceDTO()){
                Resource resource = new Resource();
                resource.setBlogSection(blogSection);
                resource.setUrl(resourceDTO.getUrl());
                resource.setType(resourceDTO.getType());
                resources.add(resource);
            }
            blogSection.setResources(resources);
            blogSections.add(blogSection);
        }
        blog.setBlogSections(blogSections);
        try{
            return blogRepository.save(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Blog activeBlog(long blogId){
        Blog blog = blogRepository.findBlogById(blogId);
//        blog.setStatus(BlogStatus.ACTIVE);
        return blogRepository.save(blog);
    }


    public List<Blog> getAllBlogs() {
//        List<Blog> blogs = blogRepository.findBlogsByStatus(BlogStatus.ACTIVE);
        List<Blog> blogs = blogRepository.findBlogsByIdNotNull();
        return blogs;
    }

    public Blog getBlogDetail(long blogId) {
        Blog blog = blogRepository.findBlogById(blogId);
        return blog;
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
//        for (ResourceDTO resourceDTO : blogRequestDTO.getResourceDTO()) {
//            Resource resource = new Resource();
//            resource.setType(resourceDTO.getType());
//            resource.setUrl(resourceDTO.getUrl());
//            resource.setBlog(blog);
//            resources.add(resource);
//        }
//        blog.setResources(resources);
        return blogRepository.save(blog);
    }
}
