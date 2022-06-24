package com.exception.mapper;


import com.exception.entity.Document;
import com.exception.entityDto.DocumentDto;
import com.exception.entityDto.DocumentWithoutIdDto;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(
        withIgnoreMissing = IgnoreMissing.ALL,
        withIoC = IoC.SPRING
)
public interface DocumentMapper {

    Document asDocument(DocumentDto documentDto);
    DocumentDto asDocumentDto(Document document);
    Document asDocument(DocumentWithoutIdDto documentWithoutIdDto);
    DocumentWithoutIdDto asDocumentWithoutIdDto(Document document);

}
