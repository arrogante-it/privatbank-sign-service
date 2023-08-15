package client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import service.SignService;

import java.io.IOException;

public class PrivatBankSignClient {
    private static final String BASE_URL = "https://acsk.privatbank.ua/cloud/api/back";

    private final SignService signService;

    private final CloseableHttpClient httpClient;

    public PrivatBankSignClient(SignService signService, CloseableHttpClient httpClient) {
        this.signService = signService;
        this.httpClient = httpClient;
    }

    public SignDocumentStatus signDocument(String operationId) throws IOException {
        HttpPost signRequest = new HttpPost(BASE_URL + "/sign");

        signService.signDocument(operationId, signRequest);

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
