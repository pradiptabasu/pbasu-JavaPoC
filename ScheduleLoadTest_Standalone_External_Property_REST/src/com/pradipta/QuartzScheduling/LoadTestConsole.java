package com.pradipta.QuartzScheduling;

import java.math.BigInteger;

import java.net.URI;

import javax.ws.rs.client.Client;

import model.FundsAvailableAPI;
import model.GetPaymentID;
import model.PaymentProcessingAPI;

import org.bank.payments.PaymentRequest;
import org.bank.payments.PaymentValidationResponse;

import org.gringottbank.oracle.demo.PaymentBookingRequest;
import org.gringottbank.oracle.demo.PaymentBookingResponse;


public class LoadTestConsole implements Runnable {

    protected long paymentReqId;
    protected PaymentValidationResponse fundsAvailableResponse = new PaymentValidationResponse();
    protected PaymentBookingResponse paymentBookingResponse = new PaymentBookingResponse();
    protected String CustomerToken;
    protected String FinTechID;
    protected String Region;
    protected String PaymentCategory;
    protected float RequiredFunds;
    protected String salesChannel;
    protected String technicalChannel;

    Client getPaymentIdClient = GetPaymentID.createClient();
    GetPaymentID.Root getpaymentidroot = GetPaymentID.root(getPaymentIdClient);
    Client fundsAvailableClient = FundsAvailableAPI.createClient();
    FundsAvailableAPI.Root fundsavailableapiroot =
        FundsAvailableAPI.root(fundsAvailableClient,
                               URI.create("http://oa8102.us.oracle.com:8001/FundsAvailableAPI/1/"));
    Client paymentProcessingclient = PaymentProcessingAPI.createClient();
    PaymentProcessingAPI.Root paymentprocessingapiroot =
        PaymentProcessingAPI.root(paymentProcessingclient,
                                  URI.create("http://oa8102.us.oracle.com:8001/PaymentProcessingAPI/1/"));


    public LoadTestConsole(long paymentReqId, String CustomerToken, float RequiredFunds, String FinTechID,
                           String PaymentCategory, String salesChannel, String technicalChannel, String Region) {
        super();
        this.paymentReqId = paymentReqId;
        this.CustomerToken = CustomerToken;
        this.RequiredFunds = RequiredFunds;
        this.FinTechID = FinTechID;
        this.PaymentCategory = PaymentCategory;
        this.salesChannel = salesChannel;
        this.technicalChannel = technicalChannel;
        this.Region = Region;
    }

    @Override
    public void run() {

        try {
            System.out.println("FintechPaymentRequestId : " + paymentReqId);
            PaymentRequest fundsAvailableRequest = new PaymentRequest();
            fundsAvailableRequest.setCustomerToken(CustomerToken);
            fundsAvailableRequest.setFintechPaymentRequestId(BigInteger.valueOf(paymentReqId));
            fundsAvailableRequest.setFinTechID(FinTechID);
            fundsAvailableRequest.setRegion(Region);
            fundsAvailableRequest.setRequiredFunds(RequiredFunds);
            fundsAvailableRequest.setPaymentCategory(PaymentCategory);
            fundsAvailableRequest.setSalesChannel(salesChannel);
            fundsAvailableRequest.setTechnicalChannel(technicalChannel);
            fundsAvailableResponse = fundsavailableapiroot.postJsonAsPaymentValidationResponse(fundsAvailableRequest);
            System.out.println(fundsAvailableResponse.getPaymentValidationStatus());
            if ((fundsAvailableResponse.getPaymentValidationStatus().equalsIgnoreCase("Approved based on Customer Asset and Credit")) ||
                (fundsAvailableResponse.getPaymentValidationStatus().equalsIgnoreCase("Approved based on Customer Asset"))) {
                PaymentBookingRequest paymentBookingRequest = new PaymentBookingRequest();
                paymentBookingRequest.setFintechPaymentRequestId(BigInteger.valueOf(paymentReqId));
                paymentBookingRequest.setCashAmount(fundsAvailableResponse.getCashAmount());
                paymentBookingRequest.setCreditAmount(fundsAvailableResponse.getCreditAmount());
                paymentBookingRequest.setCustomerToken(CustomerToken);
                paymentBookingRequest.setFinTechID(FinTechID);
                paymentBookingRequest.setPaymentCategory(PaymentCategory);
                paymentBookingRequest.setRegion(Region);
                paymentBookingRequest.setSalesChannel(salesChannel);
                paymentBookingRequest.setTechnicalChannel(technicalChannel);
                paymentBookingResponse =
                    paymentprocessingapiroot.postJsonAsPaymentBookingResponse(paymentBookingRequest);
                System.out.println(paymentBookingResponse.getPaymentBookingStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
