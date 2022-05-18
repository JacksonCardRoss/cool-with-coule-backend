package main.java.com.sequence.customer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import main.java.com.dependency.DaggerServiceComponent;
import main.java.com.dependency.ServiceComponent;
import main.java.com.exception.CustomerNotFoundException;
import main.java.com.obj.ResponseStatus;
import main.java.com.sequence.sample.DELETESampleRequest;
import main.java.com.sequence.sample.DELETESampleResult;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

public class DELETECustomerActivityProvider implements RequestHandler<DELETECustomerRequest, DELETECustomerResult> {

    @Override
    public DELETECustomerResult handleRequest(DELETECustomerRequest input, Context context) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        try {
            return dagger.provideDELTECustomerActivity().handleRequest(input, context);
        } catch (CustomerNotFoundException e) {
            ResponseStatus status = new ResponseStatus(400, "Customer not found.");
            return new DELETECustomerResult(null, status);
        } catch (DynamoDbException e) {
            ResponseStatus status = new ResponseStatus(400, "Error, try again");
            return new DELETECustomerResult(null, status);
        } catch (RuntimeException e) {
            ResponseStatus status = new ResponseStatus(400, "Error, cannot delete another user.");
            return new DELETECustomerResult(null, status);
        }
    }
}
