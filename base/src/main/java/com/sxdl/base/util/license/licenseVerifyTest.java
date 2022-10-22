package com.sxdl.base.util.license;

public class licenseVerifyTest {
	public static void main(String[] args){
		VerifyLicense vLicense = new VerifyLicense();
		try{
			
//			vLicense.setParam("D:/workspaces/GIT/JavaSpringSurmmary/java-license-jar/src/main/resources/verifyparam.properties");
			
			System.out.println(vLicense.verify());
		}
		catch(Exception er){
			er.printStackTrace();
		}

	}
}
