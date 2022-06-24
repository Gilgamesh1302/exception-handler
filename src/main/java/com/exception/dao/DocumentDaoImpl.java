package com.exception.dao;

import com.exception.entity.Document;
import com.exception.entity.QDocument;
import com.exception.repository.DocumentRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public class DocumentDaoImpl implements DocumentDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DocumentRepository repository;
    private JPAQueryFactory query;
    private QDocument document;

    @PostConstruct
    public void init() {
        query = new JPAQueryFactory(entityManager);
        document = QDocument.document;
    }


    @Override
    public List<Document> searchDocumentByKeywordInTitle(String keyword) {
        return query
                .selectFrom(document)
                .where(document.title.containsIgnoreCase(keyword))
                .fetch();
    }

    @Override
    public List<Document> getAllDocuments() {
        return (List<Document>) this.repository.findAll();
    }

    @Override
    public Optional<Document> findDocumentById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Document> findDocumentsByAuthor(String author) {
        return query
                .selectFrom(document)
                .where(document.author.equalsIgnoreCase(author))
                .fetch();
    }

    @Override
    public Document saveNewCreatedDocument(Document documentToBeSaved) {
        return this.repository.save(documentToBeSaved);
    }

    @Override
    public Document saveDocument(Document document) {
        return this.repository.save(document);
    }
}
