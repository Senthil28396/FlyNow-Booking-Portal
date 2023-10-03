//package com.springsecurity.entity;
//
//import java.io.IOException;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//public class TripSerializer extends JsonSerializer<Trip> {
//	    @Override
//	    public void serialize(Trip trip, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
//	            throws IOException {
//	        
//	        jsonGenerator.writeStartObject();
//	        jsonGenerator.writeStringField("departure", trip.getDeparture());
//	        jsonGenerator.writeEndObject();
//	    }
//	}
//
