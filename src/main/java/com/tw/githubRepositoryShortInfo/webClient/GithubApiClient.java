package com.tw.githubRepositoryShortInfo.webClient;

import com.tw.githubRepositoryShortInfo.dto.GithubClientDto;
import com.tw.githubRepositoryShortInfo.exception.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubApiClient {

    @Value("${github.baseUrl}")
    private String githubBaseUrl;

    private final RestTemplate restTemplate;

    public GithubApiClient(RestTemplateBuilder restTemplateBuilder,
                           RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        this.restTemplate = restTemplateBuilder.errorHandler(restTemplateResponseErrorHandler).build();
    }

    public GithubClientDto getRepositoryShortInfo(String owner, String repositoryName) {

        return restTemplate.getForObject(githubBaseUrl + "{owner}/{repositoryName}",
                GithubClientDto.class,
                owner,
                repositoryName);
    }
}
