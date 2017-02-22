package com.livemykarma.gc.finalizer;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;

public class ServletWithDestroyer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InputStream stream;

	@Override
	protected void finalize() throws Throwable {
		stream.close(); 
	}
	
	/**
	 * This is preferred over finalizer. 
	 */
	@Override
	public void destroy() {
		super.destroy();
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
