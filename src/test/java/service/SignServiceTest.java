package service;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.entity.HttpEntityWrapper;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@ExtendWith(MockitoExtension.class)
public class SignServiceTest {
//    private static final String RESPONSE_BODY = "Signed document content";
//    private static final String OPERATION_ID = "12345";
//
//    @Mock
//    private CloseableHttpClient mockHttpClient;
//
//    @InjectMocks
//    private SignServiceImpl signService;
//
//    @Test
//    public void testSignDocument() throws IOException {
//        CloseableHttpResponse mockResponse = mock(CloseableHttpResponse.class);
//        HttpEntityWrapper mockEntity = mock(HttpEntityWrapper.class);
//
//        InputStream inputStream = new ByteArrayInputStream(RESPONSE_BODY.getBytes());
//
//        when(mockEntity.getContent()).thenReturn(inputStream);
//        when(mockResponse.getEntity()).thenReturn(mockEntity);
//        when(mockHttpClient.execute(any())).thenReturn(mockResponse);
//
//        String signedDocument = signService.signDocument(OPERATION_ID);
//
//        assertEquals(RESPONSE_BODY, signedDocument);
//    }
}
