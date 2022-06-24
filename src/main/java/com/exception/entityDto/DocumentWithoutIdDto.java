package com.exception.entityDto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class DocumentWithoutIdDto {

    @NotBlank(message = "title should not be blank")
    private String title;
    @NotBlank(message = "author should not be blank")
    private String author;
    @Past(message = "publish date should not be in future")
    private LocalDate publishDate;


    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public LocalDate getPublishDate() {
        return this.publishDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
