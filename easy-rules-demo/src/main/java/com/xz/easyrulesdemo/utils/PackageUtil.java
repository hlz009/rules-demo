package com.xz.easyrulesdemo.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 获取某个包下的所有类
 * @author Huxiaozhi
 * @date 2019年9月11日 下午3:24:50
 */
public class PackageUtil {
	public static List<Class<?>> getClassName(String packageName) throws IOException {
		try {
			return  getClassNamefFromPachage(packageName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }

	  /**
	   * 获取指定包下面的所有类
	   * @param packageName 包名
	   * @return 类的完整名称 （不包括后缀）
	   * @throws IOException
	   * @throws ClassNotFoundException
	   */
	private static List<Class<?>> getClassNamefFromPachage(String packageName) throws IOException, ClassNotFoundException {
		Enumeration<URL> iterator = Thread.currentThread().getContextClassLoader().getResources(packageName.replace(".", "/"));
		List<Class<?>>list = new ArrayList<>();
		
		URL url = null;
		File file = null;
		File[] fls = null;
		Class<?> c = null;
		String className = null;
		String classFullName = null;
		while(iterator.hasMoreElements()) {
			url = iterator.nextElement();
			 if ("file".equals(url.getProtocol())) {
				 file = new File(url.getPath());
				 System.out.println(file);
				 if (file.isDirectory()){
					 fls= file.listFiles();
					 for(File fl :fls) {
						className = fl.getName();
						//获取该类的类名 person
						className = className.substring(0,className.lastIndexOf("."));
						//该类的完整名称,例如com.xx.person
						classFullName = packageName+"."+className;
						c=Thread.currentThread().getContextClassLoader().loadClass(classFullName);
						list.add(c);
					 }
				 }
			 }
		}
		return list;
	}
}
