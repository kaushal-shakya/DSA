package lld2.decorator.apidecorator.solved.api;


import lld2.decorator.apidecorator.solved.utils.ApiUtils;
import lld2.decorator.apidecorator.solved.utils.Logger;
import lld2.decorator.apidecorator.solved.utils.RateLimitExceededException;

public class ECommerceApi implements Api {

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
