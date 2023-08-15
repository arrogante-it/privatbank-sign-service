package service;

import java.io.IOException;

public interface SignService {
    String signDocument(String operationId) throws IOException;

    SignDocumentStatus returnSignDocumentStatus(String operationId) throws IOException;
}
