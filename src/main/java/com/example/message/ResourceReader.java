package com.example.message;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;


public class ResourceReader {
	private static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
	
	public static String readFileToString(String path) {
//	    ResourceLoader resourceLoader = new DefaultResourceLoader();
	    Resource resource = new FileSystemResource(path);
	    return asString(resource);
	}
}
