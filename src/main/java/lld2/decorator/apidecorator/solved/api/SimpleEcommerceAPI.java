package lld2.decorator.apidecorator.solved.api;


import lld2.decorator.apidecorator.solved.utils.ApiUtils;

/**
 * TODO: Task 2 - Implement the API interface to simply call the Simple Ecommerce API, without any additional functionality.
 * Methods you can use
 * 1. {@link apidecorator.utils.ApiUtils#callAPI(String, String)}
 */
public class SimpleEcommerceAPI implements Api {

    @Override
    public String executeRequest(String requestData) {
        return ApiUtils.callAPI("https://www.google.com", requestData);
    }

    

}
