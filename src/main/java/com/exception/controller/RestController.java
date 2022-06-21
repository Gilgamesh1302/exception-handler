package com.exception.controller;

import com.exception.entity.Document;
import com.exception.exception.DocumentNonExistentException;
import com.exception.exception.DocumentNotFoundException;
import com.exception.exception.EmptyDocumentListException;
import com.exception.service.RestControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RestController {

    @Autowired
    RestControllerService restControllerService;

    @GetMapping(value = "/document")
    @ResponseBody
    public List<Document> getDocumentList() throws EmptyDocumentListException {
        return this.restControllerService.getAllDocuments();
    }

    @GetMapping("/document/{id}")
    @ResponseBody
    public Document getDocumentById( @PathVariable("id") Long id ) throws DocumentNonExistentException {
        return this.restControllerService.getDocumentById(id);
    }

    @GetMapping(value = "/document", params = "keyword")
    @ResponseBody
    public List<Document> getDocumentByKeywordInTitle( @RequestParam("keyword") String keyword ) throws DocumentNotFoundException {
        return this.restControllerService.getDocumentByKeywordInTitle(keyword);
    }

}
