package com.giri.springdata.filedata.repos;

import org.springframework.data.repository.CrudRepository;

import com.giri.springdata.filedata.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
