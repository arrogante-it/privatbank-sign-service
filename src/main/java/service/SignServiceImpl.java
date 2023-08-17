package service;

import client.PrivatbankSignClient;
import exception.SignServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final PrivatbankSignClient privatbankSignClient;

    @Override
    public SignDocumentStatus signDocument(String operationId) {
        try {
            String result = EntityUtils.toString(privatbankSignClient.signDocument(operationId).getEntity());
            return getSignDocumentStatus(result);
        } catch (IOException e) {
            throw new SignServiceException("couldn't sign document", e);
        }
    }

    private SignDocumentStatus getSignDocumentStatus(String operationId) {
        try {
            String responseContent = EntityUtils.toString(privatbankSignClient
                    .checkSignDocumentStatus(operationId)
                    .getEntity());
            return responseContent.equals("SUCCESS") ? SignDocumentStatus.SUCCESS : SignDocumentStatus.FAILURE;
        } catch (IOException e) {
            throw new SignServiceException("couldn't return status", e);
        }
    }
}


