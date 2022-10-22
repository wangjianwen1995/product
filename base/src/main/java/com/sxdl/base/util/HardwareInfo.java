package com.sxdl.base.util;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 获取当前系统硬件信息
 */
public class HardwareInfo {
	private static String os = getOSName(), mainBordId, mac, cpuId;

	/**
	 * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
	 */
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 获取当前系统硬件信息
	 * @return
	 */
	public static String getHardWare() {
		return getCPUId() + "@" + getMAC() + "@" + getMainBordId();
	}

	/**
	 * 获取当前机器的主板id
	 *
	 * @return
	 */
	public static String getMainBordId() {
		if (os.startsWith("windows")) {
			mainBordId = getMainBordId_windows();
		} else if (os.startsWith("linux")) {
			mainBordId = getMainBordId_linux();
		}
		if (null == mainBordId || mainBordId.trim().equals("")) {
			mainBordId = "null";
		}
		return mainBordId;
	}

	/**
	 * 获取当前机器的MAC地址
	 *
	 * @return
	 * @throws Exception
	 */
	public static String getMAC() {
		if (os.startsWith("windows")) {
			mac = getMAC_windows();
		} else if (os.startsWith("linux")) {
			mac = getMAC_linux();
		}
		if (null == mac || mac.trim().equals("")) {
			mac = "null";
		}
		return mac;
	}

	/**
	 * 获取当前机器的CPUid
	 *
	 * @return
	 * @throws InterruptedException
	 */
	public static String getCPUId() {
		if (os.startsWith("windows")) {
			cpuId = getCPUID_Windows();
		} else if (os.startsWith("linux")) {
			cpuId = getCPUID_linux();
		}
		if (null == cpuId || cpuId.trim().equals("")) {
			cpuId = "null";
		}
		return cpuId;
	}

	/**
	 * 获取lunix网卡的mac地址.
	 *
	 * @return mac地址
	 */
	public static String getMAC_linux() {
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// linux下的命令，一般取eth0作为本地主网卡
			process = Runtime.getRuntime().exec("ifconfig eth0");
			// 显示信息中包含有mac地址信息
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				// 寻找标示字符串[hwaddr]
				index = line.toLowerCase().indexOf("hwaddr");
				if (index >= 0) {// 找到了
					// 取出mac地址并去除2边空格
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					break;
				}
			}
		} catch (IOException e) {
			// TODO 增加日志
			System.out.println("获取mac信息错误" + e.getMessage());
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				// TODO 增加日志
				System.out.println("获取mac信息错误" + e1.getMessage());
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}

	/**
	 * 获取widnows网卡的mac地址.
	 *
	 * @return mac地址
	 */
	public static String getMAC_windows() {
		InetAddress ip = null;
		NetworkInterface ni = null;
		List<String> macList = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
					.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				ni = (NetworkInterface) netInterfaces.nextElement();
				// ----------特定情况，可以考虑用ni.getName判断
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (!ip.isLoopbackAddress() // 非127.0.0.1
							&& ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						macList.add(getMacFromBytes(ni.getHardwareAddress()));
					}
				}
			}
		} catch (Exception e) {
			// TODO 增加日志
			System.out.println("获取mac信息错误" + e.getMessage());
		}
		if (macList.size() > 0) {
			return macList.get(0);
		} else {
			return "";
		}

	}

	private static String getMacFromBytes(byte[] bytes) {
		StringBuffer mac = new StringBuffer();
		byte currentByte;
		boolean first = false;
		for (byte b : bytes) {
			if (first) {
				mac.append("-");
			}
			currentByte = (byte) ((b & 240) >> 4);
			mac.append(Integer.toHexString(currentByte));
			currentByte = (byte) (b & 15);
			mac.append(Integer.toHexString(currentByte));
			first = true;
		}
		return mac.toString().toUpperCase();
	}

	/**
	 * 获取win服务器主板信息
	 * @return
	 */
	public static String getMainBordId_windows() {
		String result = "";
		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new FileWriter(file);

			String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
					+ "Set colItems = objWMIService.ExecQuery _ \n" + "   (\"Select * from Win32_BaseBoard\") \n"
					+ "For Each objItem in colItems \n" + "    Wscript.Echo objItem.SerialNumber \n"
					+ "    exit for  ' do the first cpu only! \n" + "Next \n";

			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
			// TODO 增加日志
			System.out.println("获取主板信息错误" + e.getMessage());
		}
		return result.trim();
	}

	/**
	 * 获取linux服务器的主板信息
	 * @return
	 */
	public static String getMainBordId_linux() {

		String result = "";
		String maniBord_cmd = "dmidecode | grep 'Serial Number' | awk '{print $3}' | tail -1";
		Process p;
		try {
			p = Runtime.getRuntime().exec(new String[] { "sh", "-c", maniBord_cmd });// 管道
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
				break;
			}
			br.close();
		} catch (IOException e) {
			// TODO 增加日志
			System.out.println("获取主板信息错误" + e.getMessage());
		}
		return result;
	}

	/**
	 * 获取win服务器的CPU序列号,
	 *
	 * @return
	 */
	public static String getCPUID_Windows() {
		String result = "";
		try {
			File file = File.createTempFile("tmp", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new FileWriter(file);
			String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
					+ "Set colItems = objWMIService.ExecQuery _ \n" + "   (\"Select * from Win32_Processor\") \n"
					+ "For Each objItem in colItems \n" + "    Wscript.Echo objItem.ProcessorId \n"
					+ "    exit for  ' do the first cpu only! \n" + "Next \n";

			// + " exit for \r\n" + "Next";
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
			file.delete();
		} catch (Exception e) {
			// TODO 增加日志
			System.out.println("获取cpu信息错误" + e.getMessage());
		}
		return result.trim();
	}

	/**
	 * 获取linux服务器的cpu信息
	 * @return
	 */
	public static String getCPUID_linux() {
		String result = "";
		String CPU_ID_CMD = "dmidecode";
		BufferedReader bufferedReader = null;
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(new String[] { "sh", "-c", CPU_ID_CMD });// 管道
			bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				// 寻找标示字符串[hwaddr]
				index = line.toLowerCase().indexOf("uuid");
				if (index >= 0) {// 找到了
					// 取出mac地址并去除2边空格
					result = line.substring(index + "uuid".length() + 1).trim();
					break;
				}
			}
		} catch (IOException e) {
			// TODO 增加日志
			System.out.println("获取cpu信息错误" + e.getMessage());
		}
		return result.trim();
	}
}
