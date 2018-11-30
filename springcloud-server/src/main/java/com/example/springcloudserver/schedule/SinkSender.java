package com.example.springcloudserver.schedule;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//Source.class,Processer.class
public interface SinkSender {
	
	@Output(SinkReceiver.INPUT1)
	MessageChannel output1();
	
	@Output(SinkReceiver.INPUT2)
	MessageChannel output2();
	
	@Output(SinkReceiver.INPUT3)
	MessageChannel output3();
	
	@Output(SinkReceiver.INPUT4)
	MessageChannel output4();
}
