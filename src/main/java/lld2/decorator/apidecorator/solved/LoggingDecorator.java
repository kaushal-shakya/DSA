package lld2.decorator.apidecorator.solved;


import lld2.decorator.apidecorator.solved.api.Api;
import lld2.decorator.apidecorator.solved.utils.Logger;

/**
 * TODO Task 4a - Extend the {@link apidecorator.BaseApiDecorator} interface to implement the logging functionality.
 * Remember
 * 1. When you inherit from the {@link apidecorator.BaseApiDecorator}, you will have to implement the executeRequest method.
 * 2. You will also need to call the next layer in the chain to execute the request.
 * 3. Each decorator would also need a constructor that takes the next layer of type {@link apidecorator.api.Api}.
 */
public class LoggingDecorator extends BaseApiDecorator {

    private Api api;

    public LoggingDecorator(Api api) {
        super(api);
    }
    
    public String executeRequest(String requestData) {
        Logger.log(requestData);
        return "";
    }
}
