package main;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class JerseyApplication extends Application {

	public JerseyApplication() {
		super();
	}

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		// register resources and features
		classes.add(MultiPartFeature.class);
		classes.add(JacksonFeature.class);
		// classes.add(LoggingFilter.class);
		return classes;
	}
}