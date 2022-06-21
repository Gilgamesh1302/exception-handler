package com.exception.repository;


import com.exception.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query("SELECT doc FROM Document doc WHERE doc.title LIKE %?1%")
    List<Document> findDocumentByKeywordInTitle(String keyword);

}
