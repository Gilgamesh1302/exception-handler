package com.exception.service;

import com.exception.entity.Document;
import com.exception.exception.DocumentNonExistentException;
import com.exception.exception.DocumentNotFoundException;
import com.exception.exception.EmptyDocumentListException;
import com.exception.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestControllerServiceImpl implements RestControllerService{

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public List<Document> getAllDocuments() throws EmptyDocumentListException {
        List<Document> documents = (List<Document>) this.documentRepository.findAll();
        if (documents.isEmpty()) {
            throw new EmptyDocumentListException("list of documents is empty !!");
        }

        return documents;
    }

    @Override
    public Document getDocumentById(Long id) throws DocumentNonExistentException {
        return this.documentRepository
                .findById(id)
                .orElseThrow(() -> new DocumentNonExistentException(id));
    }

    @Override
    public List<Document> getDocumentByKeywordInTitle(String keyword) throws DocumentNotFoundException {
        List<Document> documents = this.documentRepository.findDocumentByKeywordInTitle(keyword);
        if (documents.isEmpty()) {
            throw new DocumentNotFoundException(keyword);
        }

        return documents;
    }
}
