package br.com.silo.backoffice;

import org.javatuples.Triplet;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String principalRequestHeader;
    private String secretRequestHeader;
    private String deviceRequestHeader;

    public ApiKeyAuthFilter(String principalRequestHeader, String secretRequestHeader, String deviceRequestHeader) {
        this.principalRequestHeader = principalRequestHeader;
        this.secretRequestHeader = secretRequestHeader;
        this.deviceRequestHeader = deviceRequestHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String apiKey = request.getHeader(principalRequestHeader);
        String apiSecret = request.getHeader(secretRequestHeader);
        String device = request.getHeader(deviceRequestHeader);
        String method = request.getMethod();
        String url = request.getRequestURI().replaceAll("[\\d-]", "");
        return Triplet.with(apiKey, apiSecret, device);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "";
    }

}
