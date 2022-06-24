package com.exception.dao;

import com.exception.entity.Document;
import com.exception.exception.EmptyDocumentListException;

import java.util.List;
import java.util.Optional;

public interface DocumentDao {

    List<Document> searchDocumentByKeywordInTitle(String keyword);
    List<Document> getAllDocuments() throws EmptyDocumentListException;
    Optional<Document> findDocumentById(Long id);
    List<Document> findDocumentsByAuthor(String author);
    Document saveNewCreatedDocument(Document documentToBeSaved);
    Document saveDocument(Document document);

}
