package com.mbi.los.com.mbi.los.whatsappnotification;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("whatsappNotification")
public class WhatsappNotification implements JavaDelegate{
  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID = "AC4c21aaf58b16d94cdde4425b30f8c69e";
  public static final String AUTH_TOKEN = "f0bb34c13fac2070de4738c4ea7920d3";


@Override
public void execute(DelegateExecution execution) throws Exception {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber("whatsapp:+917045011986"),
      new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
      "Your Loan has been Approved..")

    .create();

    System.out.println(message.getSid());
  }
	
	
}
