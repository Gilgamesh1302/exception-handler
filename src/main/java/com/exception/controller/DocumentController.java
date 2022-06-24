package com.exception.controller;

import com.exception.entity.Document;
import com.exception.entityDto.DocumentDto;
import com.exception.entityDto.DocumentWithoutIdDto;
import com.exception.exception.AuthorNotFoundException;
import com.exception.exception.DocumentNonExistentException;
import com.exception.exception.DocumentNotFoundException;
import com.exception.exception.EmptyDocumentListException;
import com.exception.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping(value = "")
    public List<Document> getDocumentList() throws EmptyDocumentListException {
        return this.documentService.getAllDocuments();
    }

    @GetMapping(value = "/{id}")
    public Document getDocumentById(@PathVariable("id") Long id) throws DocumentNonExistentException {
        return this.documentService.getDocumentById(id);
    }

    @PostMapping(value = "/save-new-written-document")
    public Document saveNewWrittenDocument(@RequestBody DocumentDto documentDto) {
        return this.documentService.saveNewWrittenDocument(documentDto);
    }

    @PostMapping(value = "/save-document")
    public Document saveDocument(@Valid @RequestBody DocumentWithoutIdDto documentWithoutIdDto) {
        return this.documentService.saveDocument(documentWithoutIdDto).orElse(null);
    }

    @GetMapping(value = "", params = "keyword")
    public List<Document> getDocumentByKeywordInTitle(@RequestParam("keyword") String keyword) throws DocumentNotFoundException {
        return this.documentService.getDocumentByKeywordInTitle(keyword);
    }

    @GetMapping(value="", params = "author")
    public List<Document> getDocumentsWrittenByAuthor(@RequestParam String author) throws AuthorNotFoundException {
        return this.documentService.findDocumentsByAuthor(author);
    }

}
