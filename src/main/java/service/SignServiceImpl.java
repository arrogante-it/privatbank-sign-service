package service;

import client.PrivatBankSignClient;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final PrivatBankSignClient privatBankSignClient;

    private final CloseableHttpClient httpClient;

    @Override
    public String signDocument(String operationId) throws IOException {
        StringEntity signEntity = new StringEntity("{\"operationId\": \"" + operationId + "\"}");
        privatBankSignClient.signDocument().setEntity(signEntity);
        privatBankSignClient.signDocument().setHeader("Content-Type", "application/json");

        try (CloseableHttpResponse response = httpClient.execute(privatBankSignClient.signDocument())) {
            return EntityUtils.toString(response.getEntity());
        }
    }

    @Override
    public SignDocumentStatus returnSignDocumentStatus(String operationId) throws IOException {
        try (CloseableHttpResponse response =
                     httpClient.execute(privatBankSignClient.checkSignDocumentStatus(operationId))) {
            String responseContent = EntityUtils.toString(response.getEntity());
            return responseContent.equals("SUCCESS") ? SignDocumentStatus.SUCCESS : SignDocumentStatus.FAILURE;
        }
    }
}
