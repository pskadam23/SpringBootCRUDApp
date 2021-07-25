package com.example.message;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

/*
 * This class reads data from a text file.
 */
public class ResourceReader {
	
	//This methods reads data from the input resource, in this case a text file, into a string variable and returns it
	private static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
	
	// This method loads the text file.
	public static String readFileToString(String path) {
	    Resource resource = new FileSystemResource(path);
	    return asString(resource);
	}
}
