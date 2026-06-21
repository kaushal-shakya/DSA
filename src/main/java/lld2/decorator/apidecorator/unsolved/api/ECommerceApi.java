package lld2.decorator.apidecorator.unsolved.api;


import lld2.decorator.apidecorator.unsolved.utils.ApiUtils;
import lld2.decorator.apidecorator.unsolved.utils.Logger;
import lld2.decorator.apidecorator.unsolved.utils.RateLimitExceededException;

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
