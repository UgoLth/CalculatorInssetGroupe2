package org.insset.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class DiscountService_Proxy extends RemoteServiceProxy implements org.insset.client.service.DiscountServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.insset.client.service.DiscountService";
  private static final String SERIALIZATION_POLICY ="207C4A37139B2E3ABE6948E9E2D4FC37";
  private static final org.insset.client.service.DiscountService_TypeSerializer SERIALIZER = new org.insset.client.service.DiscountService_TypeSerializer();
  
  public DiscountService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "discount", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void calculateDiscount(java.lang.Double originalPrice, java.lang.Integer discountRate, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("DiscountService_Proxy", "calculateDiscount");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Double/858496421");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeObject(originalPrice);
      streamWriter.writeObject(discountRate);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
