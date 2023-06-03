package com.abdillah.catalog.service.impl;

import org.springframework.stereotype.Service;

import com.abdillah.catalog.domain.Publisher;
import com.abdillah.catalog.dto.PublisherDTO.PublisherCreateRequestDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherUpdateRequestDTO;
import com.abdillah.catalog.exception.BadRequestException;
import com.abdillah.catalog.repository.PublisherRepository;
import com.abdillah.catalog.service.PublisherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public Publisher createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getPublisherName());
        publisher.setCompanyName(dto.getCompanyName());
        publisher.setAddress(dto.getAddress());

        publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto) {
        Publisher publisher = publisherRepository.findBySecureId(publisherId)
                .orElseThrow(() -> new BadRequestException("invalid.publisherId"));

        publisher.setName(dto.getPublisherName() == null || dto.getPublisherName().isBlank() ? publisher.getName()
                : dto.getPublisherName());
        publisher.setCompanyName(
                dto.getCompanyName() == null || dto.getCompanyName().isBlank() ? publisher.getCompanyName()
                        : dto.getCompanyName());
        publisher.setAddress(dto.getAddress());

        publisherRepository.save(publisher);
    }
}
