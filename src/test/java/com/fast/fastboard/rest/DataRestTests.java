package com.fast.fastboard.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

// @WebMvcTest /* Not Support Data REST Repositories */
@DisplayName("Date REST Test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTests {
    
    private MockMvc mvc;

    public DataRestTests(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("Get Articles")
    @Test
    void get_articles() throws Exception {
        // Given

        // When & Then
        final String PATH = "/api/articles";
        final MediaType HAL = MediaType.valueOf("application/hal+json");
        mvc.perform(get(PATH))
            .andExpect(status().isOk())
            .andExpect(content().contentType(HAL));
            // .andDo(MockMvcResultHandlers.print())
    }

    @DisplayName("Get Single Article")
    @Test
    void get_single_article() throws Exception {
        // Given

        // When & Then
        // See https://github.com/spring-projects/spring-data-rest/issues/2163
        final String PATH = "/api/articles/1";
        final MediaType HAL = MediaType.valueOf("application/hal+json");
        mvc.perform(get(PATH))
            .andExpect(status().isOk())
            .andExpect(content().contentType(HAL));
    }

    @DisplayName("Get Comments of Article")
    @Test
    void get_comments_of_article() throws Exception {
        // Given

        // When & Then
        final String PATH = "/api/articles/1/comments";
        final MediaType HAL = MediaType.valueOf("application/hal+json");
        mvc.perform(get(PATH))
            .andExpect(status().isOk())
            .andExpect(content().contentType(HAL));
    }

    @DisplayName("Get Comments")
    @Test
    void get_comments() throws Exception {
        // Given

        // When & Then
        final String PATH = "/api/comments";
        final MediaType HAL = MediaType.valueOf("application/hal+json");
        mvc.perform(get(PATH))
            .andExpect(status().isOk())
            .andExpect(content().contentType(HAL));
    }

    @DisplayName("Get Single Comment")
    @Test
    void get_single_comment() throws Exception {
        // Given

        // When & Then
        // See https://github.com/spring-projects/spring-data-rest/issues/2163
        final String PATH = "/api/comments/1";
        final MediaType HAL = MediaType.valueOf("application/hal+json");
        mvc.perform(get(PATH))
            .andExpect(status().isOk())
            .andExpect(content().contentType(HAL));
    }
}
