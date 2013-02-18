package com.test;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
public class MyProvider implements MessageBodyWriter<MyObject> {

	@Override
	public long getSize(MyObject arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		return arg0.getMessage().getBytes().length;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return true;
	}

	@Override
	public void writeTo(MyObject arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4, MultivaluedMap<String, Object> arg5, OutputStream arg6)
			throws IOException, WebApplicationException {
		System.out.println("message = "+arg0.getMessage());
		arg6.write(arg0.getMessage().getBytes());
	}

}
