package online.noithat.be.service;

import online.noithat.be.Entity.Request;
import online.noithat.be.Entity.Resource;
import online.noithat.be.dto.request.ResourceDTO;
import online.noithat.be.dto.response.CreateRequestDTO;
import online.noithat.be.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository;

    public List<Request> getAllRequest(){
        List<Request> requests = requestRepository.findRequestsByIdNotNull();
        return requests;
    }

    public Request getRequestById(long id){
        Request request = requestRepository.findRequestById(id);
        return request;
    }

    public Request createRequest(CreateRequestDTO createRequestDTO){
        Request request = new Request();
        request.setBudget(createRequestDTO.getBugget());
        request.setDescription(createRequestDTO.getDescription());
        request.setDienTich(createRequestDTO.getDienTich());
        request.setType(createRequestDTO.getType());

        List<Resource> resources = new ArrayList<>();
        for(ResourceDTO resourceDTO: createRequestDTO.getResourceDTOS()){
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setRequest(request);
            resources.add(resource);
        }
        request.setResources(resources);

        return requestRepository.save(request);
    }

    public Request delete(long id){
        Request request = requestRepository.findRequestById(id);
        request.setDeleted(true);
        return requestRepository.save(request);
    }

    public Request update(CreateRequestDTO createRequestDTO, long id){
        Request request = requestRepository.findRequestById(id);
        request.setBudget(createRequestDTO.getBugget());
        request.setDescription(createRequestDTO.getDescription());
        request.setDienTich(createRequestDTO.getDienTich());
        request.setType(createRequestDTO.getType());

        List<Resource> resources = new ArrayList<>();
        for(ResourceDTO resourceDTO: createRequestDTO.getResourceDTOS()){
            Resource resource = new Resource();
            resource.setType(resourceDTO.getType());
            resource.setUrl(resourceDTO.getUrl());
            resource.setRequest(request);
            resources.add(resource);
        }
        request.setResources(resources);
        return requestRepository.save(request);
    }
}
