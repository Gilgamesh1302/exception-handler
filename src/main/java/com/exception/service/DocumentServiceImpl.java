package com.exception.service;

import com.exception.dao.DocumentDao;
import com.exception.entity.Document;
import com.exception.entityDto.DocumentDto;
import com.exception.entityDto.DocumentWithoutIdDto;
import com.exception.exception.AuthorNotFoundException;
import com.exception.exception.DocumentNonExistentException;
import com.exception.exception.DocumentNotFoundException;
import com.exception.exception.EmptyDocumentListException;
import com.exception.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentDao documentDao;
    @Autowired
    DocumentMapper documentMapper;

    @Override
    public List<Document> getAllDocuments() throws EmptyDocumentListException {
        List<Document> documents = this.documentDao.getAllDocuments();
        if (documents.isEmpty()) {
            throw new EmptyDocumentListException("list of documents is empty !!");
        }

        return documents;
    }

    @Override
    public Document getDocumentById(Long id) throws DocumentNonExistentException {
        return this.documentDao
                .findDocumentById(id)
                .orElseThrow(() -> new DocumentNonExistentException(id));
    }

    @Override
    public Document saveNewWrittenDocument(DocumentDto documentDto) {
        Document documentToBeSaved = documentMapper.asDocument(documentDto);
        documentToBeSaved.setPublishDate(LocalDate.now());
        return this.documentDao.saveNewCreatedDocument(documentToBeSaved);
    }

    @Override
    public Optional<Document> saveDocument(DocumentWithoutIdDto documentWithoutIdDto) {
        Document documentToBeSaved = documentMapper.asDocument(documentWithoutIdDto);
        return Optional.ofNullable(documentDao.saveDocument(documentToBeSaved));
    }

    @Override
    public List<Document> findDocumentsByAuthor(String author) throws AuthorNotFoundException {
        List<Document> documentsWrittenBySearchedAuthor = documentDao.findDocumentsByAuthor(author);
        if (documentsWrittenBySearchedAuthor.isEmpty()) {
            throw new AuthorNotFoundException(author);
        }
        return documentsWrittenBySearchedAuthor;
    }


    @Override
    public List<Document> getDocumentByKeywordInTitle(String keyword) throws DocumentNotFoundException {
        List<Document> documents = this.documentDao.searchDocumentByKeywordInTitle(keyword);
        if (documents.isEmpty()) {
            throw new DocumentNotFoundException(keyword);
        }

        return documents;
    }
}
