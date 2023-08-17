package service;

import client.PrivatbankSignClient;
import exception.SignServiceException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignServiceTest {
    @Mock
    private PrivatbankSignClient mockSignClient;

    @InjectMocks
    private SignServiceImpl signService;

    @Test
    void testSignDocument_Success() throws IOException {
        String operationId = "123";
        CloseableHttpResponse response = mock(CloseableHttpResponse.class);
        HttpEntity entity = new StringEntity("SUCCESS");

        when(mockSignClient.signDocument(operationId)).thenReturn(response);
        when(response.getEntity()).thenReturn(entity);

        SignDocumentStatus result = signService.signDocument(operationId);

        assertEquals(SignDocumentStatus.SUCCESS, result);
        verify(mockSignClient).signDocument(operationId);
        verify(response).close();
    }

    @Test
    void testSignDocument_Failure() throws IOException {
        String operationId = "456";
        CloseableHttpResponse response = mock(CloseableHttpResponse.class);
        HttpEntity entity = new StringEntity("FAILURE");

        when(mockSignClient.signDocument(operationId)).thenReturn(response);
        when(response.getEntity()).thenReturn(entity);

        SignDocumentStatus result = signService.signDocument(operationId);

        assertEquals(SignDocumentStatus.FAILURE, result);
        verify(mockSignClient).signDocument(operationId);
        verify(response).close();
    }

    @Test
    void testSignDocument_Exception() throws IOException {
        String operationId = "789";
        IOException ioException = new IOException("Test exception");

        when(mockSignClient.signDocument(operationId)).thenThrow(ioException);

        SignServiceException exception =
                org.junit.jupiter.api.Assertions.assertThrows(SignServiceException.class, () -> {
                    signService.signDocument(operationId);
                });

        assertEquals("couldn't sign document", exception.getMessage());
        assertEquals(ioException, exception.getCause());
        verify(mockSignClient).signDocument(operationId);
    }
}