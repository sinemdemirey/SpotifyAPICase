package spec;

import core.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    RequestSpecification requestSpecification;
    public RequestSpec(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Constants.baseURL)
                .addHeader("Authorization","Bearer " + Constants.authToken)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
