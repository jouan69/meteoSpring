package com.example.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

    private LogService logService;

    @Autowired
    public LoggingRequestInterceptor(LogServiceFactory logServiceFactory) {
        logService = logServiceFactory.getLogService(LoggingRequestInterceptor.class.getName());
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        logService.info(()->"===========================request begin================================================", null);
        logService.info(()->"URI         : " + request.getURI(), null);
        logService.info(()->"Method      : " + request.getMethod(), null);
        logService.info(()->"Headers     : " + request.getHeaders(), null);
        String requestBody = new String(body, "UTF-8");
        logService.info(()->"Request body: " + requestBody, null);
        logService.info(()->"==========================request end================================================", null);
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }

        HttpStatus responseCode = response.getStatusCode();
        String responseText = response.getStatusText();

        logService.info(()->"============================response begin==========================================", null);
        logService.info(()->"Status code  : " + responseCode, null);
        logService.info(()->"Status text  : " + responseText, null);
        logService.info(()->"Headers      : " + response.getHeaders(), null);
        logService.info(()->"Response body: " + inputStringBuilder.toString(), null);
        logService.info(()->"=======================response end=================================================", null);
    }

}
