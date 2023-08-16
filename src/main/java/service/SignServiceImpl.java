package service;

import client.PrivatbankSignClient;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final PrivatbankSignClient privatBankSignClient;

    private final CloseableHttpClient httpClient;

    @Override
    public String signDocument(String operationId) {
        try (CloseableHttpResponse response = httpClient
                .execute(privatBankSignClient
                        .signDocument(operationId))) {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SignDocumentStatus returnSignDocumentStatus(String operationId) {
        try {
            String responseContent = EntityUtils.toString(privatBankSignClient
                    .checkSignDocumentStatus(operationId)
                    .getEntity());
            return responseContent.equals("SUCCESS") ? SignDocumentStatus.SUCCESS : SignDocumentStatus.FAILURE;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


