package utils;

import com.tw.githubRepositoryShortInfo.dto.GithubResponseDto;
import org.json.JSONException;
import org.json.JSONObject;

import static utils.GithubSampleResponses.getSampleGithubResponse;

public class GithubRepositoryShortInfoDtos {

    public static GithubResponseDto getSampleDto() throws JSONException {
        JSONObject jsonResponse = new JSONObject(getSampleGithubResponse());

        GithubResponseDto dto = new GithubResponseDto();
        dto.setFullName(jsonResponse.getString("full_name"));
        dto.setDescription(jsonResponse.getString("description"));
        dto.setCloneUrl(jsonResponse.getString("clone_url"));
        dto.setStars(jsonResponse.getInt("stargazers_count"));
        dto.setCreatedAt(DateParser.parseDateToLocalDate(jsonResponse.getString("created_at")));

        return dto;
    }
}
