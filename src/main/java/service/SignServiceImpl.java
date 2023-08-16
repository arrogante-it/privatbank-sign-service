package service;

import client.PrivatbankSignClient;
import exception.SignServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final PrivatbankSignClient privatBankSignClient;

    @Override
    public String signDocument(String operationId) throws SignServiceException {
        try {
            String result = EntityUtils.toString(privatBankSignClient.signDocument(operationId).getEntity());
            returnSignDocumentStatus(result);
            return result;
        } catch (IOException e) {
            throw new SignServiceException();
        }
    }

    private SignDocumentStatus returnSignDocumentStatus(String operationId) throws SignServiceException {
        try {
            String responseContent = EntityUtils.toString(privatBankSignClient
                    .checkSignDocumentStatus(operationId)
                    .getEntity());
            return responseContent.equals("SUCCESS") ? SignDocumentStatus.SUCCESS : SignDocumentStatus.FAILURE;
        } catch (IOException e) {
            throw new SignServiceException();
        }
    }
}


