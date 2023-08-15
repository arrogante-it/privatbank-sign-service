package client;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class PrivatBankSignClient {
    private static final String BASE_URL = "https://acsk.privatbank.ua/cloud/api/back";

    public HttpPost signDocument() {
        return new HttpPost(BASE_URL + "/sign");
    }

    public HttpGet checkSignDocumentStatus(String operationId) {
        return new HttpGet(BASE_URL + "/sign-status?operationId=" + operationId);
    }
}
