package com.tw.githubRepositoryShortInfo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GithubDtoMapper {

    GithubDtoMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(GithubDtoMapper.class);

    @Mapping(source = "stargazersCount", target = "stars")
    GithubResponseDto toGithubResponseDto(GithubClientDto githubRepository);
}
