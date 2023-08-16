package service;

import exception.SignServiceException;

public interface SignService {
    String signDocument(String operationId) throws SignServiceException;
}
