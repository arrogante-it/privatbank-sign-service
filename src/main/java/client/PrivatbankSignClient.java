package client;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RequiredArgsConstructor
public class PrivatbankSignClient {
    private static final String BASE_URL = "${application.endpoint.root}";
    private static final String SIGN = "${application.endpoint.sign}";
    private static final String SIGN_STATUS_BY_OPERATION_ID = "${application.endpoint.sign.status}";

    private final CloseableHttpClient httpClient;

    public HttpPost signDocument(String operationId) throws UnsupportedEncodingException {
        StringEntity signEntity = new StringEntity("{\"operationId\": \"" + operationId + "\"}");
        HttpPost signRequest = new HttpPost(SIGN);
        signRequest.setEntity(signEntity);
        signRequest.setHeader("Content-Type", "application/json");
        return signRequest;
    }

    public CloseableHttpResponse checkSignDocumentStatus(String operationId) throws IOException {
        HttpGet signStatusRequest = new HttpGet(SIGN_STATUS_BY_OPERATION_ID + operationId);
        return httpClient.execute(signStatusRequest);
    }
}
