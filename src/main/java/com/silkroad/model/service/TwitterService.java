package com.silkroad.model.service;

import java.util.List;

public interface TwitterService {

    /**
     * Returns a List of Strings that are the latest tweets from an argument String username.
     *
     * @param username a string representing the username to get latest tweets from
     * @return a list of Strings of the latest tweets from a username OR an empty List
     */
    List<String> getLatestTweetFromUsername(String username);

}
