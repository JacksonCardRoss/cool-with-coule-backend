package main.java.com.sequence.product.provider;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.NoArgsConstructor;
import main.java.com.dependency.DaggerServiceComponent;
import main.java.com.sequence.product.request.DELETEProductRequest;
import main.java.com.sequence.product.result.DELETEProductResult;

@NoArgsConstructor
public class DELETEProductActivityProvider implements RequestHandler<DELETEProductRequest, DELETEProductResult> {

    @Override
    public DELETEProductResult handleRequest(DELETEProductRequest deleteProductRequest, Context context) {
        return null;
    }

    private DaggerServiceComponent getDaggerComponent() {
        return (DaggerServiceComponent) DaggerServiceComponent.create();
    }
}
