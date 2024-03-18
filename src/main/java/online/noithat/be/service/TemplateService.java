package online.noithat.be.service;

import online.noithat.be.Entity.ProjectType;
import online.noithat.be.Entity.Resource;
import online.noithat.be.Entity.Template;
import online.noithat.be.Entity.TemplateSection;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.dto.request.TemplateDTO;
import online.noithat.be.dto.request.TemplateSectionDTO;
import online.noithat.be.repository.ProjectTypeRepository;
import online.noithat.be.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    ProjectTypeRepository projectTypeRepository;

    public List<Template> getAllTemplate(){
        List<Template> templates = templateRepository.findTemplatesByIdNotNull();
        return templates;
    }

    public Template getTemplateById(long id){
        Template template = templateRepository.findTemplateById(id);
        return template;
    }

    public Template createTemplate(TemplateDTO templateDTO){
        ProjectType projectType = projectTypeRepository.findProjectTypeById(templateDTO.getProjectTypeId());
        Template template = new Template();
        List<TemplateSection> templateSections = new ArrayList<>();
        template.setDatePost(templateDTO.getDatePost());
        template.setName(templateDTO.getName());
        template.setProjectType(projectType);
        for (TemplateSectionDTO templateSectionDTO : templateDTO.getTemplateSectionDTOS()){
            TemplateSection templateSection = new TemplateSection();
            templateSection.setTemplate(template);
            List<Resource> resources = new ArrayList<>();
            templateSection.setName(templateSectionDTO.getName());
            for (ResourceDTO resourceDTO : templateSectionDTO.getResourceDTOS()){
                Resource resource = new Resource();
                resource.setTemplateSection(templateSection);
                resource.setUrl(resourceDTO.getUrl());
                resource.setProjectType(projectType);
                resources.add(resource);
            }
            templateSection.setResources(resources);
            templateSections.add(templateSection);
        }
        template.setTemplateSections(templateSections);
        try{
            return templateRepository.save(template);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Template delete(long id){
        Template template = templateRepository.findTemplateById(id);
        template.setDeleted(true);
        return templateRepository.save(template);
    }

    public Template update(long id, TemplateDTO templateDTO){
        Template template = templateRepository.findTemplateById(id);
        template.setName(templateDTO.getName());
        template.setDatePost(templateDTO.getDatePost());
        return templateRepository.save(template);
    }
}
