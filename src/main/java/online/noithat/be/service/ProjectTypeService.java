package online.noithat.be.service;

import online.noithat.be.Entity.Category;
import online.noithat.be.Entity.ProjectType;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.request.ProjectTypeRequestDTO;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.repository.ProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectTypeService {
    @Autowired
    ProjectTypeRepository projectTypeRepository;

    public ProjectType createProjectType(ProjectTypeRequestDTO projectTypeRequestDTO){
        ProjectType projectType = new ProjectType();

        projectType.setType(projectTypeRequestDTO.getType());
        List<Resource> resources = new ArrayList<>();
        for (ResourceDTO resourceDTO : projectTypeRequestDTO.getResourceDTOList()){
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setProjectType(projectType);
            resources.add(resource);
        }
        List<Category> categoryList = new ArrayList<>();
        for(Category category : projectTypeRequestDTO.getCategoryList()){
            category.setName(category.getName());
            categoryList.add(category);
        }
        projectType.setCategoryList(categoryList);
        projectType.setResources((resources));
        return projectTypeRepository.save(projectType);
    }

    public List<ProjectType> getAllProjectTypes(){
        List<ProjectType> projectTypes = projectTypeRepository.findProjectTypeByIdNotNull();
        return projectTypes;
    }

    public ProjectType delete(long id){
        ProjectType projectType = projectTypeRepository.findProjectTypeById(id);
        projectType.setDeleted(true);
        return projectTypeRepository.save(projectType);
    }

    public ProjectType update(long id, ProjectTypeRequestDTO projectTypeRequestDTO){
        ProjectType projectType = projectTypeRepository.findProjectTypeById(id);

        projectType.setType(projectTypeRequestDTO.getType());
        List<Resource> resources = new ArrayList<>();
        for (ResourceDTO resourceDTO : projectTypeRequestDTO.getResourceDTOList()) {
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setProjectType(projectType);
            resources.add(resource);
        }
        List<Category> categoryList = new ArrayList<>();
        for(Category category : projectTypeRequestDTO.getCategoryList()){
            category.setName(category.getName());
            categoryList.add(category);
        }
        projectType.setCategoryList(categoryList);
        projectType.setResources(resources);
        return projectTypeRepository.save(projectType);
    }

}
