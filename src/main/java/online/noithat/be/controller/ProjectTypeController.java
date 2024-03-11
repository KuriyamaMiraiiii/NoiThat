package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import online.noithat.be.Entity.ProjectType;
import online.noithat.be.dto.request.ProjectTypeRequestDTO;
import online.noithat.be.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class ProjectTypeController {
    @Autowired
    ProjectTypeService projectTypeService;

    @PostMapping("/projectType")
    public ResponseEntity createProjectType(@RequestBody ProjectTypeRequestDTO projectTypeRequestDTO) {
        ProjectType createdProjectType = projectTypeService.createProjectType(projectTypeRequestDTO);
        return ResponseEntity.ok(createdProjectType);
    }

    @GetMapping("/projectTypes")
    public ResponseEntity getAllProjectTypes() {
        List<ProjectType> projectTypes = projectTypeService.getAllProjectTypes();
        return ResponseEntity.ok(projectTypes);
    }

    @DeleteMapping("/projectType/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(projectTypeService.delete(id));
    }
    @PutMapping("/projectType/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody ProjectTypeRequestDTO projectTypeRequestDTO){
        return ResponseEntity.ok(projectTypeService.update(id,projectTypeRequestDTO));
    }
}
