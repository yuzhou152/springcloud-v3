package com.example.springcloudclientfeign.schedule;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//Source.class,Processer.class
public interface SinkSender {
	
	@Output(SinkReceiver.INPUT1)
	public abstract MessageChannel output1();
	
	@Output(SinkReceiver.INPUT2)
	public abstract MessageChannel output2();
	
	@Output(SinkReceiver.INPUT3)
	public abstract MessageChannel output3();
	
	@Output(SinkReceiver.INPUT4)
	public abstract MessageChannel output4();
}
