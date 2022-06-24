package com.exception.service;

import com.exception.entity.Document;
import com.exception.entityDto.DocumentDto;
import com.exception.entityDto.DocumentWithoutIdDto;
import com.exception.exception.*;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    List<Document> getAllDocuments() throws EmptyDocumentListException;
    Document getDocumentById(Long id) throws DocumentNonExistentException;
    Document saveNewWrittenDocument(DocumentDto documentDto);
    Optional<Document> saveDocument(DocumentWithoutIdDto documentWithoutIdDto);
    List<Document> findDocumentsByAuthor(String author) throws AuthorNotFoundException;
    List<Document> getDocumentByKeywordInTitle(String keyword) throws DocumentNotFoundException;

}
