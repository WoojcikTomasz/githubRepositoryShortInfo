package com.tw.githubRepositoryShortInfo.controller;

import com.tw.githubRepositoryShortInfo.service.GithubApiService;
import com.tw.githubRepositoryShortInfo.dto.GithubResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RepositoriesController {
    private final GithubApiService githubApiService;

    public RepositoriesController(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    @RequestMapping(method = GET, path = "/repositories/{owner}/{repositoryName}")
    public GithubResponseDto getRepositoryInfo(@PathVariable String owner,
                                               @PathVariable String repositoryName) {
        return githubApiService.getShortInfo(owner, repositoryName);
    }
}
