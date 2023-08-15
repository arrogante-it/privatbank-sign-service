package service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SignServiceImpl implements SignService {

    private static final String BASE_URL = "http://localhost:8080/api/v1/sign-service-url";

    private final CloseableHttpClient httpClient;

    public SignServiceImpl(CloseableHttpClient mockHttpClient) {
        this.httpClient = mockHttpClient;
    }

    @Override
    public SignDocumentStatus signDocument(String operationId) throws IOException {
        HttpPost signRequest = new HttpPost(BASE_URL + "/sign");
        StringEntity signEntity = new StringEntity("{\"operationId\": \"" + operationId + "\"}");
        signRequest.setEntity(signEntity);
        signRequest.setHeader("Content-Type", "application/json");

        try (CloseableHttpResponse response = httpClient.execute(signRequest)) {
            String responseContent = EntityUtils.toString(response.getEntity());

            if (responseContent.equals("SUCCESS")) {
                return SignDocumentStatus.SUCCESS;
            } else {
                return SignDocumentStatus.FAILURE;
            }
        }
    }
}
