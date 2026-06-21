package lld2.decorator.apidecorator.solved;


import lld2.decorator.apidecorator.solved.api.Api;

/**
 * TODO Task 3a - Each decorator should have the same methods as the product it decorates i.e. executeRequest
 * Inherit from the API interface {@link apidecorator.api.Api}.
 */

public abstract class BaseApiDecorator implements Api {

    private Api api;

    public BaseApiDecorator(Api api) {
        this.api = api;
    }

    /**
     * TODO Task 3b - Each decorator will have to call the next decorator in the chain and finally call the {@link apidecorator.api.SimpleEcommerceAPI} to execute the request.
     * To achieve this, you will need to store a reference to the next layer. Add a field that stores the next layer of
     * type {@link apidecorator.api.Api}.
     */

    public String executeRequest(String requestData) {
        return api.executeRequest(requestData);
    }

}
