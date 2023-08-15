package service;

import java.io.IOException;

public interface SignService {
    SignDocumentStatus signDocument(String operationId) throws IOException;
}
