package com.tw.githubRepositoryShortInfo.service;

import com.tw.githubRepositoryShortInfo.dto.GithubDtoMapper;
import com.tw.githubRepositoryShortInfo.dto.GithubResponseDto;
import com.tw.githubRepositoryShortInfo.exception.ValidationException;
import com.tw.githubRepositoryShortInfo.webClient.GithubApiClient;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.hasText;

@Service
public class GithubApiService {
    private final GithubApiClient githubApiClient;

    public GithubApiService(GithubApiClient githubApiClient) {
        this.githubApiClient = githubApiClient;

    }

    public GithubResponseDto getShortInfo(String owner, String repositoryName) {
        if (!hasText(owner) || !hasText(repositoryName)) {
            throw new ValidationException();
        }
        return GithubDtoMapper.INSTANCE.toGithubResponseDto(githubApiClient.getRepositoryShortInfo(owner, repositoryName));
    }
}
