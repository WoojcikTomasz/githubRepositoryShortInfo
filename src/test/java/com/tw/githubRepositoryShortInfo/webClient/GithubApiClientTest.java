package com.tw.githubRepositoryShortInfo.webClient;

import com.tw.githubRepositoryShortInfo.dto.GithubClientDto;
import com.tw.githubRepositoryShortInfo.exception.RepositoryNotFoundException;
import com.tw.githubRepositoryShortInfo.exception.ServiceUnavailableException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static utils.GithubSampleResponses.getSampleGithubResponse;

@RestClientTest(GithubApiClient.class)
@ComponentScan(basePackages = "com.tw.githubRepositoryShortInfo")
class GithubApiClientTest {
    private static final String SAMPLE_GITHUB_URL = "https://api.github.com/repos/owner/sampleRepoName";

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private GithubApiClient client;

    @Test
    void checkGithubRepository_successResponse_dtoCreatedSuccessfully() throws JSONException {
        //Given
        this.mockRestServiceServer
                .expect(MockRestRequestMatchers.requestTo(SAMPLE_GITHUB_URL))
                .andRespond(MockRestResponseCreators.withSuccess(getSampleGithubResponse(), MediaType.APPLICATION_JSON));

        //When
        GithubClientDto dto = client.getRepositoryShortInfo("owner", "sampleRepoName");

        //Then
        assertThatDtoCreatedSuccessfully(dto);
    }

    @Test
    void checkRepository_notFoundResponse_notFoundExceptionThrown() {
        //Given
        this.mockRestServiceServer
                .expect(MockRestRequestMatchers.requestTo(SAMPLE_GITHUB_URL))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        //When
        //Then
        assertThrows(RepositoryNotFoundException.class, () -> client.getRepositoryShortInfo("owner", "sampleRepoName"));

    }

    @Test
    void checkRepository_serviceUnavailableExceptionResponse_serviceUnavailableExceptionThrown() {
        //Given
        this.mockRestServiceServer
                .expect(MockRestRequestMatchers.requestTo(SAMPLE_GITHUB_URL))
                .andRespond(withStatus(HttpStatus.SERVICE_UNAVAILABLE));

        //When
        //Then
        assertThrows(ServiceUnavailableException.class,
                () -> client.getRepositoryShortInfo("owner", "sampleRepoName"));

    }

    private void assertThatDtoCreatedSuccessfully(GithubClientDto dto) throws JSONException {
        JSONObject jsonResponse = new JSONObject(getSampleGithubResponse());
        Assertions.assertEquals(jsonResponse.getString("full_name"), dto.getFullName());
        Assertions.assertEquals(jsonResponse.getString("description"), dto.getDescription());
        Assertions.assertEquals(jsonResponse.getString("clone_url"), dto.getCloneUrl());
        Assertions.assertEquals(jsonResponse.getInt("stargazers_count"), dto.getStargazersCount());
        Assertions.assertEquals(jsonResponse.getString("created_at"),
                dto.getCreatedAt().atOffset(ZoneOffset.UTC).toString());
    }

}