package lld2.decorator.apidecorator.solved;


import lld2.decorator.apidecorator.solved.api.Api;
import lld2.decorator.apidecorator.solved.utils.ApiUtils;

/**
 * TODO Task 4a - Extend the {@link BaseApiDecorator} interface to implement rate limiting functionality. Use
 * {@link apidecorator.utils.ApiUtils#rateLimitExceeded(String)} to check if the rate limit has been exceeded.
 * If it has, throw a {@link apidecorator.utils.RateLimitExceededException}, else call the next layer in the chain to execute the request.
 * <br />
 * Remember
 * 1. When you inherit from the {@link BaseApiDecorator}, you will have to implement the executeRequest method.
 * 2. You will also need to call the next layer in the chain to execute the request.
 * 3. Each decorator would also need a constructor that takes the next layer of type {@link apidecorator.api.Api}.
 */
public class RateLimitingDecorator extends BaseApiDecorator {

    private Api api;

    public RateLimitingDecorator(Api api) {
        super(api);
    }

    public String executeRequest(String requestData) {
        ApiUtils.rateLimitExceeded("https://www.facebook.com");
        return "";
    }

}
