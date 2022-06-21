package com.exception.service;

import com.exception.entity.Document;
import com.exception.exception.DocumentNonExistentException;
import com.exception.exception.DocumentNotFoundException;
import com.exception.exception.EmptyDocumentListException;

import java.util.List;

public interface RestControllerService {

    List<Document> getAllDocuments() throws EmptyDocumentListException;
    Document getDocumentById(Long id) throws DocumentNonExistentException;
    List<Document> getDocumentByKeywordInTitle(String keyword) throws DocumentNotFoundException;

}
