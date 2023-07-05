package com.tw.githubRepositoryShortInfo.controller;

import com.tw.githubRepositoryShortInfo.dto.GithubResponseDto;
import com.tw.githubRepositoryShortInfo.exception.RepositoryNotFoundException;
import com.tw.githubRepositoryShortInfo.exception.RestResponseEntityExceptionHandler;
import com.tw.githubRepositoryShortInfo.exception.ServiceUnavailableException;
import com.tw.githubRepositoryShortInfo.service.GithubApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import utils.GithubRepositoryShortInfoDtos;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = RepositoriesController.class)
class GithubApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GithubApiService githubApiService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RepositoriesController(githubApiService))
                .setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
    }

    @Test
    void handleGetRequest_repositoryFound_returnSuccessResponse() throws Exception {
        //Given
        GithubResponseDto sampleDto = GithubRepositoryShortInfoDtos.getSampleDto();
        when(githubApiService.getShortInfo("sampleOwner", "sampleRepositoryName"))
                .thenReturn(sampleDto);
        MockHttpServletRequestBuilder httpRequest = prepareGetRequest();

        //When
        //Then
        mockMvc.perform(httpRequest)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName").value(sampleDto.getFullName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(sampleDto.getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cloneUrl").value(sampleDto.getCloneUrl()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stars").value(sampleDto.getStars()))
                .andReturn();
    }

    @Test
    void handleGetRequest_repositoryNotFound_returnNotFoundResponse() throws Exception {
        //Given
        when(githubApiService.getShortInfo("sampleOwner", "sampleRepositoryName"))
                .thenThrow(new RepositoryNotFoundException());
        MockHttpServletRequestBuilder httpRequest = prepareGetRequest();

        //When
        //Then
        mockMvc.perform(httpRequest)
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void handleGetRequest_serviceError_returnServiceUnavailable() throws Exception {
        //Given
        when(githubApiService.getShortInfo("sampleOwner", "sampleRepositoryName"))
                .thenThrow(new ServiceUnavailableException());
        MockHttpServletRequestBuilder httpRequest = prepareGetRequest();

        //When
        //Then
        mockMvc.perform(httpRequest)
                .andExpect(status().isServiceUnavailable())
                .andReturn();
    }

    @Test
    void handleGetRequest_serviceError_returnInternalServerError() throws Exception {
        //Given
        when(githubApiService.getShortInfo("sampleOwner", "sampleRepositoryName"))
                .thenThrow(new RuntimeException());
        MockHttpServletRequestBuilder httpRequest = prepareGetRequest();

        //When
        //Then
        mockMvc.perform(httpRequest)
                .andExpect(status().isInternalServerError())
                .andReturn();
    }

    private static MockHttpServletRequestBuilder prepareGetRequest() {
        MockHttpServletRequestBuilder httpRequest = MockMvcRequestBuilders
                .get("/repositories/{owner}/{repository}", "sampleOwner", "sampleRepositoryName")
                .accept(MediaType.APPLICATION_JSON);
        return httpRequest;
    }
}

