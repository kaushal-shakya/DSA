package lld2.decorator.apidecorator.unsolved.api;

import apidecorator.utils.ApiUtils;
import apidecorator.utils.Logger;
import apidecorator.utils.RateLimitExceededException;

public class ECommerceApi {

    private static final String API_ENDPOINT = "http://ecommerce.api";

    public String executeRequest(String requestData) {

        Logger.log("Processing request: " + requestData);

        if (!ApiUtils.rateLimitExceeded(requestData)) {
            throw new RateLimitExceededException("Rate limit exceeded.");
        }

        String response = ApiUtils.callAPI(API_ENDPOINT, requestData);
        Logger.log("Response: " + response);

        return response;
    }
}
