package com.example.springcloudserver.schedule;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

//Sink.class,Processer.class 
public interface SinkReceiver {

	String INPUT1 = "input_exchange1";

	String INPUT2 = "input_exchange2";

	String INPUT3 = "input_exchange3";

	String INPUT4 = "input_exchange4";

	@Input(SinkReceiver.INPUT1)
	SubscribableChannel input1();

	@Input(SinkReceiver.INPUT2)
	SubscribableChannel input2();

	@Input(SinkReceiver.INPUT3)
	SubscribableChannel input3();

	@Input(SinkReceiver.INPUT4)
	SubscribableChannel input4();

}
