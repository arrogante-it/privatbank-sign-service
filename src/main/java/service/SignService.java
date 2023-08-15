package service;

import client.SignDocumentStatus;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;

public interface SignService {
    void signDocument(String operationId, HttpPost signRequest) throws IOException;
}
