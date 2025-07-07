package com.alinakhan.wallet.services;

import com.alinakhan.wallet.config.exception.PaymentGatewayServiceException;

public interface PaymentGatewayService {

	public String addMoney(String userName, Integer amount) throws PaymentGatewayServiceException;
	public String transferMoney(String fromUserName, String toUserName, Integer amount) throws PaymentGatewayServiceException;
}
