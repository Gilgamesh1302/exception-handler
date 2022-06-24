package com.exception.dao;


import com.exception.entity.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentDaoTest {

    @Autowired
    DocumentDao documentDao;
    Document document;

    @Before
    public void init() {
        document = new Document();
        document.setId(1L);
        document.setAuthor("mohamed el kadiri");
        document.setTitle("the epic of gilgamesh");
        document.setPublishDate(LocalDate.of(2022, 06, 22));
    }

    @Test
    public void testFindDocumentByIdSuccess() {
        Document toBeTested = documentDao.findDocumentById(1L).orElse(null);
        assertNotNull(toBeTested);
    }

    @Test
    public void testFindDocumentByIdNotFound() {
        Document toBeTested = documentDao.findDocumentById(-1L).orElse(null);
        assertNull(toBeTested);
    }

    @Test
    public void testFindAllDocumentsSuccess() throws Exception {
        List<Document> expectedList = documentDao.getAllDocuments();
        assertTrue(expectedList.size() > 0);
    }

    @Test
    public void testFindDocumentByKeywordInTitle() {
        List<Document> foundDocuments = documentDao.searchDocumentByKeywordInTitle("gilgamesh");
        System.out.println(foundDocuments);
        assertTrue(foundDocuments.size() > 0);
    }

    @Test
    public void testFindDocumentByKeywordInTitleNotFound() {
        List<Document> foundDocuments = documentDao.searchDocumentByKeywordInTitle("bla bla bla");
        assertTrue(foundDocuments.isEmpty());
    }

    @Test
    public void testSaveNewDocument() {
        Document newDocument = new Document();
        newDocument.setTitle("test title");
        newDocument.setAuthor("test author");
        newDocument.setPublishDate(LocalDate.now());
        Document documentSaved = this.documentDao.saveDocument(newDocument);
        assertNotNull(documentSaved.getId());
    }

    @Test
    public void testSearchByAuthor() {
        List<Document> documents = documentDao.findDocumentsByAuthor("mohamed el kadiri");
        assertTrue(documents.size() > 0);
    }

    @Test
    public void testSearchByAuthorFailure() {
        List<Document> documents = documentDao.findDocumentsByAuthor("abdlekader not existing");
        assertTrue(documents.isEmpty());
    }


}
