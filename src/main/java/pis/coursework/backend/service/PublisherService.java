package pis.coursework.backend.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pis.coursework.backend.dto.PublisherDto;
import pis.coursework.backend.entity.Publisher;
import pis.coursework.backend.mapper.PublisherMapper;
import pis.coursework.backend.repository.PublisherRepo;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepo publisherRepo;
    private final PublisherMapper publisherMapper;

    @Transactional(readOnly = true)
    public PublisherDto getPublisherById(Long publisherId) {
        return publisherMapper.toDto(publisherRepo.findById(publisherId).orElseThrow(() ->
                new EntityExistsException("Издателя по такому id не существует")));
    }

    @Transactional(readOnly = true)
    public ArrayList<PublisherDto> getAllPublishers() {
        return publisherMapper.listToDto(publisherRepo.getAllPublishers());
    }

    @Transactional
    public void createPublisher(PublisherDto publisherDto) {
        publisherRepo.save(Publisher.builder()
                .name(publisherDto.getName())
                .city(publisherDto.getCity())
                .license(publisherDto.getLicense())
                .build());
    }

    @Transactional
    public void deletePublisher(Long publisherId) {
        if (publisherRepo.getPublisherById(publisherId) == null) {
            throw new EntityExistsException("Издателя по такому id не существует");
        }
        publisherRepo.deleteById(publisherId);
    }

    @Transactional
    public void updatePublisher(Long publisherId, PublisherDto publisherDto) {
        if (publisherRepo.getPublisherById(publisherId) == null) {
            throw new EntityExistsException("Издателя по такому id не существует");
        }
        Publisher updatedPublisher = publisherMapper.toEntity(publisherDto);
        updatedPublisher.setId(publisherId);
        publisherRepo.save(updatedPublisher);
    }


}
