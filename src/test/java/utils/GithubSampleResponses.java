package utils;

public class GithubSampleResponses {
    public static String getSampleGithubResponse() {

        return "{\n" +
                "  \"id\": 1234567,\n" +
                "  \"node_id\": \"MDEwOlJlcG9zaXRvcnk1MDUwODUz\",\n" +
                "  \"name\": \"sampleRepoName\",\n" +
                "  \"full_name\": \"owner/sampleRepoName\",\n" +
                "  \"private\": false,\n" +
                "  \"owner\": {\n" +
                "    \"login\": \"owner\",\n" +
                "    \"id\": 1234567,\n" +
                "    \"node_id\": \"MDQ6VXNlcjM4OTU4MQ==\",\n" +
                "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/1234567?v=4\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/owner\",\n" +
                "    \"html_url\": \"https://github.com/owner\",\n" +
                "    \"followers_url\": \"https://api.github.com/users/owner/followers\",\n" +
                "    \"following_url\": \"https://api.github.com/users/owner/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github.com/users/owner/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github.com/users/owner/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github.com/users/owner/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github.com/users/owner/orgs\",\n" +
                "    \"repos_url\": \"https://api.github.com/users/owner/repos\",\n" +
                "    \"events_url\": \"https://api.github.com/users/owner/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github.com/users/owner/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  },\n" +
                "  \"html_url\": \"https://github.com/owner/sampleRepoName\",\n" +
                "  \"description\": \"Sample description\",\n" +
                "  \"fork\": false,\n" +
                "  \"url\": \"https://api.github.com/repos/owner/sampleRepoName\",\n" +
                "  \"forks_url\": \"https://api.github.com/repos/owner/sampleRepoName/forks\",\n" +
                "  \"keys_url\": \"https://api.github.com/repos/owner/sampleRepoName/keys{/key_id}\",\n" +
                "  \"collaborators_url\": \"https://api.github.com/repos/owner/sampleRepoName/collaborators{/collaborator}\",\n" +
                "  \"teams_url\": \"https://api.github.com/repos/owner/sampleRepoName/teams\",\n" +
                "  \"hooks_url\": \"https://api.github.com/repos/owner/sampleRepoName/hooks\",\n" +
                "  \"issue_events_url\": \"https://api.github.com/repos/owner/sampleRepoName/issues/events{/number}\",\n" +
                "  \"events_url\": \"https://api.github.com/repos/owner/sampleRepoName/events\",\n" +
                "  \"assignees_url\": \"https://api.github.com/repos/owner/sampleRepoName/assignees{/user}\",\n" +
                "  \"branches_url\": \"https://api.github.com/repos/owner/sampleRepoName/branches{/branch}\",\n" +
                "  \"tags_url\": \"https://api.github.com/repos/owner/sampleRepoName/tags\",\n" +
                "  \"blobs_url\": \"https://api.github.com/repos/owner/sampleRepoName/git/blobs{/sha}\",\n" +
                "  \"git_tags_url\": \"https://api.github.com/repos/owner/sampleRepoName/git/tags{/sha}\",\n" +
                "  \"git_refs_url\": \"https://api.github.com/repos/owner/sampleRepoName/git/refs{/sha}\",\n" +
                "  \"trees_url\": \"https://api.github.com/repos/owner/sampleRepoName/git/trees{/sha}\",\n" +
                "  \"statuses_url\": \"https://api.github.com/repos/owner/sampleRepoName/statuses/{sha}\",\n" +
                "  \"languages_url\": \"https://api.github.com/repos/owner/sampleRepoName/languages\",\n" +
                "  \"stargazers_url\": \"https://api.github.com/repos/owner/sampleRepoName/stargazers\",\n" +
                "  \"contributors_url\": \"https://api.github.com/repos/owner/sampleRepoName/contributors\",\n" +
                "  \"subscribers_url\": \"https://api.github.com/repos/owner/sampleRepoName/subscribers\",\n" +
                "  \"subscription_url\": \"https://api.github.com/repos/owner/sampleRepoName/subscription\",\n" +
                "  \"commits_url\": \"https://api.github.com/repos/owner/sampleRepoName/commits{/sha}\",\n" +
                "  \"git_commits_url\": \"https://api.github.com/repos/owner/sampleRepoName/git/commits{/sha}\",\n" +
                "  \"comments_url\": \"https://api.github.com/repos/owner/sampleRepoName/comments{/number}\",\n" +
                "  \"issue_comment_url\": \"https://api.github.com/repos/owner/sampleRepoName/issues/comments{/number}\",\n" +
                "  \"contents_url\": \"https://api.github.com/repos/owner/sampleRepoName/contents/{+path}\",\n" +
                "  \"compare_url\": \"https://api.github.com/repos/owner/sampleRepoName/compare/{base}...{head}\",\n" +
                "  \"merges_url\": \"https://api.github.com/repos/owner/sampleRepoName/merges\",\n" +
                "  \"archive_url\": \"https://api.github.com/repos/owner/sampleRepoName/{archive_format}{/ref}\",\n" +
                "  \"downloads_url\": \"https://api.github.com/repos/owner/sampleRepoName/downloads\",\n" +
                "  \"issues_url\": \"https://api.github.com/repos/owner/sampleRepoName/issues{/number}\",\n" +
                "  \"pulls_url\": \"https://api.github.com/repos/owner/sampleRepoName/pulls{/number}\",\n" +
                "  \"milestones_url\": \"https://api.github.com/repos/owner/sampleRepoName/milestones{/number}\",\n" +
                "  \"notifications_url\": \"https://api.github.com/repos/owner/sampleRepoName/notifications{?since,all,participating}\",\n" +
                "  \"labels_url\": \"https://api.github.com/repos/owner/sampleRepoName/labels{/name}\",\n" +
                "  \"releases_url\": \"https://api.github.com/repos/owner/sampleRepoName/releases{/id}\",\n" +
                "  \"deployments_url\": \"https://api.github.com/repos/owner/sampleRepoName/deployments\",\n" +
                "  \"created_at\": \"2012-07-14T20:37:41Z\",\n" +
                "  \"updated_at\": \"2013-10-10T14:44:12Z\",\n" +
                "  \"pushed_at\": \"2013-10-10T14:44:10Z\",\n" +
                "  \"git_url\": \"git://github.com/owner/sampleRepoName.git\",\n" +
                "  \"ssh_url\": \"git@github.com:owner/sampleRepoName.git\",\n" +
                "  \"clone_url\": \"https://github.com/owner/sampleRepoName.git\",\n" +
                "  \"svn_url\": \"https://github.com/owner/sampleRepoName\",\n" +
                "  \"homepage\": \"sampleRepoName.herokuapp.com\",\n" +
                "  \"size\": 1564,\n" +
                "  \"stargazers_count\": 1,\n" +
                "  \"watchers_count\": 1,\n" +
                "  \"language\": \"CSS\",\n" +
                "  \"has_issues\": true,\n" +
                "  \"has_projects\": true,\n" +
                "  \"has_downloads\": true,\n" +
                "  \"has_wiki\": true,\n" +
                "  \"has_pages\": false,\n" +
                "  \"has_discussions\": false,\n" +
                "  \"forks_count\": 0,\n" +
                "  \"mirror_url\": null,\n" +
                "  \"archived\": false,\n" +
                "  \"disabled\": false,\n" +
                "  \"open_issues_count\": 0,\n" +
                "  \"license\": null,\n" +
                "  \"allow_forking\": true,\n" +
                "  \"is_template\": false,\n" +
                "  \"web_commit_signoff_required\": false,\n" +
                "  \"topics\": [\n" +
                "\n" +
                "  ],\n" +
                "  \"visibility\": \"public\",\n" +
                "  \"forks\": 0,\n" +
                "  \"open_issues\": 0,\n" +
                "  \"watchers\": 1,\n" +
                "  \"default_branch\": \"master\",\n" +
                "  \"temp_clone_token\": null,\n" +
                "  \"network_count\": 0,\n" +
                "  \"subscribers_count\": 2\n" +
                "}";
    }
}
