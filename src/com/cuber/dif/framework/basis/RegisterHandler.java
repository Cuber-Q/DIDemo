package com.cuber.dif.framework.basis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class RegisterHandler {
	public static void registerFromPackage(String packagePath){
		List<String> clazzNames;
		try {
			clazzNames = PackageScanner.getClassNamesFromPackage(packagePath);
			RegisterExecutor.register(clazzNames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
