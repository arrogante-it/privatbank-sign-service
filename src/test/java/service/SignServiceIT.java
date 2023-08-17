package service;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SignServiceIT {
//
//    private static SignServiceImpl signService;
//
//    @BeforeEach
//    public void setUp() {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        signService = new SignServiceImpl(httpClient);
//    }
//
//    @Test
//    public void testSignDocumentIntegration() throws IOException {
//        String operationId = "testOperationId";
//
//        String actualResponse = signService.signDocument(operationId);
//
//        assertEquals("Document signed successfully", actualResponse);
//    }
}

//
//import org.apache.http.Header;
//import org.apache.http.HeaderIterator;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpHost;
//import org.apache.http.HttpRequest;
//import org.apache.http.ProtocolVersion;
//import org.apache.http.StatusLine;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.message.BasicStatusLine;
//import org.apache.http.params.HttpParams;
//import org.apache.http.protocol.HttpContext;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.util.Locale;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SignServiceIT {
//
//    @Test
//    public void testSignDocument() throws IOException {
//        CloseableHttpClientMock httpClientMock = new CloseableHttpClientMock();
//        SignService signService = new SignService(httpClientMock);
//
//        String operationId = "testOperationId";
//        String expectedResponse = "Document signed successfully";
//
//        httpClientMock.setHttpResponse(new StringEntity(expectedResponse), 200);
//
//        String actualResponse = signService.signDocument(operationId);
//
//        assertEquals(expectedResponse, actualResponse);
//    }
//
//    private static class CloseableHttpClientMock extends CloseableHttpClient {
//        private HttpEntity httpEntity;
//        private StatusLine statusLine;
//
//        public void setHttpResponse(HttpEntity httpEntity, int statusCode) {
//            this.httpEntity = httpEntity;
//            this.statusLine = new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), statusCode, "Reason");
//        }
//
//        @Override
//        protected CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
//            return new CloseableHttpResponse() {
//                @Override
//                public StatusLine getStatusLine() {
//                    return statusLine;
//                }
//
//                @Override
//                public void close() throws IOException {
//                    httpEntity.getContent().close();
//                }
//
//                @Override
//                public HttpEntity getEntity() {
//                    return httpEntity;
//                }
//
//                @Override
//                public boolean containsHeader(String s) {
//                    return false;
//                }
//
//                @Override
//                public Header[] getHeaders(String s) {
//                    return new Header[0];
//                }
//
//                @Override
//                public Header[] getAllHeaders() {
//                    return new Header[0];
//                }
//
//                @Override
//                public ProtocolVersion getProtocolVersion() {
//                    return null;
//                }
//
//                @Override
//                public Header getFirstHeader(String s) {
//                    return null;
//                }
//
//                @Override
//                public Header getLastHeader(String s) {
//                    return null;
//                }
//
//
//                @Override
//                public void addHeader(Header header) {
//
//                }
//
//                @Override
//                public void addHeader(String s, String s1) {
//
//                }
//
//                @Override
//                public void setHeader(Header header) {
//
//                }
//
//                @Override
//                public void setHeader(String s, String s1) {
//
//                }
//
//                @Override
//                public void setHeaders(Header[] headers) {
//
//                }
//
//                @Override
//                public void removeHeader(Header header) {
//
//                }
//
//                @Override
//                public void removeHeaders(String s) {
//
//                }
//
//                @Override
//                public HeaderIterator headerIterator() {
//                    return null;
//                }
//
//                @Override
//                public HeaderIterator headerIterator(String s) {
//                    return null;
//                }
//
//                @Override
//                public HttpParams getParams() {
//                    return null;
//                }
//
//                @Override
//                public void setParams(HttpParams httpParams) {
//
//                }
//
//                @Override
//                public void setStatusLine(StatusLine statusLine) {
//
//                }
//
//                @Override
//                public void setStatusLine(ProtocolVersion protocolVersion, int i) {
//
//                }
//
//                @Override
//                public void setStatusLine(ProtocolVersion protocolVersion, int i, String s) {
//
//                }
//
//                @Override
//                public void setStatusCode(int i) throws IllegalStateException {
//
//                }
//
//                @Override
//                public void setReasonPhrase(String s) throws IllegalStateException {
//
//                }
//
//                @Override
//                public void setEntity(HttpEntity httpEntity) {
//
//                }
//
//                @Override
//                public Locale getLocale() {
//                    return null;
//                }
//
//                @Override
//                public void setLocale(Locale locale) {
//
//                }
//            };
//        }
//
//        @Override
//        public void close() throws IOException {
//
//        }
//
//        @Override
//        public HttpParams getParams() {
//            return null;
//        }
//
//        @Override
//        public ClientConnectionManager getConnectionManager() {
//            return null;
//        }
//    }
//}