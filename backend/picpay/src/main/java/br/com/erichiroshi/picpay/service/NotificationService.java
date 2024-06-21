package br.com.erichiroshi.picpay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.erichiroshi.picpay.client.NotificationClient;
import br.com.erichiroshi.picpay.entity.Transfer;

@Service
public class NotificationService {

	private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

	private final NotificationClient notificationClient;

	public NotificationService(NotificationClient notificationClient) {
		this.notificationClient = notificationClient;
	}

	public void sendNotification(Transfer transfer) {

		try {
			logger.info("Sending notification...");

			ResponseEntity<Void> resp = notificationClient.sendNotification(transfer);

			if (resp.getStatusCode().isError()) {
				logger.error("Error while sending notification, status code is not OK");
			}

		} catch (Exception e) {
			logger.error("Error while sending notification", e);
		}
	}
}