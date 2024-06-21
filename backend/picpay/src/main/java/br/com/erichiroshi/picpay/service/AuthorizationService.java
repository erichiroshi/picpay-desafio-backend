package br.com.erichiroshi.picpay.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.erichiroshi.picpay.client.AuthorizationClient;
import br.com.erichiroshi.picpay.client.dto.AuthorizationResponse;
import br.com.erichiroshi.picpay.controller.dto.TransferDTO;
import br.com.erichiroshi.picpay.service.exception.PicPayException;

@Service
public class AuthorizationService {

	private final AuthorizationClient authorizationClient;

	public AuthorizationService(AuthorizationClient authorizationClient) {
		this.authorizationClient = authorizationClient;
	}

	public boolean isAuthorized(TransferDTO transfer) {

		ResponseEntity<AuthorizationResponse> resp = authorizationClient.isAuthorized();

		if (resp.getStatusCode().isError()) {
			throw new PicPayException();
		}

		return resp.getBody().authorized();
	}
}