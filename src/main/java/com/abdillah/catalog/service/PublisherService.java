package com.abdillah.catalog.service;

import com.abdillah.catalog.domain.Publisher;
import com.abdillah.catalog.dto.PublisherDTO.PublisherCreateRequestDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherUpdateRequestDTO;

public interface PublisherService {

    public Publisher createPublisher(PublisherCreateRequestDTO dto);

    public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);
}
