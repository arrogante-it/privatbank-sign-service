package service;

public interface SignService {
    String signDocument(String operationId);

    SignDocumentStatus returnSignDocumentStatus(String operationId);
}
