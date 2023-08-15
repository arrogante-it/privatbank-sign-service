package service;

import client.SignDocumentStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

public class SignServiceImpl implements SignService {
    @Override
    public void signDocument(String operationId, HttpPost signRequest) throws IOException {
        StringEntity signEntity = new StringEntity("{\"operationId\": \"" + operationId + "\"}");
        signRequest.setEntity(signEntity);
        signRequest.setHeader("Content-Type", "application/json");
    }
}
