package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Template;
import online.noithat.be.Entity.TemplateSection;
import online.noithat.be.dto.request.TemplateDTO;
import online.noithat.be.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @PostMapping("/template")
    public ResponseEntity createTemplate(@RequestBody TemplateDTO templateDTO){
        Template createTemplate = templateService.createTemplate(templateDTO);
        return ResponseEntity.ok(createTemplate);
    }



    @GetMapping("/template")
    public ResponseEntity getAllTemplate(){
        List<Template> template = templateService.getAllTemplate();
        return ResponseEntity.ok(template);
    }

    @DeleteMapping("/template/{id}")
    public ResponseEntity delete(@PathVariable long id){return ResponseEntity.ok(templateService.delete(id));}

    @PutMapping("/template/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody  TemplateDTO templateDTO)
    {
        return ResponseEntity.ok(templateService.update(id, templateDTO));
    }

    @GetMapping("/template-ProjectType/{id}")
    public ResponseEntity getTemplateByProjectTypeId(@PathVariable long id){
        List<Template> templates = templateService.getTemplatesByProjectTypeId(id);
        return ResponseEntity.ok(templates);
    }
}
