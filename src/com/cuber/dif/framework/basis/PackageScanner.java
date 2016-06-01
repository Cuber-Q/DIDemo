package com.cuber.dif.framework.basis;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PackageScanner {
	private static ArrayList<String> names = new ArrayList<String>();;
	private static String PACKAGE_FILE_PATH = "";
	
	public static ArrayList<String>getClassNamesFromPackage(String packageNameVar) throws IOException, URISyntaxException{
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    URL packageURL;
	    PACKAGE_FILE_PATH = packageNameVar.replace(".", "\\");
	    packageURL = classLoader.getResource(packageNameVar.replace(".", "/"));

//	    if(packageURL.getProtocol().equals("jar")){
//	        String jarFileName;
//	        JarFile jf ;
//	        Enumeration<JarEntry> jarEntries;
//	        String entryName;
//
//	        // build jar file name, then loop through zipped entries
//	        jarFileName = URLDecoder.decode(packageURL.getFile(), "UTF-8");
//	        jarFileName = jarFileName.substring(5,jarFileName.indexOf("!"));
//	        System.out.println(">"+jarFileName);
//	        jf = new JarFile(jarFileName);
//	        jarEntries = jf.entries();
//	        while(jarEntries.hasMoreElements()){
//	            entryName = jarEntries.nextElement().getName();
//	            if(entryName.startsWith(packageNameVar) && entryName.length()>packageNameVar.length()+5){
//	                entryName = entryName.substring(packageNameVar.length(),entryName.lastIndexOf('.'));
//	                names.add(entryName);
//	            }
//	        }
//
//	    // loop through files in classpath
//	    }else{
//	    }
	    URI uri = new URI(packageURL.toString());
	    getClassNamesRecursively(uri.getPath());
	    return names;
	}
	
	public static void getClassNamesRecursively(String pathName){
		File folder = new File(pathName);
        // won't work with path which contains blank (%20)
        // File folder = new File(packageURL.getFile()); 
        File[] contenuti = folder.listFiles();
        String entryName;
        for(File actual: contenuti){
            entryName = actual.getName();
            if(entryName.indexOf(".") < 0){
            	getClassNamesRecursively(actual.getPath());
            }
            if(entryName.indexOf(".") > 0){
//            	entryName = entryName.substring(0, entryName.lastIndexOf('.'));
            	String filePath = actual.getPath();
            	filePath =  filePath.substring(filePath.indexOf(PACKAGE_FILE_PATH));
            	filePath = filePath.replace("\\", ".");
            	filePath = filePath.substring(0, filePath.lastIndexOf('.'));
            	names.add(filePath);
            }
        }
    }
	
	public static void main(String[] args) throws Exception{
		long start = System.currentTimeMillis();
		String basePackageName = "com.cuber.dif";
		PackageScanner.getClassNamesFromPackage(basePackageName);
		long end = System.currentTimeMillis();
		System.out.println("scanning package costs " + (end - start) + "ms");
		for(String clazzName : names){
			System.out.println(clazzName);
		}
	}
}
